package com.ysy.petadopt.controller;

import com.qiniu.http.Response;
import com.ysy.petadopt.dto.PutRetDTO;
import com.ysy.petadopt.entity.AnimalCategory;
import com.ysy.petadopt.entity.Article;
import com.ysy.petadopt.entity.ArticleCategory;
import com.ysy.petadopt.entity.User;
import com.ysy.petadopt.service.AnimalCategoryService;
import com.ysy.petadopt.service.ArticleCategoryService;
import com.ysy.petadopt.service.ArticleService;
import com.ysy.petadopt.service.QiniuUploadFileService;
import com.ysy.petadopt.utils.PageUtils;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/admin/article/")
public class AdminArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private AnimalCategoryService animalCategoryService;

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @Autowired
    private QiniuUploadFileService qiniuUploadFileService;

    @Value("${qiniu.cdn.prefix}")
    private String prefix;

    @GetMapping("articleList")
    public String articleList(ModelMap modelMap, @RequestParam(defaultValue = "1") Integer pageNum, String animalCategoryName,
                              String articleCategoryName) {
        System.out.println(animalCategoryName);
        System.out.println(articleCategoryName);
        Pageable pageable = PageRequest.of(--pageNum, 8);
        Page<Article> page = articleService.findAll(pageable);
        modelMap.put("page", page);
        modelMap.put("navigationNums", PageUtils.getNavigationNums(page));
        modelMap.put("animalCategoryList", animalCategoryService.findAll());
        modelMap.put("articleCategoryList", articleCategoryService.findAll());
        return "article/article_list";
    }

    @GetMapping("getArticle")
    @ResponseBody
    public ResultVO getArticle(Integer articleId) {
        Article article = articleService.findOne(articleId);
        if (article != null) {
            return ResultVOUtils.success(article);
        } else {
            return ResultVOUtils.error(1, "数据已被删除，请刷新");
        }
    }

    @PostMapping("addArticle")
    public String addArticle(String title, String description, Integer watchCount, Integer commentCount, Integer animalCategoryId,
                             Integer articleCategoryId, MultipartFile mainImage, String content, HttpSession httpSession) throws IOException {
        // 上传主图到七牛云
        String mainImagePath = "";
        if (mainImage.getSize() != 0) {
            Response response = qiniuUploadFileService.uploadFile(mainImage.getInputStream());
            PutRetDTO putRetDTO = response.jsonToObject(PutRetDTO.class);
            mainImagePath = prefix + "/" + putRetDTO.getKey();
        }

        // 构建文章对象
        Article article = new Article();
        // 设置标题
        article.setTitle(title);
        // 设置描述
        article.setDescription(description);
        // 设置围观数
        article.setWatchCount(watchCount);
        // 设置评论数
        article.setCommentCount(commentCount);

        // 设置宠物类别
        AnimalCategory animalCategory = new AnimalCategory();
        animalCategory.setAnimalCategoryId(animalCategoryId);
        article.setAnimalCategory(animalCategory);

        // 设置文章类别
        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setArticleCategoryId(articleCategoryId);
        article.setArticleCategory(articleCategory);

        // 设置主图地址
        article.setMainImage(mainImagePath);

        // 设置文章内容
        article.setContent(content);

        // 设置创建时间
        article.setCreateTime(new Date());
        // 设置修改时间
        article.setUpdateTime(new Date());
        // 设置用户
        User user = (User) httpSession.getAttribute("user");
        article.setUser(user);

        // 保存文章
        articleService.save(article);

        return "redirect:articleList";
    }

    @GetMapping("deleteArticle")
    public String deleteArticle(Integer articleId) {
        // 调用业务层删除
        articleService.deleteById(articleId);
        return "redirect:articleList";
    }

    @PostMapping("updateArticle")
    public String updateArticle(Integer articleId, String title, String description, Integer watchCount, Integer commentCount, Integer animalCategoryId,
                                Integer articleCategoryId, MultipartFile mainImage, String content, HttpSession httpSession) throws IOException {

        // 查询出原数据
        Article article = articleService.findOne(articleId);
        // 设置标题
        article.setTitle(title);
        // 设置描述
        article.setDescription(description);
        // 设置围观数
        article.setWatchCount(watchCount);
        // 设置评论数
        article.setCommentCount(commentCount);

        // 设置宠物类别
        AnimalCategory animalCategory = new AnimalCategory();
        animalCategory.setAnimalCategoryId(animalCategoryId);
        article.setAnimalCategory(animalCategory);

        // 设置文章类别
        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setArticleCategoryId(articleCategoryId);
        article.setArticleCategory(articleCategory);

        // 上传主图到七牛云
        if (mainImage.getSize() != 0) {
            Response response = qiniuUploadFileService.uploadFile(mainImage.getInputStream());
            PutRetDTO putRetDTO = response.jsonToObject(PutRetDTO.class);
            String mainImagePath = prefix + "/" + putRetDTO.getKey();
            // 设置主图地址
            article.setMainImage(mainImagePath);
        }

        // 设置文章内容
        article.setContent(content);

        // 设置修改时间
        article.setUpdateTime(new Date());

        // 设置用户
        User user = (User) httpSession.getAttribute("user");
        article.setUser(user);

        // 保存文章
        articleService.save(article);
        return "redirect:articleList";
    }

}

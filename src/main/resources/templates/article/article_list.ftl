<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>百科管理</title>
    <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/bootstrap4/css/bootstrap.min.css">
    <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/css/common.css">
    <style>
        .table td {
            vertical-align: middle;
        }
    </style>
</head>
<body>
<#-- 引入头部菜单 -->
<#include "../common/header_menu.ftl"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-2 padding-0">
        <#-- 引入左侧菜单栏 -->
            <#include "../common/left_menu.ftl"/>
        </div>
        <div class="col-10 page-wrapper">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th scope="col">
                        <input type="checkbox" class="check-all">
                    </th>
                    <th scope="col">#</th>
                    <th scope="col" width="104">主图</th>
                    <th scope="col">用户</th>
                    <th scope="col">动物类别</th>
                    <th scope="col">文章类别</th>
                    <th scope="col">标题</th>
                    <th scope="col" style="width: 320px;">描述</th>
                    <th scope="col">围观数</th>
                    <th scope="col">评论数</th>
                    <th scope="col">创建时间</th>
                    <th scope="col">修改时间</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <#list page.content as article>
                <tr>
                    <td>
                        <input type="checkbox" class="check-item">
                    </td>
                    <td>${article_index + 1}</td>
                    <td>
                        <img src="${article.mainImage}" width="80" height="60">
                    </td>
                    <td>${article.user.userInfo.nickname}</td>
                    <td>${article.animalCategory.categoryName}</td>
                    <td>${article.articleCategory.categoryName}</td>
                    <td>${article.title}</td>
                    <td style="display: block;width: 320px;height: 90px;overflow: hidden;"
                        title="${article.description}">${article.description}</td>
                    <td>${article.watchCount}</td>
                    <td>${article.commentCount}</td>
                    <td>${article.createTime}</td>
                    <td>${article.updateTime}</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal"
                                data-target="#update-article-model" data-article-id="${article.articleId}">修改
                        </button>
                        <button type="button" class="btn btn-danger btn-sm delete" data-article-category-id="1"
                                data-article-id="${article.articleId}">删除
                        </button>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>

            <div class="container-fluid p-0 d-flex justify-content-between">
                <div class="button-wrapper">
                <#-- 添加按钮,开启模态框 -->
                    <button type="button" class="btn btn-primary mb-3" data-toggle="modal"
                            data-target="#add-article-model">
                        添加
                    </button>
                </div>

            <#-- 分页按钮 -->
                <nav aria-label="Page navigation example">
                    <ul class="pagination">

                        <#if page.hasPrevious()>
                        <li class="page-item">
                            <a class="page-link"
                               href="${springMacroRequestContext.contextPath}/admin/article/articleList?pageNum=${page.previousPageable().getPageNumber() + 1}"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                            </a>
                        </li>
                        <#else>
                        <li class="page-item disabled">
                            <a class="page-link" href="javascript:;" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                            </a>
                        </li>
                        </#if>

                        <#list navigationNums as num>
                            <#if num == page.getNumber() + 1>
                            <li class="page-item active"><a class="page-link" href="javascript:;">${num}</a></li>
                            <#else>
                            <li class="page-item">
                                <a class="page-link"
                                   href="${springMacroRequestContext.contextPath}/admin/article/articleList?pageNum=${num}">${num}</a>
                            </li>
                            </#if>
                        </#list>

                        <#if page.hasNext()>
                        <li class="page-item">
                            <a class="page-link"
                               href="${springMacroRequestContext.contextPath}/admin/article/articleList?pageNum=${page.nextPageable().getPageNumber() + 1}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                            </a>
                        </li>
                        <#else>
                        <li class="page-item disabled">
                            <a class="page-link" href="javascript:;" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                            </a>
                        </li>
                        </#if>
                    </ul>
                </nav>
            </div>

        <#-- 添加类别的模态框 -->
            <div class="modal fade" id="add-article-model" tabindex="-1" role="dialog"
                 aria-labelledby="myLargeModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">添加文章</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form id="addArticle"
                                  action="${springMacroRequestContext.contextPath}/admin/article/addArticle"
                                  method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="标题" name="title">
                                </div>
                                <div class="form-group">
                                    <textarea placeholder="描述" class="form-control" name="description"></textarea>
                                </div>
                                <div class="form-group">
                                    <input type="number" class="form-control" placeholder="围观数" name="watchCount">
                                </div>
                                <div class="form-group">
                                    <input type="number" class="form-control" placeholder="评论数" name="commentCount">
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col">
                                            <select name="animalCategoryId" class="form-control">
                                                <#list animalCategoryList as animalCategory>
                                                    <option value="${animalCategory.animalCategoryId}">${animalCategory.categoryName}</option>
                                                </#list>
                                            </select>
                                        </div>
                                        <div class="col">
                                            <select name="articleCategoryId" class="form-control">
                                                <#list articleCategoryList as articleCategory>
                                                    <option value="${articleCategory.articleCategoryId}">${articleCategory.categoryName}</option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="custom-file mb-3">
                                    <input type="file" class="custom-file-input" id="customFile" name="mainImage">
                                    <label class="custom-file-label" for="customFile">文章主图</label>
                                </div>
                                <script id="container" name="content" type="text/plain"></script>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary add-article">保存</button>
                        </div>
                    </div>
                </div>
            </div>

        <#-- 修改模态框 -->
            <div class="modal fade" id="update-article-model" tabindex="-1" role="dialog"
                 aria-labelledby="myLargeModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">添加文章</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form id="updateArticle"
                                  action="${springMacroRequestContext.contextPath}/admin/article/updateArticle"
                                  method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <input type="hidden" class="form-control" id="update-article-id" name="articleId">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="标题" id="update-title"
                                           name="title">
                                </div>
                                <div class="form-group">
                                    <textarea placeholder="描述" class="form-control" id="update-description"
                                              name="description"></textarea>
                                </div>
                                <div class="form-group">
                                    <input type="number" class="form-control" placeholder="围观数" id="update-watch-count"
                                           name="watchCount">
                                </div>
                                <div class="form-group">
                                    <input type="number" class="form-control" placeholder="评论数"
                                           id="update-comment-count" name="commentCount">
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col">
                                            <select id="update-animal-category-id" name="animalCategoryId"
                                                    class="form-control">
                                                <#list animalCategoryList as animalCategory>
                                                    <option value="${animalCategory.animalCategoryId}">${animalCategory.categoryName}</option>
                                                </#list>
                                            </select>
                                        </div>
                                        <div class="col">
                                            <select id="update-article-category-id" name="articleCategoryId"
                                                    class="form-control">
                                                <#list articleCategoryList as articleCategory>
                                                    <option value="${articleCategory.articleCategoryId}">${articleCategory.categoryName}</option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="custom-file mb-3">
                                    <input type="file" class="custom-file-input" id="update-main-image"
                                           name="mainImage">
                                    <label class="custom-file-label" for="customFile">文章主图</label>
                                </div>
                                <script id="update-container" name="content" type="text/plain"></script>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary update-article">保存</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${springMacroRequestContext.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/bootstrap4/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/ueditor/ueditor.all.min.js"></script>
<script>
    $(function () {
        // 全选全不选功能
        $('.check-all').click(function () {
            $('.check-item').prop('checked', $(this).prop('checked'));
        });

        // 初始化添加模态框富文本编辑器
        let addue = UE.getEditor('container', {
            initialFrameHeight: 200
        });

        let updateue = UE.getEditor('update-container', {
            initialFrameHeight: 200
        });

        // 添加模态框保存按钮的事件
        $('.add-article').click(function () {
            // 提交表单
            $("#addArticle").submit();
        });

        // 删除按钮的点击事件
        $('.delete').click(function () {
            if (confirm('确定删除吗？')) {
                // 获取要删除的文章id
                let articleId = $(this).data('articleId');
                location.href = "${springMacroRequestContext.contextPath}/admin/article/deleteArticle?articleId=" + articleId;
            }
        });

        // 绑定修改模态框打开之前的事件
        $('#update-article-model').on('show.bs.modal', function (e) {
            // 从后台获取数据显示到修改模态框上
            $.ajax({
                type: 'get',
                url: 'getArticle?articleId=' + $(e.relatedTarget).data('articleId'),
                success: function (data) {
                    if (data.status == 0) {
                        const article = data.data;
                        // 将数据显示到修改表单上
                        $('#update-article-id').val(article.articleId);
                        $('#update-title').val(article.title);
                        $('#update-description').val(article.description);
                        $('#update-watch-count').val(article.watchCount);
                        $('#update-comment-count').val(article.commentCount);
                        // 设置宠物类别select
                        const animalCategoryOptions = $('#update-animal-category-id option');
                        for (let i = 0; i < animalCategoryOptions.length; i++) {
                            if (animalCategoryOptions[i].value == article.animalCategory.animalCategoryId) {
                                $('#update-animal-category-id').get(0).selectedIndex = i;
                                break;
                            }
                        }
                        // 设置文章类别select
                        const articleCategoryOptions = $('#update-article-category-id option');
                        for (let i = 0; i < articleCategoryOptions.length; i++) {
                            if (articleCategoryOptions[i].value == article.articleCategory.articleCategoryId) {
                                $('#update-article-category-id').get(0).selectedIndex = i;
                                break;
                            }
                        }

                        // TODO文章主图未处理
                        // 设置文章内容富文本编辑器
                        updateue.setContent(article.content);
                    } else {
                        alert(data.message);
                    }
                },
                error: function () {
                    alert('获取数据失败，请刷新');
                }
            });
        })

        // 修改模态框的保存按钮
        $('.update-article').click(function () {
            $('#updateArticle').submit();
        });

    });
</script>
</body>
</html>
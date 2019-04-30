<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>文章类别管理</title>
    <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/bootstrap4/css/bootstrap.min.css">
    <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/css/common.css">
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
                    <th scope="col">类别名</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <#list page.content as category>
                <tr>
                    <td>
                        <input type="checkbox" class="check-item">
                    </td>
                    <td>${category_index + 1}</td>
                    <td>${category.categoryName}</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal"
                                data-target="#update-category-model"
                                data-article-category-id="${category.articleCategoryId}"
                                data-category-name="${category.categoryName}">修改
                        </button>
                        <button type="button" class="btn btn-danger btn-sm delete"
                                data-article-category-id="${category.articleCategoryId}">删除
                        </button>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>

        <#-- 添加按钮,开启模态框 -->
            <button type="button" class="btn btn-primary mb-3" data-toggle="modal" data-target="#add-category-model">
                添加
            </button>

        <#-- 添加类别的模态框 -->
            <div class="modal fade" id="add-category-model" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">添加文章类别</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="category-name" placeholder="类别名">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary add-category">保存</button>
                        </div>
                    </div>
                </div>
            </div>

        <#-- 修改模态框 -->
            <div class="modal fade" id="update-category-model" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">修改文章类别</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <input type="hidden" class="form-control" id="update-article-category-id">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="update-category-name" placeholder="类别名">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary update-category">保存</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<script type="text/javascript" src="${springMacroRequestContext.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/bootstrap4/js/bootstrap.min.js"></script>
<script>
    $(function () {
        // 全选全不选功能
        $('.check-all').click(function () {
            $('.check-item').prop('checked', $(this).prop('checked'));
        });

        // 删除按钮的点击事件
        $('.delete').click(function () {
            if (confirm('确定删除吗？删除类别之后所属文章也将被删除')) {
                let articleCategoryId = $(this).data('articleCategoryId');
                location.href = '${springMacroRequestContext.contextPath}/admin/article/deleteArticleCategory?articleCategoryId=' + articleCategoryId;
            }
        });

        // 添加模态框保存按钮的点击事件
        $('.add-category').click(function () {
            let categoryName = $('#category-name').val();
            if (categoryName) {
                $.ajax({
                    type: 'post',
                    url: 'addArticleCategory',
                    data: 'categoryName=' + categoryName,
                    success: function (data) {
                        if (data.status === 0) {
                            location.reload();
                        } else {
                            alert(data.message);
                        }
                    },
                    error: function () {
                        alert('服务器很忙');
                    }
                });
            } else {
                alert('类别名不能为空');
            }
        });

        // 绑定修改模态框打开之前的事件
        $('#update-category-model').on('show.bs.modal', function (e) {
            let articleCategoryId = $(e.relatedTarget).data('articleCategoryId');
            // 类别id显示到修改模态框上
            $('#update-article-category-id').val(articleCategoryId);
            let categoryName = $(e.relatedTarget).data('categoryName');
            // 将类别名显示到修改模态框上
            $('#update-category-name').val(categoryName);
        });

        // 修改模态框保存按钮的点击事件
        $('.update-category').click(function () {
            let articleCategoryId = $('#update-article-category-id').val();
            let categoryName = $('#update-category-name').val();
            if (categoryName) {
                $.ajax({
                    type: 'post',
                    url: 'updateArticleCategory',
                    data: 'articleCategoryId=' + articleCategoryId + '&categoryName=' + categoryName,
                    success: function (data) {
                        if (data.status === 0) {
                            location.reload();
                        } else {
                            alert(data.message);
                        }
                    },
                    error: function () {
                        alert('服务器很忙');
                    }
                });
            }
        });

    });
</script>
</body>
</html>
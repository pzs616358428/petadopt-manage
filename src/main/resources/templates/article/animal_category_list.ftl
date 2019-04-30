<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>动物类别管理</title>
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
                <#list page.getContent() as category>
                <tr>
                    <td>
                        <input type="checkbox" class="check-item"
                               data-animal-category-id="${category.animalCategoryId}">
                    </td>
                    <td>${category_index + 1}</td>
                    <td>${category.categoryName}</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal"
                                data-target="#update-category-model"
                                data-animal-category-id="${category.animalCategoryId}"
                                data-category-name="${category.categoryName}">修改
                        </button>
                        <button type="button" class="btn btn-danger btn-sm delete"
                                data-animal-category-id="${category.animalCategoryId}">删除
                        </button>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>

            <div class="container-fluid padding-0 d-flex justify-content-between">
                <div class="button-wrapper">
                <#-- 添加按钮,开启模态框 -->
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#add-category-model">
                        添加
                    </button>
                <#-- 批量删除按钮 -->
                    <button type="button" class="btn btn-danger delete-checked">删除所选</button>
                </div>
            <#-- 分页按钮 -->
                <nav aria-label="Page navigation example">
                    <ul class="pagination mb-0">
                        <#if page.hasPrevious()>
                        <li class="page-item">
                            <a class="page-link"
                               href="${springMacroRequestContext.contextPath}/admin/article/animalCategoryList?pageNum=${page.previousPageable().getPageNumber() + 1}"
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
                                <li class="page-item"><a class="page-link"
                                                         href="${springMacroRequestContext.contextPath}/admin/article/animalCategoryList?pageNum=${num}">${num}</a>
                                </li>
                            </#if>
                        </#list>

                        <#if page.hasNext()>
                        <li class="page-item">
                            <a class="page-link"
                               href="${springMacroRequestContext.contextPath}/admin/article/animalCategoryList?pageNum=${page.nextPageable().getPageNumber() + 1}"
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
            <div class="modal fade" id="add-category-model" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">添加宠物类别</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="add-category-name" placeholder="类别名">
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

            <!-- 修改模态框 -->
            <div class="modal fade" id="update-category-model" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">修改宠物类别</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <input type="hidden" class="form-control" id="update-animal-category-id">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="update-category-name" placeholder="类别名">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
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
                let animalCategoryId = $(this).data('animalCategoryId');
                location.href = '${springMacroRequestContext.contextPath}/admin/article/deleteAnimalCategory?animalCategoryId=' + animalCategoryId;
            }
        });

        // 删除所选按钮点击事件
        $('.delete-checked').click(function () {
            let animalCategoryIds = new Array();
            $('.check-item').each(function (index, item) {
                // 注意,遍历出来的item为js原生节点对象
                if ($(item).prop('checked')) {
                    animalCategoryIds.push($(item).data('animalCategoryId'));
                }
            });
            // 判断数组长度
            if (animalCategoryIds.length && confirm('确定删除吗？删除类别之后所属文章也将被删除')) {
                location.href = '${springMacroRequestContext.contextPath}/admin/article/deleteAnimalCategorys?animalCategoryIds=' + animalCategoryIds;
            }
        });

        // 添加模态框保存按钮的点击事件
        $('.add-category').click(function () {
            let categoryName = $('#add-category-name').val();
            if (categoryName) {
                $.ajax({
                    type: 'post',
                    url: 'addAnimalCategory',
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
            let animalCategoryId = $(e.relatedTarget).data('animalCategoryId');
            // 类别id显示到修改模态框上
            $('#update-animal-category-id').val(animalCategoryId);
            let categoryName = $(e.relatedTarget).data('categoryName');
            // 将类别名显示到修改模态框上
            $('#update-category-name').val(categoryName);
        });

        // 修改模态框的保存按钮
        $('.update-category').click(function () {
            let animalCategoryId = $('#update-animal-category-id').val();
            let categoryName = $('#update-category-name').val();
            if (categoryName) {
                $.ajax({
                    type: 'post',
                    url: 'updateAnimalCategory',
                    data: 'animalCategoryId=' + animalCategoryId + '&categoryName=' + categoryName,
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
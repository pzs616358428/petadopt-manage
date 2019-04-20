<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>百科管理</title>
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
                        <button type="button" class="btn btn-primary btn-sm">修改</button>
                        <button type="button" class="btn btn-danger btn-sm delete" categoryid="${category.categoryId}">删除</button>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript" src="${springMacroRequestContext.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/bootstrap4/js/bootstrap.min.js"></script>
<script>
    $(function () {
        // 全选全不选功能
        $(".check-all").click(function () {
            $(".check-item").prop("checked", $(this).prop("checked"));
        });
        // 删除按钮的点击事件
        $(".delete").click(function () {
            let categoryId = $(this).attr("categoryid");
            // 发送删除请求
            location.href = "${springMacroRequestContext.contextPath}/admin/encyclopedias/deleteCategory?categoryId=" + categoryId;
        });
    });
</script>
</body>
</html>
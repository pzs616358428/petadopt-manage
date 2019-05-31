<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>领养列表页</title>
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
                    <th scope="col">#</th>
                    <th scope="col">用户</th>
                    <th scope="col">地区</th>
                    <th scope="col">宠物类别</th>
                    <th scope="col">标题</th>
                    <th scope="col">发布时间</th>
                    <th scope="col">审核状态</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <#list page.content as adopt>
                <tr>
                    <td>${adopt_index + 1}</td>
                    <td>${adopt.member.memberInfo.nickname}</td>
                    <td>${adopt.region.regionName}</td>
                    <td>${adopt.animalCategory.categoryName}</td>
                    <td>${adopt.title}</td>
                    <td>${adopt.createTime}</td>
                    <#if adopt.isExamine == 0>
                    <td>未审核</td>
                    <#else>
                    <td>已审核</td>
                    </#if>
                    <td>
                        <button type="button" class="btn btn-info btn-sm detail" data-id="${adopt.adoptId}">查看</button>
                        <button type="button" class="btn btn-danger btn-sm delete" data-id="${adopt.adoptId}">删除
                        </button>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination">

                        <#if page.hasPrevious()>
                        <li class="page-item">
                            <a class="page-link"
                               href="${springMacroRequestContext.contextPath}/admin/adopt/adoptList?pageNum=${page.previousPageable().getPageNumber() + 1}"
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
                                   href="${springMacroRequestContext.contextPath}/admin/adopt/adoptList?pageNum=${num}">${num}</a>
                            </li>
                            </#if>
                        </#list>

                        <#if page.hasNext()>
                        <li class="page-item">
                            <a class="page-link"
                               href="${springMacroRequestContext.contextPath}/admin/adopt/adoptList?pageNum=${page.nextPageable().getPageNumber() + 1}"
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
    </div>
</div>

<script type="text/javascript" src="${springMacroRequestContext.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/bootstrap4/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $('.delete').click(function () {
            let id = $(this).data('id');
            location.href = '${springMacroRequestContext.contextPath}/admin/adopt/deleteAdopt?adoptId=' + id;
        });

        $('.detail').click(function () {
            let id = $(this).data('id');
            location.href = '${springMacroRequestContext.contextPath}/admin/adopt/adoptDetail?adoptId=' + id;
        });
    });
</script>
</body>
</html>
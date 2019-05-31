<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>领养详情页</title>
    <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/bootstrap4/css/bootstrap.min.css">
    <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/css/common.css">
    <style>
        .content {
            overflow-x: hidden;
        }

        .info {
            color: #999;
            margin: 2rem 0;
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
            <h1 class="title">
            ${adopt.animalCategory.categoryName} --  ${adopt.title} -- ${adopt.region.regionName}
            </h1>
            <p class="info">
            ${adopt.member.memberInfo.nickname} -- 发布于 ${adopt.createTime}
            </p>
            <div class="content">
            ${adopt.content}
            </div>
            <div class="operation">
                <#if adopt.isExamine == 0>
                    <a href="${springMacroRequestContext.contextPath}/admin/adopt/examine?adoptId=${adopt.adoptId}"
                       class="btn btn-primary">审核通过</a>
                <#else>
                    <a href="${springMacroRequestContext.contextPath}/admin/adopt/examine?adoptId=${adopt.adoptId}"
                       class="btn btn-danger">取消审核</a>
                </#if>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${springMacroRequestContext.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/bootstrap4/js/bootstrap.min.js"></script>
</body>
</html>
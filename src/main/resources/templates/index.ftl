<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>宠物领养网管理端</title>
    <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/bootstrap4/css/bootstrap.min.css">
    <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/css/common.css">
</head>
<body>
<#-- 引入头部菜单 -->
<#include "common/header_menu.ftl"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-2 padding-0">
            <#-- 引入左侧菜单栏 -->
            <#include "common/left_menu.ftl"/>
        </div>
        <div class="col-10 page-wrapper"></div>
    </div>
</div>

<script type="text/javascript" src="${springMacroRequestContext.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/bootstrap4/js/bootstrap.min.js"></script>
</body>
</html>
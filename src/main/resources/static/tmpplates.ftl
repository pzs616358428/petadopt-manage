<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>模板页面</title>
    <link rel="stylesheet" href="${request.contextPath}/bootstrap4/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/common.css">
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

<script type="text/javascript" src="${request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${request.contextPath}/bootstrap4/js/bootstrap.min.js"></script>
</body>
</html>
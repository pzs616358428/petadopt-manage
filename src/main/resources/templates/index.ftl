<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>宠物领养网管理端</title>
    <link rel="stylesheet" href="${request.contextPath}/bootstrap4/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/common.css">
</head>
<body>
<#--<#include "css/left_menu.ftl"/>-->
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <#-- 引入头部菜单 -->
            <#include "common/header_menu.ftl"/>
        </div>
    </div>
    <div class="row">
        <div class="col-2 padding-0">
            <#-- 引入左侧菜单栏 -->
            <#include "common/left_menu.ftl"/>
        </div>
    </div>
</div>

<script type="text/javascript" src="${request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${request.contextPath}/bootstrap4/js/bootstrap.min.js"></script>
</body>
</html>
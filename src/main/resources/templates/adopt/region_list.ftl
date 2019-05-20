<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>地区列表页</title>
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
                    <th scope="col">地区名</th>
                    <th scope="col">地区描述</th>
                    <th scope="col">主题数</th>
                    <th scope="col">帖子数</th>
                    <th scope="col">最后发布</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <#list regionList as region>
                <tr>
                    <td>
                        <input type="checkbox" class="check-item">
                    </td>
                    <td>${region_index + 1}</td>
                    <td>${region.regionName}</td>
                    <td>${region.description}</td>
                    <td>${region.themeCount}</td>
                    <td>${region.postCount}</td>
                    <td>${region.lastTime}</td>
                    <td>
                        <#--<button type="button" class="btn btn-primary btn-sm">修改</button>-->
                        <button type="button" class="btn btn-danger btn-sm delete" data-id="${region.regionId}">删除</button>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>

            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addRegion">添加</button>

            <!-- Modal -->
            <div class="modal fade" id="addRegion" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">添加地区</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="${springMacroRequestContext.contextPath}/admin/adopt/addRegion" method="post" id="saveRegion">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="region_name" name="regionName" placeholder="请输入地区名">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="description" name="description" placeholder="请输入地区描述">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary saveRegion">保存</button>
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
        // 添加模态框的保存按钮
        $('.saveRegion').click(function () {
            console.log(1);
            $('#saveRegion').submit();
        });

        // 删除按钮的事件
        $('.delete').click(function () {
            const id = $(this).data('id');
            location.href = '${springMacroRequestContext.contextPath}/admin/adopt/deleteRegion?id=' + id;
        });

    });
</script>
</body>
</html>
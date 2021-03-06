<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${springMacroRequestContext.contextPath}/admin/index">宠物领养网</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
        <form class="form-inline my-2 my-lg-0" action="javascript:;">
            <input class="form-control mr-sm-2" type="search" placeholder="请输入搜索内容" aria-label="Search">
            <button class="btn btn-info my-2 my-sm-0" type="submit">搜索</button>
        </form>
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle pt-0 pb-0 ml-1" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <#if Session.user.userInfo.headportrait?? && Session.user.userInfo.headportrait != "">
                        <img src="${Session.user.userInfo.headportrait}" width="36" height="36" class="rounded-circle">
                        <#else >
                        <img src="${springMacroRequestContext.contextPath}/image/default-head.png" width="36" height="36" class="rounded-circle">
                    </#if>
                </a>
                <div class="dropdown-menu dropdown-menu-right md-0" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="javascript:;">个人中心</a>
                    <a class="dropdown-item" href="${springMacroRequestContext.contextPath}/admin/user/logout">退出</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
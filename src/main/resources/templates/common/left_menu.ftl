<div id="accordion">
    <div class="card">
        <div class="card-header bg-dark" id="heading-one">
            <a href="#collapse-one" class="btn btn-dark btn-block text-left" data-toggle="collapse" aria-expanded="true"
               aria-controls="collapse-one">
                知识百科管理
            </a>
        </div>
        <ul id="collapse-one" class="collapse show list-group" aria-labelledby="heading-one" data-parent="#accordion">
            <li class="list-group-item">
                <a href="${springMacroRequestContext.contextPath}/admin/article/articleList" class="btn btn-link">文章管理</a>
            </li>
            <li class="list-group-item">
                <a href="${springMacroRequestContext.contextPath}/admin/article/animalCategoryList" class="btn btn-link">宠物类别管理</a>
            </li>
            <li class="list-group-item">
                <a href="${springMacroRequestContext.contextPath}/admin/article/articleCategoryList" class="btn btn-link">文章类别管理</a>
            </li>
        </ul>
    </div>
    <div class="card">
        <div class="card-header bg-dark rounded-0" id="heading-two">
            <a href="#collapse-two" class="btn btn-dark btn-block text-left" data-toggle="collapse" aria-expanded="true"
               aria-controls="collapse-two">
                用户管理
            </a>
        </div>
        <ul id="collapse-two" class="collapse list-group" aria-labelledby="heading-two" data-parent="#accordion">
            <li class="list-group-item">
                <a href="javascript:;" class="btn btn-link">管理员</a>
            </li>
            <li class="list-group-item">
                <a href="javascript:;" class="btn btn-link">用户</a>
            </li>
        </ul>
    </div>
</div>
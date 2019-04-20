<div id="accordion">
    <div class="card">
        <div class="card-header bg-dark" id="heading-one">
            <a href="#collapse-one" class="btn btn-dark btn-block text-left" data-toggle="collapse" aria-expanded="true"
               aria-controls="collapse-one">
                百科管理
            </a>
        </div>
        <ul id="collapse-one" class="collapse show list-group" aria-labelledby="heading-one" data-parent="#accordion">
            <li class="list-group-item">
                <a href="${springMacroRequestContext.contextPath}/admin/encyclopedias/list" class="btn btn-link">百科</a>
            </li>
            <li class="list-group-item">
                <a href="${springMacroRequestContext.contextPath}/admin/encyclopedias/categoryList" class="btn btn-link">类别</a>
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
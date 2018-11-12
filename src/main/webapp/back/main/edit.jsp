<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form id="editUserInputForm" class="easyui-form" method="post">
        <input type="hidden" name="id" value="${sessionScope.admins.id}">
        <input type="hidden" name="name" value="${sessionScope.admins.name}">
        <div style="margin-top: 50px;">
            新&nbsp;&nbsp;密&nbsp;码: <input type="text" name="password"  class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            确认密码: <input type="text" name="pwd"  class="easyui-textbox">
        </div>
    </form>
</div>
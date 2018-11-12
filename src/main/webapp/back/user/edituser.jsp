<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#editUserInputForms").form('load','${pageContext.request.contextPath}/user/findOneUser?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="editUserInputForms" class="easyui-from" method="post">
        <div style="margin-top: -14px;">
        <input name="id" type="hidden" value="${param.id}" class="easyui-textbox">
        <input name="phoneNum" type="hidden" class="easyui-textbox">
        <input name="username" type="hidden" class="easyui-textbox">
        <input name="password" type="hidden" class="easyui-textbox">
        <input name="salt" type="hidden" class="easyui-textbox">
        <input name="province" type="hidden" class="easyui-textbox">
        <input name="city" type="hidden" class="easyui-textbox">
        <input name="nickName" type="hidden" class="easyui-textbox">
        <input name="sign" type="hidden" class="easyui-textbox">
        <input name="headPic" type="hidden" class="easyui-textbox">
        <input name="date" type="hidden" class="easyui-datebox">
        <input name="gender" type="hidden" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            状&nbsp;态：<input name="status" type="text" class="easyui-textbox">
        </div>
    </form>
</div>
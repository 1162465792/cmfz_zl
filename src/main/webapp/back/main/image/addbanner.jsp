<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form id="editUserInputForm" class="easyui-from" method="post" enctype="multipart/form-data">

        <div style="margin-top: 50px;">
            名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input name="title" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            显示时间：<input name="description" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：<input name="status" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            选择文件：<input class="easyui-filebox" name="aas">
        </div>
    </form>
</div>
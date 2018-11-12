<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form id="addChapterInputForm" class="easyui-from" method="post"  enctype="multipart/form-data">
        <div style="margin-top: 50px;">
            <input type="hidden" name="album_id" value="${param.id}" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;margin-left: 70px">
            选择音频：<input type="file" name="ff">
        </div>
    </form>
</div>
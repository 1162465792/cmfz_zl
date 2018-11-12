<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#editnInputForm").form('load','${pageContext.request.contextPath}/album/findOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="editnInputForm" class="easyui-form" method="post">
        <input type="hidden" name="id">
        <div style="margin-top: 50px;">
            名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input name="title" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            封面图片：<input name="coverimg" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            章&nbsp;节&nbsp;&nbsp;数：<input name="count" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            星&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级：<input name="star" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：<input name="author" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：<input name="broadCast" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            简&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;介：<input name="brief" type="text" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            上传时间: <input type="text" name="publishDate"  class="easyui-datebox">
        </div>
    </form>
</div>
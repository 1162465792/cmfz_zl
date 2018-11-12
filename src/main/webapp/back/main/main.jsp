<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.edatagrid.js"></script>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/back/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/form.validator.rules.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.edatagrid.js"></script>
<script type="text/javascript">
    $(function () {
        $.post("${pageContext.request.contextPath}/Menu/queryAllMenu",function (menu) {
            if(menu=="error"){
                location="${pageContext.request.contextPath}/back/login.jsp";
            }
            $.each(menu,function (index,m) {
                var content="<div style='text-align: center'>";
                $.each(m.menus,function (idx,child) {
                    content += "<a onclick=\"addTabs('"+child.name+"','"+child.iconCls+"','"+child.href+"')\" style='width:95%;margin:10px 0px; border: 1px #00ee00 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.name+"</a><br>";
                });
                content+="</div>"
                $("#menu").accordion('add',{
                    title:m.name,
                    iconCls:m.iconCls,
                    content:content,
                });
            });
        });
    });
	/*二级菜单*/
    function addTabs(title,iconCls,href){
        if(!$("#tabs").tabs('exists',title)){
            $("#tabs").tabs('add',{
                title:title,
                iconCls:iconCls,
                closable:true,
                fit:true,
                href:"${pageContext.request.contextPath}/"+href,
            });
        }else{
            $("#tabs").tabs('select',title);
        }
    }
	<!--修改密码-->
    function editadmin() {
        $("#editUserDialog").dialog({
            href:'${pageContext.request.contextPath}/back/main/edit.jsp',
            buttons:[
                {
                    iconCls:'icon-save',
                    text:'修改',
                    handler:function(){
                        $("#editUserInputForm").form('submit',{
                            url:'${pageContext.request.contextPath}/admin/updateAdmin',
                            success:function (result) {
                                var s = $.parseJSON(result);
                                if (s.success) {
                                    $("#editUserDialog").dialog('close');
                                    $.messager.show({title: '提示', msg: "密码修改成功!!!"});
                                }else {
                                    $("#editUserDialog").dialog('close');
                                    $.messager.show({title: '提示', msg:s.message});
                                }
                            }
                        })
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function(){
                        $("#editUserDialog").dialog('close');
                    }
                }
            ]
        })
    }
</script>

</head>
    <body class="easyui-layout">
        <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
            <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
            <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admins.name} &nbsp;<a href='javascript:;' class="easyui-linkbutton" onclick="editadmin()" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/remveAdmin" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
        </div>
        <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
            <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
        </div>
        <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
            <div id="menu" class="easyui-accordion" data-options="fit:true">
            </div>
        </div>
        <div data-options="region:'center'">
            <div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
                <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
            </div>
        </div>
        <div id="editUserDialog" data-options="draggable:false,iconCls:'icon-edit',width:400,height:250,title:'修改密码'"></div>
    </body>
</html>
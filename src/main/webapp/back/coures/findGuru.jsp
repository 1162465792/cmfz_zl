<%@page pageEncoding="UTF-8" isELIgnored="false" isErrorPage="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-detailview.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.edatagrid.js"></script>

<script>
    $(function () {
        $("#coures").datagrid({
            url:'${pageContext.request.contextPath}/coures/findCoures',
            fitColumns:true,
            autoRowHeight:true,
            height:460,
            resizeHandle:'both',
            striped:true,//斑马线效果
            loadMsg:'正在加载,请等待.....',
            toolbar:[{
                text:'添加',
                iconCls:'icon-add',
                handler:function () {
                    $("#saveCouresEdit").dialog({
                        buttons:[{
                            text:'保存',
                            iconCls:'icon-add',
                            handler:function () {
                                $("#editCouresInputForms").form('submit',{
                                    url:'${pageContext.request.contextPath}/coures/addCoures',
                                    success:function () {
                                        $("#saveCouresEdit").dialog('close');
                                        $("#coures").datagrid('reload');
                                    }
                                })
                            }
                        },{
                            text:'取消',
                            iconCls:'icon-cancel',
                            handler:function () {
                                $("#saveCouresEdit").dialog('close');
                            }
                        }]
                    })
                }
            }],
            columns:[[
                {title:'id',field:'id',width:100},
                {title:'名称',field:'title',width:100,},
                {title:'是否必修',field:'marking',width:100},
                {title:'创建时间',field:'creatTime',width:100},
                {title:'操作',field:'options',width:100,
                    formatter:function (value,row,index) {
                        return "<a href='javascript:;' onclick=\"delRow('"+row.id+"')\" class='options' data-options=\"iconCls:'icon-remove'\">删除</a>"
                    }
                }
            ]],
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
        });
    });
    function delRow(id) {
        var idds=$("#coures").treegrid('getSelected');
        if (idds.marking==3){
            $.post('${pageContext.request.contextPath}/coures/removeCoures',{'id':id},function () {
                $("#coures").datagrid('reload');
            })
        }else {
            $.messager.show({title:'提示',msg:"不在管理员权限范围之类!!!"});
        }
    }
</script>
<table id="coures"></table>
<%--添加主修功课--%>
<div id="saveCouresEdit" data-options="href:'${pageContext.request.contextPath}/back/coures/editcoures.jsp',width:400,height:300"></div>
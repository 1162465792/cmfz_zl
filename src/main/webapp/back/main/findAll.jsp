<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-detailview.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.edatagrid.js"></script>

<script>
    $(function () {
        $("#deprDate").datagrid({
            url:'${pageContext.request.contextPath}/banner/findAllBanner',
            updateUrl:'${pageContext.request.contextPath}/banner/updateBanner',
            fitColumns:true,
            autoRowHeight:true,
            height:460,
            resizeHandle:'both',
            striped:true,//斑马线效果
            loadMsg:'正在加载,请等待.....',
            toolbar:[
                {
                    text:'添加用户',
                    iconCls:'icon-add',
                    handler:function(){
                        $("#saveUserDialog").dialog({
                            buttons:[
                                {
                                    iconCls:'icon-save',
                                    text:'保存',
                                    handler:function(){
                                        $("#editUserInputForm").form('submit',{
                                            url:'${pageContext.request.contextPath}/banner/insertBanner',
                                            success:function (result) {
                                                $("#saveUserDialog").dialog('close');
                                                $("#deprDate").datagrid('reload');
                                            }
                                        })
                                    }
                                },{
                                    iconCls:'icon-cancel',
                                    text:'关闭',
                                    handler:function(){
                                        $("#saveUserDialog").dialog('close');
                                    }
                                }
                            ]
                        })
                    }
                },
            ],
            columns:[[
                {title:'id',field:'id',width:100},
                {title:'名称',field:'title',width:100},
                {title:'图片',field:'imgPath',width:100},
                {title:'显示时间',field:'description',width:100},
                {title:'状态',field:'status',width:100},
                {title:'上传时间',field:'date',width:100},
                {title:'操作',field:'options',width:100,
                    formatter:function (value,row,index) {
                        return "<a href='javascript:;' onclick=\"delRow('"+row.id+"')\" class='options' data-options=\"iconCls:'icon-remove'\">删除</a>&nbsp;&nbsp;"+
                        "<a href='javascript:;' onclick=\"openBanner('"+row.id+"')\" class='options' data-options=\"iconCls:'icon-edit'\">更新</a>"
                    }
                }
            ]],
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/'+rowData.imgPath+'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>名称: ' + rowData.title + '</p>' +
                    '<p>上传时间: ' + rowData.date + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    });
    /*删除*/
    function delRow(id) {
        $.post('${pageContext.request.contextPath}/banner/deleteBanner',{"id":id},function (result) {
            $("#deprDate").datagrid('reload');
        })
    }
    /*更新*/
    function openBanner(id) {
        $("#editUserDialogs").dialog({
            href:'${pageContext.request.contextPath}/back/main/editbanner.jsp?id='+id,
            buttons:[{
                iconCls:'icon-save',
                text:'更新',
                handler:function () {
                    $("#editUserInputForms").form('submit',{
                        url:'${pageContext.request.contextPath}/banner/updateBanner',
                        success:function () {
                            $("#editUserDialogs").dialog('close');
                            $("#deprDate").datagrid('reload');
                        }
                    })
                }
            }, {
                iconCls:'icon-cancel',
                text:'关闭',
                handler: function () {
                    $("#editUserDialogs").dialog('close');
                }
            },
        ]
        })
    }
</script>
<table id="deprDate"></table>
<%--修改数据--%>
<div id="editUserDialogs" data-options="draggable:false,iconCls:'icon-edit',width:400,height:360,title:'更新用户信息'"></div>
<%--添加数据--%>
<div id="saveUserDialog" data-options="href:'${pageContext.request.contextPath}/back/main/image/addbanner.jsp',draggable:false,iconCls:'icon-save',width:400,height:360,title:'添加用户信息'"></div>

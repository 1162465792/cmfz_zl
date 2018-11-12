<%@page pageEncoding="UTF-8" isELIgnored="false" isErrorPage="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-detailview.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.edatagrid.js"></script>

<script>
    $(function () {
        $("#guru").edatagrid({
            url:'${pageContext.request.contextPath}/guru/findAllGuru',
            fitColumns:true,
            autoRowHeight:true,
            height:460,
            resizeHandle:'both',
            striped:true,//斑马线效果
            loadMsg:'正在加载,请等待.....',
            updateUrl:'${pageContext.request.contextPath}/guru/motisfyGuru',
            toolbar:[{
                text:'添加',
                iconCls:'icon-add',
                handler:function () {
                    $("#saveGuruDialog").dialog({
                        buttons:[
                            {
                                text:'保存',
                                iconCls:'icon-add',
                                handler:function () {
                                    $("#editGuruInputForms").form('submit', {
                                        url:'${pageContext.request.contextPath}/guru/addGuru',
                                        success:function(result) {
                                            $("#saveGuruDialog").dialog('close');
                                            $("#guru").datagrid('reload');
                                        }
                                    })
                                }
                            },{
                                text:'取消',
                                iconCls:'icon-cancel',
                                handler:function () {
                                    $("#saveGuruDialog").dialog('close');
                                }
                            }
                        ]
                    })
                }
            }],
            columns:[[
                {title:'id',field:'id',width:100},
                {title:'图片',field:'headPic',width:100},
                {title:'名称',field:'name',width:100,},
                {title:'状态',field:'status',width:100},
                {title:'性别',field:'sxs',width:100},
                {title:'操作',field:'options',width:100,
                    formatter:function (value,row,index) {
                        return "<a href='javascript:;' onclick=\"delRow('"+row.id+"')\" class='options' data-options=\"iconCls:'icon-remove'\">删除</a>"
                    }
                }
            ]],
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/'+rowData.headPic+'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>名称: ' + rowData.name + '</p>' +
                    '<p>性别: ' + rowData.sxs + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    });
    function delRow(id) {
        $.post('${pageContext.request.contextPath}/guru/removeGuru',{'id':id},function () {
            $("#guru").datagrid('reload');
        })
    }
</script>
<table id="guru"></table>
<%--添加数据--%>
<div id="saveGuruDialog" data-options="href:'${pageContext.request.contextPath}/back/guru/editguru.jsp',draggable:false,iconCls:'icon-save',width:400,height:360,title:'添加用户信息'"></div>

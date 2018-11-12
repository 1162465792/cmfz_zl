<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-detailview.js"></script>
<script>
    $(function () {
        $("#users").datagrid({
            url:"${pageContext.request.contextPath}/user/findAllUser",
            fitColumns:true,//让列自适应整个容器
            autoRowHeight:true,//自动适应行高
            height:300,
            resizeHandle:'both',
            striped:true,//斑马线效果
            loadMsg:'正在加载,请等待.....',
            pagination:true,//页码
            pageNumber:1,//当前页
            pageSize:2,//每页显示记录数
            pageList:[2,4,10,20,50],//下拉列表的值
            columns:[[
                {title:'用户名',field:'username',width:100},
                {title:'职位',field:'province',width:100},
                {title:'城市',field:'city',width:100},
                {title:'法名',field:'nickName',width:100},
                {title:'性别',field:'gender',width:100},
                {title:'作者图片',field:'headPic',width:100},
                {title:'状态',field:'status',width:100},
                {title:'注册时间',field:'date',width:100},
                {title:'操作',field:'options',width:100,
                    formatter:function (value,row,index) {
                        return "<a href='javascript:;' onclick=\"openBanner('"+row.id+"')\" class='options' data-options=\"iconCls:'icon-edit'\">更新</a>"
                    }
                }
            ]],
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
        });

    });
    /*更新*/
    function openBanner(id) {
        $("#editUserDialogs").dialog({
            href:'${pageContext.request.contextPath}/back/user/edituser.jsp?id='+id,
            buttons:[{
                iconCls:'icon-save',
                text:'更新',
                handler:function () {
                    $("#editUserInputForms").form('submit',{
                        url:'${pageContext.request.contextPath}/user/updateUser',
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
<table id="users" class="eayui-datagrid" data-option="fit:true"></table>
<div id="editUserDialogs" data-options="draggable:false,iconCls:'icon-edit',width:400,height:160,title:'更新用户状态'"></div>

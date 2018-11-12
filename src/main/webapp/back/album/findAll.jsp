<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-detailview.js"></script>
<script>
    $(function () {
        $('#tt').treegrid({
            url:'${pageContext.request.contextPath}/album/findAllAlbum',
            fitColumns:true,
            idField:'id',
            treeField:'title',
            collapsible:true,
            animate:true,
            width:1100,
            height:400,
            pagination:true,//页码
            pageNumber:1,//当前页
            pageSize:10,//每页显示记录数
            pageList:[10,20,50],//下拉列表的值
            columns:[[
                {title:'专辑名称',field:'title',width:100},
                {title:'作者',field:'author',width:100},
                {title:'上传时间',field:'uploadTime',width:100},
                {title:'音频大小',field:'size',width:100},
                {title:'时长',field:'downPath',width:100},
                {title:'下载路径',field:'duration',width:100},
                {title:'简介',field:'brief',width:100},
            ]],
            toolbar:[
                {
                    text:'专辑详细',
                    iconCls:'icon-search',
                    handler:function () {
                        var idd=$("#tt").treegrid('getSelected');
                        if (idd.album_id==null){
                        if (idd==""||idd==null){
                            $.messager.show({title:'提示',msg:"必须选择一个专辑!!!"});
                        }else {
                            var s=idd.id;
                            $("#findAlbum").dialog({
                                href:'${pageContext.request.contextPath}/back/album/editablum.jsp?id='+s,
                            })
                        }
                    }
                        else {
                            $.messager.show({title:'提示',msg:"必须选择专辑!!!"});
                        }
                    }
                },
                {
                    text:'添加专辑',
                    iconCls:'icon-add',
                    handler:function(){

                        $("#saveAlbumDialog").dialog({
                            buttons:[{
                                text:'保存',
                                iconCls:'icon-add',
                                handler:function () {
                                    $("#editAlbumInputForm").form('submit',{
                                        url:'${pageContext.request.contextPath}/album/addAlbums',
                                        success:function (result) {
                                            $("#saveAlbumDialog").dialog('close');
                                            $("#tt").datagrid('reload');
                                        }
                                    })
                                }
                            },{
                                text:'取消',
                                iconCls:'icon-remove',
                                handler:function () {
                                    $("#saveAlbumDialog").dialog('close');
                                }
                                }
                            ]
                        })
                    }
                },
                {
                    text:'添加章节',
                    iconCls:'icon-edit',
                    handler:function(){
                        var idds=$("#tt").treegrid('getSelected');
                        if (idds.album_id==null){
                            $("#saveChapterDialog").dialog({
                                href:'${pageContext.request.contextPath}/back/album/addchapter.jsp?id='+idds.id,
                                buttons:[{
                                    text:'保存',
                                    iconCls:'icon-add',
                                    handler:function () {
                                        $("#addChapterInputForm").form('submit',{
                                            url:'${pageContext.request.contextPath}/chapter/insertChapter',
                                            success:function (result) {
                                                $("#saveChapterDialog").dialog('close');
                                                $("#tt").datagrid('reload');
                                            }
                                        })
                                    }
                                },{
                                    text:'取消',
                                    iconCls:'icon-remove',
                                    handler:function () {
                                        $("#saveChapterDialog").dialog('close');
                                    }
                                }
                                ]
                            })
                        }else {
                            $.messager.show({title:'提示',msg:"必须选择专辑!!!"});
                        }
                    }
                },
                {
                    text:'下载音频',
                    iconCls:'icon-reload',
                    handler:function(){
                        var idds=$("#tt").treegrid('getSelected');
                        if (idds.album_id!=null){
                            window.location="${pageContext.request.contextPath}/chapter/download?fileName="+idds.title;
                        }else {
                            $.messager.show({title:'提示',msg:"必须选择章节!!!"});
                        }
                    }
                }
            ],
        });
    });
</script>
<table id="tt" style="width:600px;height:400px"></table>
<%--添加专辑数据--%>
<div id="saveAlbumDialog" data-options="href:'${pageContext.request.contextPath}/back/album/addalbum.jsp',draggable:false,iconCls:'icon-save',width:500,height:450,title:'添加专辑'"></div>
<%--查看专辑详情--%>
<div id="findAlbum" data-options="width:500,height:450,title:'查看专辑详情'"></div>
<%--添加章节数据--%>
<div id="saveChapterDialog" data-options="draggable:false,iconCls:'icon-save',width:400,height:250,title:'添加章节'"></div>
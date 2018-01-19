<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>安全生产事故及控制平台</title>

        <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icons">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="stylesheet" type="text/css" href="css/base.css">

        <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
        <script type="text/javascript" src="js/index.js"></script>
        <script type="text/javascript" src="js/WdatePicker.js"></script>

        <style type="text/css"></style>
        <script></script>
    </head>

    <body class="easyui-layout">
        <div id="north_title" data-options="region:'north',border:false" style="height:60px;padding:10px;">安全生产事故及控制平台</div>

        <div id="west_menus" data-options="region:'west',split:true,title:'菜单'" style="width:240px;padding:10px;">
            <ul>
                <li><a >重特大事故</a></li>
                <li><a>建筑事故</a></li>
                <li><a>化工事故</a></li>
                <li><a>交通事故</a></li>
            </ul>
        </div>

        <div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">下标题...</div>
        <div data-options="region:'center',title:'Center'">
            <button id="add" onclick="main_accident_add()">
                添加
            </button>
            <button id="delete" onclick="main_accident_delete()">
                删除
            </button>
            <%--首页表单--%>
            <table id="accident_datagrid" class="easyui-datagrid" title="基本信息数据" style="width:94%;height:70%"
                           data-options="rownumbers:true,checkbox:true,pagination:true,striped: true,singleSelect:true,
                        collapsible:true">
                <thead>
                        <tr>
                            <th data-options="field:'checkbox',checkbox:true" style="width:2%" align="center"></th>
                            <th data-options="field:'accidentId',hidden:'true'" style="width:10%" align="center"></th>
                            <th data-options="field:'accidentName',formatter:details,halign:'center'" style="width:20%" align="center">事故名称</th>
                            <th data-options="field:'occurrencePlace'" style="width:20%" align="center">事故发生地点</th>
                            <th data-options="field:'occurrenceTime'" style="width:15%" align="center">事故发生时间</th>
                            <th data-options="field:'isAnalysis'" style="width:15%" align="center">是否完成分析</th>
                            <th data-options="field:'userId'" style="width:15%" align="center">创建用户id</th>
                            <th data-options="field:'accidentCategoryId'" style="width:10%" align="center">事故类别id</th>
                            <%--<th data-options="field:'product',formatter:zdwxyjb" style="width:15%" align="center">生产经营情况</th>--%>
                        </tr>
                </thead>
            </table>
        </div>


        <%--添加页面（window）--%>
        <div id="main_accident_add_window" class="easyui-window" title="事故添加页面" data-options="iconCls:'icon-save',modal:true,closed:true,minimizable: false,maximizable:false,collapsible: false"
             style="top:20%;width:60%;height:300px;padding:10px;;overflow: hidden">
            <form id="main_accident_add_Form"  method="post">
                <div id="dialogarea">
                    <!-- 	库区信息表 ID ，用于删除库区信息表数据时，级联删除 库房列表 信息	 -->
                    <%--<input type="hidden" name="warehouse_Delete_Id" id="warehouse_Delete_Id" />--%>
                    <table id="main_accident_add_table" border="1" cellpadding="1" cellspacing="1" style="border:1px solid red;width: 100%;height: 100%;font-size: 14px;color: #222222;font-family: 微软雅黑">
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">事故名称：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <input type="text" id="accidentName" name="accidentName" class="easyui-validatebox" data-options="required:true,missingMessage:'非空选项',validType:['unnormal','length[1,50]']" style="width:130px;border:1px solid red;"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">事故发生地点 ：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <input id="occurrencePlace" name="occurrencePlace" data-options="" style="width:130px;border:1px solid red;" class="easyui-validatebox" />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">是否完成分析：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <input type="text" id="isAnalysis" name="isAnalysis" class="easyui-validatebox" data-options="required:true,missingMessage:'请输入数字',validType:['intOrFloat','unnormal','length[1,10]']" style="width:130px;border:1px solid red;"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">事故发生时间：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <input type="text" id="occurrenceTime" name="occurrenceTime" class="easyui-datetimebox"  data-options="required:true" style="width:130px;border:1px solid red;"/>
                                </div>
                            </td>
                        </tr>
                    </table>
                    <hr/>
                </div>
            </form>
            <div style="float: right">
                <button id="main_accident_Saves" onclick="main_accident_Save()">
                    保存
                </button>
                <button id="main_accident_Cancels" onclick="main_accident_Cancel()">
                    取消
                </button>
            </div>
        </div>


        <%--详情页面（window）--%>
        <div id="w" class="easyui-window" title="Window Layout" data-options="iconCls:'icon-save',modal:true,closed:true,minimizable: false,maximizable:false,collapsible: false"
             style="top:20%;width:80%;height:400px;padding:10px;;overflow: hidden">

            <%--//内层tabs--%>
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'east',split:true" style="width:100%">
                    <div class="easyui-tabs" style="width:100%;height:100%">
                        <div title="事故基本信息" style="padding:10px;width:100%;height:800px;">
                            <table id="accidentBaseInfo_datagrid" class="easyui-datagrid" title="事故基本信息数据" style="width:80%;height:70%"
                                   data-options="rownumbers:true,checkbox:true,pagination:true,striped: true,singleSelect:true,
                                            collapsible:true">
                                <thead>
                                <tr>
                                    <th data-options="field:'checkbox',checkbox:true" style="width:2%" align="center"></th>
                                    <th data-options="field:'accidentId',hidden:'true'" style="width:3%" align="center"></th>
                                    <th data-options="field:'accidentName',formatter:details,halign:'center'" style="width:13%" align="center">事故名称</th>
                                    <th data-options="field:'occurrencePlace'" style="width:15%" align="center">事故发生地点</th>
                                    <th data-options="field:'occurrenceTime'" style="width:10%" align="center">事故发生时间</th>
                                    <th data-options="field:'isAnalysis'" style="width:10%" align="center">是否完成分析</th>
                                    <th data-options="field:'userId'" style="width:15%" align="center">创建用户id</th>
                                    <th data-options="field:'accidentCategoryId'" style="width:10%" align="center">事故类别id</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                        <div title="事物宏观规律" style="padding:10px">
                            <table id="macroscopic_law_of_accident_datagrid" class="easyui-datagrid" title="事物宏观规律数据" style="width:80%;height:70%"
                                   data-options="rownumbers:true,checkbox:true,pagination:true,striped: true,singleSelect:true,
                                            collapsible:true">
                                <thead>
                                <tr>
                                    <th data-options="field:'checkbox',checkbox:true" style="width:2%" align="center"></th>
                                    <th data-options="field:'accidentId',hidden:'true'" style="width:3%" align="center"></th>
                                    <th data-options="field:'accidentName',formatter:details,halign:'center'" style="width:13%" align="center">事故名称</th>
                                    <th data-options="field:'occurrencePlace'" style="width:15%" align="center">事故发生地点</th>
                                    <th data-options="field:'occurrenceTime'" style="width:10%" align="center">事故发生时间</th>
                                    <th data-options="field:'isAnalysis'" style="width:10%" align="center">是否完成分析</th>
                                    <th data-options="field:'userId'" style="width:15%" align="center">创建用户id</th>
                                    <th data-options="field:'accidentCategoryId'" style="width:10%" align="center">事故类别id</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                        <div title="行为原因分析" style="padding:10px">
                            <table id="analysis_of_the_cause_of_behavior_datagrid" class="easyui-datagrid" title="行为原因分析数据" style="width:80%;height:70%"
                                   data-options="rownumbers:true,checkbox:true,pagination:true,striped: true,singleSelect:true,
                                            collapsible:true">
                                <thead>
                                <tr>
                                    <th data-options="field:'checkbox',checkbox:true" style="width:2%" align="center"></th>
                                    <th data-options="field:'accidentId',hidden:'true'" style="width:3%" align="center"></th>
                                    <th data-options="field:'accidentName',formatter:details,halign:'center'" style="width:13%" align="center">事故名称</th>
                                    <th data-options="field:'occurrencePlace'" style="width:15%" align="center">事故发生地点</th>
                                    <th data-options="field:'occurrenceTime'" style="width:10%" align="center">事故发生时间</th>
                                    <th data-options="field:'isAnalysis'" style="width:10%" align="center">是否完成分析</th>
                                    <th data-options="field:'userId'" style="width:15%" align="center">创建用户id</th>
                                    <th data-options="field:'accidentCategoryId'" style="width:10%" align="center">事故类别id</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                        <div title="原因规律统计" style="padding:10px">
                            <table id="statistics_of_reasons_datagrid" class="easyui-datagrid" title="原因规律统计数据" style="width:80%;height:70%"
                                   data-options="rownumbers:true,checkbox:true,pagination:true,striped: true,singleSelect:true,
                                            collapsible:true">
                                <thead>
                                <tr>
                                    <th data-options="field:'checkbox',checkbox:true" style="width:2%" align="center"></th>
                                    <th data-options="field:'accidentId',hidden:'true'" style="width:3%" align="center"></th>
                                    <th data-options="field:'accidentName',formatter:details,halign:'center'" style="width:13%" align="center">事故名称</th>
                                    <th data-options="field:'occurrencePlace'" style="width:15%" align="center">事故发生地点</th>
                                    <th data-options="field:'occurrenceTime'" style="width:10%" align="center">事故发生时间</th>
                                    <th data-options="field:'isAnalysis'" style="width:10%" align="center">是否完成分析</th>
                                    <th data-options="field:'userId'" style="width:15%" align="center">创建用户id</th>
                                    <th data-options="field:'accidentCategoryId'" style="width:10%" align="center">事故类别id</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                        <div title="预防控制措施" style="padding:10px">
                            <table id="prevention_and_control_measures_datagrid" class="easyui-datagrid" title="预防控制措施数据" style="width:80%;height:70%"
                                   data-options="rownumbers:true,checkbox:true,pagination:true,striped: true,singleSelect:true,
                                            collapsible:true">
                                <thead>
                                <tr>
                                    <th data-options="field:'checkbox',checkbox:true" style="width:2%" align="center"></th>
                                    <th data-options="field:'accidentId',hidden:'true'" style="width:3%" align="center"></th>
                                    <th data-options="field:'accidentName',formatter:details,halign:'center'" style="width:13%" align="center">事故名称</th>
                                    <th data-options="field:'occurrencePlace'" style="width:15%" align="center">事故发生地点</th>
                                    <th data-options="field:'occurrenceTime'" style="width:10%" align="center">事故发生时间</th>
                                    <th data-options="field:'isAnalysis'" style="width:10%" align="center">是否完成分析</th>
                                    <th data-options="field:'userId'" style="width:15%" align="center">创建用户id</th>
                                    <th data-options="field:'accidentCategoryId'" style="width:10%" align="center">事故类别id</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>

                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:alert('ok')" style="width:80px">Ok</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:alert('cancel')" style="width:80px">Cancel</a>
                </div>
            </div>
        </div>
    </body>

</html>
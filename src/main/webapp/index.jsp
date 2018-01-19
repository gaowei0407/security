<%@ page language="java" pageEncoding="UTF-8"%>

<%
    Object userId = session.getAttribute("userId");
    Object userNames = session.getAttribute("userName");
%>

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
        <script type="text/javascript" src="js/Util.js"></script>
        <script type="text/javascript" src="js/WdatePicker.js"></script>

        <style type="text/css"></style>
        <script></script>
    </head>

    <body class="easyui-layout">
        <input type="hidden" name="accident_Id" id="accident_Id"/>
        <div id="north_title" data-options="region:'north',border:false" style="height:60px;padding:10px;">
            <span>安全生产事故及控制平台</span>
            <div>登录用户：<%=userNames%></div>
        </div>

        <div id="west_menus" data-options="region:'west',split:true,title:'菜单'" style="width:240px;padding:10px;">
            <ul>
                <li style="color: red"><a onclick="sel_all_mainAccident()">查看全部</a></li>
                <li><a onclick="sel_mainAccident()">重特大事故</a></li>
                <li><a onclick="sel_buildingAccident()">建筑事故</a></li>
                <li><a onclick="sel_chemicalAccident()">化工事故</a></li>
                <li><a onclick="sel_trafficAccident()">交通事故</a></li>
            </ul>
        </div>

        <div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">下标题...</div>
        <div data-options="region:'center',title:'Center'">
            <button id="add" onclick="main_accident_add()" style="width: 100px;height: 40px;color: red;font-size: 18px;font-family: 微软雅黑">
                添加
            </button>
            <button id="delete" onclick="main_accident_delete()" style="width: 100px;height: 40px;color: red;font-size: 18px;font-family: 微软雅黑">
                删除
            </button>
            <%--首页表单--%>
            <table id="accident_datagrid" class="easyui-datagrid" title="基本信息数据" style="width:94%;height:70%"
                           data-options="rownumbers:true,checkbox:true,pagination:true,striped: true,singleSelect:false,
                        collapsible:true">
                <thead>
                        <tr>
                            <th data-options="field:'checkbox',checkbox:true" style="width:2%" align="center"></th>
                            <th data-options="field:'accidentId',hidden:'true'" style="width:10%" align="center"></th>
                            <th data-options="field:'accidentName',formatter:details,halign:'center'" style="width:20%" align="center">事故名称</th>
                            <th data-options="field:'occurrencePlace'" style="width:20%" align="center">事故发生地点</th>
                            <th data-options="field:'occurrenceTime'" style="width:15%" align="center">事故发生时间</th>
                            <th data-options="field:'isAnalysis',formatter:analyzeWhetherOrNot" style="width:15%" align="center">是否完成分析</th>
                            <th data-options="field:'userId',hidden:'true'" style="width:15%" align="center">创建用户id</th>
                            <th data-options="field:'accidentCategoryId',formatter:accidentSort" style="width:10%" align="center">事故类别</th>
                        </tr>
                </thead>
            </table>
        </div>


        <%--添加页面（window）--%>
            <div id="main_accident_add_window" class="easyui-window" title="事故添加页面" data-options="iconCls:'icon-save',modal:true,closed:true,minimizable: false,maximizable:false,collapsible: false"
             style="top:20%;width:60%;height:520px;padding:10px;;overflow: hidden">
            <form id="main_accident_add_Form"  method="post">
                <div id="dialogarea">
                    <!-- 	库区信息表 ID ，用于删除库区信息表数据时，级联删除 库房列表 信息	 -->
                    <input type="hidden" name="userId" id="userId" value="<%=userId%>"/>
                    <table id="main_accident_add_table" border="1" cellpadding="1" cellspacing="1" style="border:1px solid red;width: 100%;height: 100%;font-size: 14px;color: #222222;font-family: 微软雅黑">
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">事故名称：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <input type="text" id="accidentName" name="accidentName" class="easyui-validatebox" data-options="required:true,missingMessage:'非空选项',validType:['unnormal','length[1,50]']" style="width:200px;border:1px solid red;"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">事故发生地点 ：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <input id="occurrencePlace" name="occurrencePlace" data-options="required:true,missingMessage:'非空选项',validType:['unnormal','length[1,50]']" style="width:200px;border:1px solid red;" class="easyui-validatebox" />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">是否完成分析：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <select class="easyui-validatebox" id="isAnalysis" name="isAnalysis" onchange="cascade(this.value)" data-options="required:true,validType:['unnormal']" style="width:200px;border:1px solid red;">
                                        <option selected="selected" value="">请选择</option>
                                        <option value="1">未完成</option>
                                        <option value="2">已完成</option>
                                    </select>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">事故类型：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <select class="easyui-validatebox" id="accidentCategoryId" name="accidentCategoryId" onchange="cascade(this.value)" data-options="required:true,validType:['unnormal']" style="width:200px;border:1px solid red;">
                                        <option selected="selected" value="">请选择</option>
                                        <option value="1">重特大事故</option>
                                        <option value="2">建筑事故</option>
                                        <option value="3">化工事故</option>
                                        <option value="4">交通事故</option>
                                    </select>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">事故发生时间：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <input type="text" id="occurrenceTime" name="occurrenceTime" class="easyui-datetimebox"  data-options="required:true" style="width:200px;border:1px solid red;"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">事故调查报告：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <textarea name="accident_investigation_report" id="accident_investigation_report" style="width: 99%" class="easyui-validatebox" data-options="required:true,missingMessage:'非空选项',validType:['unnormal','length[1,100]']" ></textarea>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">事物宏观规律：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <textarea name="macroscopic_law_of_content" id="macroscopic_law_of_content" style="width: 99%" class="easyui-validatebox" data-options="required:true,missingMessage:'非空选项',validType:['unnormal','length[1,100]']" ></textarea>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">行为原因分析：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <textarea name="analysis_of_the_cause_of_behavior_content" id="analysis_of_the_cause_of_behavior_content" style="width: 99%" class="easyui-validatebox" data-options="required:true,missingMessage:'非空选项',validType:['unnormal','length[1,100]']" ></textarea>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">原因规律统计：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <textarea name="statistics_of_reasons_content" id="statistics_of_reasons_content" style="width: 99%" class="easyui-validatebox" data-options="required:true,missingMessage:'非空选项',validType:['unnormal','length[1,100]']" ></textarea>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="inputname" style="text-align: right">预防控制措施：</div>
                            </td>
                            <td>
                                <div class="inputvalue">
                                    <textarea name="prevention_and_control_measures_content" id="prevention_and_control_measures_content" style="width: 99%" class="easyui-validatebox" data-options="required:true,missingMessage:'非空选项',validType:['unnormal','length[1,100]']" ></textarea>
                                </div>
                            </td>
                        </tr>
                    </table>
                    <hr/>
                </div>
            </form>
            <div style="float: right">
                <button id="main_accident_Saves" onclick="main_accident_Save()" style="width: 100px;height: 40px;color: red;font-size: 18px;font-family: 微软雅黑">
                    保存
                </button>
                <button id="main_accident_Cancels" onclick="main_accident_Cancel()" style="width: 100px;height: 40px;color: red;font-size: 18px;font-family: 微软雅黑">
                    关闭
                </button>
            </div>
        </div>


        <%--详情页面（window）--%>
        <div id="w" class="easyui-window" title="Window Layout" data-options="iconCls:'icon-save',modal:true,closed:true,minimizable: false,maximizable:false,collapsible: false"
             style="top:20%;width:80%;height:600px;padding:10px;;overflow: hidden">

            <%--//内层tabs--%>
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'east',split:true" style="width:100%">
                    <div class="easyui-tabs" style="width:100%;height:100%">
                        <div title="事故调查报告" style="padding:10px;width:100%;height:800px;">
                            <table id="accident_investigation_report_datagrid" class="easyui-datagrid" title="事故调查报告数据" style="width:100%;height:400px"
                                   data-options="rownumbers:true,checkbox:true,pagination:true,striped: true,singleSelect:true,
                                            collapsible:true">
                                <thead>
                                <tr>
                                    <th data-options="field:'checkbox',checkbox:true" style="width:2%" align="center"></th>
                                    <th data-options="field:'accidentInvestigationReportId'" style="width:10%" align="center"></th>
                                    <th data-options="field:'accidentId'" style="width:15%" align="center">事故id</th>
                                    <th data-options="field:'content'" style="width:70%" align="center">事故名称</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                        <div title="事物宏观规律" style="padding:10px">
                            <table id="macroscopic_law_of_accident_datagrid" class="easyui-datagrid" title="事物宏观规律数据" style="width:100%;height:400px"
                                   data-options="rownumbers:true,checkbox:true,pagination:true,striped: true,singleSelect:false,
                                            collapsible:true">
                                <thead>
                                    <tr>
                                        <th data-options="field:'checkbox',checkbox:true" style="width:2%" align="center"></th>
                                        <th data-options="field:'macroscopicLawOfAccidentId'" style="width:10%" align="center"></th>
                                        <th data-options="field:'accidentId'" style="width:15%" align="center">事故id</th>
                                        <th data-options="field:'content'" style="width:70%" align="center">事故名称</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <div title="行为原因分析" style="padding:10px">
                            <table id="analysis_of_the_cause_of_behavior_datagrid" class="easyui-datagrid" title="行为原因分析数据" style="width:100%;height:400px"
                                   data-options="rownumbers:true,checkbox:true,pagination:true,striped: true,singleSelect:false,
                                            collapsible:true">
                                <thead>
                                <tr>
                                    <th data-options="field:'checkbox',checkbox:true" style="width:2%" align="center"></th>
                                    <th data-options="field:'analysisOfTheCauseOfBehaviorId'" style="width:10%" align="center">id</th>
                                    <th data-options="field:'accidentId'" style="width:15%" align="center">事故类别id</th>
                                    <th data-options="field:'content'" style="width:70%" align="center">内容</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                        <div title="原因规律统计" style="padding:10px">
                            <table id="statistics_of_reasons_datagrid" class="easyui-datagrid" title="原因规律统计数据" style="width:100%;height:400px"
                                   data-options="rownumbers:true,checkbox:true,pagination:true,striped: true,singleSelect:false,
                                            collapsible:true">
                                <thead>
                                <tr>
                                    <th data-options="field:'checkbox',checkbox:true" style="width:2%" align="center"></th>
                                    <th data-options="field:'statisticsOfReasonsId'" style="width:10%" align="center">id</th>
                                    <th data-options="field:'accidentId'" style="width:15%" align="center">事故类别id</th>
                                    <th data-options="field:'content'" style="width:70%" align="center">内容</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                        <div title="预防控制措施" style="padding:10px">
                            <table id="prevention_and_control_measures_datagrid" class="easyui-datagrid" title="预防控制措施数据" style="width:100%;height:400px;"
                                   data-options="rownumbers:true,checkbox:true,pagination:true,striped: true,singleSelect:false,
                                            collapsible:true">
                                <thead>
                                <tr>
                                    <th data-options="field:'checkbox',checkbox:true" style="width:2%" align="center"></th>
                                    <th data-options="field:'preventionAndControlMeasuresId'" style="width:10%" align="center">id</th>
                                    <th data-options="field:'accidentId'" style="width:15%" align="center">事故类别id</th>
                                    <th data-options="field:'content'" style="width:70%" align="center">内容</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>

                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:$('#w').window('close');" style="width: 100px;height: 40px;color: red;font-size: 18px;font-family: 微软雅黑">关闭</a>
                </div>
            </div>
        </div>
    </body>
</html>
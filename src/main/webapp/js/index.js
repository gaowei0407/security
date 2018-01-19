


//预加载事件
$(function(){

    //加载首页表单
    load_home_datagrid();
});




//加载首页表单
function load_home_datagrid(){
    param = {
        "map": {}
    };
    param.map = {
        "pageNo": 1,
        "pageSize": 20
        /*"accident_category_id": 1,*/
        /*"adposType": 3*/
    };
    $.ajax({
        url : 'http://localhost:8080/security/Accident/queryAllAccident',
        type : "POST",
        data: JSON.stringify(param),
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',
        success : function(result) {
            var data_dadagrid = result.result.data.accidentList.list;
            $('#accident_datagrid').datagrid('loadData', data_dadagrid);
        }
    });
}


//危险特性	对比字典表数据
function analyzeWhetherOrNot(value,rowData,rowIndex){
    var name = ""
    if (value == 1) {
        name = "已完成";
    } else if (value == 2) {
        name = "未完成"
    }
    return name;
}

//危险特性	对比字典表数据
function accidentSort(value,rowData,rowIndex){
    var name = ""
    if (value == 1) {
        name = "重特大事故";
    } else if (value == 2) {
        name = "建筑事故"
    }else if (value == 3) {
        name = "化工事故"
    }else if (value == 4) {
        name = "交通事故"
    }
    return name;
}



function load_home_datagridByAccidentId(accidentId){
    param = {
        "map": {}
    };
    param.map = {
        "pageNo": 1,
        "pageSize": 20,
        "accidentCategoryId": accidentId
    };
    $.ajax({
        url : 'http://localhost:8080/security/Accident/queryAllAccidentByCategoryId',
        type : "POST",
        data: JSON.stringify(param),
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',
        success : function(result) {
            var data_dadagrid = result.result.data.accidentList.list;
            $('#accident_datagrid').datagrid('loadData', data_dadagrid);
        }
    });
}


function sel_all_mainAccident(){
    /*alert("全部...");*/
    load_home_datagrid();
}


function sel_mainAccident(){
    /*alert("重特大事故...");*/
    var accidentId = 1;
    load_home_datagridByAccidentId(accidentId);
}

function sel_buildingAccident(){
    /*alert("建筑事故...");*/
    var accidentId = 2;
    load_home_datagridByAccidentId(accidentId);
}

function sel_chemicalAccident(){
    /*alert("化工事故...");*/
    var accidentId = 3;
    load_home_datagridByAccidentId(accidentId);
}

function sel_trafficAccident(){
    /*alert("交通事故...");*/
    var accidentId = 4;
    load_home_datagridByAccidentId(accidentId);
}





//查看详情  事件
function details(value,rowData,rowIndex){
    var str = "<a href='javascript:void(0)' onclick='danger_Details(&apos;" + rowData.accidentId + "&apos;)'>"+ rowData.accidentName +"</a>";
    return str;
}

function danger_Details(accident) {
    param = {
        "map": {}
    };
    param.map = {
        "pageNo": 1,
        "pageSize": 15
    };
    $.ajax({
        url : 'http://localhost:8080/security/Accident/queryAllAccident',
        type : "POST",
        data: JSON.stringify(param),
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',
        success : function(result) {
            var data_dadagrid = result.result.data.accidentList.list;
            $('#accidentBaseInfo_datagrid').datagrid('loadData', data_dadagrid);
        }
    });
    accident_investigation_report_datagrid ();
    macroscopic_law_of_accident_datagrid();
    analysis_of_the_cause_of_behavior_datagrid();
    statistics_of_reasons_datagrid ();
    prevention_and_control_measures_datagrid();
    $('#w').window('open');
}




//=======重大事故   添加并打开添加页面按钮
function main_accident_add(){
    $('#main_accident_add_window').window('open');
}




//=======重大事故   删除按钮
function main_accident_delete(){
    var sel_Line = $("#accident_datagrid").datagrid("getChecked");
    if(sel_Line.length == 0){
        $.messager.alert("提示信息","请选择要删除的数据...","info");
    }else{
        $.messager.confirm("操作提示", "确定删除该数据吗？", function (data) {
            if (data) {
                param = {
                    "map": {}
                };
                param.map = {
                    "accidentId": sel_Line[0].accidentId
                };
                $.ajax({
                    type: "POST",
                    data: JSON.stringify(param),
                    dataType: 'json',
                    contentType:'application/json;charset=UTF-8',
                    url : 'http://localhost:8080/security/Accident/deleteAccidentById',
                    success : function (data){
                        if(data.result.subCode == "10002"){
                            $.messager.alert("提示信息","删除数据成功...","info");
                            load_home_datagrid();
                            /*$("#accident_datagrid").datagrid("reload");*/
                        }
                    }
                });
             }
         });
    }
}




//=======重大事故  添加并保存数据按钮
function main_accident_Save(){
    var validate = $("#main_accident_add_Form").form("validate");
    if(validate == false) {
        $.messager.alert("消息提醒", "你输入的数据不完整...", "warning");
        return;
    }
    var accidentName = $("#accidentName").val();
    var occurrencePlace = $("#occurrencePlace").val();
    var isAnalysis = $("#isAnalysis").val();
    var accidentCategoryId = $("#accidentCategoryId").val();
    var occurrenceTime = $("#occurrenceTime").datetimebox("getValue");
    var userId = $('#userId').val();

    var accident_investigation_report = $('#accident_investigation_report').val();
    var macroscopic_law_of_content = $('#macroscopic_law_of_content').val();
    var analysis_of_the_cause_of_behavior_content = $('#analysis_of_the_cause_of_behavior_content').val();
    var statistics_of_reasons_content = $('#statistics_of_reasons_content').val();
    var prevention_and_control_measures_content = $('#prevention_and_control_measures_content').val();

    /*alert("accidentName: " + accidentName + ",occurrencePlace: " + occurrencePlace + ",isAnalysis: " + isAnalysis + ",occurrenceTime: " + occurrenceTime );*/
    var datas = $('#main_accident_add_Form').serialize();
    param = {
        "map": {}
    };
    param.map = {
        "accidentName": accidentName,
        "occurrencePlace" : occurrencePlace,
        "occurrenceTime": occurrenceTime,
        "isAnalysis": isAnalysis,
        "userId": userId,
        "accidentCategoryId": accidentCategoryId,
        "reportContent": accident_investigation_report,
        "behaviorContent": analysis_of_the_cause_of_behavior_content,
        "macroscopicContent":  macroscopic_law_of_content,
        "measuresContent": prevention_and_control_measures_content,
        "reasonsContent": statistics_of_reasons_content
    };

    $.ajax({
        type: "POST",
        /*data:$('#main_accident_add_Form').serialize(),// 序列化表单值*/
        data: JSON.stringify(param),
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',
        url : 'http://localhost:8080/security/Accident/addAccident',
        success : function (data){
                if(data.result.data.isSuccess == "1"){
                    $.messager.alert("提示信息",data.result.subMessage,"info");
                    $('#main_accident_add_window').window('close');
                    load_home_datagrid();
                }
        }
    });
}




//=======重大事故  取消并关闭按钮
function main_accident_Cancel(){
    $('#main_accident_add_window').window('close');
}




//加载    事故调查报告表单
function accident_investigation_report_datagrid (){
    param = {
        "map": {}
    };
    param.map = {
        "pageNo": 1,
        "pageSize": 20,
        "accidentId": 1
    };
    $.ajax({
        url : 'http://localhost:8080/security/Accident/queryInvestigationReportByAccidentId',
        type : "POST",
        data: JSON.stringify(param),
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',
        success : function(result) {
            var data_dadagrids = result.result.data.accidentReport;
            $('#accident_investigation_report_datagrid').datagrid('loadData', data_dadagrids);
        }
    });
}



//加载事物宏观规律表单
function macroscopic_law_of_accident_datagrid (){
    param = {
        "map": {}
    };
    param.map = {
        "pageNo": 1,
        "pageSize": 20,
        "accidentId": 1
        /*"accidentId": accident_id*/
    };
    $.ajax({
        url : 'http://localhost:8080/security/Accident/queryMacroscopicLawOfAccidentByAccidentId',
        type : "POST",
        data: JSON.stringify(param),
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',
        success : function(result) {
            var data_dadagrids = result.result.data.accidentMacroscopicLaw;
            $('#macroscopic_law_of_accident_datagrid').datagrid('loadData', data_dadagrids);
        }
    });
}


//加载    行为原因分析表单
function analysis_of_the_cause_of_behavior_datagrid (){
    param = {
        "map": {}
    };
    param.map = {
        "pageNo": 1,
        "pageSize": 20,
        "accidentId": 1
    };
    $.ajax({
        url : 'http://localhost:8080/security/Accident/queryAnalysisOfTheCauseOfBehaviorByAccidentId',
        type : "POST",
        data: JSON.stringify(param),
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',
        success : function(result) {
            var data_dadagrids = result.result.data.accidentReason;
            $('#analysis_of_the_cause_of_behavior_datagrid').datagrid('loadData', data_dadagrids);
        }
    });
}


//加载    原因规律统计表单
function statistics_of_reasons_datagrid (){
    param = {
        "map": {}
    };
    param.map = {
        "pageNo": 1,
        "pageSize": 20,
        "accidentId": 1
    };
    $.ajax({
        url : 'http://localhost:8080/security/Accident/queryStatisticsOfReasonsByAccidentId',
        type : "POST",
        data: JSON.stringify(param),
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',
        success : function(result) {
            var data_dadagrids = result.result.data.accidentStatisticsOfReasons;
            $('#statistics_of_reasons_datagrid').datagrid('loadData', data_dadagrids);
        }
    });
}


//加载    预防控制措施表单
function prevention_and_control_measures_datagrid (){
    param = {
        "map": {}
    };
    param.map = {
        "pageNo": 1,
        "pageSize": 20,
        "accidentId": 1
    };
    $.ajax({
        url : 'http://localhost:8080/security/Accident/queryPreventionAndControlMeasuresByAccidentId',
        type : "POST",
        data: JSON.stringify(param),
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',
        success : function(result) {
            var data_dadagrids = result.result.data.accidentPreventionAndControl;
            $('#prevention_and_control_measures_datagrid').datagrid('loadData', data_dadagrids);
        }
    });
}







/**
 * 格式化时间
 */
function formatDatebox(value) {
    var ret = "";
    var time = value.time;
    if(time != "" && typeof time != "undefined"){
        ret = getSmpFormatDate(new Date(time),false);
    }
    return ret;
}
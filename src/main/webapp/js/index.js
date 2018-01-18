




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
        "pageSize": 15
        /*"accident_category_id": 1,*/
        /*"adposType": 3*/
    };
    alert("加载数据...");
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





//查看详情  事件
function details(value,rowData,rowIndex){
    var str = "<a href='javascript:void(0)' onclick='danger_Details(&apos;" + rowData.accidentId+ "&apos;)'>"+ rowData.accidentName +"</a>";
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
    $('#w').window('open');
}




//=======重大事故   添加并打开添加页面按钮
function main_accident_add(){
    $('#main_accident_add_window').window('open');
}




//=======重大事故   删除按钮
function main_accident_delete(){
    alert("删除");
}




//=======重大事故  添加并保存数据按钮
function main_accident_Save(){
    alert("保存");
    var accidentName = $("#accidentName").val();
    var occurrencePlace = $("#occurrencePlace").val();
    var isAnalysis = $("#isAnalysis").val();
    var occurrenceTime = $("#occurrenceTime").val();
    alert("accidentName: " + accidentName + ",occurrencePlace: " + occurrencePlace + ",isAnalysis: " + isAnalysis + ",occurrenceTime: " + occurrenceTime );
    var datas = $('#main_accident_add_Form').serialize();
    alert("datas: " + datas);
    param = {
        "map": {}
    };
    param.map = {
        "accidentName": accidentName,
        "occurrencePlace" : occurrencePlace,
        "occurrenceTime": "2018-02-26 15:34:16",
        "isAnalysis": isAnalysis,
        "userId": "1",
        "accidentCategoryId":"1",
        "reportContent": "100",
        "behaviorContent":"100",
        "macroscopicContent": "100",
        "measuresContent":"100",
        "reasonsContent":"100"
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
                }
        }
    });
}




//=======重大事故  取消并关闭按钮
function main_accident_Cancel(){
    alert("取消");
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


$(function(){
    param = {
        "map": {}
    };
    param.map = {
        "pageNo": 1,
        "pageSize": 15
        /*"accident_category_id": 1,*/
        /*"adposType": 3*/
    };
    $.ajax({
        /*url : 'http://localhost:8080/security/Accident/queryAccidentById',*/
        url : 'http://localhost:8080/security/Accident/queryAllAccident',
        type : "POST",
        data: JSON.stringify(param),
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',
        success : function(result) {
            /*console.log(JSON.stringify(result));*/
            var data_dadagrid = result.result.data.accidentList.list;
            $('#accident_datagrid').datagrid('loadData', data_dadagrid);
        }
    });

});

/*//加载储罐区列表
 /!*var worksiteid = $("#worksiteid").val();*!/
 function jiaZai(){
 var pageopt = $('#accident_datagrid').datagrid('getPager').data("pagination").options;
 var page=pageopt.pageNumber;
 var row=pageopt.pageSize;
 /!*url:'http://localhost:8080/security/Accident/queryAllAccidentcategory?pageSize=5&pageNo=1',method:'get'*!/
 $('#accident_datagrid').datagrid({
 url : 'http://localhost:8080/security/Accident/queryAllAccident',
 method: 'post',
 queryParams:{
 pageNo : page,
 pageSize : row
 }
 });
 }*/

//查看详情
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
        /*"accident_category_id": 1,*/
        /*"adposType": 3*/
    };
    $.ajax({
        /*url : 'http://localhost:8080/security/Accident/queryAccidentById',*/
        url : 'http://localhost:8080/security/Accident/queryAllAccident',
        type : "POST",
        data: JSON.stringify(param),
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',
        success : function(result) {
            /*console.log(JSON.stringify(result));*/
            var data_dadagrid = result.result.data.accidentList.list;
            $('#accidentBaseInfo_datagrid').datagrid('loadData', data_dadagrid);
        }
    });
    $('#w').window('open');
    /*<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('open')">Open</a>
     <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('close')">Close</a>*/
    /*alert(accident);*/
}

function main_accident_add(){
    $('#main_accident_add_window').window('open');
}

function main_accident_delete(){
    alert("删除");
}

function mainaccidentSave(){
    alert("保存");
    $("#accidentName").val();
    $("#occurrencePlace").val();
    $("#isAnalysis").val();
    $("#occurrenceTime").val();

    param = {
        "map": {}
    };
    param.map = {
        "accidentName": "10",
        "occurrencePlace":"1",
        "occurrenceTime": "2018-02-26 15:34:16",
        "isAnalysis":"1",
        "userId": "10",
        "accidentCategoryId":"1",
        "reportContent": "10",
        "behaviorContent":"1",
        "macroscopicContent": "10",
        "measuresContent":"1",
        "reasonsContent":"1"
    };

    $.ajax({
        type: "POST",
        /*data:$('#main_accident_add_Form').serialize(),// 序列化表单值*/
        data: JSON.stringify(param),
        url : 'http://localhost:8080/security/Accident/queryAllAccident',
        onSubmit:function(){
            return $(this).form('validate');
        },
        success : function (data){
                $.messager.alert("提示信息",data,"info");
        }
    });
}

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
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>安全生产事故及控制平台</title>
        <link rel="stylesheet" type="text/css" href="css/base.css">
        <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icons">
        <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
        <script type="text/javascript"   src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
        <style type="text/css">
            #north_title{
                font-size: 30px;
                color: #fff;
                text-align: center;
                background: url(images/title-banner.png) no-repeat ;
            }
            #west_menus ul li{
                font-size: 14px;
                color: #0E2D5F;
                height: 40px;
                line-height: 40px;
                border-bottom: 1px solid red;
                background-color: aquamarine;
                margin-top: 5px;
                text-align: center;
            }
        </style>

        <script>
            $(function(){
               /* var str = '{"map":{pageSize:"10",pageNo:"1"}';
                var jsondata={"map":[{"pageSize":"10","pageNo":"1"}]}*/
                param = {
                    "map": {}
                };
                param.map = {
                    "pageNo": 1,
                    "pageSize": 15,
                    "adposType": 3
                };
                $.ajax({
                    url : 'http://localhost:8080/security/Accident/queryAllAccident',
                    type : "POST",
                    /*data: $.parseJSON(str),*/
                    data: JSON.stringify(param),
                   /* data : {
                 /!* "map": {
                 "pageSize": "10",
                 "pageNo": "1"
                 }*!/
                 },*/
                    dataType: 'json',
                    contentType:'application/json;charset=UTF-8',
                    success : function(result) {
                        console.log(JSON.stringify(result));
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


        </script>
    </head>

    <body class="easyui-layout">
        <div id="north_title" data-options="region:'north',border:false" style="height:60px;padding:10px;">安全生产事故及控制平台</div>

        <div id="west_menus" data-options="region:'west',split:true,title:'菜单'" style="width:150px;padding:10px;">
            <ul>
                <li><a >重特大事故</a></li>
                <li><a>建筑事故</a></li>
                <li><a>化工事故</a></li>
                <li><a>交通事故</a></li>
            </ul>
        </div>

        <div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">

        </div>
        <div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">下标题...</div>
        <div data-options="region:'center',title:'Center'">
            <table id="accident_datagrid" class="easyui-datagrid" title="Basic DataGrid" style="width:80%;height:70%"
                           data-options="rownumbers:true,checkbox:true,pagination:true,striped: true,singleSelect:true,
                        collapsible:true">
            <thead>
            <tr>
                <th data-options="field:'checkbox',checkbox:true" style="width:2%" align="center"></th>
                <th data-options="field:'accidentId',hidden:'true'" style="width:3%" align="center"></th>
                <th data-options="field:'accidentName',halign:'center'" style="width:13%">事故名称</th>
                <th data-options="field:'occurrencePlace'" style="width:15%" align="center">事故发生地点</th>
                <th data-options="field:'occurrenceTime'" style="width:10%" align="center">事故发生时间</th>
                <th data-options="field:'isAnalysis'" style="width:10%" align="center">是否完成分析</th>
                <th data-options="field:'userId'" style="width:15%" align="center">创建用户id</th>
                <th data-options="field:'accidentCategoryId'" style="width:10%" align="center">事故类别id</th>
            </tr>
            </thead>
        </table>

            <%--<table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:250px"
                           data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
                <thead>
                    <tr>
                        <th data-options="field:'itemid',width:80">Item ID</th>
                        <th data-options="field:'productid',width:100">Product</th>
                        <th data-options="field:'listprice',width:80,align:'right'">List Price</th>
                        <th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
                        <th data-options="field:'attr1',width:250">Attribute</th>
                        <th data-options="field:'status',width:60,align:'center'">Status</th>
                    </tr>
                </thead>
            </table>--%>
        </div>
    </body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: xuyuanhui
  Date: 2018/7/2
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>报名信息展示</title>
    <link href="../bootstrap.min.css" rel="stylesheet">
    <link href="../shards.min.css" rel="stylesheet">
    <script src="../jquery.min.js"></script>
    <script src="../bootstrap.min.js"></script>
    <script src="../shards.min.js"></script>
</head>
<body>
<jsp:include page="navi.jsp"></jsp:include>


    <div class="example col-md-10 ">
        <div class="alert alert-primary" role="alert">
            运动会报名信息汇总
        </div>
        <div>
            &nbsp; &nbsp; <span>输入项目名称进行查询:</span>
            <input name="itemName" type="text" id="itemName">
            <button type="button" class="btn btn-primary btn-pill" id="searchItem">查询</button>
        </div>
        <br>
        <table class="table table-striped table-responsive">
            <thead>
            <tr>
                <th>记录编号</th>
                <th>项目名称</th>
                <th>项目编号</th>
                <th>姓名</th>
                <th>院系</th>
                <th>性别</th>
                <th>年龄</th>
                <th>参赛时间</th>
                <th>报名时间</th>
                <th>联系电话</th>
            </tr>
            </thead>
            <tbody id="tbody1">

            </tbody>
        </table>

        <br>
        <div class="alert alert-primary" role="alert">
            关于运动会报名信息的一些统计数据
        </div>
        <table class="table table-striped table-responsive">
            <tr>
                <td>报名人数最多的项目</td>
                <td id="max"></td>
            </tr>
            <tr>
                <td>所有报名者的平均年龄</td>
                <td id="avg"></td>
            </tr>
        </table>
    </div>

<script>
    $(function () {
        $("#list1").addClass("active");
        getAllItem();
        getAggre();
    });
    function getAllItem() {
        $.ajax({
            url:"../sport/getAll.do",
            data:"",
            dataType:"json",
            type:"post",
            success:function (obj) {
                var list = obj.data;
                var sex = "男";
                for(i=0;i<list.length;i++){
                    if(list[i].gender==0){
                        var sex ="男";
                    }else{
                        var sex="女";
                    }
                    var startTime = new Date(list[i].startTime).toLocaleString();
                    var enrollTime = new Date(list[i].enrollTime).toLocaleString();
                    var str = '<tr>\n' +
                        '<td>'+(i+1)+'</td>\n' +
                        '<td>'+list[i].projectName+'</td>\n' +
                        '<td>'+list[i].projectId+'</td>\n' +
                        '<td>'+list[i].name+'</td>\n' +
                        '<td>'+list[i].dept+'</td>\n' +
                        '<td>'+sex+'</td>\n' +
                        '<td>'+list[i].age+'</td>\n' +
                        '<td>'+startTime+'</td>\n' +
                        '<td>'+enrollTime+'</td>\n' +
                        '<td>'+list[i].phone+'</td>\n' +
                        '</tr>';
                    $("#tbody1").append(str);
                }
            }
        });
    }
    function getAggre() {
        $.ajax({
            url:"../sport/getAggre.do",
            data:"",
            type:"post",
            dataType:"json",
            success:function (obj) {
                for(i=0;i<obj.data.length;i++){
                    $("#max").append(obj.data[i]+" ");
                }
                $("#avg").html(obj.message);
            }
        });
    }
    $("#searchItem").click(function () {
        $.ajax({
            url:"../sport/getItemByName.do",
            data:"itemName="+$("#itemName").val(),
            type:"post",
            dataType:"json",
            success:function (obj) {
                $("#tbody1").html("");
                var list = obj.data;
                var sex = "男";
                for(i=0;i<list.length;i++){
                    if(list[i].gender==0){
                        var sex ="男";
                    }else{
                        var sex="女";
                    }
                    var startTime = new Date(list[i].startTime).toLocaleString();
                    var enrollTime = new Date(list[i].enrollTime).toLocaleString();
                    var str = '<tr>\n' +
                        '<td>'+(i+1)+'</td>\n' +
                        '<td>'+list[i].projectName+'</td>\n' +
                        '<td>'+list[i].projectId+'</td>\n' +
                        '<td>'+list[i].name+'</td>\n' +
                        '<td>'+list[i].dept+'</td>\n' +
                        '<td>'+sex+'</td>\n' +
                        '<td>'+list[i].age+'</td>\n' +
                        '<td>'+startTime+'</td>\n' +
                        '<td>'+enrollTime+'</td>\n' +
                        '<td>'+list[i].phone+'</td>\n' +
                        '</tr>';
                    $("#tbody1").append(str);
                }
            }
        });
    });
</script>
</body>
</html>

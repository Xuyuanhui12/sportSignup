<%--
  Created by IntelliJ IDEA.
  User: xuyuanhui
  Date: 2018/7/2
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>运动会报名</title>
    <link href="../bootstrap.min.css" rel="stylesheet">
    <link href="../shards.min.css" rel="stylesheet">
    <script src="../jquery.min.js"></script>
    <script src="../bootstrap.min.js"></script>
    <script src="../shards.min.js"></script>
</head>
<body>
<jsp:include page="navi.jsp"></jsp:include>
<form class="form-horizontal" role="form" id="sportForm">
    <div class="form-group">
        <label for="projectname" class="col-sm-2 control-label">报名项目</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="projectname" name="projectName"
                   placeholder="请输入报名项目">
        </div>
    </div>
    <div class="form-group">
        <label for="firstname" class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="firstname" name="name"
                   placeholder="请输入姓名">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">院系</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="lastname" name="dept"
                   placeholder="请输入院系">
        </div>
    </div>
    <div class="form-group">
        <label for="gender" class="col-sm-2 control-label">院系</label>
        <div class="col-sm-10">
            &nbsp;<input type="radio" name="gender" id="gender" value="0">&nbsp;男 &nbsp; &nbsp;&nbsp;&nbsp;
            <input type="radio" name="gender" value="1">&nbsp;女
        </div>
    </div>
    <div class="form-group">
        <label for="age" class="col-sm-2 control-label">年龄</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="age" name="age"
                   placeholder="请输入年龄">
        </div>
    </div>

    <div class="form-group">
        <label for="phone" class="col-sm-2 control-label">联系电话</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="phone" name="phone"
                   placeholder="请输入联系电话">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#exampleModal">报名</button>
            &nbsp;<span class="badge badge-danger" id="error1"></span>
        </div>
    </div>
</form>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">确认提交?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                确定要提交报名信息吗?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">否</button>
                <button type="button" class="btn btn-primary" id="signUp" data-dismiss="modal">是</button>
            </div>
        </div>
    </div>
</div>
<script>
    $("#signUp").click(function () {
        $.ajax({
            url:"../sport/addItem.do",
            data:$("#sportForm").serialize(),
            dataType:"json",
            type:"post",
            success:function (obj) {
                if(obj.state==1){
                    alert(obj.message);
                    $("#exampleModal").attr("class","modal fade");
                }else {
                    alert(obj.message);
                    $("#error1").html(obj.message);
                }

            }

        });
    })
    $(function () {
        $("#add1").addClass("active");
    });
</script>
</body>
</html>

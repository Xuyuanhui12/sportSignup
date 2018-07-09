<%--
  Created by IntelliJ IDEA.
  User: xuyuanhui
  Date: 2018/7/2
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加运动项目</title>
    <link href="../bootstrap.min.css" rel="stylesheet">
    <link href="../shards.min.css" rel="stylesheet">
    <script src="../jquery.min.js"></script>
    <script src="../bootstrap.min.js"></script>
    <script src="../shards.min.js"></script>
</head>
<body>
<jsp:include page="navi.jsp"></jsp:include>
<form class="form-horizontal" role="form">
    <div class="form-group">
        <label for="projectname" class="col-sm-2 control-label">项目名称</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="projectname" name="name"
                   placeholder="请输入项目名称">
        </div>
        <br>
        <%--<label for="projectID" class="col-sm-2 control-label">项目编号</label>--%>
        <%--<div class="col-sm-10">--%>
            <%--<input type="text" class="form-control" id="projectID"--%>
                   <%--placeholder="请输入项目编号">--%>
        <%--</div>--%>
        <label for="startTime" class="col-sm-2 control-label">参赛时间</label>
        <div class="col-sm-10">
            <input type="datetime-local" class="form-control" id="startTime" name="startName"
                   value="2018-07-09T13:59:59" >
        </div>
        <br>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">增加项目</button>
                &nbsp;<span class="badge badge-danger"  id="error1"></span>
            </div>
        </div>
    </div>
</form>

<!-- Modal -->
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
                确定要增加一项新的运动项目吗?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">否</button>
                <button type="button" class="btn btn-primary" id="addProject" data-dismiss="modal">是</button>
            </div>
        </div>
    </div>
</div>

<script>
    $("#addProject").click(function () {
        $.ajax({
            url:"../sport/addProject.do",
            data:"name="+$("#projectname").val()+"&startTime="+$("#startTime").val(),
            type:"get",
            dataType:"json",
            success:function (obj) {
                if(obj.state==1){
                    alert(obj.message);
                }

            }
            
        });
    })
    $(function () {
        $("#addSport1").addClass("active");
    });
</script>
</body>
</html>

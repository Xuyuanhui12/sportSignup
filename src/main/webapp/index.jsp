<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>运动会报名</title>
    <link href="bootstrap.min.css" rel="stylesheet">
    <link href="shards.min.css" rel="stylesheet">
    <script src="jquery.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <script src="shards.min.js"></script>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-4">
    <a class="navbar-brand" href="#">运动会</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown-1"
            aria-controls="navbarNavDropdown-1"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown-1">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item " id="list1">
                <a class="nav-link" href="sport/showList.do">报名信息展示
                </a>
            </li>
            <li class="nav-item" id="addSport1">
                <a class="nav-link" href="sport/showAddSport.do">新增运动项目</a>
            </li>
            <li class="nav-item" id="add1">
                <a class="nav-link" href="sport/showAdd.do">新增报名</a>
            </li>

        </ul>


    </div>
</nav>
<div>
    本项目包含3个功能:1.添加运动项目 2.添加报名信息 3.列表展示报名信息
</div>
</body>
</html>

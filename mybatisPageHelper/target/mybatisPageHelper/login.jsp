<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.css">
<link type="text/css" rel="stylesheet"
      href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap-theme.css">
<body>

<div class="row" style="margin-top: 200px;">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <h1 style="margin-bottom: 50px;text-align: center">后台登陆系统</h1>
        <form  class="form-horizontal" action="/LoginServlet" method="post">
            <div align="center">
                <div class="form-group">
                    <label for="exampleInputEmail1" class="col-sm-2 control-label">账号：</label>
                    <div class="col-sm-10">
                        <input type="text" name="username" class="form-control" id="exampleInputEmail1"
                               placeholder="请输入账号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1" class="col-sm-2 control-label">密码：</label>
                    <div class="col-sm-10">
                        <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                               placeholder="请输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">登陆</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>


<script type="text/javascript" src="jquery-3.3.1.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>

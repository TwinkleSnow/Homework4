<%--
  Created by IntelliJ IDEA.
  User: Twinkle
  Date: 2020/10/4
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="col-sm-12" style="height: 100px;"></div>
    <h2>用户登录</h2>
    <div class="divider">
        <hr/>
    </div>
    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/login.action" method="post">
        <input type="hidden" name="method" value="login"/>

        <div class="col-sm-12" style="height: 50px;"></div>

        <div class="form-group">
            <div class="col-sm-push-2 col-sm-8 input-group">
				<span class="input-group-addon" id="basic-addon1">
					<span class="glyphicon glyphicon-user"></span>
				</span>
                <input type="text" class="form-control input-block input-lg" id="inputUsername3" name="username"
                       placeholder="用户名"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-push-2 col-sm-8 input-group">
				<span class="input-group-addon" id="basic-addon2">
					<span class="glyphicon glyphicon-lock"></span>
				</span>
                <input type="password" class="form-control input-block input-lg" id="inputPassword3" name="password"
                       placeholder="密码"/>
            </div>
        </div>

        <div class="col-sm-12" style="height: 50px;"></div>

        <div class="form-group">
            <div class="col-sm-push-2 col-sm-8">
                <button type="submit" class="btn btn-primary btn-block btn-lg">登录</button>
            </div>
        </div>

        <div class="col-sm-12" style="height: 50px;"></div>

    </form>
    <div class="form-group text-right col-sm-push-6 col-sm-6">
        没有账号？<a href="${pageContext.request.contextPath}/register.jsp">注册</a>一个吧！
    </div>
</div>
</body>
</html>

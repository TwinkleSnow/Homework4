<%@ page import="com.homework4.dao.UserDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.homework4.bean.UserEntity" %><%--
  Created by IntelliJ IDEA.
  User: Twinkle
  Date: 2020/10/4
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>登录成功</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <jsp:useBean id="f" class="com.homework4.bean.UserEntity" scope="session"/>
    <jsp:setProperty name="f" property="*"/>
    <h2>欢迎，
        <jsp:getProperty property="username" name="f"/>
    </h2>
    <div class="divider">
        <hr/>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr class="active">
            <th>id</th>
            <th>用户名</th>
            <th>密码</th>
            <th colspan="2">操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            UserDAO userDAO = new UserDAO();
            List<UserEntity> list = userDAO.selectUser();
            for (UserEntity ue : list
            ) {
        %>
        <form action="${pageContext.request.contextPath }/userupdate.action" method="post">
            <tr>
                <td><input type="text" value="<%=ue.getUserid()%>" name="userid" readonly="true"></td>
                <td><input type="text" value="<%=ue.getUsername()%>" name="username"></td>
                <td><input type="text" value="<%=ue.getPassword()%>" name="password"></td>
                <td>
                    <input class="updateBtn btn btn-info btn-block btn-lg" type="submit" value="更新">
                </td>
                <td>
                    <a class="deleteBtn btn btn-danger btn-block btn-lg"
                       href="${pageContext.request.contextPath }/userdelete.action?userid=<%=ue.getUserid()%>">删除
                    </a>
                </td>
            </tr>
        </form>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>

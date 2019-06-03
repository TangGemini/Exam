<%--
  Created by IntelliJ IDEA.
  User: tangyq
  Date: 2019/6/1
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>欢迎页面</title>
    <link rel="stylesheet" href="resources/css/common/bootstrap.css">
    <link rel="stylesheet" href="resources/css/common/elementUI.css">
    <link rel="stylesheet" href="resources/css/common/nav.css">
    <link rel="stylesheet" href="resources/css/common/display.css">
    <link rel="stylesheet" href="resources/css/common/base.css">
    <link rel="stylesheet" href="resources/css/index.css">
</head>

<body>
<div id="app">
    <!-- 统一注入导航栏模板 -->
    <div id="navigation" class="nav_content">
        <div class="navLeft">
            <h3>Examination</h3>
            <p>——考试答题系统——</p>
        </div>
        <div class="navRight">
            <a href="index.jsp">主页</a>
            <el-divider direction="vertical"></el-divider>
            <a href="sdenglu.jsp">学生登录</a>
            <el-divider direction="vertical"></el-divider>
            <a href="tdenglu.jsp">教师登录</a>
            <el-divider direction="vertical"></el-divider>
            <a href="adenglu.jsp">管理员登录</a>
            <el-divider direction="vertical"></el-divider>
            <a href="http://188.131.244.33:8080/Work2">四则运算</a>
            <el-divider direction="vertical"></el-divider>
        </div>
    </div>
    <!-- 用户姓名显示区 -->
    <!-- <div class="user_show">
        <img src="../../resources/images/common/头像.png">&ensp;
        尊敬的&ensp;<span id="name">李先生</span> ,您好
    </div> -->
    <!-- 主要內容模块 -->
    <el-card class="main_content">
        <el-row type="flex" class="row-bg-first" justify="center">
            <i style="font-size: 55px;" class='el-icon-time'  ></i> &emsp;
            今天是&ensp;<span class="time">2019-6-3 星期一</span>
        </el-row>
        <el-row :gutter="5" type="flex" class="row-bg" justify="space-around">
            <el-col :sm="2">&nbsp;</el-col>
            <el-col :sm="4">
                <img src="resources/images/common/学生.png">
            </el-col>
            <el-col :sm="12">
                <h2 style="margin-top:14px;">学生登录</h2>
            </el-col>
            <el-col :sm="4">
                <a href="sdenglu.jsp"><el-button type="primary" id="signIn">进入登录</el-button></a>
            </el-col>
            <el-col :sm="2">&nbsp;</el-col>
        </el-row>
        <el-row :gutter="10" type="flex" class="row-bg" justify="space-around">
            <el-col :sm="2">&nbsp;</el-col>
            <el-col :sm="4">
                <img src="resources/images/common/教师.png">
            </el-col>
            <el-col :sm="12">
                <h2 style="margin-top:14px;">教师登录</h2>
            </el-col>
            <el-col :sm="4">
                <a href="tdenglu.jsp"><el-button type="primary" id="signOut" >进入登录</el-button></a>
            </el-col>
            <el-col :sm="2">&nbsp;</el-col>
        </el-row>
        <el-row :gutter="15" type="flex" class="row-bg" justify="space-around">
            <el-col :sm="2">&nbsp;</el-col>
            <el-col :sm="4">
                <img src="resources/images/common/管理员.png">
            </el-col>
            <el-col :sm="12">
                <h2 style="margin-top:14px;">管理员登录</h2>
            </el-col>
            <el-col :sm="4">
                <a href="adenglu.jsp"><el-button type="primary" id="signOut" >进入登录</el-button></a>
            </el-col>
            <el-col :sm="2">&nbsp;</el-col>
        </el-row>
    </el-card>
    <!-- 统一注入尾部栏 -->
    <div id="footer">
        <p>Examination 考试答题系统v1.0</p>
    </div>
</div>
</body>
<!-- <script src="../../resources/js/common/jquery.js"></script> -->
<!-- <script src="../../resources/js/common/bootstrap.js"></script> -->
<script src="resources/js/common/vue.js"></script>
<script src="resources/js/common/newVue.js"></script>
<script src="resources/js/common/elementUI.js"></script>
<script src="resources/js/common/index.js"></script>
<script type="text/javascript">
    window.onscroll = function () {
        var topScroll = document.documentElement.scrollTop;//滚动的距离,距离顶部的距离
        var navigation = document.getElementById("navigation");//获取到导航栏id
        if (topScroll > 100) {  //当滚动距离大于250px时执行下面的东西
            navigation.classList.add("fixed")
        } else {//当滚动距离小于250的时候执行下面的内容，也就是让导航栏恢复原状
            navigation.classList.remove("fixed")
        }
    }
</script>

</html>

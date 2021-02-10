<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/2/4
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>

  <body>


  <!--
    模拟修改操作
    1.原始数据 1,lisiming,123456,857854781@qq.com,24
    2.要求密码不能被修改
    3.表单回显模拟操作 直接在表单填写对应的属性值
  -->
  <form action="springmvc/testModelAttribute" method="post">
    <input type="hidden" name="id" value="1">
    username: <input type="text" name="username" value="lisiming"/>
    <br>
    email: <input type="text" name="email" value="857854781@qq.com"/>
    <br>
    age: <input type="text" name="age" value="24"/>
    <br>
    <input type="submit" value="Submit"/>
  </form>
  <br><br>

  <a href="springmvc/testSessionAttributes">testSessionAttributes</a>
  <br><br>
  <a href="springmvc/testMap">testMap</a>
  <br><br>
  <a href="springmvc/testModelAndView">testModelAndView</a>
  <br><br>

  <a href="springmvc/testServletAPI">testServletAPI</a>
  <br><br>

  <form action="springmvc/testPojo" method="post">
    username: <input type="text" name="username">
    <br>
    password: <input type="password" name="password">
    <br>
    email: <input type="text" name="email">
    <br>
    age: <input type="text" name="age">
    <br>
    city: <input type="text" name="address.city">
    <br>
    province: <input type="text" name="address.province">
    <br>
    <input type="submit" name="Submit">
  </form>
  <br><br>
  <a href="springmvc/testCookieValue">testCookieValue</a>
  <br><br>
  <br><br>
  <a href="springmvc/testRequestHeader">testRequestHeader</a>
  <br><br>
  <br><br>
  <a href="springmvc/testRequestParam?username=lisiming&age=11">testRequestParam</a>
  <br><br>
  <form action="springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="Test-Rest-PUT">
  </form>

  <br><br>
  <form action="springmvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="Test-Rest-DELETE">
  </form>

  <br><br>

  <form action="springmvc/testRest" method="post">
    <input type="submit" value="Test-Rest-Post">
  </form>
  <br><br>
  <a href="springmvc/testRest/1">Test-Rest-Get</a>
  <br><br>
  <a href="springmvc/testPathVariable/1">testPathVariable</a>
  <br><br>
  <a href="springmvc/testAntPath/acc/abc">testAntPath</a>
  <br><br>
  <a href="springmvc/testParamsAndHeaders?username=lisiming&age=10">testParamsAndHeaders</a>
  <br><br>
  <form action="springmvc/testMethod" method="post">
    <input type="submit" value="submit">
  </form>
  <br><br>
  <a href="springmvc/testMethod">testMethod</a>
  <br><br>
  <a href="springmvc/testRequestMapping">Test RequestMapping</a>
    <br><br>
    <a href="helloworld">hello Word</a>
  </body>
</html>

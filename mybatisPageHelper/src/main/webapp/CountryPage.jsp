<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
    a {
        width: 60px;
        height: 40px;
        text-align: center;
        line-height: 40px;
        font-size: 16px;
        text-decoration-line: none;
        margin-left: 10px;
    }

    td {
        min-width: 400px;
        height: 45px;
        font-size: 16px;
        text-align: center;
        line-height: 45px;
    }

    option {
        width: 60px;
        height: 20px;
    }

</style>
<body style="overflow: hidden;">


<h1 align="center" style="margin-top: 50px">国家名称与代码号</h1>
<hr/>
<table align="center" border="1">
    <thead>
    <tr>
        <td>ID</td>
        <td>countryname</td>
        <td>countrycode</td>
    </tr>
    </thead>
    <tbody style="height:504px;width: 1220px; overflow: auto;margin-top:10px;position:absolute;border: 1px solid ;background-color: #02d7dc">
    <c:forEach items="${countries}" var="country">
        <tr>
            <td>${country.id}</td>
            <td>${country.countryname}</td>
            <td>${country.countrycode}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<div align="center" style="margin-top: 520px;font-size: 16px;text-align: center;line-height: 40px">

    <form id="myform" action="/CountryServlet?action=all" method='post' style="float: left;margin-left: 20%;">
        一页显示数量：<select name="pageSize" id="pageSize" onchange="MyselectChange()" style="width: 60px;height: 24px">
        <c:if test="${pageSize == 10}">
            <option value="10" selected="selected">10</option>
            <option value="20">20</option>
            <option value="30">30</option>
        </c:if>

        <c:if test="${pageSize == 20}">
            <option value="10">10</option>
            <option value="20" selected="selected">20</option>
            <option value="30">30</option>
        </c:if>

        <c:if test="${pageSize == 30}">
            <option value="10">10</option>
            <option value="20">20</option>
            <option value="30" selected="selected">30</option>
        </c:if>

    </select>
    </form>
    <div style="float: left;margin-left: 10%">
        共${pagehelper.total}条/共${pagehelper.pages}页
        <a href="${pageContext.request.contextPath}/CountryServlet?action=all&pageSize=${pageSize}">首页</a>
        <a href="${pageContext.request.contextPath}/CountryServlet?action=all&num=${pagehelper.prePage}&pageSize=${pageSize}">上一页</a>
        <c:forEach items="${pagehelper.navigatepageNums}" var="num">
            <a href="${pageContext.request.contextPath}/CountryServlet?action=all&num=${num}&pageSize=${pageSize}">${num}</a>
        </c:forEach>
        <a href="${pageContext.request.contextPath}/CountryServlet?action=all&num=${pagehelper.nextPage}&pageSize=${pageSize}">下一页</a>
        <a href="${pageContext.request.contextPath}/CountryServlet?action=all&num=${pagehelper.pages}&pageSize=${pageSize}">末页</a>

        跳转到
        <input id="number" type="text" name="hello" size="6">页 <input type="button" value="跳转" onclick="changeNumber()">
    </div>
</div>

<script>
    function MyselectChange() {
        //alert("调用改变事件");
        var myform = document.getElementById("myform");
        myform.submit();//form表单提交
    }

    function changeNumber() {
        var num = document.getElementById("number").value;
        if (num > ${pagehelper.pages}) {
            num = ${pagehelper.pages};
        }
        if (num < 1) {
            num = 1;
        }
        //如果是数字
        window.location.href = "${pageContext.request.contextPath}/CountryServlet?action=all&pageSize=${pageSize}&num=" + num;
    }
</script>


</body>
</html>

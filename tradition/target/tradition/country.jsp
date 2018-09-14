<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    a {
        min-width: 80px;
    }
</style>
<body>

    <h1 align="center">国家名称与代码号</h1>
    <hr/>
    <table align="center" width="80%" border="1">
        <tr>
            <td>ID</td>
            <td>countryname</td>
            <td>countrycode</td>
        </tr>
        <c:forEach items="${page.records}" var="country">
            <tr>
                <td>${country.id}</td>
                <td>${country.countryname}</td>
                <td>${country.countrycode}</td>
            </tr>
        </c:forEach>
    </table>



    <div align="center" id="testAjax">


        <form id="myform" action="/CountryServlet?action=all" method='post'>
        <select name="pageSize" id="pageSize" onchange="selectChange()">
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
        共${page.totalSize}条/共${page.totalPageNum}页
        <a href="${pageContext.request.contextPath}/CountryServlet?action=all&pageSize=${pageSize}">首页</a>
        <a href="${pageContext.request.contextPath}/CountryServlet?action=all&num=${page.prePageNum}&pageSize=${pageSize}">上一页</a>
        <c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
             <a href="${pageContext.request.contextPath}/CountryServlet?action=all&num=${num}&pageSize=${pageSize}">${num}</a>
        </c:forEach>
        <a href="${pageContext.request.contextPath}/CountryServlet?action=all&num=${page.nextPageNum}&pageSize=${pageSize}">下一页</a>
        <a href="${pageContext.request.contextPath}/CountryServlet?action=all&num=${page.totalPageNum}&pageSize=${pageSize}">末页</a>

        跳转到
        <input id="number" type="text" name="hello" size="6">页 <input type="button" value="跳转" onclick="changeNumber()">





        <script type="text/javascript" src="jquery-3.3.1.js"></script>
        <script>
            function changeNumber() {
                var num = document.getElementById("number").value;
                if (num > ${page.totalPageNum}){
                    num = ${page.totalPageNum};
                }
                if (num < 1){
                    num = 1;
                }
                //如果是数字
                window.location.href="${pageContext.request.contextPath}/CountryServlet?action=all&pageSize=${pageSize}&num="+num;
            }
            function selectChange() {
                var myform = document.getElementById("myform");
                myform.submit();//form表单提交
            }




        </script>









    </div>

</body>
</html>

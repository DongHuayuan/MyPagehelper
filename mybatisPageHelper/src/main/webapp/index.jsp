<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<jsp:forward  page="/CountryServlet">
    <jsp:param name="action" value="all"></jsp:param>
    <jsp:param name="pageSize" value="10"></jsp:param>
</jsp:forward >

</body>
</html>

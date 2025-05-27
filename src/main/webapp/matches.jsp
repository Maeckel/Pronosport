<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: Romain
  Date: 27/05/2025
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
     String [] competitionsId= (String[]) request.getAttribute("CompetitionsId");
%>
<html>
<head>
    <title>Matches</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<h1> Matchs  sélectionnés </h1>
<span>  <%=Arrays.toString(competitionsId)%>> </span>
</body>
</html>

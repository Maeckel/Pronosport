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
<div class ="max-w-lg mx-auto p-4 bg-white rounded-lg shadow">
    <div class="flex justify-between items-center mb-4">
        <h2 class="text-xl font-bold">Mes pronostics</h2>
        <div class="flex space-x-2">
            <button
            class="p-2 rounded-full bg-gray-100 hover:bg-gray-200"
            >
            <Filter size={20} />
            </button>
            <button
                class="p-2 rounded-full bg-gray-100 hover:bg-gray-200"
            >
                <img src="images/refresh_480px.png"  class="w-48 h-48" alt="Refresh logo">
            </button>
        </div>
    </div>
</div>
</body>
</html>

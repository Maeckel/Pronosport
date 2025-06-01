<%@ page import="java.util.List" %>
<%@ page import="fr.cnam.pronosport.pronosport.model.Competition" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Romain
  Date: 16/05/2025
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
   List<Competition> competitions = (List<Competition>) request.getAttribute("competitions");
%>
<html>
<head>
    <title>Compétition</title>
    <script src="https://cdn.tailwindcss.com"></script>

</head>
<body>
<div class="max-w-lg mx-auto p-4 bg-white rounded-lg shadow">
    <%--
    si international (dans api -> world) afficher
    --%>
    <h2 class ="text-xl font-bold mb-4">Sélection des compétitions</h2>
    <input
            type="text"
            placeholder="Rechercher une compétition..."
            class="pl-10 pr-4 py-2 w-full border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
            value=""
            onchange=""
    />
    <div class="space-y-2 max-h-96 overflow-y-auto pr-1">
        <div class="flex items-center">
            <input
                    type="checkbox"
                    class="h-4 w-4 text-blue-600 rounded"
                    checked=""
                    onChange=""
            />
            <h3 class="font-medium ml-3">international</h3>
        </div>
<% if(competitions!=null){
        for (Competition competition :competitions){

%>
        <div class ="flex items-center">
            <input
                    type="checkbox"
                    class ="h-4 w-4 text-blue-600 rounded"
                    checked=""
                    onChange=""
            />
            <h3 class ="font-medium ml-3"><%=competition.getZone()%></h3>
        </div>
        <div class ="flex items-center p-2 hover:bg-gray-50 rounded cursor-pointer">

            <input
                    type="checkbox"
                    class = "h-4 w-4 text-blue-600 rounded"
                    checked=""
                    onChange=""
            />
            <img
                    src=""
                    alt="Logo trophy"}
                    class="ml-3 w-7 h-7"
            />
            <span class="ml-3"><%=competition.getNom()%></span>
        </div>
        <%}%>

        <%}%>



        <%-- liste des
         compétitions--%>
    </div>
</div>
</body>
</html>

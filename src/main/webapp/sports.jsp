<%@ page import="java.util.List" %>
<%@ page import="fr.cnam.pronosport.pronosport.model.Sport" %>
<%@ page import="java.util.Map" %><%--
<%-- 
    Document   : sports
    Created on : 31 mai 2025, 13:56:03
    Author     : networks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%
   List<Sport> sports = (List<Sport>) request.getAttribute("sports");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sélection du Sport</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex flex-col items-center justify-center min-h-screen p-4">
    <h1 class="text-5xl font-bold mb-6">Sélection du Sport</h1>

    <% if(sports != null) { %>
        <div class="flex flex-col gap-4 p-6">
            <% for (Sport sport : sports) { %>
                <% if(sport.getNom().equals("Football")){ %>
                    <a href="hello-servlet">
                <% } %>
                <button class="relative p-4 rounded-lg border-2 transition-all border-green-500 bg-blue-50 hover:bg-blue-100 w-64">
                    <div class="text-sm font-semibold text-center"><%= sport.getNom() %></div>      
                </button>
                    <% if(sport.getNom().equals("Football")){ %>
                </a>
                <% } %>
            <% } %>
        </div>
    <% } %>
</body>
</html>


<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="fr.cnam.pronosport.pronosport.model.Competition" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Map<String, List<Competition>> competitionsParZone = (Map<String, List<Competition>>) request.getAttribute("competitionsParZone");
    String selectedCompetition = request.getParameter("competition");
%>
<html>
<head>
    <title>Compétition</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<%--le traitement des données est fait par matches qui reçoit les différents id des compétitions référencé par competition_id --%>
<form method ="post" action="matches-servlet">
<div class="max-w-lg mx-auto p-4 bg-white rounded-lg shadow mt-20">
    <h2 class="text-xl font-bold mb-4">Sélection des compétitions</h2>
    <input
            type="text"
            placeholder="Rechercher une compétition..."
            class="pl-10 pr-4 py-2 w-full border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 mb-8 "
    />
    <div class="space-y-2 max-h-96 overflow-y-auto pr-1">
        <% if (competitionsParZone != null) {
            for (Map.Entry<String, List<Competition>> entry : competitionsParZone.entrySet()) {
                String zone = entry.getKey();
                List<Competition> competitionsDansZone = entry.getValue();
        %>
        <!-- Affichage du nom de la zone -->
        <div class="border rounded-lg overflow-hidden mb-2">
            <div class="flex items-center justify-between p-3 bg-gray-50">
                <div class="flex items-center">

                    <h3 class="font-medium ml-3"><%= zone %></h3>
                </div>
            </div>
            <div class="p-2 space-y-1">
                <% for (Competition competition : competitionsDansZone) { %>
                <div class="flex items-center p-2 hover:bg-gray-50 rounded cursor-pointer">
                    <input
                            type="checkbox"
                            class="h-4 w-4 text-blue-600 rounded"
                            name="competition"
                            value="<%= competition.getId() %>"

                    />
                    <img
                            src="images/cup.jpg"
                            class="ml-3 w-7 h-7"
                            alt="<%= competition.getNom() %>"
                    />
                    <span class="ml-3"><%= competition.getNom() %></span>
                </div>
                <% } %>
            </div>
        </div>
        <%  }
        } %>
    </div>
    <div class="mt-4 flex justify-between items-center">
        <div class="text-sm text-gray-600">
             compétition(s) sélectionnée(s) <span>0</span>
        </div>
        <button
                class="px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 disabled:opacity-50"

        type="submit"
        >
            <%-- if(hasSelections)? "" : disabled--%>
        Valider
        </button>

    </div>
</div>
</form>
</body>
</html>

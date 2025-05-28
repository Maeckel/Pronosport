<%@ page import="java.util.Arrays" %>
<%@ page import="fr.cnam.pronosport.pronosport.model.Match" %><%--
  Created by IntelliJ IDEA.
  User: Romain
  Date: 27/05/2025
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    // Variable de test
    Match match = null;
    // match reçu de MachServlet
    // Match match = (Match)request.getAttribute("mathches")
    // test String[] competitionsId = (String[]) request.getAttribute("CompetitionsId");
%>
<html>
<head>
    <title>Matches</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<h1> Matchs sélectionnés </h1>


<%--<span>  <%=Arrays.toString(competitionsId)%>> </span>--%>

<%-- Génération des Badges des compétitions sélectionnées  --%>
<%-- for competition :selectedCompetition créer un bouton  --%>
<%--Liste des matchs --%>
<div class="max-w-lg mx-auto p-4 bg-white rounded-lg shadow">
    <div class="flex justify-between items-center mb-4">
        <h2 class="text-xl font-bold">Matchs</h2>
        <div class="flex space-x-2">
            <button class="p-2 rounded-full bg-gray-100 hover:bg-gray-200">
                <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="20"
                        height="20"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="lucide lucide-filter"
                >
                    <polygon
                            points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3"
                    ></polygon>
                </svg>
            </button
            >
            <button class="p-2 rounded-full bg-gray-100 hover:bg-gray-200">
                <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="20"
                        height="20"
                        viewBox="0 0 24 24"
                        fill="none"
                        stroke="currentColor"
                        stroke-width="2"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        class="lucide lucide-refresh-cw"
                >
                    <path d="M3 12a9 9 0 0 1 9-9 9.75 9.75 0 0 1 6.74 2.74L21 8"></path>
                    <path d="M21 3v5h-5"></path>
                    <path d="M21 12a9 9 0 0 1-9 9 9.75 9.75 0 0 1-6.74-2.74L3 16"></path>
                    <path d="M8 16H3v5"></path>
                </svg>
            </button>
        </div>
    </div>
    <div class="flex flex-wrap gap-2 mb-4">
        <div
                class="px-3 py-1 bg-blue-100 text-blue-800 rounded-full text-sm flex items-center"
        >
            UEFA Champions League
        </div>
        <div
                class="px-3 py-1 bg-blue-100 text-blue-800 rounded-full text-sm flex items-center"
        >
            Premier League
        </div>
        <div
                class="px-3 py-1 bg-blue-100 text-blue-800 rounded-full text-sm flex items-center"
        >
            Ligue 1
        </div>
        <button
                class="px-3 py-1 bg-gray-100 text-gray-600 rounded-full text-sm flex items-center hover:bg-gray-200"
        >
            Modifier
        </button>
    </div>

    <div class="space-y-3 max-h-96 overflow-y-auto pr-1">
        <div class="border rounded-lg overflow-hidden">
            <div
                    class="bg-gray-50 px-3 py-2 text-sm flex justify-between items-center"
            >
                <div class="flex items-center">
          <span class="font-medium">UEFA Champions League</span
          ><span class="ml-2 text-xs text-gray-500">Europe</span>
                </div>
                <div class="flex items-center text-gray-500">
                    <svg
                            xmlns="http://www.w3.org/2000/svg"
                            width="14"
                            height="14"
                            viewBox="0 0 24 24"
                            fill="none"
                            stroke="currentColor"
                            stroke-width="2"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            class="lucide lucide-calendar mr-1"
                    >
                        <path d="M8 2v4"></path>
                        <path d="M16 2v4"></path>
                        <rect width="18" height="18" x="3" y="4" rx="2"></rect>
                        <path d="M3 10h18"></path>
                    </svg>
                    <span>jeu. 29 mai, 16:50</span>
                </div>
            </div>

            <div class=" flex flex-col items-center p-3">
                <div class="flex items-center justify-between">
                    <div class="flex items-center space-x-2 flex-1">
                        <img
                                src="/api/placeholder/30/30"
                                alt="Real Madrid"
                                class="w-6 h-6"
                        /><span class="font-medium">Real Madrid</span>
                    </div>
                    <div class="flex space-x-2">
                        <button class="w-10 h-8 rounded bg-gray-100 hover:bg-gray-200">
                            1
                        </button
                        >
                        <button class="w-10 h-8 rounded bg-gray-100 hover:bg-gray-200">
                            N
                        </button
                        >
                        <button class="w-10 h-8 rounded bg-gray-100 hover:bg-gray-200">
                            2
                        </button>
                    </div>
                    <div class="flex items-center space-x-2 justify-end flex-1">
            <span class="font-medium text-center">Bayern Munich</span
            ><img
                            src="/api/placeholder/30/30"
                            alt="Bayern Munich"
                            class="w-6 h-6"
                    />
                    </div>
                </div>
                <button class=" flex items-center justify-center w-24 px-6 py-4 bg-blue-100 text-blue-800 rounded-full text-sm ">Predire le score</button>
                <div class="mt-2 flex justify-center">
                    <button
                            class="flex items-center text-sm text-gray-500 hover:text-gray-700"
                    >
            <span>Voir plus</span
            >
                        <svg
                                xmlns="http://www.w3.org/2000/svg"
                                width="16"
                                height="16"
                                viewBox="0 0 24 24"
                                fill="none"
                                stroke="currentColor"
                                stroke-width="2"
                                stroke-linecap="round"
                                stroke-linejoin="round"
                                class="lucide lucide-chevron-down"
                        >
                            <path d="m6 9 6 6 6-6"></path>
                        </svg>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

package fr.cnam.pronosport.pronosport.service;

import fr.cnam.pronosport.pronosport.dto.*;

public interface ApiClient {

    public ApiCompetitionDto[] getAllCompetitions() throws Exception;
    public ApiMatchDto[] getAllMatchs()throws Exception;
    public ApiTeamDto[] getAllTeams()throws Exception;
    public ApiSportDto[] getAllSports()throws Exception;
    public ApiAreaDto[] getAllArea()throws Exception;

}

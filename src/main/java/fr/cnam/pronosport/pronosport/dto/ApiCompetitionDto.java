package fr.cnam.pronosport.pronosport.dto;

import com.google.gson.annotations.SerializedName;

public class ApiCompetitionDto {
    //ApiCompetitionDto représente une classe de transfert de données (DTO pour Data Transfer Object) qui correspond à la structure des données reçues depuis l’API externe.
    // Dans notre cas du JSON


    /*
    L’annotation @SerializedName("name")
    en Java (avec la bibliothèque Gson) indique que le champ Java annoté doit être associé au champ "name"
    dans le JSON lors de la sérialisation (conversion Java → JSON) ou de la désérialisation (JSON → Java)


   Faire correspondre des noms de champs différents entre ta classe Java et le JSON reçu.
    * */



    /*
    *********  Extrait Structure du JSON reçu *********
    {
  "count": 148,
  "filters": {},
  "competitions": [
    {
      "id": 2021,
      "name": "Premier League",
      "area": {
        "name": "England"
      },
      "code": "PL",
      "type": "LEAGUE",
      ...
    }
  ]
}

    * */




    @SerializedName("name")
    private String name;



    @SerializedName("type")
    private String type;

    @SerializedName("area")
    private ApiAreaDto area;



    public String getType() {
        return type;
    }



    public ApiAreaDto getArea() {
        return area;
    }

    public String getName() {
        return name;
    }
}

package fr.cnam.pronosport.pronosport.dto;

import com.google.gson.annotations.SerializedName;

public class ApiAreaDto {

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }
}

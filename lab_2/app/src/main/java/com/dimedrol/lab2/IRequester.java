package com.dimedrol.lab2;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRequester {
    @GET("data/techs.ruleset.json")
    Call<ArrayList<Tech>> getTechs();
}
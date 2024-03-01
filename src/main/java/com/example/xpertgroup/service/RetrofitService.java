package com.example.xpertgroup.service;

import com.example.xpertgroup.model.Breed;
import com.example.xpertgroup.model.ImageCat;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.ArrayList;

public interface RetrofitService {

    String APIKEY = "live_SNohCyltHJSCMkvMp29QBDQbTjwq5PX3UZvK9XVULEAHp2aNwxc1rORlLVzCI1al";

    @GET("breeds")
    Call<ArrayList<Breed>> getBreads();

    @Headers({"x-api-key:"+APIKEY})
    @GET("https://api.thecatapi.com/v1/images/search")
    Call<ArrayList<ImageCat>> getImagesByBreed(@Query("breed_ids") String breedId, @Query("limit") String limit);

    @Headers({"x-api-key:"+APIKEY})
    @GET("https://api.thecatapi.com/v1/images/search")
    Call<ArrayList<ImageCat>> getByCustomSearch(
            @Query("limit") String limit,
            @Query("page") String page,
            @Query("order") String order,
            @Query("has_breeds") String hasBreeds,
            @Query("breed_ids") String breedIds,
            @Query("category_ids") String categoryIds,
            @Query("sub_id") String subId);


}

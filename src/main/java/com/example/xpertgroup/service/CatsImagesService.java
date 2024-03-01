package com.example.xpertgroup.service;


import com.example.xpertgroup.model.BreedDTO;
import com.example.xpertgroup.model.Breed;
import com.example.xpertgroup.model.ImageCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatsImagesService {


    @Autowired
    RetrofitImpl retrofit;

    public ArrayList<BreedDTO> getAllBreed() throws Exception {

        ArrayList<BreedDTO> allBreeds =  new ArrayList<>();
        Call<ArrayList<Breed>> call = retrofit.service.getBreads();

        try{
            Response<ArrayList<Breed>> response = call.execute();
            if(response.isSuccessful()){
                ArrayList<Breed> nofilteredBreeds = response.body();
                if(nofilteredBreeds != null){
                    for(Breed breed : nofilteredBreeds){
                        allBreeds.add(new BreedDTO(breed.getName(), breed.getId()));
                    }
                }
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return  allBreeds;
    }

    public ArrayList<ImageCat> getCatsByBreed(String breed) throws Exception {

        ArrayList<ImageCat> catImages =  new ArrayList<>();
        Call<ArrayList<ImageCat>> call = retrofit.service.getImagesByBreed(breed, "100");
        try{
            Response<ArrayList<ImageCat>> response = call.execute();

            if(response.isSuccessful()){
                catImages = response.body();
            }
        }catch (Exception e){
            System.out.println("An error has occurred");
            throw new Exception(e.getMessage());

        }
        return catImages;
    }


    public ArrayList<?> customSearch(String limit, String page, String order, String hasBreeds, String breedIds, String categoryIds, String subId) throws Exception {

        ArrayList<?> result = new ArrayList<>();
        Call<ArrayList<ImageCat>> call = retrofit.service.getByCustomSearch(limit, page, order, hasBreeds, breedIds, categoryIds, subId);

        try{
            Response<ArrayList<ImageCat>> response = call.execute();
            System.out.println();
            if(response.isSuccessful()) {
                result = response.body();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception("something went wrong");
        }

        return result;

    }

}

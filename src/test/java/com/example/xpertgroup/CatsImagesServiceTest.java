package com.example.xpertgroup;

import com.example.xpertgroup.model.BreedDTO;
import com.example.xpertgroup.model.ImageCat;
import com.example.xpertgroup.service.CatsImagesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.ArrayList;




public class CatsImagesServiceTest extends XpertgroupApplicationTests{


    @InjectMocks
    @Autowired
    CatsImagesService catsImagesService;


    @Test
    public void gettingAllBreeds(){

        try{
            ArrayList<BreedDTO> result = catsImagesService.getAllBreed();
            Assertions.assertFalse(result.isEmpty());
        }catch(Exception e ){
            Assertions.fail();
        }
    }



    @Test
    public void nonExistentBreed(){

        try{
            ArrayList<ImageCat> result = catsImagesService.getCatsByBreed("nonexistenbreed");

            Assertions.assertTrue(result.isEmpty());
        }catch (Exception e){
            Assertions.fail();
        }


    }

    @Test
    public void limitedSearch(){

        try{
            ArrayList<?> result = catsImagesService.customSearch("10", null,null, null, null, null, null);
            Assertions.assertEquals(10, result.size());
            result = catsImagesService.customSearch("1", null,null, null, null, null, null);
            Assertions.assertEquals(1, result.size());

        }catch (Exception e){
            Assertions.fail();
        }


    }

}

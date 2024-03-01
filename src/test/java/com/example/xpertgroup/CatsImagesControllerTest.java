package com.example.xpertgroup;

import com.example.xpertgroup.controller.CatsImagesController;
import com.example.xpertgroup.model.ImageCat;
import com.example.xpertgroup.service.CatsImagesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.when;

public class CatsImagesControllerTest extends XpertgroupApplicationTests{

    @Mock
    CatsImagesService catsImagesService;

    @InjectMocks
    CatsImagesController catsImagesController;

    @Test
    public void gettingBreed(){
        try{

            ResponseEntity<?> response = catsImagesController.getBreads();

            Assertions.assertEquals(HttpStatusCode.valueOf(200),response.getStatusCode());

            List<?> body = (List<?>) response.getBody();
            Assertions.assertNotNull(body);
        }catch (Exception e){

            Assertions.assertEquals("Error", e.getMessage());

        }
    }

    @Test
    public void gettingBreedError(){
        try{
            when(catsImagesService.getAllBreed()).thenThrow(new Exception("Error"));

            ResponseEntity<?> response = catsImagesController.getBreads();

            Assertions.assertNotEquals(HttpStatusCode.valueOf(200),response.getStatusCode());
        }catch (Exception e){

            Assertions.assertEquals("Error", e.getMessage());

        }
    }

    @Test
    public void gettingCatByBreedNonExistent(){
        try{
            when(catsImagesService.getCatsByBreed(Mockito.anyString())).thenReturn(new ArrayList<>());

            ResponseEntity<?> response = catsImagesController.getByBreeds("nonexistentone");

            Assertions.assertEquals(HttpStatusCode.valueOf(404),response.getStatusCode());
        }catch (Exception e){

            Assertions.fail();

        }
    }

    @Test
    public void gettingCatByBreed(){
        try{

            ArrayList<ImageCat> result = new ArrayList<>();
            result.add(new ImageCat());
            when(catsImagesService.getCatsByBreed(Mockito.anyString())).thenReturn(result);

            ResponseEntity<?> response = catsImagesController.getByBreeds("existentOne");

            Assertions.assertEquals(HttpStatusCode.valueOf(200),response.getStatusCode());
            List<ImageCat> list = (List<ImageCat>) response.getBody();
            assert list != null;
            Assertions.assertFalse(list.isEmpty() );

        }catch (Exception e){

            Assertions.fail();

        }
    }

    @Test
    public void customSearchError(){
        try{

            when(catsImagesService.customSearch(Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any())).thenThrow(new Exception("massive error"));

            ResponseEntity<?> response = catsImagesController.search("10", null,null,null,null,null,null );

            Assertions.assertEquals("massive error", Objects.requireNonNull(response.getBody()).toString());
            Assertions.assertEquals(HttpStatusCode.valueOf(500), response.getStatusCode());
        }catch (Exception e){

            Assertions.fail();
        }
    }

    @Test
    public void customSearch(){
        try{

            when(catsImagesService.customSearch(Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(new ArrayList<>());

            ResponseEntity<?> response = catsImagesController.search("10", null,null,null,null,null,null );

            Assertions.assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        }catch (Exception e){

            Assertions.fail();
        }
    }
}

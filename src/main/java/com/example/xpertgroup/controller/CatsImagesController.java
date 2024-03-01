package com.example.xpertgroup.controller;


import com.example.xpertgroup.model.BreedDTO;
import com.example.xpertgroup.model.ImageCat;
import com.example.xpertgroup.service.CatsImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/breeds")
public class CatsImagesController {

    @Autowired
    CatsImagesService catsImagesService;

    @GetMapping
    public ResponseEntity<?> getBreads(){

        try{
            List<BreedDTO> list = catsImagesService.getAllBreed();

            return new ResponseEntity<>(list, HttpStatusCode.valueOf(200));

        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(500));
        }
    }

    @GetMapping("/{breed}")
    public  ResponseEntity<?> getByBreeds(@PathVariable String breed){

        try{

            List<ImageCat> list = catsImagesService.getCatsByBreed(breed);
            if(list.isEmpty()){
                return new ResponseEntity<>("Raza no existe", HttpStatusCode.valueOf(404));
            }
            return new ResponseEntity<>(list, HttpStatusCode.valueOf(200));

        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(500));
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam(required = false, defaultValue = "1") String limit,
            @RequestParam(required = false) String page,
            @RequestParam(required = false) String order,
            @RequestParam(required = false) String has_breeds,
            @RequestParam(required = false) String breed_ids,
            @RequestParam(required = false) String category_ids,
            @RequestParam(required = false) String sub_id
    ){
        try{

            List<?> list = catsImagesService.customSearch(limit, page, order, has_breeds, breed_ids, category_ids, sub_id);
            return new ResponseEntity<>(list, HttpStatusCode.valueOf(200));

        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(500));
        }

    }


}

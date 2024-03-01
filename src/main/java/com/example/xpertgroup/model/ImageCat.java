package com.example.xpertgroup.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageCat {
    private ArrayList<BreedDTO> breeds;
    private List<?> categories;
    private String id;
    private String url;
    private int width;
    private int height;

}

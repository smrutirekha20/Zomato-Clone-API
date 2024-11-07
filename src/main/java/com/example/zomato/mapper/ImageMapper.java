package com.example.zomato.mapper;

import com.example.zomato.entity.Image;
import com.example.zomato.requestdtos.ImageRequest;
import com.example.zomato.responsedtos.ImageResponse;

public class ImageMapper {

    public Image mapToImage(ImageRequest imageRequest, Image image){
        image.setImageId(imageRequest.getImageURL());

        return image;
    }

    public ImageResponse mapToImageResponse(Image image){
        ImageResponse imageResponse = new ImageResponse();
        imageResponse.setImageId(image.getImageId());
        imageResponse.setImageURL(image.getImageURL());

        return imageResponse;
    }
}

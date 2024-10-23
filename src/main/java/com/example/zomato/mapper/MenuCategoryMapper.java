package com.example.zomato.mapper;

import com.example.zomato.entity.MenuCategory;
import com.example.zomato.requestdtos.MenuCategoryRequest;
import com.example.zomato.responsedtos.MenuCategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class MenuCategoryMapper {

    public MenuCategory mapToMenuCategory(MenuCategoryRequest menuCategoryRequest,MenuCategory menuCategory){
        menuCategory.setTitle(menuCategoryRequest.getTitle());

        return menuCategory;
    }

    public MenuCategoryResponse mapToMenuCategoryResponse(MenuCategory menuCategory){
        MenuCategoryResponse menuCategoryResponse=new MenuCategoryResponse();
        menuCategoryResponse.setMenuCategoryId(menuCategory.getMenuCategoryId());
        menuCategoryResponse.setTitle(menuCategory.getTitle());

        return menuCategoryResponse;
    }
}

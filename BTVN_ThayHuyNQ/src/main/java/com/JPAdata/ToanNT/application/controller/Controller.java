package com.JPAdata.ToanNT.application.controller;

import com.JPAdata.ToanNT.application.data.model.Category;
import com.JPAdata.ToanNT.application.data.model.Item;
import com.JPAdata.ToanNT.application.data.model.ItemCategory;
import com.JPAdata.ToanNT.application.data.model.Type;
import com.JPAdata.ToanNT.application.data.service.CategoryService;
import com.JPAdata.ToanNT.application.data.service.ItemCategoryService;
import com.JPAdata.ToanNT.application.data.service.ItemService;
import com.JPAdata.ToanNT.application.data.service.TypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemService itemService;

    @Autowired
    TypeService typeService;

    @Autowired
    ItemCategoryService itemCategoryService;

    //get Category by name type
    @GetMapping("/listByType/{type}")
    public List<Category> list(@PathVariable("type") String type) {
        Type type1 = typeService.getTypeByName(type);
        List<Category> list = categoryService.findByType(type1.getId());
        list.forEach(System.out::println);
        return list;
    }

    //get Item by category name
    @GetMapping("/list/{name}")
    public List<Item> getByName(@PathVariable("name") String name) {
        ModelMapper modelMapper = new ModelMapper();
        Category category = categoryService.getOneByName(name);
        List<ItemCategory> itemCategory = itemCategoryService.getByCat(category.getId());

        itemCategory.forEach(System.out::println);
        List<Item> list = new ArrayList<>();
        for(int i = 0; i < itemCategory.size(); i++) {
            list.add(modelMapper.map(itemCategory.get(i).getItem(), Item.class));
        }
        list.forEach(System.out::println);
        return list;
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Category category) {
        try {
            categoryService.update(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/getAll")
    public List<Category> getOne() {
        return categoryService.getAll();
    }
}

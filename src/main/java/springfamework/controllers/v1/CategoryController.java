package springfamework.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfamework.api.v1.model.CategoryDTO;
import springfamework.api.v1.model.CategoryListDTO;
import springfamework.services.CategoryService;

//I'm using this controller to test @RestController annotation, added at Spring 4.
//It combines @Controller and @ResponseBody annotations.
//This way we can keep code cleaner. Check CustomerController for earlier versions of Spring Controllers.

@RestController
@RequestMapping(CategoryController.CAT_BASE_URL)
public class CategoryController {

    private final CategoryService categoryService;
    public static final String CAT_BASE_URL = "/api/v1/categories";


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories(){
        return new CategoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }
}

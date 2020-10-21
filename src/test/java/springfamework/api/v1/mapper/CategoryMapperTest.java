package springfamework.api.v1.mapper;

import org.junit.Test;
import springfamework.api.v1.model.CategoryDTO;
import springfamework.domain.Category;

import static org.junit.Assert.*;

public class CategoryMapperTest {

    public static final  String NAME = "Joe";
    public static final long ID = 1L;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() throws Exception{

        //GIVEN
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        //WHEN
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //THEN
        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }
}
package com.hj.recipe.converters;

import com.hj.recipe.command.CategoryCommand;
import com.hj.recipe.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CategoryCommandToCategoryTest {
    CategoryCommandToCategory categoryCommandToCategory;
    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "description";

    @Before
    public void setUp() throws Exception {
        this.categoryCommandToCategory = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(categoryCommandToCategory.convert(null));
    }

    @Test
    public void testBlankObject() throws Exception {
        assertNotNull(categoryCommandToCategory.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws  Exception{
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setDescription(DESCRIPTION);
        categoryCommand.setId(ID_VALUE);

        Category category = categoryCommandToCategory.convert(categoryCommand);

        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}
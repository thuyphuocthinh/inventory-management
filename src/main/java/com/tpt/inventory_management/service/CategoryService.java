package com.tpt.inventory_management.service;

import com.tpt.inventory_management.dto.CategoryDTO;
import com.tpt.inventory_management.dto.Response;

public interface CategoryService {

    Response createCategory(CategoryDTO categoryDTO);

    Response getAllCategories();

    Response getCategoryById(Long id);

    Response updateCategory(Long id, CategoryDTO categoryDTO);

    Response deleteCategory(Long id);
}
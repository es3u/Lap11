package com.example.lap11.Service;

import com.example.lap11.ApiResponse.ApiException;
import com.example.lap11.Model.Category;
import com.example.lap11.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id ,Category category) {
        Category category1 = categoryRepository.findCategoriesById(id);

        if(category1 != null) {
            category1.setCategoryName(category.getCategoryName());
            categoryRepository.save(category1);
        }
        throw new ApiException("category not found");
    }

    public void deleteCategory(Integer categoryId) {
        Category category1 = categoryRepository.findCategoriesById(categoryId);
        if(category1 != null) {
            categoryRepository.delete(category1);
        }
        throw new ApiException("category not found");
    }

}

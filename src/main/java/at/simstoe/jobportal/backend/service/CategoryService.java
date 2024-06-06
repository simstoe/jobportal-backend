package at.simstoe.jobportal.backend.service;

import at.simstoe.jobportal.backend.models.Category;
import at.simstoe.jobportal.backend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return this.categoryRepository.findCategoryById(id);
    }

    public Category createCategory(Category category) {
        if (this.categoryRepository.findCategoryById(category.getId()) != null) return null;

        return this.categoryRepository.save(category);
    }
}

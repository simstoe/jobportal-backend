package at.simstoe.jobportal.backend.controller;

import at.simstoe.jobportal.backend.models.Category;
import at.simstoe.jobportal.backend.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        if (this.categoryService.getCategoryById(category.getId()) != null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(this.categoryService.createCategory(category));
    }
}

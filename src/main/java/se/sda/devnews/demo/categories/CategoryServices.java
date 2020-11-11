package se.sda.devnews.demo.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository repo;


    public List<Category> getAll(String sort) {
        return repo.findAll().stream().sorted(Comparator
                .comparing(Category::getName))
                .collect(Collectors.toList());
    }

    public Optional<Category> getById(Long id) {
        return repo.findById(id);
    }

    public Category createCategory(Category newCategory) {

        return repo.save(newCategory);
    }

    public void deleteCategory(Long id) {
        repo.deleteById(id);
    }

    public Category update(Category updatedCategory) {
        return repo.save(updatedCategory);
    }
}

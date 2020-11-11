package se.sda.devnews.demo.categories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("")
    public List<Category> getAll(@RequestParam String sort) {
        return categoryServices.getAll(sort);
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryServices.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /*
  To Post using curl instead of postman:
  curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"name":"pc", "date":"2020.12.12"}' \ http: localhost:8080/categories

  OR
  curl -X POST -d '{"name":"pc", "date":"2020.11.12"}' -H "Content-Type: application/json" localhost:8080/categories
 */
    @PostMapping("")
    public Category create(@RequestBody Category newCategory){
        return categoryServices.createCategory(newCategory);
    }

    @PutMapping("")
    public Category update(@RequestBody Category updatedCategory){
        return categoryServices.update(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoryServices.deleteCategory(id);
    }


}

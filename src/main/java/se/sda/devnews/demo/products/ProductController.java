package se.sda.devnews.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServices productServices;


    @GetMapping("")
    public List<Product> getAll(@RequestParam(required = false) String sort, @RequestParam(required = false) Long categoryId) {
        if (sort == null){
            sort = "name";
        }
        if(categoryId == null){
            return productServices.getAll(sort);
        } else {
            return productServices.getAllByCategoryId(categoryId);
        }
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productServices.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /*
  To Post using curl instead of postman:
  curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"name":"pc", "date":"2020.12.12"}' \ http: localhost:8080/products

  OR
curl -X POST -d '{"name":"pc", "date":"2020.11.12"}' -H "Content-Type: application/json" localhost:8080/products
  curl -X POST -d '{"name":"pc", "date":"2020.11.12"}' -H "Content-Type: application/json" localhost:8080/products
 */
    @PostMapping("")
    public Product create(@RequestBody Product newProduct) {
        return productServices.createProduct(newProduct);
    }

    @PutMapping("")
    public Product update(@RequestBody Product updatedProduct) {
        return productServices.update(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productServices.deleteProduct(id);
    }


}

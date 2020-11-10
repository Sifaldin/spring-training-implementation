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
    public List<Product> getAll(@RequestParam String sort) {
        return productServices.getAll(sort);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productServices.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /*
  To Post using curl instead of postman:
  curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"name":"laptop", "date":"2020.12.12"}' \ http: localhost:8080/products
 */
    @PostMapping("")
    public Product create(@RequestBody Product newProduct){
        return productServices.createProduct(newProduct);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         productServices.deleteProduct(id);
    }



}

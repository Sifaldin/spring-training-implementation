package se.sda.devnews.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository repo;
    private Long idCounter = 1L;
   /* private List<Product> productList;
    public ProductServices() {
        this.productList = new ArrayList<>();
        add(new Product(null, "keyboard", "2020.01.01"));
        add(new Product(null, "mouse", "2019.01.01"));
        add(new Product(null, "monitor", "2019.01.02"));
    }*/

    public List<Product> getAll(String sort) {
        return repo.findAll().stream().sorted(Comparator
                .comparing(sort.equals("name") ? Product::getName : Product::getDate))
                .collect(Collectors.toList());
    }

    public Optional<Product> getById(Long id) {
        return repo.findById(id);
        /*
        return productList.stream().filter((p) -> p.getId().equals(id)).findFirst();
        (Optional<> is added so no need for this for now and to seperate http related work from services class)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
         */
        /*
          ForEach Method Option
        for (Product p: productList){
         if (p.getId().equals(id)){return p;}
            }
           return null;
         */
    }

    public Product createProduct(Product newProduct) {
        newProduct.setId(idCounter);
        idCounter++;
        return repo.save(newProduct);
    }
    /*public boolean add(Product newProduct){
        newProduct.setId(idCounter);
        idCounter++;
        return productList.add(newProduct);

    }*/
    public void deleteProduct(Long id) {
        repo.deleteById(id);
        /* productList = productList.stream().filter(p -> !p.getId().equals(id)).collect(Collectors.toList()); */
    }
}

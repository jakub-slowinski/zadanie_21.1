package pl.biomechanika.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("/lista")
    public String list() {
        return "list";
    }

    private void listOfProducts() {
        List<Product> products = productRepo.allProducts();
        double sumofPrice = 0;
        for (Product product : products) {
            sumofPrice += product.getPrice();
        }
    }

    @PostMapping("/add")
    public String add(@RequestParam String name, @RequestParam double price, @RequestParam String category) {

        Product product = new Product(name, price, category);
        productRepo.add(product);

        return "redirect:/lista";
    }
}

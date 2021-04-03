package pl.biomechanika.demo;

import java.util.List;

public class ProductRepo {

    private List<Product> products;

    private ProductRepo(){

    }

    public List<Product> allProducts() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }
}

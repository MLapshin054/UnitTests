package seminar01.HW01.Shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> sortProductsByPrice() {
        List<Product> sortedProducts = new ArrayList<>(products);
        Collections.sort(sortedProducts, Comparator.comparingInt(Product::getCost));
        return sortedProducts;
    }

    public Product getMostExpensiveProduct() {
        if (products == null || products.isEmpty()) {
            return null;
        }
        Product mostExpensive = products.get(0);
        for (Product product : products) {
            if (product.getCost() > mostExpensive.getCost()) {
                mostExpensive = product;
            }
        }
        return mostExpensive;
    }
}
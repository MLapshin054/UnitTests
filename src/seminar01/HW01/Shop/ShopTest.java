package seminar01.HW01.Shop;

import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    private Shop shop;
    private List<Product> products;

    void setUp() {
        products = new ArrayList<>();
        Product product1 = new Product();
        product1.setTitle("Apple");
        product1.setCost(100);
        products.add(product1);

        Product product2 = new Product();
        product2.setTitle("Banana");
        product2.setCost(50);
        products.add(product2);

        Product product3 = new Product();
        product3.setTitle("Orange");
        product3.setCost(75);
        products.add(product3);

        shop = new Shop(products);
    }

    void testShopInitialization() {
        assertThat(shop.getProducts())
                .isNotNull()
                .hasSize(3)
                .containsExactlyElementsOf(products);
    }

    void testGetMostExpensiveProduct() {
        Product mostExpensive = shop.getMostExpensiveProduct();
        assertThat(mostExpensive).isNotNull();
        assertThat(mostExpensive.getTitle()).isEqualTo("Apple");
        assertThat(mostExpensive.getCost()).isEqualTo(100);
    }

    void testSortProductsByPrice() {
        List<Product> sortedProducts = shop.sortProductsByPrice();
        assertThat(sortedProducts)
                .isSortedAccordingTo((p1, p2) -> p1.getCost() - p2.getCost());

        assertThat(sortedProducts.get(0).getTitle()).isEqualTo("Banana");
        assertThat(sortedProducts.get(1).getTitle()).isEqualTo("Orange");
        assertThat(sortedProducts.get(2).getTitle()).isEqualTo("Apple");
    }

    void testSetProducts() {
        List<Product> newProducts = new ArrayList<>();
        Product product4 = new Product();
        product4.setTitle("Grape");
        product4.setCost(60);
        newProducts.add(product4);

        shop.setProducts(newProducts);

        assertThat(shop.getProducts())
                .isNotNull()
                .hasSize(1)
                .containsExactlyElementsOf(newProducts);
    }

    public static void main(String[] args) {
        ShopTest test = new ShopTest();
        test.setUp();
        test.testShopInitialization();
        test.testGetMostExpensiveProduct();
        test.testSortProductsByPrice();
        test.testSetProducts();
        System.out.println("Все тесты пройдены!");
    }
}
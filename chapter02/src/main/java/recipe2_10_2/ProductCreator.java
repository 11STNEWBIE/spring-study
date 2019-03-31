package recipe2_10_2;

import recipe2_10_1.Battery;
import recipe2_10_1.Disc;
import recipe2_10_1.Product;

import java.util.Map;

public class ProductCreator {

    private Map<String, Product> products;

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    public Product createProduct(String productId) {

        Product product = products.get(productId);

        if (product != null) {
            return product;
        }
        throw new IllegalArgumentException("Unknown Product");
    }
}

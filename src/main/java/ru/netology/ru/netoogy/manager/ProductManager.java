package ru.netology.ru.netoogy.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager() {
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product item : repository.findAll()) {
            if (item.matches(text)) {
                int length = result.length + 1;
                Product[] tmp = new Product[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = item;
                result = tmp;
            }
        }
        return result;
    }
}

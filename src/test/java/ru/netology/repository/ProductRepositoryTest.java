package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.ru.netoogy.manager.NotFoundException;
import ru.netology.ru.netoogy.manager.ProductManager;

import java.io.UncheckedIOException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository;

    private Book book1 = new Book(1, "Java", 100, "Dane");
    private TShirt tshirt1 = new TShirt(2, "Z1", 10_000, "Red", "M");
    private Book book2 = new Book(3, "Java", 100, "Burd");
    private TShirt tshirt2 = new TShirt(4, "Z1", 10_000, "Red", "M");
    private Book book3 = new Book(5, "Life", 100, "Smith");
    private TShirt tshirt3 = new TShirt(6, "Z1", 10_000, "Red", "M");

    @BeforeEach
    public void setUp() {
        repository = new ProductRepository();
        repository.save(book1);
        repository.save(tshirt1);
        repository.save(book2);
        repository.save(tshirt2);
        repository.save(book3);
        repository.save(tshirt3);
    }

    @Test
    void shouldRemoveByIfExistsId() {
        Product[] expected = new Product[]{book1, book2, tshirt2, book3, tshirt3};
        repository.removeById(2);
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldGenerateNotFoundException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(7));
    }
}
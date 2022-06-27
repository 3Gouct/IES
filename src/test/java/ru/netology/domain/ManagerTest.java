package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    Book book1 = new Book (1, "War and peace", 1000, "Tolstoy");
    Smartphone smartphone1 = new Smartphone (2, "Galaxy", 10_000, "Samsung");
    Book book2 = new Book (3, "Eugene Onegin", 1_500, "Pushkin");
    Smartphone smartphone2 = new Smartphone (4, "X", 30_000, "Apple");

    @Test
    public void shouldAddProduct() {
        Manager manager = new Manager ();
        manager.add (book1);
        manager.add (smartphone2);

        Product[] actual = manager.findAll ();
        Product[] expected = {book1, smartphone2};

        Assertions.assertArrayEquals (expected, actual);
    }

    @Test
    public void removeById() {
        Manager manager = new Manager ();

        manager.add (book1);
        manager.add (book2);
        manager.add (smartphone1);

        manager.removeById (2);

        Product[] actual = manager.findAll ();
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals (expected, actual);
    }

    @Test
    public void search() {
        Manager manager = new Manager ();

        manager.add (book1);
        manager.add (book2);
        manager.add (smartphone1);


        Product[] actual = manager.searchBy ("Eugene Onegin");
        Product[] expected = {book2};

        Assertions.assertArrayEquals (expected, actual);
    }

    @Test
    public void searchNeg() {
        Manager manager = new Manager ();

        manager.add (book1);
        manager.add (book2);
        manager.add (smartphone1);


        Product[] actual = manager.searchBy ("Crime and punishment");
        Product[] expected = {};

        Assertions.assertArrayEquals (expected, actual);
    }
}
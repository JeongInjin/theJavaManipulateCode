package com.manipulatecode.java.thejavamanipulatecode.di;

import com.manipulatecode.java.di.ContainerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ContainerServiceTest {

    @Test
    void getObject_BookRepository() {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertThat(bookRepository).isNotNull();
    }

    @Test
    void getObject_BookService() {
        BookService bookService = ContainerService.getObject(BookService.class);
        assertThat(bookService).isNotNull();
        assertThat(bookService.bookRepository).isNotNull();
    }
}

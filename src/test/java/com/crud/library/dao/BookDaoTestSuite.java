package com.crud.library.dao;

import com.crud.library.domain.Book;
import com.crud.library.domain.Rent;
import com.crud.library.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDaoTestSuite {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private RentDao rentDao;
    @Autowired
    private UserDao userDao;

    @Test
    public void testBookDaoSaveAndFindByBookId() {
        //given
        Book book = new Book("Test tytul", "Test autor", 1234);

        //when
        bookDao.save(book);

        //then
        int id = book.getBookId();
        String title = book.getTitle();
        String author = book.getAuthor();
        int yearOfPublication = book.getYearOfPublication();
        Book bookTest = (bookDao.findByBookId(id)).get(0);
        assertEquals(id, bookTest.getBookId());
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(yearOfPublication, book.getYearOfPublication());

        //cleanup
        bookDao.deleteById(id);
    }

    @Test
    public void testBookDaoSaveAndFindByBookTitle() {
        //given
        Book book = new Book("Test tytul", "Test autor", 1234);

        //when
        bookDao.save(book);

        //then
        String title = book.getTitle();
        int bookTest = (bookDao.findByTitle(title)).size();
        assertEquals(1, bookTest);

        //cleanup
        bookDao.deleteById(book.getBookId());
    }

    @Test
    public void testRentDaoSaveConnectedEntities() {
        //given
        Book book = new Book("Test tytul", "Test autor", 1234);
        Book book2 = new Book("Test tytul2", "Test autor2", 4321);

        User user = new User("Test imie", "Test nazwisko", new BigInteger("12345612345"));
        Rent rent = new Rent(book, user, LocalDate.of(2018, 9,2));
        Rent rent2 = new Rent(book2, user,LocalDate.of(2018, 8,2));

        //when
        bookDao.save(book);
        bookDao.save(book2);
        userDao.save(user);
        rentDao.save(rent);
        rentDao.save(rent2);

        //then
        List<Rent> searchedRents = rentDao.findByBookId(book.getBookId());
        assertEquals(1, searchedRents.size());

    }
}

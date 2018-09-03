package com.crud.library.dao;

import com.crud.library.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTestSuite {
    @Autowired
    private UserDao userDao;

    @Test
    public void testUserDaoSaveAndFindByUserId() {
        //given
        User user = new User("Test imie", "Test nazwisko", new BigInteger("12345612345"));

        //when
        userDao.save(user);

        //then
        int id = user.getUserId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        BigInteger pesel = user.getPesel();
        User userTest = (userDao.findByUserId(id)).get(0);

        assertEquals(id, userTest.getUserId());
        assertEquals(firstName, userTest.getFirstName());
        assertEquals(lastName, userTest.getLastName());
        assertEquals(pesel, userTest.getPesel());

        //cleanup
        userDao.deleteById(id);
    }

    @Test
    public void testUserDaoSaveAndFindByUserPesel() {
        //given
        User user = new User("Test imie", "Test nazwisko", new BigInteger("12345612345"));

        //when
        userDao.save(user);

        //then
        BigInteger pesel = user.getPesel();
        int userTest = (userDao.findByPesel(pesel)).size();
        assertEquals(1, userTest);

        //cleanup
        userDao.deleteById(user.getUserId());
    }
}

package com.crud.library.dao;

import com.crud.library.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    List<User> findByUserId(int id);
    List<User> findByPesel(BigInteger pesel);
}

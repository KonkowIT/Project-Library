package com.crud.library.dao;

import com.crud.library.domain.Rent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentDao extends CrudRepository<Rent, Integer> {
    List<Rent> findByBookId(int id);
}

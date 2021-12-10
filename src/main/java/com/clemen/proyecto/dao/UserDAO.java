package com.clemen.proyecto.dao;

import com.clemen.proyecto.entities.User;

import java.util.List;


public interface UserDAO {

        List<User> findAllActive();

}

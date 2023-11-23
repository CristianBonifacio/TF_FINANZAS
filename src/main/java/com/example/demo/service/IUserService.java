package com.example.demo.service;

import com.example.demo.entities.users;


public interface IUserService extends CrudService<users>{

    users findByEmailAndPassword(String email, String password);
}

package com.chitiapp.repository;


import com.chitiapp.model.Users;

public interface UserRepository {
Users getUserbyEmail(String email);
Users save(Users u);

}

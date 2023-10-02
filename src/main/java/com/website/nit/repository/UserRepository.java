package com.website.nit.repository;

import com.website.nit.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query("Select u from Users u where u.username=?1")
    Users findByUsername(String username);


    @Query("Select u from Users u where u.email=?1")
    Users findByEmail(String email);
}

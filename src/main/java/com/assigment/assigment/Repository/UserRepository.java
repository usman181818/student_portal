package com.assigment.assigment.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.assigment.assigment.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

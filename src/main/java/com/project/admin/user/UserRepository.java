package com.project.admin.user;

import org.springframework.data.repository.CrudRepository;

import com.project.admin.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}

package com.zipcode.group3blog.group3blog.repository;

import com.zipcode.group3blog.group3blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}

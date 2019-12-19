package com.zipcode.group3blog.model;

import javax.persistence.*;

@Entity
@Table
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long usersId;
@Column
private String username;
@Column
private String password;
@Column
private String email;


    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsersName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

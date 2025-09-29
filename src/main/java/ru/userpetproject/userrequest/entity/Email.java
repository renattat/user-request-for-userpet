package ru.userpetproject.userrequest.entity;

import lombok.Data;

@Data
public class Email {

    private Long id;
    private String address;
    private User user;
}

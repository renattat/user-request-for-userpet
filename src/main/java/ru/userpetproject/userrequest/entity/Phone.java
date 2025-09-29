package ru.userpetproject.userrequest.entity;

import lombok.Data;

@Data
public class Phone {

    private Long id;
    private String number;
    private String type;
    private User user;
}

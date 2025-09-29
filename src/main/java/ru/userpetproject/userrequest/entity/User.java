package ru.userpetproject.userrequest.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private Long id;
    private String name;
    private List<Email> emails = new ArrayList<>();
    private List<Phone> phones = new ArrayList<>();
}


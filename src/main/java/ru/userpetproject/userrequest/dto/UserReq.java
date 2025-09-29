package ru.userpetproject.userrequest.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserReq {

    private String name;
    private List<EmailReq> emails;
    private List<PhoneReq> phones;
}

package ru.userpetproject.userrequest.service;

import ru.userpetproject.userrequest.dto.UserReq;

public interface KafkaService {

    void requestUser(UserReq userReq);
}

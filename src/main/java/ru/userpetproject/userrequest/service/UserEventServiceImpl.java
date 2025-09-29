package ru.userpetproject.userrequest.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.userpetproject.userrequest.dto.EmailReq;
import ru.userpetproject.userrequest.dto.PhoneReq;
import ru.userpetproject.userrequest.dto.UserReq;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserEventServiceImpl implements UserEventService {

private final KafkaService kafkaService;

    @Override
    @Scheduled(fixedRateString = "${configuration.kafka.scheduled}")
    public void sendUserRequest() {
        UserReq userReq = getStubUserRequest();
        kafkaService.requestUser(userReq);
    }

    private UserReq getStubUserRequest() {
        UserReq userReq = new UserReq();
        userReq.setName("Max");
        PhoneReq phone = new PhoneReq();
        phone.setType("work");
        phone.setNumber("+79879879865");
        EmailReq emailReq = new EmailReq();
        emailReq.setAddress("mail@mail.ru");
        userReq.setPhones(Collections.singletonList(phone));
        userReq.setEmails(Collections.singletonList(emailReq));
        return userReq;
    }
}

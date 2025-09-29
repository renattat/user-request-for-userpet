package ru.userpetproject.userrequest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.userpetproject.userrequest.dto.UserReq;
import ru.userpetproject.userrequest.kafka.KafkaProducer;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaServiceImpl implements KafkaService {

    private final KafkaProducer kafkaProducer;
    private final ObjectMapper objectMapper;

    @Value("${configuration.kafka.user-request}")
    private String requestUserTopic;

    @Override
    public void requestUser(UserReq userReq) {
        try {
            String payload = objectMapper.writeValueAsString(userReq);
            kafkaProducer.sendEventToKafka(requestUserTopic, new Random().nextLong(), payload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("ошибка при парсинге в строку: " + userReq);
        }

    }
}

package com.ru.klimash.consumer.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ru.klimash.consumer.dto.FoodOrderDTO;
import com.ru.klimash.consumer.services.FoodOrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    private static final String orderTopic = "t.food.order";
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    private final ObjectMapper objectMappper;
    private final FoodOrderService foodOrderService;

    @Autowired
    public Consumer(ObjectMapper objectMappper, FoodOrderService foodOrderService) {
        this.objectMappper = objectMappper;
        this.foodOrderService = foodOrderService;


    }

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        FoodOrderDTO foodOrderDTO = objectMappper.readValue(message, FoodOrderDTO.class);
        foodOrderService.persistFoodOrder(foodOrderDTO);
    }
}

package com.ru.klimash.consumer.services;

import com.ru.klimash.consumer.dto.FoodOrderDTO;
import com.ru.klimash.consumer.model.FoodOrder;
import com.ru.klimash.consumer.repositories.FoodOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodOrderService {

    private static final Logger log = LoggerFactory.getLogger(FoodOrderService.class);
    private final FoodOrderRepository foodOrderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FoodOrderService(FoodOrderRepository foodOrderRepository, ModelMapper modelMapper) {
        this.foodOrderRepository = foodOrderRepository;
        this.modelMapper = modelMapper;
    }

    public void persistFoodOrder(FoodOrderDTO foodOrderDTO) {
        FoodOrder foodOrder = modelMapper.map(foodOrderDTO, FoodOrder.class);
        FoodOrder persistedFoodOrder = foodOrderRepository.save(foodOrder);

        log.info("food order persisted {}", persistedFoodOrder);
    }
}

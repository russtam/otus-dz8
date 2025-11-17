package ru.rustam.otus.order.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rustam.otus.order.ConvertUtil;
import ru.rustam.otus.order.models.OrderDto;
import ru.rustam.otus.order.service.OrderService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto order) {
        log.debug("createOrder: {}", order);
        var savedEntity = orderService.createOrder(ConvertUtil.convertOrder(order));
        return ResponseEntity.ok(ConvertUtil.convertOrder(savedEntity));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable long orderId) {
        var orderDto = orderService.getOrder(orderId);
        return ResponseEntity.ok(ConvertUtil.convertOrder(orderDto));
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

}

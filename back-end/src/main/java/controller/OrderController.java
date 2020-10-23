package controller;

import dto.OrderRequest;
import dto.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.OrderService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getOrders() {
        List<OrderResponse> orders =orderService.getOrders();
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/orders")
    public ResponseEntity createOrder(@Valid @RequestBody OrderRequest order) {
        orderService.createOrder(order);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity deleteOrderById(@PathVariable Integer orderId) {
        orderService.deleteOrderById(orderId);
        return ResponseEntity.ok().build();
    }
}

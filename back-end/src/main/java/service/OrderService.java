package service;

import dto.OrderResponse;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderResponse> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderResponse::fromEntityToOrderResponse)
                .collect(Collectors.toList());
    }
}

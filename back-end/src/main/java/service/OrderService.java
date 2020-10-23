package service;

import dto.OrderRequest;
import dto.OrderResponse;
import entity.OrderEntity;
import entity.ProductEntity;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.util.List;
import java.util.Optional;
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


    public void createOrder(OrderRequest order) {
        Optional<OrderEntity> orderOptional = orderRepository.findByProductId(order.getProductId());

        if (orderOptional.isPresent()) {
            OrderEntity orderEntity = orderOptional.get();
            orderEntity.setAmount(orderEntity.getAmount() + 1);
            orderRepository.save(orderEntity);
        } else {
            orderRepository.save(OrderEntity.builder()
                    .amount(1)
                    .product(ProductEntity.builder()
                            .id(order.getProductId())
                            .build())
                    .build());
        }
    }
}

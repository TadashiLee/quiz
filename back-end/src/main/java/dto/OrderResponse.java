package dto;

import entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    Integer id;

    Integer amount;

    Product product;

    public static OrderResponse fromEntityToOrderResponse(OrderEntity orderEntity) {
        return OrderResponse.builder()
                .id(orderEntity.getId())
                .amount(orderEntity.getAmount())
                .product(Product.fromEntityToProduct(orderEntity.getProduct()))
                .build();
    }
}

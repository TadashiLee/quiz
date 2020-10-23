package entity;

import dto.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    Double price;

    String unit;

    String image;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    List<OrderEntity> orders;

    public static ProductEntity fromProductToEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .unit(product.getUnit())
                .image(product.getImage())
                .build();
    }
}

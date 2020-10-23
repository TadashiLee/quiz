package dto;

import entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    Integer id;

    @NotNull
    String name;

    @NotNull
    Double price;

    @NotNull
    String unit;

    @NotNull
    String image;

    public static Product fromEntityToProduct(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .unit(productEntity.getUnit())
                .image(productEntity.getImage())
                .build();
    }
}

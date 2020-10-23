package controller;

import dto.OrderRequest;
import entity.OrderEntity;
import entity.ProductEntity;
import javafx.application.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import repository.OrderRepository;
import repository.ProductRepository;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        orderRepository.deleteAll();
    }

    @Test
    void should_get_orders() throws Exception {
        ProductEntity productEntity = productRepository.save(ProductEntity.builder()
                .name("可乐")
                .price(1.00)
                .unit("瓶")
                .image("colar")
                .build());
        orderRepository.save(OrderEntity.builder()
                .amount(2)
                .product(productEntity)
                .build());
        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].amount", is(2)))
                .andExpect(jsonPath("$[0].product.name", is(productEntity.getName())))
                .andExpect(jsonPath("$[0].product.price", is(productEntity.getPrice())))
                .andExpect(jsonPath("$[0].product.unit", is(productEntity.getUnit())))
                .andExpect(jsonPath("$[0].product.image", is(productEntity.getImage())));
    }

    @Test
    void should_save_order() throws Exception {
        ProductEntity productEntity = productRepository.save(ProductEntity.builder()
                .name("可乐")
                .price(1.00)
                .unit("瓶")
                .image("colar")
                .build());
        OrderRequest orderRequest = OrderRequest.builder()
                .productId(productEntity.getId())
                .build();
        mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(orderRequest.toJson()))
                .andExpect(status().isCreated());
        OrderEntity orderEntity = orderRepository.findAll().get(0);
        assertEquals(1, orderEntity.getAmount());
        assertEquals(orderRequest.getProductId(), orderEntity.getProduct().getId());
    }
}

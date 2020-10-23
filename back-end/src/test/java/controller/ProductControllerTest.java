package controller;

import dto.Product;
import entity.ProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
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
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }

    @Test
    void should_get_all_products() throws Exception {
        productRepository.save(ProductEntity.builder()
                .name("可乐")
                .price(1.00)
                .unit("瓶")
                .image("colar")
                .build());
        productRepository.save(ProductEntity.builder()
                .name("雪碧")
                .price(2.50)
                .unit("听")
                .image("spring")
                .build());
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("可乐")))
                .andExpect(jsonPath("$[0].price", is(1.00)))
                .andExpect(jsonPath("$[0].unit", is("瓶")))
                .andExpect(jsonPath("$[0].image", is("colar")))
                .andExpect(jsonPath("$[1].name", is("雪碧")))
                .andExpect(jsonPath("$[1].price", is(2.50)))
                .andExpect(jsonPath("$[1].unit", is("听")))
                .andExpect(jsonPath("$[1].image", is("spring")));
    }

    @Test
    void should_create_product() throws Exception {
        Product product = Product.builder()
                .name("name")
                .price(2.30)
                .unit("unit")
                .image("image")
                .build();
        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(product.toJson()))
                .andExpect(status().isCreated());
        ProductEntity productEntity = productRepository.findAll().get(0);
        assertEquals(product.getName(), productEntity.getName());
        assertEquals(product.getPrice(), productEntity.getPrice());
        assertEquals(product.getUnit(), productEntity.getUnit());
        assertEquals(product.getImage(), productEntity.getImage());
    }

    @Test
    void should_not_create_product_when_name_already_exists() throws Exception {
        productRepository.save(ProductEntity.builder()
                .name("可乐")
                .price(2.30)
                .unit("unit")
                .image("image")
                .build());

        Product product = Product.builder()
                .name("可乐")
                .price(2.30)
                .unit("unit")
                .image("image")
                .build();

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(product.toJson()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("商品已存在，请检查您输入的商品名")));
    }
}

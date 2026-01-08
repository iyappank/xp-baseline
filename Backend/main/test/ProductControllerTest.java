package com.products;

import com.products.ProductsApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ProductsApiApplication.class)
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getProductsOk() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(4))))
                .andExpect(jsonPath("$[0].id", notNullValue()))
                .andExpect(jsonPath("$[0].name", notNullValue()))
                .andExpect(jsonPath("$[0].price", notNullValue()))
                .andExpect(jsonPath("$[0].description", notNullValue()));
    }

    @Test
    void getProductsWithMinPriceFilter() throws Exception {
        mockMvc.perform(get("/products?minPrice=3000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].price", everyItem(greaterThanOrEqualTo(3000.0))));
    }

    @Test
    void getProductsInvalidParam() throws Exception {
        mockMvc.perform(get("/products?minPrice=abc"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", containsString("Invalid value for parameter 'minPrice'")))
                .andExpect(jsonPath("$.status", is(400)));
    }
}
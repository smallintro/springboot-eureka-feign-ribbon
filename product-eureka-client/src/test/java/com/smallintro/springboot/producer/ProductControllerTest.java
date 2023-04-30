package com.smallintro.springboot.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class ProductControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void addProduct_Ok() throws Exception {
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("monitor");
        product.setProductCategory("hardware");
        product.setPrice(25.00);
        byte[] productJson1 = toJson(product);
        product.setProductId(2);
        product.setProductName("Office 365");
        product.setProductCategory("software");
        product.setPrice(50.00);
        byte[] productJson2 = toJson(product);
        mockMvc.perform(post("/create")
                        .content(productJson1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc.perform(post("/create")
                        .content(productJson2)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void retrieve_Ok() throws Exception {
        addProduct_Ok();
        mockMvc.perform(get("/1")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("monitor"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productCategory").value("hardware"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.00));
    }

    @Test
    public void deleteProduct_Ok() throws Exception {
        mockMvc.perform(delete("/delete/1")).andDo(print())
                .andExpect(status().isOk());
    }

    private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }

}
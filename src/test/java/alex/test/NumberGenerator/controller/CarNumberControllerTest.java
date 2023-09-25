package alex.test.NumberGenerator.controller;

import alex.test.NumberGenerator.model.CarNumber;
import alex.test.NumberGenerator.services.NextCarNumberService;
import alex.test.NumberGenerator.services.RandomCarNumberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarNumberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RandomCarNumberService randomService;
    @MockBean
    private NextCarNumberService nextService;

    private CarNumber carNumber;

    @BeforeEach
    void init() {
        carNumber = mock(CarNumber.class);
    }

    @Test
    void testShowCarNumbers() throws Exception {
        mockMvc.perform(get("/number"))
                .andExpect(content().json(objectMapper.writeValueAsString(new ArrayList<>())))
                .andExpect(status().isOk());
    }

    @Test
    void testRandomCarNumber() throws Exception {
        when(randomService.randomCarNumber()).thenReturn(carNumber);
        when(carNumber.toString()).thenReturn("A111AA 116 RUS");
        mockMvc.perform(get("/number/random"))
                .andExpect(content().string("A111AA 116 RUS"))
                .andExpect(status().isOk());
    }

    @Test
    void testNextCarNumber() throws Exception {
        when(nextService.nextCarNumber()).thenReturn(carNumber);
        when(carNumber.toString()).thenReturn("A111AA 116 RUS");
        mockMvc.perform(get("/number/next"))
                .andExpect(content().string("A111AA 116 RUS"))
                .andExpect(status().isOk());
    }
}

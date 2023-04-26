package io.metersphere.project.controller;

import io.metersphere.sdk.util.LogUtils;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProjectApplicationControllerTests {
    @Resource
    private MockMvc mockMvc;

    @Test
    public void testSelectAll() throws Exception {
        LogUtils.info("testSelectAll");
        mockMvc.perform(MockMvcRequestBuilders.get("/project/list-all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.person.name").value("Jason"))
                .andDo(print());
    }

    @Test
    public void testSelectAll2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/project/list-all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.person.name").value("Jason"))
                .andDo(print());
    }
}

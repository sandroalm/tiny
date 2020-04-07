package com.engine.tiny.request;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TicketApi.class)
public class TicketApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService service;

    private static final String CLIENT_URL = "http://verylong.client.url.com";
    public static final Long ID = 12l;

    @Test
    public void shouldReturnATinyUrl() throws Exception {
        final String tinyUrl = "t.co/" + ID;
        when(service.create(CLIENT_URL)).thenReturn(tinyUrl);

        this.mockMvc
                .perform(post("/").content(CLIENT_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(is(tinyUrl)));
    }

    @Test
    public void shouldReturnLongUrl() throws Exception {
        when(service.find(ID)).thenReturn(CLIENT_URL);

        this.mockMvc
                .perform(get("/" + ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(is(CLIENT_URL)));
    }
}

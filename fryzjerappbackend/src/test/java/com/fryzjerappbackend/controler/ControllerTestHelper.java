package com.fryzjerappbackend.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


//klasa zwraca metode do tworzenia post requestow, ktora wykorzystujemy w kontrolerach by nie powtarzac kodu
public class ControllerTestHelper {

    private static final ObjectMapper OM = new ObjectMapper();

    public static ResultActions post(MockMvc mockMvc, String path, Object request) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(OM.writeValueAsString(request)));
    }
}

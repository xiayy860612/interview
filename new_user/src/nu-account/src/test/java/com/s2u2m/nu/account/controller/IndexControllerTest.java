package com.s2u2m.nu.account.controller;

import com.s2u2m.nu.account.base.AbControllerTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
public class IndexControllerTest extends AbControllerTest {

    @Test
    public void index() throws Exception {
        mockMvc.perform(get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andDo(rst -> System.out.println(rst.getResponse().getContentAsString()));
                .andDo(MockMvcRestDocumentation.document("pingpong", preprocessResponse(prettyPrint())));

    }
}
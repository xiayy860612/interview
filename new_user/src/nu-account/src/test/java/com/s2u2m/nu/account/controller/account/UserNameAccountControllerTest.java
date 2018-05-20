package com.s2u2m.nu.account.controller.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.s2u2m.nu.account.base.AbControllerTest;
import com.s2u2m.nu.account.controller.account.dto.LoginInfoDTO;
import com.s2u2m.nu.account.controller.account.dto.UserNameAccountLoginDTO;
import com.s2u2m.nu.account.controller.account.dto.UserNameAccountRegDTO;
import com.s2u2m.nu.account.dao.UserNameAccountDAO;
import com.s2u2m.nu.account.entity.UserEntity;
import com.s2u2m.nu.account.entity.UserNameAccountEntity;
import com.s2u2m.nu.account.enums.GenderEnum;
import com.s2u2m.nu.account.service.UserNameAccountService;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.web.servlet.MvcResult;

import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * class UserNameAccountControllerTest
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
public class UserNameAccountControllerTest extends AbControllerTest {

    @MockBean
    private UserNameAccountService accountService;

    @Test
    public void reg() throws Exception {
        String nickName = "test12345";
        String password = "test@123456";
        String id = "123456";
        GenderEnum gender = GenderEnum.Female;

        UserEntity exp = new UserEntity()
                .setId(id).setNickName(nickName)
                .setGender(gender);
        doReturn(exp).when(accountService).reg(any(UserNameAccountRegDTO.class));

        UserNameAccountRegDTO regDTO = new UserNameAccountRegDTO()
                .setUserName(nickName).setPassword(password)
                .setGender(gender);

        ObjectMapper mapper = new ObjectMapper();
        MvcResult rst = mockMvc.perform(post("/account/username/reg")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(regDTO)))
                .andExpect(status().isOk())
                .andDo(document("UserNameAccountReg", preprocessResponse(prettyPrint())))
                .andReturn();

        LoginInfoDTO infoDTO = this.convertResponseToObject(rst, LoginInfoDTO.class);
        String expToken = exp.getId();
        assertEquals(expToken, infoDTO.getToken());
    }

    @Test
    public void login() throws Exception {
        String id = "123456";
        UserEntity exp = new UserEntity().setId(id);
        doReturn(exp).when(accountService).login(any(UserNameAccountLoginDTO.class));

        UserNameAccountEntity accountEntity = new UserNameAccountEntity()
                .setUserId(id);

        UserNameAccountLoginDTO dto = new UserNameAccountLoginDTO()
                .setUserName("test").setPassword("123456");

        ObjectMapper mapper = new ObjectMapper();
        MvcResult rst = mockMvc.perform(post("/account/username/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andDo(document("UserNameAccountLogin", preprocessResponse(prettyPrint())))
                .andReturn();

        LoginInfoDTO infoDTO = this.convertResponseToObject(rst, LoginInfoDTO.class);
        String expToken = exp.getId();
        assertEquals(expToken, infoDTO.getToken());
    }
}

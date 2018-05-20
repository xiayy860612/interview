package com.s2u2m.nu.account.controller.user;

import com.s2u2m.nu.account.base.AbControllerTest;
import com.s2u2m.nu.account.entity.UserEntity;
import com.s2u2m.nu.account.enums.GenderEnum;
import com.s2u2m.nu.account.service.UserService;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.time.Instant;
import java.util.Date;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * class UserControllerTest
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
public class UserControllerTest extends AbControllerTest {

    @MockBean
    private UserService userService;

    @Test
    public void getUserInfo() throws Exception {
        String id = "123456";
        String nickName = "test";
        GenderEnum gender = GenderEnum.Unknown;
        Date birthday = Date.from(Instant.now());

        UserEntity entity = new UserEntity()
                .setId(id)
                .setNickName(nickName)
                .setGender(gender)
                .setBirthday(birthday);
        doReturn(entity).when(userService).get(anyString());

        mockMvc.perform(get("/user/")
                .header("token", "asdfsafd")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("getUserInfo"));
    }
}

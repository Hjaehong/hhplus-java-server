package kr.hhplus.be.server.layer.balance.controller;

import kr.hhplus.be.server.layer.balance.controller.BalanceController;
import kr.hhplus.be.server.layer.balance.service.BlanceService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BalanceController.class)
public class BalanceControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean // Spring Context에 BalanceService의 Mock 객체를 주입합니다.
    private BlanceService blanceService;

    // 임시 유저 아이디
    private String userId = "user-test-uuid-001";

    @Test
    @DisplayName("GET /api/v1/users/{userId}/balance - 사용자 잔액 조회 성공")
    public void getBalance_success() throws Exception {

        mockMvc.perform(get("/api/v1/users/{userId}/balance", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(userId)) // JSON 응답의 userId 필드 검증
                .andExpect(jsonPath("$.balance").value(15000));


    }

}
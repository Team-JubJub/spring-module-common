package com.zupzup.untact.dto.auth.token.customer;

import com.zupzup.untact.dto.auth.customer.UserDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "Response body에 실을 토큰(액세스, 리프레시) 정보를 담은 DTO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerTokenInfoDto {

    @Schema(description = "요청 처리 결과", example = "success")
    private String result;
    @Schema(description = "요청 처리 결과에 대한 메세지", example = "Create user success(회원가입 시), Token refreshed(재로그인 시)")
    private String message;
    @Schema(description = "액세스 토큰")
    private String accessToken;
    @Schema(description = "리프레시 토큰")
    private String refreshToken;

    @Schema(description = "유저의 정보", implementation = UserDto.class)
    private UserDto userDto;

}

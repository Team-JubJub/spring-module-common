package com.zupzup.untact.dto.auth.customer.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "애플의 client-secret을 담은 DTO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppleClientSecretDto {

    @Schema(description = "애플 회원탈퇴에 필요한 client secret(jwt)", example = "jwt token")
    private String clientSecret;

}

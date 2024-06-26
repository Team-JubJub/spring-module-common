package com.zupzup.untact.dto.auth.token.seller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "액세스 토큰 갱신 요청의 결과와 정보를 담은 DTO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SellerRefreshResultDto {

    @Schema(description = "요청 처리 결과", example = "success")
    private String result;
    @Schema(description = "요청 처리 결과에 대한 메세지", example = "Access token refreshed(액세스 토큰 갱신 성공)")
    private String message;
    @Schema(description = "갱신된 액세스 토큰")
    private String accessToken;
    @Schema(description = "사장님의 로그인 ID", example = "test123")
    private String loginId;

}

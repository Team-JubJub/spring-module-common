package com.zupzup.untact.dto.auth.customer.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.nio.charset.Charset;

@Schema(description = "회원가입 요청 시 사용되는 DTO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserSignUpDto {

    @Schema(description = "소셜 플랫폼에서 받아온 유저의 unique ID", example = "im1from2naver3")
    @NotBlank(message = "User unique id cannot be null or empty or space")
    private String userUniqueId;
    @Schema(description = "소셜 플랫폼에서 받아온 유저의 실명", example = "위대한")
    @NotBlank(message = "User name cannot be null or empty or space")
    private String userName;
    @Schema(description = "줍줍에 회원가입 시 입력한 유저의 닉네임(특수문자, 공백 불가, 12bytes(한:2bytes, 영어&숫자: 1byte) 제한)", example = "S2줍줍화이팅")
    @NotBlank(message = "Nickname cannot be null or empty or space")
    private String nickName;
    @Schema(description = "성별", allowableValues = {"male", "female"})
    @NotNull(message = "Gender cannot be null")
    private String gender;
    @Schema(description = "010-xxxx-xxxx 포맷의 인증 완료된 전화번호", example = "010-1234-5678")
    @Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "Phone number pattern should be like 010-xxxx-xxxx")
    private String phoneNumber;
    @Schema(description = "필수 약관들의 동의 여부", allowableValues = {"true", "false"})
    @NotNull(message = "Answer for essential terms cannot be null")
    private Boolean essentialTerms;
    @Schema(description = "선택 약관 1의 동의 여부", allowableValues = {"true", "false"})
    @NotNull(message = "Answer for optional terms cannot be null")
    private Boolean optionalTerm1;

    @Schema(description = "푸시 알림을 위한 device token")
    private String deviceToken;

    @AssertTrue(message = "Nickname should be in range 4bytes to 12bytes")
    private boolean isNickNameValid() {
        int bytes = getNickName().getBytes(Charset.forName("EUC-KR")).length;
        if (bytes < 4 || bytes > 12) return false;

        return true;
    }

}
package com.zupzup.untact.dto.auth.seller;

import com.zupzup.untact.model.enums.auth.Role;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class SellerDto {

    private Long sellerId;
    private String loginId;
    private String loginPwd;

    private String name;
    private String phoneNumber;
    private String email;

    private Role role;
}

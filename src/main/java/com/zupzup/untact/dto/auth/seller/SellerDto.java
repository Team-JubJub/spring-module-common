package com.zupzup.untact.dto.auth.seller;

import com.zupzup.untact.domain.auth.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SellerDto {

    private Long sellerId;
    private String loginId;
    private String loginPwd;

    private Role role;
}

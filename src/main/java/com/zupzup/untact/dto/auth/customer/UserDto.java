package com.zupzup.untact.dto.auth.customer;


import com.zupzup.untact.domain.auth.Role;
import com.zupzup.untact.domain.auth.User.Provider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long userId;
    private Provider provider;
    private String providerUserId;  // ex) NAVER_userID
    private String userName;
    private String nickName;
    private String gender;
    private String phoneNumber;
    private Role role;
    private Boolean essentialTerms;
    private Boolean optionalTerm1;
    private String registerTime;
    private int orderCount;

}

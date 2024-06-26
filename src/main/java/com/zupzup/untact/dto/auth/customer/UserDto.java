package com.zupzup.untact.dto.auth.customer;


import com.zupzup.untact.model.enums.auth.Role;
import com.zupzup.untact.model.enums.auth.Provider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

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

    private Set<Long> starredStores;
    private Set<Long> alertStores;

    private Boolean essentialTerms;
    private Boolean optionalTerm1;
    private String registerTime;
    private int orderCount;

    private String deviceToken;

    private Role role;

}

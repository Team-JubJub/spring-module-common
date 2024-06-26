package com.zupzup.untact.model.domain.auth.user;

import com.zupzup.untact.model.BaseEntity;
import com.zupzup.untact.model.enums.auth.Provider;
import com.zupzup.untact.model.enums.auth.Role;
import com.zupzup.untact.dto.auth.customer.UserDto;
import com.zupzup.untact.dto.info.customer.request.PatchNickNameDto;
import com.zupzup.untact.dto.info.customer.request.PatchOptionalTermDto;
import com.zupzup.untact.dto.info.customer.request.PatchPhoneNumberDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Where;

import java.util.Set;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
//@Builder(builderMethodName = "UserBuilder")
@SuperBuilder
@Where(clause = "is_deleted = 0")
@Table(name = "users")   // 나중에 customer, seller 구분해서 만들지 고민할 것
public class User extends BaseEntity {

//    @Id
//    @Column(name = "userId")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long userId;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Provider provider;  // 가입 시 사용한 플랫폼
    @Column(nullable = false) private String providerUserId;  // ex) KAKAO_user123
    @Column(nullable = false) private String userName;    // 유저의 실명
    @Column(nullable = false) private String nickName;  // 닉네임
    @Column(nullable = false) private String gender;    // 성별
    @Column(nullable = false) private String phoneNumber;   // 유저의 연락처


    @ElementCollection
    @CollectionTable(name = "starredStores", joinColumns = @JoinColumn(name="userId", referencedColumnName="id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Long> starredStores;    // 찜한 가게 아이디들
    @ElementCollection
    @CollectionTable(name = "alertStores", joinColumns = @JoinColumn(name="userId", referencedColumnName="id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Long> alertStores;    // 알림 설정한 가게 아이디들

    @Column(nullable = false) private Boolean essentialTerms;   // 필수 약관 동의 여부
    @Column(nullable = false) private Boolean optionalTerm1;    // 선택 약관1 동의 여부
    @Column(nullable = false) private String registerTime;  // 가입 시간(LocalDateTime, 현재는 KST 기준)
    @Column(nullable = false) private int orderCount;   // 주문 횟수(바로바로 수 계산이 가능하게끔 primitive type으로)

    private String deviceToken; //  푸시 알림을 위한 디바이스 토큰

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;  // 유저 권한

//    public static UserBuilder builder(String providerUserId) {  // 현재 필수 파라미터는 임시
//        if(providerUserId.equals(null)) {
//            throw new IllegalArgumentException("필수 파라미터(providerUserId) 누락");
//        }
//        return UserBuilder().providerUserId(providerUserId);
//    }

    public void updateOrderCount() {
        this.orderCount += 1;
    }

    public void updatePhoneNumber(PatchPhoneNumberDto patchPhoneNumberDto) {
        this.phoneNumber = patchPhoneNumberDto.getPhoneNumber();
    }

    public void updateNickName(PatchNickNameDto patchNickNameDto) {
        this.nickName = patchNickNameDto.getNickName();
    }

    public void updateOptionalTerm1(PatchOptionalTermDto patchOptionalTermDto) {
        this.optionalTerm1 = patchOptionalTermDto.getOptionalTerm1();
    }

    public void updateStarredStoreList(UserDto userDto) {
        this.starredStores = userDto.getStarredStores();
        this.alertStores = userDto.getAlertStores();
    }

    public void updateDeviceToken(UserDto userDto) {
        this.deviceToken = userDto.getDeviceToken();
    }

    public void updateAlertStoreList(UserDto userDto) {
        this.alertStores  = userDto.getAlertStores();
    }

}
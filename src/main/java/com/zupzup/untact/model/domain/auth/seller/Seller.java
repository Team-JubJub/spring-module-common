package com.zupzup.untact.model.domain.auth.seller;

import com.zupzup.untact.model.BaseEntity;
import com.zupzup.untact.model.enums.auth.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;

@Entity
@Setter @Getter
@Table(name = "seller")
@NoArgsConstructor
//@Builder(builderMethodName = "SellerBuilder")
@SuperBuilder
@Where(clause = "is_deleted = 0")
public class Seller extends BaseEntity {

//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long sellerId;

    @Column(nullable = false)
    private String loginId;
    @Column(nullable = false)
    private String loginPwd;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;  // 사장님의 앱 권한 -> 우선 ROLE_SELLER로 통일

    @Column(nullable = false)
    private Boolean wantDeletion; // 삭제 요청 여부

//    public SellerBuilder builder(String loginId) {
//        if (loginId.equals(null)) {
//            throw new IllegalArgumentException("필수 파라미터(loginId) 누락");
//        }
//        return SellerBuilder().sellerId(sellerId);
//    }
    
}

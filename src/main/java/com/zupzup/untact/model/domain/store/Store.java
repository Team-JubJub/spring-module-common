package com.zupzup.untact.model.domain.store;

import com.zupzup.untact.model.BaseEntity;
import com.zupzup.untact.model.enums.EnterState;
import com.zupzup.untact.model.enums.StoreCategory;
import com.zupzup.untact.dto.store.StoreDto;
import com.zupzup.untact.dto.store.seller.request.ModifyStoreDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Where;

import java.util.Set;

@Entity
@Table(name = "stores")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
//@Builder(builderMethodName = "StoreBuilder")
@Getter @Setter
@SuperBuilder
@Where(clause = "is_deleted = 0")
public class Store extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "storeId")
//    @Getter
//    private Long storeId;

    @JoinColumn(name = "seller")
    private Long sellerId;

    @Column(nullable = false)
    private String storeName; // 가게이름
    @Column(nullable = false)
    private String storeImageUrl; // 가게 대표 이미지 url - 이미지 없을 시 기본이미지
    @Column(nullable = false, length = 1000)
    private String storeAddress; // 가게 주소
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private StoreCategory category; // 카테고리
    @Column(nullable = false)
    private String sellerName; // 대표자 이름
    @Column(nullable = false)
    private String sellerContact; // 대표자 연락처
    @Column(nullable = false)
    private String storeContact; // 가게 연락처

    @Column(nullable = false)
    private Double longitude;   // 경도
    @Column(nullable = false)
    private Double latitude;    // 위도
    @Column(nullable = false)
    private String openTime; // 운영 시작 시간
    @Column(nullable = false)
    private String closeTime; // 운영 마감 시간
    @Column(nullable = false)
    private String saleTimeStart;   // 할인 시작 시간
    @Column(nullable = false)
    private String saleTimeEnd; // 할인 마감 시간
    @Column(nullable = false)
    private String saleMatters; // 공지사항
    @Column(nullable = false)
    private String promotion; // 공지와 별개의 프로모션

    @Column(nullable = false)
    private Boolean isOpen; // 가게 운영 여부
    @Column(nullable = false)
    private String closedDay; // 휴무일

    @Column(length = 300)
    private String reviewAnnouncement; // 리뷰 공지
    @Column(nullable = false)
    private int reviewCount;    // 리뷰 수
    @Column(nullable = false)
    private float starRate;   // 별점

    @ElementCollection
    @CollectionTable(name = "starredUsers", joinColumns = @JoinColumn(name="storeId", referencedColumnName="id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Long> starredUsers;    // 찜한 유저 아이디들 -> 사용자 앱에서 찜 설정 시 조작됨
    @ElementCollection
    @CollectionTable(name = "alertUsers", joinColumns = @JoinColumn(name="storeId", referencedColumnName="id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Long> alertUsers;    // 알림 설정한 유저 아이디들 -> 사용자 앱에서 알림 설정 시 조작됨

    @ElementCollection
    @CollectionTable(name = "deviceTokens", joinColumns = @JoinColumn(name="storeId", referencedColumnName="id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<String> deviceTokens;    // 푸시 알림을 받을 사장님들의 FCM 디바이스 토큰, 아이디 비번 로그인 시 저장

    @Column(nullable = false)
    private String crNumber;    // 사업자 등록번호

    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private EnterState enterState;  // 등록 상태(NEW, WAIT, CONFIRM)

    private String waitStatusTimestamp;  // NEW -> WAIT (CONFIRM -> WAIT) 으로 변경된 시간
    private String confirmStatusTimestamp;   // WAIT -> CONFIRM 으로 변경된 시간
    private String deleteStatusTimestamp;   // CONFIRM -> DELETE 으로 변경된 시간

//    public static StoreBuilder builder(String storeName) {   // 필수 파라미터 고려해볼 것
//        if(storeName == null) {
//            throw new IllegalArgumentException("필수 파라미터(store name) 누락");
//        }
//        return StoreBuilder().storeName(storeName);
//    }

    // 가게 deviceTokens를 업데이트하는 로직
    public void modifyDeviceTokens(Set<String> deviceTokens) {
        this.deviceTokens = deviceTokens;
    }

    // 가게 데이터를 업데이트하는 로직
    public void modifyStore(ModifyStoreDto modifyStoreDto) {
        this.storeImageUrl = modifyStoreDto.getStoreImageUrl();
        this.openTime = modifyStoreDto.getOpenTime();
        this.closeTime = modifyStoreDto.getCloseTime();
        this.saleTimeStart = modifyStoreDto.getSaleTimeStart();
        this.saleTimeEnd = modifyStoreDto.getSaleTimeEnd();
        this.closedDay = modifyStoreDto.getClosedDay();
    }

    public void updateStarredUserList(StoreDto storeDto) {
        this.starredUsers = storeDto.getStarredUsers();
        this.alertUsers = storeDto.getAlertUsers();
    }

    public void updateAlertUserList(StoreDto storeDto) {
        this.alertUsers = storeDto.getAlertUsers();
    }

    public void updateDeviceTokens(StoreDto storeDto) { this.deviceTokens = storeDto.getDeviceTokens(); }

    // 리뷰 개수 관련 method
    public void addReviewCount() {
        this.reviewCount++;
    }

    public void subtractReviewCount() {
        this.reviewCount--;
    }

    public void calculateStarRate(int reviewCount, float newStarRate) {
        this.starRate = (this.starRate * reviewCount + newStarRate) / reviewCount;
    }
}
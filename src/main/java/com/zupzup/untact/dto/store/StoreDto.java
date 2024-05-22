package com.zupzup.untact.dto.store;

import com.zupzup.untact.model.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter @Setter
public class StoreDto {

    private Long storeId;

    private String storeName; //가게이름
    private String storeImageUrl;
    private String storeAddress; //가게 주소
    private String category;
    private String sellerName;
    private String sellerContact;
    private String storeContact;

    private Double longitude;
    private Double latitude;
    private String openTime;
    private String closeTime;
    private String saleTimeStart;
    private String saleTimeEnd;
    private String saleMatters;
    private String promotion;

    private Boolean isOpen;
    private String closedDay;
    private String reviewAnnouncement;

    private Set<Long> starredUsers;
    private Set<Long> alertUsers;

    private String crNumber;

    private Set<String> deviceTokens;

    private List<Item> storeItems;

}
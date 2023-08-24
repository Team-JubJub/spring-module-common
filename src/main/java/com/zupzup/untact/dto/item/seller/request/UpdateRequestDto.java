package com.zupzup.untact.dto.item.seller.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateRequestDto {

    private String itemName;
    private String imageURL;
    private int itemPrice;
    private int salePrice;
    private int itemCount;
}

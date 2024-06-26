package com.zupzup.untact.dto.item.seller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetDto {

    private Long itemId;
    private String itemName;
    private String imageURL;
    private int itemPrice;
    private int salePrice;
    private int itemCount;

}

package com.zupzup.untact.dto.item.seller.response;

import com.zupzup.untact.model.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ItemResponseDto {

    private Long id;
    private String itemName;
    private String imageURL;
    private int itemPrice;
    private int salePrice;
    private int itemCount;
    //private Long storeId;

    public ItemResponseDto toItemResponseDto(Item item) {

        this.id = item.getId();
        this.itemName = item.getItemName();
        this.imageURL = item.getImageURL();
        this.itemPrice = item.getItemPrice();
        this.salePrice = item.getSalePrice();
        this.itemCount = item.getItemCount();
        //this.storeId = item.getStore().getStoreId();

        return this;
    }
}

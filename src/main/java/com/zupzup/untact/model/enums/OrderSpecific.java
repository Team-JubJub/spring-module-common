package com.zupzup.untact.model.enums;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class OrderSpecific {
    //[상품 이름, 가격, 갯수, (이미지)]
    private Long itemId; // 일단 단순 Long으로 받아오고, 외래키로 갈지 말지는 나중에
    private String itemName;    // 상품 이름
    private String imageUrl;    // 상품 이미지 url
    private Integer itemPrice;  // 상품의 원래 가격
    private Integer salePrice;  // 상품의 할인 가격
    @Min(value = 0, message = "상품의 개수는 0개 미만일 수 없습니다.")
    private Integer itemCount;  // 갯수

}

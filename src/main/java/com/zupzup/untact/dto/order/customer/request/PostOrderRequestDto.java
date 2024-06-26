package com.zupzup.untact.dto.order.customer.request;

import com.zupzup.untact.model.enums.OrderSpecific;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostOrderRequestDto {

    @Schema(example = "yyyy-MM-dd HH:mm, 24h 포맷( ex) 2023-09-28 19:30 )")
    private String visitTime;
    @Schema(implementation = OrderSpecific.class)
    private List<OrderSpecific> orderList; // 주문 품목 이름, 가격, 개수

}
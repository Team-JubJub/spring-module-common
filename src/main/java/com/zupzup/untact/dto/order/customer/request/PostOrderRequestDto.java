package com.zupzup.untact.dto.order.customer.request;

import com.zupzup.untact.domain.order.type.OrderSpecific;
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

    private String visitTime;
    private List<OrderSpecific> orderList; // 주문 품목 이름, 가격, 개수

}
package com.zupzup.untact.dto.order.customer.response;

import com.zupzup.untact.domain.order.type.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetOrderDto {

    private Long orderId;
    private Long storeId;
    private Long userId;

    private OrderStatus orderStatus;
    private String orderTitle;
    private String storeName;
    private String category;

    private Integer totalPrice;

}

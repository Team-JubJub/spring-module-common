package com.zupzup.untact.model.dto.order.customer.response;

import com.zupzup.untact.model.domain.order.type.OrderStatus;
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
    private String orderTime;
    private String visitTime;
    private String storeName;
    private String category;

    private Integer totalPrice;

}

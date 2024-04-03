package com.zupzup.untact.model.domain.order.type;

public enum OrderStatus {

    // 확정(부분), 취소(반려), 완료, 신규
    CONFIRM("주문 확정"),
    CANCEL("주문 취소"),
    COMPLETE("주문 완료"),
    NEW("신규 주문"),
    WITHDREW("탈퇴한 회원 주문");  // withdraw의 과거형

    private final String status;

    OrderStatus(String status) { this.status = status; }

    public String getStatus() { return status; }
}

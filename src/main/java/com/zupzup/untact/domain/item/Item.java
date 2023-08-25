package com.zupzup.untact.domain.item;

import com.zupzup.untact.domain.store.Store;
import com.zupzup.untact.dto.item.seller.request.UpdateRequestDto;
import com.zupzup.untact.dto.item.seller.response.GetDtoWithStore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@NoArgsConstructor
@Table(name = "items")
public class Item {

        @Id
        @Column(name = "itemId")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long itemId;    // auto increment id
        @Column(nullable = false, length = 20)
        private String itemName; // 상품명
        private String imageURL; // 상품 이미지
        @Column(nullable = false)
        private int itemPrice; // 상품 가격 -> 변경(사칙연산을 통한)이 가능할 수도 있어서 primitive type
        private int salePrice; // 할인된 가격 -> 변경(사칙연산을 통한)이 가능할 수도 있어서 primitive type
        private int itemCount; // 제품 개수 -> 변경(사칙연산을 통한)이 있울 거라 primitive type
        @ManyToOne(optional = false) @JoinColumn(name = "storeId")
        private Store store; // store (relation with store)

    // 상품 데이터를 업데이트 하는 로직
        public void updateItem(UpdateRequestDto itemDto) {

            this.itemName = itemDto.getItemName();
            this.imageURL = itemDto.getImageURL();
            this.itemPrice = itemDto.getItemPrice();
            this.salePrice = itemDto.getSalePrice();
            this.itemCount = itemDto.getItemCount();
        }

        public void saveItem(GetDtoWithStore itemDto) {

            this.itemName = itemDto.getItemName();
            this.imageURL = itemDto.getImageURL();
            this.itemPrice = itemDto.getItemPrice();
            this.salePrice = itemDto.getSalePrice();
            this.itemCount = itemDto.getItemCount();
            this.store = itemDto.getStore();
        }

    // 상품 개수 변경(사장님이 예약 확정, 완료 시)
        public void updateItemCount(GetDtoWithStore itemDto) {
            this.itemCount = itemDto.getItemCount();
        }

}

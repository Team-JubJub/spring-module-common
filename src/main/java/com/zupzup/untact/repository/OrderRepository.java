package com.zupzup.untact.repository;

import domain.order.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStoreId(Long storeId);  //해당 store Id를 참조하는 Order의 list -> 수정하기(Join column 설정해줬으니 findByStoreId로)

}
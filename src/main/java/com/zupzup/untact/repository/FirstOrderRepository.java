package com.zupzup.untact.repository;

import com.zupzup.untact.domain.data.FirstOrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstOrderRepository extends JpaRepository<FirstOrderData, Long> {
}

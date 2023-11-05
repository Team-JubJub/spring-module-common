package com.zupzup.untact.repository;

import com.zupzup.untact.domain.auth.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    Seller findSellerByLoginId(String loginId);

}

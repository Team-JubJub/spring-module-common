package com.zupzup.untact.repository;

import com.zupzup.untact.model.domain.auth.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByProviderUserId(String providerUserId); //isPresent() 사용 위해 Optional<> 타입으로 선언
    Optional<User> findByNickName(String nickName);
    Optional<User> findByPhoneNumber(String phoneNumber);
    List<User> findByStarredStoresContains(Long storeId);
    List<User> findByAlertStoresContains(Long storeId);
}

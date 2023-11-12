package com.zupzup.untact.domain.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "firstOrderDataBuilder")
@Table(name = "firstOrderData")
public class FirstOrderData {

    @Id
    @Column(name = "firstOrderDataId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long firstOrderDataId;    // auto increment id

    @Column(nullable = false) private String registerTime;
    @Column(nullable = false) private String firstOrderTime;

    public static FirstOrderDataBuilder builder(String firstOrderTime) {
        if (firstOrderTime == null) throw new IllegalArgumentException("필수 파라미터(first order time) 누락");

        return firstOrderDataBuilder().firstOrderTime(firstOrderTime);
    }

}

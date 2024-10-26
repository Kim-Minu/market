package com.api.market.domain.product.domain;

import com.api.market.domain.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private int price;

  @Enumerated(value = EnumType.STRING)
  private ProductSalesStatus productSalesStatus;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id", nullable = false)
  private Member seller;

  @CreatedDate
  @Column(nullable = false)
  private LocalDateTime createdAt;

}

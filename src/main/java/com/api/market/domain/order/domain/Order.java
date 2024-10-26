package com.api.market.domain.order.domain;

import com.api.market.domain.member.domain.Member;
import com.api.market.domain.product.domain.Product;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  private String productName;

  private int productPrice;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member buyer;

  @CreatedDate
  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Builder
  public Order(Product product, String productName, int productPrice, Member buyer) {
    this.product = product;
    this.productName = productName;
    this.productPrice = productPrice;
    this.buyer = buyer;
    this.createdAt = LocalDateTime.now();
  }

}

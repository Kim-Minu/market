package com.api.market.domain.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductSalesStatus {
  SALE("판매중"),
  RESERVATION("에약중"),
  COMPLETION("완료");

  private final String desc;

}

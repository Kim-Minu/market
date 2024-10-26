package com.api.market.domain.product.dto;

import com.api.market.domain.member.domain.Member;
import com.api.market.domain.product.domain.Product;
import com.api.market.domain.product.domain.ProductSalesStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProductCreateRequestDto {

  private String name;
  private int price;

  public Product toEntity(Member seller) {
        return Product.builder()
            .price(this.price)
            .name(this.name)
            .seller(seller)
            .productSalesStatus(ProductSalesStatus.SALE)
            .build();
    }


}

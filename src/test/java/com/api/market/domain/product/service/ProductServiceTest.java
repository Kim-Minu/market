package com.api.market.domain.product.service;

import com.api.market.domain.member.domain.Member;
import com.api.market.domain.member.domain.MemberRepository;
import com.api.market.domain.product.domain.Product;
import com.api.market.domain.product.domain.ProductRepository;
import com.api.market.domain.product.dto.ProductCreateRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Profile(value = "local")
public class ProductServiceTest {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private MemberRepository memberRepository;


  @Test
  void 상품_등록() {

    Member member = memberRepository.save(
        Member.builder()
        .name("판매자1")
        .build()
    );

    ProductCreateRequestDto requestDto = ProductCreateRequestDto
        .builder()
        .price(10000)
        .name("기프티콘")
        .build();

    Product newProduct = productRepository.save(requestDto.toEntity(member));

    assertThat(newProduct.getId()).isNotNull();
    assertThat(newProduct.getSeller().getId()).isEqualTo(member.getId());

  }

}

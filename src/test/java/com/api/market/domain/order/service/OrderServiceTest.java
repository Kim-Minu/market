package com.api.market.domain.order.service;

import com.api.market.domain.member.domain.Member;
import com.api.market.domain.member.domain.MemberRepository;
import com.api.market.domain.order.domain.Order;
import com.api.market.domain.order.domain.OrderRepository;
import com.api.market.domain.product.domain.Product;
import com.api.market.domain.product.domain.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
@Profile(value = "local")
public class OrderServiceTest {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private MemberRepository memberRepository;


  @Test
  void 구매하기() {

    Long memberId = 1L;
    Long productId = 1L;

    Member member = memberRepository.findById(memberId).orElseThrow(IllegalArgumentException::new);

    Product product = productRepository.findById(productId).orElseThrow(IllegalArgumentException::new);

    Order order = Order
        .builder()
        .product(product)
        .productName(product.getName())
        .productPrice(product.getPrice())
        .buyer(member)
        .build();

    orderRepository.save(order);



  }


}

package com.api.market.domain.member.domain;

import com.api.market.test.RepositoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest extends RepositoryTest {

  @Autowired
  private MemberRepository memberRepository;

  private Member saveMember;
  private String email;
  private String name;

  @BeforeEach
  public void setUp() throws Exception {

    email = "test1@gmail.com";
    name = "홍길동";

    saveMember = memberRepository.save(
        Member.builder()
            .email(email)
            .name(name)
            .build()
    );

  }


  @Test
  void 회원_조회() {

    Member member = memberRepository.findById(saveMember.getId())
        .orElseThrow(() -> new IllegalArgumentException("member를 찾지 못했습니다."));

    assertThat(member.getEmail()).isEqualTo(email);
    assertThat(member.getName()).isEqualTo(name);
    assertThat(member.getId()).isEqualTo(saveMember.getId());

  }

  @Test
  public void existsByEmail_존재하는경우_true() {
    final boolean existsByEmail = memberRepository.existsByEmail(email);

    assertThat(existsByEmail).isTrue();
  }

  @Test
  public void existsByEmail_존재하지않은_경우_false() {

    String email = "ehdgoanfrhkqortntksdls@asd.com";

    final boolean existsByEmail = memberRepository.existsByEmail(email);

    assertThat(existsByEmail).isFalse();

  }


}
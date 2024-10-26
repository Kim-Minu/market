package com.api.market.domain.member.exception;

import com.api.market.global.exception.EntityNotFoundException;

public class MemberNotFoundException extends EntityNotFoundException {

    public MemberNotFoundException(Long target) {
        super(target + " is not found");
    }

    public MemberNotFoundException(String email) {
        super(email + " is not found");
    }
}

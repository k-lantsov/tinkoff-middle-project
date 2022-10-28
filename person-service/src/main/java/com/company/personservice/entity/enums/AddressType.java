package com.company.personservice.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AddressType {
    REGISTRATION(1), ACTUAL(2);

    private final int code;
}

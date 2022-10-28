package com.company.personservice.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ContactType {
    PHONE_NUMBER(1), EMAIL(2);

    private final int code;
}

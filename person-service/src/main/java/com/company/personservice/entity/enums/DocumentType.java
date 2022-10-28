package com.company.personservice.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DocumentType {
    PASSPORT(1), DRIVER_LICENSE(2);

    private final int code;
}

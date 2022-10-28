package com.company.personservice.entity.converter;

import com.company.personservice.entity.enums.AddressType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class AddressTypeConverter implements AttributeConverter<AddressType, Integer> {


    @Override
    public Integer convertToDatabaseColumn(AddressType addressType) {
        if (addressType == null) {
            return null;
        }
        return addressType.getCode();
    }

    @Override
    public AddressType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return Stream.of(AddressType.values())
                .filter(addressType -> addressType.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

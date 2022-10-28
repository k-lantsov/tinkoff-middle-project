package com.company.personservice.entity.converter;

import com.company.personservice.entity.enums.AddressType;
import com.company.personservice.entity.enums.ContactType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ContactTypeConverter implements AttributeConverter<ContactType, Integer> {


    @Override
    public Integer convertToDatabaseColumn(ContactType contactType) {
        if (contactType == null) {
            return null;
        }
        return contactType.getCode();
    }

    @Override
    public ContactType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return Stream.of(ContactType.values())
                .filter(contactType -> contactType.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

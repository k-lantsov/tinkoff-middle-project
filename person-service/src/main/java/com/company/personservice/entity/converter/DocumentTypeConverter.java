package com.company.personservice.entity.converter;

import com.company.personservice.entity.enums.DocumentType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class DocumentTypeConverter implements AttributeConverter<DocumentType, Integer> {


    @Override
    public Integer convertToDatabaseColumn(DocumentType documentType) {
        if (documentType == null) {
            return null;
        }
        return documentType.getCode();
    }

    @Override
    public DocumentType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return Stream.of(DocumentType.values())
                .filter(documentType -> documentType.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

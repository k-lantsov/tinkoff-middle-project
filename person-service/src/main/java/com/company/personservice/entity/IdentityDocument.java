package com.company.personservice.entity;

import com.company.personservice.entity.converter.DocumentTypeConverter;
import com.company.personservice.entity.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "identity_document")
public class IdentityDocument extends ParentEntity{

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "document_type")
    @Convert(converter = DocumentTypeConverter.class)
    private DocumentType documentType;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
}

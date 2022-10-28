package com.company.personservice.entity;

import com.company.personservice.entity.converter.ContactTypeConverter;
import com.company.personservice.entity.enums.ContactType;
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
@Table(name = "contact")
public class Contact extends ParentEntity{

    @Column(name = "contact_type")
    @Convert(converter = ContactTypeConverter.class)
    private ContactType contactType;

    @Column(name = "contact_value")
    private String contactValue;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}

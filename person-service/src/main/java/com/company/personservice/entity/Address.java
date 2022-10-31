package com.company.personservice.entity;

import com.company.personservice.entity.converter.AddressTypeConverter;
import com.company.personservice.entity.enums.AddressType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address")
public class Address extends ParentEntity{

    @Column(name = "country")
    private String country;

    @Column(name = "locality")
    private String locality;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private int houseNumber;

    @Column(name = "apartments_number")
    private int apartmentsNumber;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "address_type")
    @Convert(converter = AddressTypeConverter.class)
    private AddressType addressType;

    @ManyToMany(mappedBy = "addresses")
    private Set<Person> persons;
}

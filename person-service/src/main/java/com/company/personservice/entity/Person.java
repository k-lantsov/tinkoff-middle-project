package com.company.personservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "person")
public class Person extends ParentEntity{

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @OneToMany(mappedBy = "person")
    private Set<IdentityDocument> documents;

    @ManyToMany
    @JoinTable(name = "person_address"
            , joinColumns = @JoinColumn(name = "address_id")
            , inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Address> addresses;

    @OneToMany(mappedBy = "person")
    private Set<Contact> contacts;
}

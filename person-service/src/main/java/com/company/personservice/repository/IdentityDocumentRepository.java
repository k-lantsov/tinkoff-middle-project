package com.company.personservice.repository;

import com.company.personservice.entity.IdentityDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityDocumentRepository extends JpaRepository<IdentityDocument, Long> {
}

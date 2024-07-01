package com.sme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sme.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Vendor findByEmail(String email);

}

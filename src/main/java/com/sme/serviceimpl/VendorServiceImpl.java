package com.sme.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sme.entity.Vendor;
import com.sme.repository.VendorRepository;
import com.sme.service.VendorService;
@Service
public class VendorServiceImpl implements VendorService{

	@Autowired
    private VendorRepository vendorRepository;

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

	@Override
	public Vendor findByEmail(String email) {
		// TODO Auto-generated method stub
		return vendorRepository.findByEmail(email);
	}

}

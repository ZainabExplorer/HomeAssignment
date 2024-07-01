package com.sme.service;

import java.util.List;

import com.sme.entity.Vendor;

public interface VendorService {
	 public List<Vendor> getAllVendors();
	 public Vendor saveVendor(Vendor vendor);
	public Vendor findByEmail(String email);
}

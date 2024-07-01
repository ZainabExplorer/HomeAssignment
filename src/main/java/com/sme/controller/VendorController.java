package com.sme.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sme.entity.Vendor;
import com.sme.service.VendorService;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin(origins = "*")
public class VendorController {

	@Autowired
	private VendorService vendorService;

	private List<String> sentEmails = new ArrayList<>(); 

	@GetMapping
	public List<Vendor> getAllVendors() {
		return vendorService.getAllVendors();
	}

	@PostMapping
	public ResponseEntity<?> createVendor(@RequestBody Vendor vendor) {
		Vendor existingVendor = vendorService.findByEmail(vendor.getEmail());
		if (existingVendor != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
		}

		Vendor newVendor = vendorService.saveVendor(vendor);
		return ResponseEntity.status(HttpStatus.CREATED).body(newVendor);
	}

	@PostMapping("/send-email")
	public String sendEmailToVendors(@RequestBody List<Long> vendorIds) {
		List<Vendor> vendors = vendorService.getAllVendors();

		vendors.forEach(vendor -> {
			if (vendorIds.contains(vendor.getId())) {
				System.out.println("Sending email to vendor " + vendor.getName() + " at email " + vendor.getEmail());
				sentEmails.add("Email sent to vendor " + vendor.getName() + " at email " + vendor.getEmail());

			}
		});

		return "Emails sent";
	}

	@GetMapping("/sent-emails")
	public List<String> getSentEmails() {
		return sentEmails;
	}
}

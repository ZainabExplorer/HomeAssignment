package com.sme.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String upi;
	public Vendor() {
		super();
	}
	public Vendor(Long id, String name, String email, String upi) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.upi = upi;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUpi() {
		return upi;
	}
	public void setUpi(String upi) {
		this.upi = upi;
	}
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", upi=" + upi + "]";
	}
    
}
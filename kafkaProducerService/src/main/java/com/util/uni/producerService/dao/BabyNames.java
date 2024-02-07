package com.util.uni.producerService.dao;

import java.io.Serializable;

public class BabyNames implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordid;
	private String babyname;
	private String meaning;
	private String gender;
	private String religion;
	private String origin;
	private String nakshatra;
	
	public BabyNames() {	}
	public BabyNames(String babyname) {
		this.babyname = babyname;
	}
	public BabyNames(String babyname, String meaning) {
		this.babyname = babyname;
		this.meaning = meaning;
	}
	
	public String getRecordid() {
		return recordid;
	}
	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}
	public String getBabyname() {
		return babyname;
	}
	public void setBabyname(String babyname) {
		this.babyname = babyname;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getNakshatra() {
		return nakshatra;
	}
	public void setNakshatra(String nakshatra) {
		this.nakshatra = nakshatra;
	}
	
	@Override
	public String toString() {
		return "BabyModel [recordid=" + recordid + ", babyname=" + babyname + ", meaning=" + meaning + ", gender="
				+ gender + ", religion=" + religion + ", origin=" + origin + ", nakshatra=" + nakshatra + "]";
	}
}

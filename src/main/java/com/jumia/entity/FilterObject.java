package com.jumia.entity;

public class FilterObject {

	private NavigationObject navigationObject;

	private String sortCol;

	private String country;
	
	private Boolean state;

	public NavigationObject getNavigationObject() {
		return navigationObject;
	}

	public void setNavigationObject(NavigationObject navigationObject) {
		this.navigationObject = navigationObject;
	}

	public String getSortCol() {
		return sortCol;
	}

	public void setSortCol(String sortCol) {
		this.sortCol = sortCol;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}

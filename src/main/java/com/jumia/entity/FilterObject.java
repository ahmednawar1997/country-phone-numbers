package com.jumia.entity;

public class FilterObject {

	public FilterObject(NavigationObject navigationObject, String country, Boolean state) {
		super();
		this.navigationObject = navigationObject;
		this.country = country;
		this.state = state;
	}

	public FilterObject(String country, Boolean state) {
		super();
		this.country = country;
		this.state = state;
	}



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

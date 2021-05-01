package com.jumia.entity;

public class FilterObject {

	private NavigationObject navigationObject;

	private String sortCol;

	private String filterBy;

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

	public String getFilterBy() {
		return filterBy;
	}

	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
	}

}

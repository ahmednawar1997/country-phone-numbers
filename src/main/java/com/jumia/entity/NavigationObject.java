package com.jumia.entity;

public class NavigationObject {

	public NavigationObject(int page, int recordsPerPage) {
		super();
		this.page = page;
		this.recordsPerPage = recordsPerPage;
	}

	private int page;

	private int recordsPerPage;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

}

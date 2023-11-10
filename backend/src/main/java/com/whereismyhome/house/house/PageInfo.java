package com.whereismyhome.house.house;

public class PageInfo {
	
	private boolean isForward;
	private String path;
	
	public PageInfo(boolean isForward, String path) {
		super();
		this.isForward = isForward;
		this.path = path;
	}

	public PageInfo(String path) { // Forwarding + path
		this(true, path);
	}

	public boolean isForward() {
		return isForward;
	}

	public void setForward(boolean isForward) {
		this.isForward = isForward;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}

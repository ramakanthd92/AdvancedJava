/**
 * 
 */
package com.adobe.prj.entity;

/**
 * @author banup
 * @version 1.0
 */
public class Mobile extends Product {
	private String connectivity;

	public Mobile() {
	}

	public Mobile(int id, String name, double price, String connectivity) {
		super(id, name, price);
		this.connectivity = connectivity;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	@Override
	public boolean isExpensive() {
		return true;
	}
	
}

package com.unused;

public class ProdCust {

	String product;
	String customer;
	Double ssValue;
	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	/**
	 * @return the ssValue
	 */
	public Double getSsValue() {
		return ssValue;
	}
	/**
	 * @param ssValue the ssValue to set
	 */
	public void setSsValue(Double ssValue) {
		this.ssValue = ssValue;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProdCust [product=" + product + ", customer=" + customer
				+ ", ssValue=" + ssValue + "]";
	}
	
}

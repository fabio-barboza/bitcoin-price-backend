package br.com.aurum.bitcoin.fabio.quotation;

import java.io.Serializable;

/**
 * The entity that represents a transation quotation
 * 
 * @author fabio
 *
 */
public class Quotation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The entity id
	 */
	private Long tid;

	/**
	 * The transaction date
	 */
	private Long date;

	/**
	 * The bitcoin price
	 */
	private Double price;

	/**
	 * The quantity
	 */
	private Double amount;

	/**
	 * The type ("sell", "buy")
	 */
	private String type;
	
	/**
	 * The transaction total
	 */
	private Double total;

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quotation other = (Quotation) obj;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quotation [tid=" + tid + ", date=" + date + ", price=" + price + ", amount=" + amount + ", type="
				+ type + "]";
	}

}

package br.com.aurum.bitcoin.fabio.quotation;

import java.io.Serializable;
import java.util.List;

/**
 * The Summary Data Transfer Object
 *  
 * @author fabio
 *
 */
public class QuotationSummaryDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The top sales list
	 */
	private List<Quotation> top5Sales;
	
	/**
	 * The top purchases list
	 */
	private List<Quotation> top5Purchases;
	
	/**
	 * The average sales
	 */
	private Double averageSales;
	
	/**
	 * The average Purchases
	 */
	private Double averagePurchases;
	
	/**
	 * The median sales
	 */
	private Double medianSales;
	
	/**
	 * The median Purchases
	 */
	private Double medianPurchases;
	
	/**
	 * The Starndard Devieviation Sales
	 */
	private Double standardDeviationSales;

	/**
	 * The Starndard Devieviation Purchses
	 */
	private Double standardDeviationPurchases;

	public List<Quotation> getTop5Sales() {
		return top5Sales;
	}

	public void setTop5Sales(List<Quotation> top5Sales) {
		this.top5Sales = top5Sales;
	}

	public List<Quotation> getTop5Purchases() {
		return top5Purchases;
	}

	public void setTop5Purchases(List<Quotation> top5Purchases) {
		this.top5Purchases = top5Purchases;
	}

	public Double getAverageSales() {
		return averageSales;
	}

	public void setAverageSales(Double averageSales) {
		this.averageSales = averageSales;
	}

	public Double getAveragePurchases() {
		return averagePurchases;
	}

	public void setAveragePurchases(Double averagePurchases) {
		this.averagePurchases = averagePurchases;
	}

	public Double getMedianSales() {
		return medianSales;
	}

	public void setMedianSales(Double medianSales) {
		this.medianSales = medianSales;
	}

	public Double getMedianPurchases() {
		return medianPurchases;
	}

	public void setMedianPurchases(Double medianPurchases) {
		this.medianPurchases = medianPurchases;
	}

	public Double getStandardDeviationSales() {
		return standardDeviationSales;
	}

	public void setStandardDeviationSales(Double standardDeviationSales) {
		this.standardDeviationSales = standardDeviationSales;
	}

	public Double getStandardDeviationPurchases() {
		return standardDeviationPurchases;
	}

	public void setStandardDeviationPurchases(Double standardDeviationPurchases) {
		this.standardDeviationPurchases = standardDeviationPurchases;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averagePurchases == null) ? 0 : averagePurchases.hashCode());
		result = prime * result + ((averageSales == null) ? 0 : averageSales.hashCode());
		result = prime * result + ((medianPurchases == null) ? 0 : medianPurchases.hashCode());
		result = prime * result + ((medianSales == null) ? 0 : medianSales.hashCode());
		result = prime * result + ((standardDeviationPurchases == null) ? 0 : standardDeviationPurchases.hashCode());
		result = prime * result + ((standardDeviationSales == null) ? 0 : standardDeviationSales.hashCode());
		result = prime * result + ((top5Purchases == null) ? 0 : top5Purchases.hashCode());
		result = prime * result + ((top5Sales == null) ? 0 : top5Sales.hashCode());
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
		QuotationSummaryDTO other = (QuotationSummaryDTO) obj;
		if (averagePurchases == null) {
			if (other.averagePurchases != null)
				return false;
		} else if (!averagePurchases.equals(other.averagePurchases))
			return false;
		if (averageSales == null) {
			if (other.averageSales != null)
				return false;
		} else if (!averageSales.equals(other.averageSales))
			return false;
		if (medianPurchases == null) {
			if (other.medianPurchases != null)
				return false;
		} else if (!medianPurchases.equals(other.medianPurchases))
			return false;
		if (medianSales == null) {
			if (other.medianSales != null)
				return false;
		} else if (!medianSales.equals(other.medianSales))
			return false;
		if (standardDeviationPurchases == null) {
			if (other.standardDeviationPurchases != null)
				return false;
		} else if (!standardDeviationPurchases.equals(other.standardDeviationPurchases))
			return false;
		if (standardDeviationSales == null) {
			if (other.standardDeviationSales != null)
				return false;
		} else if (!standardDeviationSales.equals(other.standardDeviationSales))
			return false;
		if (top5Purchases == null) {
			if (other.top5Purchases != null)
				return false;
		} else if (!top5Purchases.equals(other.top5Purchases))
			return false;
		if (top5Sales == null) {
			if (other.top5Sales != null)
				return false;
		} else if (!top5Sales.equals(other.top5Sales))
			return false;
		return true;
	}	

}

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

}

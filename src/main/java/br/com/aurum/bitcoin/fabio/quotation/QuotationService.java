package br.com.aurum.bitcoin.fabio.quotation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service Class responsible to manipulate de Bitcoin transactions
 * 
 * @author fabio
 *
 */
@Service
public class QuotationService {

	/**
	 * Method responsible for returning the quotation of the period
	 * 
	 * @param start
	 *            The Start date
	 * @param end
	 *            The End date
	 * @return A list of bitcoins quotation
	 */
	public List<Quotation> getQuotation(final long start, final long end) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Quotation[]> responseEntity = restTemplate.getForEntity(
				"https://www.mercadobitcoin.net/api/BTC/trades/" + start + "/" + end + "/", Quotation[].class);
		List<Quotation> quotations = Arrays.asList(responseEntity.getBody());
		quotations.forEach(q -> q.setTotal(q.getPrice() * q.getAmount()));
		return quotations;
	}

	/**
	 * Method the return the period Sales
	 * 
	 * @param quotations The Quotation List
	 * @return The Sales list
	 */
	public List<Quotation> getSales(final List<Quotation> quotations) {
		return quotations.stream().filter(q -> q.getType().equals(QuotationType.SELL.getDescription()))
				.collect(Collectors.toList());
	}

	/**
	 * Method the return the period Purchases
	 * 
	 * @param quotations The Quotation List
	 * @return The purchases list
	 */
	public List<Quotation> getPurchases(final List<Quotation> quotations) {
		return quotations.stream().filter(q -> q.getType().equals(QuotationType.BUY.getDescription()))
				.collect(Collectors.toList());
	}

	/**
	 * Method the return the period Top Sales
	 * 
	 * @param quotations The Quotation List
	 * @param limit The limit size
	 * @return The limit sales
	 */
	public List<Quotation> getTop(final List<Quotation> quotations, int limit) {
		return quotations.stream().sorted((q1, q2) -> q2.getTotal().compareTo(q1.getTotal())).limit(limit)
				.collect(Collectors.toList());
	}

	/**
	 * Method that return the period average
	 * 
	 * @param quotations quotations The Quotation List
	 * @return the average
	 */
	public Double getAverage(final List<Quotation> quotations) {
		return quotations.stream().mapToDouble(q -> q.getTotal()).average().orElse(Double.NaN);
	}

	/**
	 * Method that return the period median
	 * 
	 * @param quotations the Quotation List
	 * @return the median
	 */
	public Double getMedian(final List<Quotation> quotations) {
		int size = quotations.size();
		return quotations.stream().mapToDouble(q -> q.getTotal()).sorted().skip((size - 1) / 2).limit(2 - size % 2)
				.average().orElse(Double.NaN);
	}

	/**
	 * Method that return the Standard Deviation
	 * 
	 * @param quotations the Quotation List
	 * @return the Standard Deviation
	 */
	public Double getStandardDeviation(final List<Quotation> quotations) {
		if (quotations.size() == 0) {
			return Double.NaN;
		}

		final double average = quotations.stream().mapToDouble((q) -> q.getTotal()).summaryStatistics().getAverage();

		final double rawSum = quotations.stream().mapToDouble((q) -> Math.pow(q.getTotal() - average, 2.0)).sum();

		return Math.sqrt(rawSum / (quotations.size() - 1));
	}
	
	/**
	 * Method that return the period Summary
	 * 
	 * @param quotations the Quotation List
	 * @return the period summary
	 */	
	public QuotationSummaryDTO getQuotationSummary(final long start, final long end) {

		final List<Quotation> quotations = getQuotation(start, end);
		QuotationSummaryDTO summary = null;		
		
		if (!quotations.isEmpty()) {
			List<Quotation> sales = getSales(quotations);
			List<Quotation> purchases = getPurchases(quotations);
			
			summary = new QuotationSummaryDTO();
			
			summary.setTop5Sales(getTop(sales, 5));
			summary.setTop5Purchases(getTop(purchases, 5));	
			
			summary.setAverageSales(getAverage(sales));
			summary.setAveragePurchases(getAverage(purchases));	
			
			summary.setMedianSales(getMedian(sales));
			summary.setMedianPurchases(getMedian(purchases));
			
			summary.setStandardDeviationSales(getStandardDeviation(sales));
			summary.setStandardDeviationPurchases(getStandardDeviation(purchases));			
		}
		
		return summary;
	}
}
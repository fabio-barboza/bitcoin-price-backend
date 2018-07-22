package br.com.aurum.bitcoin.fabio.quotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * The resource Class responsible to listen the clients requisitions
 * 
 * @author fabio
 *
 */
@RestController
@RequestMapping(value="/api")
public class QuotationResource {
	
	@Autowired
	private QuotationService service;
	
	/**
	 * Method responsible for returning the bitcoin quotation Summary
	 * 
	 * @return A Summary of bitcoin transactions.
	 */
	@ApiOperation(value = "Method responsible for returning the bitcoin quotation Summary of the period", response = QuotationSummaryDTO.class)
	@RequestMapping(value="/summary", method=RequestMethod.GET)
	public ResponseEntity<?> summary() {
		return ResponseEntity.ok().body(service.getQuotationSummary());		
	}	
	
	/**
	 * Method responsible for returning a top 5 bitcoin sales
	 * 
	 * @return A list of top 5 bitcoin sales transactions.
	 */
	@ApiOperation(value = "Method responsible for returning a top 5 bitcoin sales of the period", response = Quotation.class)
	@RequestMapping(value="/sales/top5", method=RequestMethod.GET)
	public ResponseEntity<?> top5Sales() {
		return ResponseEntity.ok().body(service.getTop(service.getSales(service.getQuotation()),5));		
	}
	
	/**
	 * Method responsible for returning the sales
	 * 
	 * @return A list of sales.
	 */
	@ApiOperation(value = "Method responsible for returning the sales", response = Quotation.class)
	@RequestMapping(value="/sales", method=RequestMethod.GET)
	public ResponseEntity<?> sales() {
		return ResponseEntity.ok().body(service.getSales(service.getQuotation()));		
	}	
	
	/**
	 * Method responsible for returning the average sales
	 * 
	 * @return The average sales.
	 */
	@ApiOperation(value = "Method responsible for returning the average sales of the period", response = Double.class)
	@RequestMapping(value="/sales/average", method=RequestMethod.GET)
	public ResponseEntity<?> salesAverage() {
		return ResponseEntity.ok().body(service.getAverage(service.getSales(service.getQuotation())));		
	}
	
	/**
	 * Method responsible for returning the median sales
	 * 
	 * @return The median sales.
	 */
	@ApiOperation(value = "Method responsible for returning the median sales of the period", response = Double.class)
	@RequestMapping(value="/sales/median", method=RequestMethod.GET)
	public ResponseEntity<?> salesMedian() {
		return ResponseEntity.ok().body(service.getMedian(service.getSales(service.getQuotation())));		
	}	
	
	/**
	 * Method responsible for returning the Standard Deviation sales
	 * 
	 * @return The Standard Deviation sales.
	 */
	@ApiOperation(value = "Method responsible for returning the Standard Deviation sales of the period", response = Double.class)
	@RequestMapping(value="/sales/deviation", method=RequestMethod.GET)
	public ResponseEntity<?> salesStandardDeviation() {
		return ResponseEntity.ok().body(service.getStandardDeviation(service.getSales(service.getQuotation())));		
	}
	
	/**
	 * Method responsible for returning the purchases
	 * 
	 * @return A list of purchases.
	 */
	@ApiOperation(value = "Method responsible for returning the purchases", response = Quotation.class)
	@RequestMapping(value="/purchases", method=RequestMethod.GET)
	public ResponseEntity<?> purchases() {
		return ResponseEntity.ok().body(service.getPurchases(service.getQuotation()));		
	}		
	
	/**
	 * Method responsible for returning a top 5 bitcoin purchases
	 * 
	 * @return A list of top 5 bitcoin purchases transactions.
	 */	
	@ApiOperation(value = "Method responsible for returning a top 5 bitcoin purchases of the period", response = Quotation.class)
	@RequestMapping(value="/purchases/top5", method=RequestMethod.GET)
	public ResponseEntity<?> top5Purchases() {
		return ResponseEntity.ok().body(service.getTop(service.getPurchases(service.getQuotation()),5));		
	}	
	
	/**
	 * Method responsible for returning the average purchases
	 * 
	 * @return The average purchases.
	 */
	@ApiOperation(value = "Method responsible for returning the average purchases of the period", response = Double.class)
	@RequestMapping(value="/purchases/average", method=RequestMethod.GET)
	public ResponseEntity<?> purchasesAverage() {
		return ResponseEntity.ok().body(service.getAverage(service.getPurchases(service.getQuotation())));		
	}
	
	/**
	 * Method responsible for returning the median purchases
	 * 
	 * @return The median purchases.
	 */
	@ApiOperation(value = "Method responsible for returning the median purchases of the period", response = Double.class)
	@RequestMapping(value="/purchases/median", method=RequestMethod.GET)
	public ResponseEntity<?> purchasesMedian() {
		return ResponseEntity.ok().body(service.getMedian(service.getPurchases(service.getQuotation())));		
	}	
	
	/**
	 * Method responsible for returning the Standard Deviation purchases
	 * 
	 * @return The Standard Deviation purchases.
	 */
	@ApiOperation(value = "Method responsible for returning the Standard Deviation purchases of the period", response = Double.class)
	@RequestMapping(value="/purchases/deviation", method=RequestMethod.GET)
	public ResponseEntity<?> purchasesStandardDeviation() {
		return ResponseEntity.ok().body(service.getStandardDeviation(service.getPurchases(service.getQuotation())));		
	}	
	
}
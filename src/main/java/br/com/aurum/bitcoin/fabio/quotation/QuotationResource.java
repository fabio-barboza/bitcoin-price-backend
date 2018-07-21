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
	 * Method responsible for returning the bitcoin quotation Summary of the period
	 * 
	 * @param start The Start date
	 * @param end The End date
	 * @return A Summary of bitcoin transactions.
	 */
	@ApiOperation(value = "Method responsible for returning the bitcoin quotation Summary of the period", response = QuotationSummaryDTO.class)
	@ApiImplicitParams({
		@ApiImplicitParam (name = "start", value = "The initial date in Timestamp format", required = true),
		@ApiImplicitParam (name = "end", value = "The end date in Timestamp format", required = true)
	})
	@RequestMapping(value="/summary/{start}/{end}", method=RequestMethod.GET)
	public ResponseEntity<?> summary(@PathVariable Long start, @PathVariable Long end) {
		return ResponseEntity.ok().body(service.getQuotationSummary(start, end));		
	}	
	
	/**
	 * Method responsible for returning a top 5 bitcoin sales of the period
	 * 
	 * @param start The Start date
	 * @param end The End date
	 * @return A list of top 5 bitcoin sales transactions.
	 */
	@ApiOperation(value = "Method responsible for returning a top 5 bitcoin sales of the period", response = QuotationSummaryDTO.class)
	@ApiImplicitParams({
		@ApiImplicitParam (name = "start", value = "The initial date in Timestamp format", required = true),
		@ApiImplicitParam (name = "end", value = "The end date in Timestamp format", required = true)
	})	
	@RequestMapping(value="/sales/top5/{start}/{end}", method=RequestMethod.GET)
	public ResponseEntity<?> top5Sales(@PathVariable Long start, @PathVariable Long end) {
		return ResponseEntity.ok().body(service.getTop(service.getSales(service.getQuotation(start, end)),5));		
	}
	
	/**
	 * Method responsible for returning the average sales of the period
	 * 
	 * @param start The Start date
	 * @param end The End date
	 * @return The average sales.
	 */
	@ApiOperation(value = "Method responsible for returning the average sales of the period", response = QuotationSummaryDTO.class)
	@ApiImplicitParams({
		@ApiImplicitParam (name = "start", value = "The initial date in Timestamp format", required = true),
		@ApiImplicitParam (name = "end", value = "The end date in Timestamp format", required = true)
	})		
	@RequestMapping(value="/sales/average/{start}/{end}", method=RequestMethod.GET)
	public ResponseEntity<?> salesAverage(@PathVariable Long start, @PathVariable Long end) {
		return ResponseEntity.ok().body(service.getAverage(service.getSales(service.getQuotation(start, end))));		
	}
	
	/**
	 * Method responsible for returning the median sales of the period
	 * 
	 * @param start The Start date
	 * @param end The End date
	 * @return The median sales.
	 */
	@ApiOperation(value = "Method responsible for returning the median sales of the period", response = QuotationSummaryDTO.class)
	@ApiImplicitParams({
		@ApiImplicitParam (name = "start", value = "The initial date in Timestamp format", required = true),
		@ApiImplicitParam (name = "end", value = "The end date in Timestamp format", required = true)
	})		
	@RequestMapping(value="/sales/median/{start}/{end}", method=RequestMethod.GET)
	public ResponseEntity<?> salesMedian(@PathVariable Long start, @PathVariable Long end) {
		return ResponseEntity.ok().body(service.getMedian(service.getSales(service.getQuotation(start, end))));		
	}	
	
	/**
	 * Method responsible for returning the Standard Deviation sales of the period
	 * 
	 * @param start The Start date
	 * @param end The End date
	 * @return The Standard Deviation sales.
	 */
	@ApiOperation(value = "Method responsible for returning the Standard Deviation sales of the period", response = QuotationSummaryDTO.class)
	@ApiImplicitParams({
		@ApiImplicitParam (name = "start", value = "The initial date in Timestamp format", required = true),
		@ApiImplicitParam (name = "end", value = "The end date in Timestamp format", required = true)
	})	
	@RequestMapping(value="/sales/deviation/{start}/{end}", method=RequestMethod.GET)
	public ResponseEntity<?> salesStandardDeviation(@PathVariable Long start, @PathVariable Long end) {
		return ResponseEntity.ok().body(service.getStandardDeviation(service.getSales(service.getQuotation(start, end))));		
	}		
	
	/**
	 * Method responsible for returning a top 5 bitcoin purchases of the period
	 * 
	 * @param start The Start date
	 * @param end The End date
	 * @return A list of top 5 bitcoin purchases transactions.
	 */	
	@ApiOperation(value = "Method responsible for returning a top 5 bitcoin purchases of the period", response = QuotationSummaryDTO.class)
	@ApiImplicitParams({
		@ApiImplicitParam (name = "start", value = "The initial date in Timestamp format", required = true),
		@ApiImplicitParam (name = "end", value = "The end date in Timestamp format", required = true)
	})		
	@RequestMapping(value="/purchases/top5/{start}/{end}", method=RequestMethod.GET)
	public ResponseEntity<?> top5Purchases(@PathVariable Long start, @PathVariable Long end) {
		return ResponseEntity.ok().body(service.getTop(service.getPurchases(service.getQuotation(start, end)),5));		
	}	
	
	/**
	 * Method responsible for returning the average purchases of the period
	 * 
	 * @param start The Start date
	 * @param end The End date
	 * @return The average purchases.
	 */
	@ApiOperation(value = "Method responsible for returning the average purchases of the period", response = QuotationSummaryDTO.class)
	@ApiImplicitParams({
		@ApiImplicitParam (name = "start", value = "The initial date in Timestamp format", required = true),
		@ApiImplicitParam (name = "end", value = "The end date in Timestamp format", required = true)
	})		
	@RequestMapping(value="/purchases/average/{start}/{end}", method=RequestMethod.GET)
	public ResponseEntity<?> purchasesAverage(@PathVariable Long start, @PathVariable Long end) {
		return ResponseEntity.ok().body(service.getAverage(service.getPurchases(service.getQuotation(start, end))));		
	}
	
	/**
	 * Method responsible for returning the median purchases of the period
	 * 
	 * @param start The Start date
	 * @param end The End date
	 * @return The median purchases.
	 */
	@ApiOperation(value = "Method responsible for returning the median purchases of the period", response = QuotationSummaryDTO.class)
	@ApiImplicitParams({
		@ApiImplicitParam (name = "start", value = "The initial date in Timestamp format", required = true),
		@ApiImplicitParam (name = "end", value = "The end date in Timestamp format", required = true)
	})		
	@RequestMapping(value="/purchases/median/{start}/{end}", method=RequestMethod.GET)
	public ResponseEntity<?> purchasesMedian(@PathVariable Long start, @PathVariable Long end) {
		return ResponseEntity.ok().body(service.getMedian(service.getPurchases(service.getQuotation(start, end))));		
	}	
	
	/**
	 * Method responsible for returning the Standard Deviation purchases of the period
	 * 
	 * @param start The Start date
	 * @param end The End date
	 * @return The Standard Deviation purchases.
	 */
	@ApiOperation(value = "Method responsible for returning the Standard Deviation purchases of the period", response = QuotationSummaryDTO.class)
	@ApiImplicitParams({
		@ApiImplicitParam (name = "start", value = "The initial date in Timestamp format", required = true),
		@ApiImplicitParam (name = "end", value = "The end date in Timestamp format", required = true)
	})		
	@RequestMapping(value="/purchases/deviation/{start}/{end}", method=RequestMethod.GET)
	public ResponseEntity<?> purchasesStandardDeviation(@PathVariable Long start, @PathVariable Long end) {
		return ResponseEntity.ok().body(service.getStandardDeviation(service.getPurchases(service.getQuotation(start, end))));		
	}	
	
}
package br.com.aurum.bitcoin.fabio;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.aurum.bitcoin.fabio.quotation.Quotation;
import br.com.aurum.bitcoin.fabio.quotation.QuotationService;
import br.com.aurum.bitcoin.fabio.quotation.QuotationSummaryDTO;

/**
 * Class responsible to test the Services include in the QuotationService class
 * 
 * @see QuotationService.java
 * 
 * @author fabio
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuotationServiceTests {

	/**
	 * Set the TOP Limit to 5
	 */
	private final int LIMIT = 5;

	/**
	 * Setup the Start date
	 */
	private final long START_DATE = 1501871369;

	/**
	 * Setup the End date
	 */
	private final long END_DATE = 1501891200;

	/**
	 * Setup the Top 5 Purchases Json
	 */
	private final String TOP5PUCHARGES = "[{\"tid\":740624,\"date\":1501889043,\"price\":9657.0,\"amount\":3.99571885,\"type\":\"buy\",\"total\":38586.656934449995},{\"tid\":740620,\"date\":1501888958,\"price\":9656.9,\"amount\":2.57435,\"type\":\"buy\",\"total\":24860.240514999998},{\"tid\":740628,\"date\":1501889180,\"price\":9656.0,\"amount\":1.54929286,\"type\":\"buy\",\"total\":14959.97185616},{\"tid\":740207,\"date\":1501879302,\"price\":9575.0,\"amount\":1.34596961,\"type\":\"buy\",\"total\":12887.65901575},{\"tid\":739838,\"date\":1501872927,\"price\":9700.0,\"amount\":1.0,\"type\":\"buy\",\"total\":9700.0}]";

	/**
	 * Setup the Top 5 Sales Json
	 */
	private final String TOP5SALES = "[{\"tid\":739902,\"date\":1501873803,\"price\":9709.99999,\"amount\":7.09311,\"type\":\"sell\",\"total\":68874.0980290689},{\"tid\":740090,\"date\":1501877113,\"price\":9550.0,\"amount\":1.8282312,\"type\":\"sell\",\"total\":17459.60796},{\"tid\":740653,\"date\":1501889997,\"price\":9595.0,\"amount\":1.76755642,\"type\":\"sell\",\"total\":16959.7038499},{\"tid\":739899,\"date\":1501873752,\"price\":9709.99999,\"amount\":1.5,\"type\":\"sell\",\"total\":14564.999985},{\"tid\":740035,\"date\":1501876161,\"price\":9600.0,\"amount\":1.51238,\"type\":\"sell\",\"total\":14518.848}]";

	/**
	 * Setup the Summary sample
	 */
	private final String SUMMARY = "{\"top5Sales\":[{\"tid\":739902,\"date\":1501873803,\"price\":9709.99999,\"amount\":7.09311,\"type\":\"sell\",\"total\":68874.0980290689},{\"tid\":740090,\"date\":1501877113,\"price\":9550.0,\"amount\":1.8282312,\"type\":\"sell\",\"total\":17459.60796},{\"tid\":740653,\"date\":1501889997,\"price\":9595.0,\"amount\":1.76755642,\"type\":\"sell\",\"total\":16959.7038499},{\"tid\":739899,\"date\":1501873752,\"price\":9709.99999,\"amount\":1.5,\"type\":\"sell\",\"total\":14564.999985},{\"tid\":740035,\"date\":1501876161,\"price\":9600.0,\"amount\":1.51238,\"type\":\"sell\",\"total\":14518.848}],\"top5Purchases\":[{\"tid\":740624,\"date\":1501889043,\"price\":9657.0,\"amount\":3.99571885,\"type\":\"buy\",\"total\":38586.656934449995},{\"tid\":740620,\"date\":1501888958,\"price\":9656.9,\"amount\":2.57435,\"type\":\"buy\",\"total\":24860.240514999998},{\"tid\":740628,\"date\":1501889180,\"price\":9656.0,\"amount\":1.54929286,\"type\":\"buy\",\"total\":14959.97185616},{\"tid\":740207,\"date\":1501879302,\"price\":9575.0,\"amount\":1.34596961,\"type\":\"buy\",\"total\":12887.65901575},{\"tid\":739838,\"date\":1501872927,\"price\":9700.0,\"amount\":1.0,\"type\":\"buy\",\"total\":9700.0}],\"averageSales\":947.8770733857139,\"averagePurchases\":937.865675872459,\"medianSales\":205.21529999999998,\"medianPurchases\":193.1199916667256,\"standardDeviationSales\":3745.5077758750494,\"standardDeviationPurchases\":2508.530500118819}";

	/**
	 * The Object Mapper do convert the Jsons
	 */
	private ObjectMapper mapper = new ObjectMapper();

	/**
	 * Inject the Quotation Service
	 */
	@Autowired
	private QuotationService service;

	/**
	 * Test is the Spring Context is working
	 */
	@Test
	public void contextLoads() {
	}

	/**
	 * Tests the Bitcoin Webservice
	 */
	@Test
	public void getQuotationTest() {
		assertTrue(service.getQuotation(START_DATE, END_DATE).size() == 966);
	}

	/**
	 * Testes the Top 5 Purchases
	 * 
	 * @throws JsonParseException
	 *             If has some error in the TOP5PUCHARGES constant
	 * @throws JsonMappingException
	 *             If is not possible to Map the TOP5PUCHARGES contant
	 * @throws IOException
	 *             If accur some input / output error
	 */
	@Test
	public void getTop5PurchasesTest() throws JsonParseException, JsonMappingException, IOException {
		List<Quotation> purchases = mapper.readValue(TOP5PUCHARGES,
				mapper.getTypeFactory().constructCollectionType(List.class, Quotation.class));
		List<Quotation> quotations = service.getTop(service.getPurchases(service.getQuotation(START_DATE, END_DATE)),
				LIMIT);
		assertArrayEquals(purchases.toArray(), quotations.toArray());
	}

	/**
	 * Test the Top 5 Sales
	 * 
	 * @throws JsonParseException
	 *             If has some error in the TOP5SALES constant
	 * @throws JsonMappingException
	 *             If is not possible to Map the TOP5SALES contant
	 * @throws IOException
	 *             If accur some input / output error
	 */
	@Test
	public void getTop5SalesTest() throws JsonParseException, JsonMappingException, IOException {
		List<Quotation> sales = mapper.readValue(TOP5SALES,
				mapper.getTypeFactory().constructCollectionType(List.class, Quotation.class));
		List<Quotation> quotations = service.getTop(service.getSales(service.getQuotation(START_DATE, END_DATE)),
				LIMIT);
		assertArrayEquals(sales.toArray(), quotations.toArray());
	}

	/**
	 * Test the Average sales
	 */
	@Test
	public void getSalesAverageTest() {
		assertTrue(new Double(947.8770733857139)
				.equals(service.getAverage(service.getSales(service.getQuotation(START_DATE, END_DATE)))));
	}

	/**
	 * Test the Avarage Purchases
	 */
	@Test
	public void getPurchasesAverageTest() {
		assertTrue(new Double(937.865675872459)
				.equals(service.getAverage(service.getPurchases(service.getQuotation(START_DATE, END_DATE)))));
	}

	/**
	 * Test the Sales Median
	 */
	@Test
	public void getSalesMedian() {
		assertTrue(new Double(205.21529999999998)
				.equals(service.getMedian(service.getSales(service.getQuotation(START_DATE, END_DATE)))));
	}

	/**
	 * Test the Purchases Median
	 */
	@Test
	public void getPurchasesMedian() {
		assertTrue(new Double(193.1199916667256)
				.equals(service.getMedian(service.getPurchases(service.getQuotation(START_DATE, END_DATE)))));
	}

	/**
	 * Test the Sales Standard Deviation
	 */
	@Test
	public void getSalesComputeStandardDeviation() {
		assertTrue(new Double(3745.5077758750494).equals(
				service.getStandardDeviation(service.getSales(service.getQuotation(START_DATE, END_DATE)))));
	}

	/**
	 * Test the Purchases Standard Deviation
	 */
	@Test
	public void getPurchasesComputeStandardDeviation() {
		assertTrue(new Double(2508.530500118819).equals(
				service.getStandardDeviation(service.getPurchases(service.getQuotation(START_DATE, END_DATE)))));
	}

	/**
	 * The the Quotation Summary
	 * 
	 * @throws JsonParseException
	 *             If has some error in the SUMMARY constant
	 * @throws JsonMappingException
	 *             If is not possible to Map the SUMMARY contant
	 * @throws IOException
	 *             If accur some input / output error
	 */
	@Test
	public void getSummaryTest() throws JsonParseException, JsonMappingException, IOException {
		QuotationSummaryDTO summary = mapper.readValue(SUMMARY, QuotationSummaryDTO.class);
		QuotationSummaryDTO summaryResult = service.getQuotationSummary(START_DATE, END_DATE);
		assertTrue(summary.equals(summaryResult));
	}

}

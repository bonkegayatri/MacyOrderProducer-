package com.zensar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.zensar.controller.OrderMessageProducerController;
import com.zensar.dto.AddressDto;
import com.zensar.dto.BillingAddressDto;
import com.zensar.dto.ContactDto;
import com.zensar.dto.JsonOrderDto;
import com.zensar.dto.NameDto;
import com.zensar.dto.OrderTotalsDto;
import com.zensar.dto.SourceDto;
import com.zensar.dto.XmlOrderDto;
import com.zensar.service.OrderMessageProducerService;

@WebMvcTest(OrderMessageProducerController.class)
public class OrderMessageProducerControllerTest {

	@Autowired
	MockMvc mockMvc;
	 
	@MockBean
	OrderMessageProducerService orderMessageProducerService;

	String exampleOrderJson = "{\r\n" + 
			"    \"messageName\": \"ITEM MASTER 11\",\r\n" + 
			"    \"command\": \"ADD\",\r\n" + 
			"    \"itemName\": \"WALLET\",\r\n" + 
			"    \"itemDescription\": \"FLAT WALLET\",\r\n" + 
			"    \"itemLength\": 2.3,\r\n" + 
			"    \"itemWidth\": 0.5,\r\n" + 
			"    \"itemHeight\": 1.3,\r\n" + 
			"    \"itemWeight\": 1.5,\r\n" + 
			"    \"imagePathname\": null,\r\n" + 
			"    \"rfidTagged\": \"Y\",\r\n" + 
			"    \"storageAttribute\": 1,\r\n" + 
			"    \"pickType\": \"E\",\r\n" + 
			"    \"upcList\": null\r\n" + 
			"}";

	String exampleOrderXml = "<ns0:fulfillmentOrder xmlns:ns0=\"http://www.mst.macys.com/main/eos/fulfillmentOrder/orderDetails.v1.1\">\r\n" + 
			"<ns0:orderID>490048480</ns0:orderID>\r\n" + 
			"<ns0:orderTypeCode>Digital4</ns0:orderTypeCode>\r\n" + 
			"<ns0:partnerOrderID>SAN10000137</ns0:partnerOrderID>\r\n" + 
			"<ns0:orderStatus>Created</ns0:orderStatus>\r\n" + 
			"<ns0:messageCreateTimeStamp>2017-08-16T15:20:29.657-04:00</ns0:messageCreateTimeStamp>\r\n" + 
			"<ns0:fulfillmentChannelCode>POOL</ns0:fulfillmentChannelCode>\r\n" + 
			"<ns0:orderStatusCode>110</ns0:orderStatusCode>\r\n" + 
			"<ns0:orderStatusDescription>IN_PROCESS</ns0:orderStatusDescription>\r\n" + 
			"<ns0:sellZLDivisionNbr>71</ns0:sellZLDivisionNbr>\r\n" + 
			"<ns0:sellZLLocationNbr>139</ns0:sellZLLocationNbr>\r\n" + 
			"<ns0:source>\r\n" + 
			"<ns0:clientID>MCOM</ns0:clientID>\r\n" + 
			"<ns0:subClientID>SITE</ns0:subClientID>\r\n" + 
			"<ns0:sellingChannelCode>MCOM</ns0:sellingChannelCode>\r\n" + 
			"<ns0:seperatorSource0>0</ns0:seperatorSource0>\r\n" + 
			"<ns0:separatorSource1>1</ns0:separatorSource1>\r\n" + 
			"</ns0:source>\r\n" + 
			"<ns0:orderTotals>\r\n" + 
			"<ns0:totalPurchaseAmount>41.95</ns0:totalPurchaseAmount>\r\n" + 
			"<ns0:seperatorOrderTotals0>0</ns0:seperatorOrderTotals0>\r\n" + 
			"</ns0:orderTotals>\r\n" + 
			"<ns0:billingAddress>\r\n" + 
			"<ns0:contact>\r\n" + 
			"<ns0:custID>51238851</ns0:custID>\r\n" + 
			"<ns0:name>\r\n" + 
			"<ns0:firstName>SUPRAJA</ns0:firstName>\r\n" + 
			"<ns0:lastName>CHIDURAL</ns0:lastName>\r\n" + 
			"<ns0:seperatorName0>0</ns0:seperatorName0>\r\n" + 
			"<ns0:seperatorName1>1</ns0:seperatorName1>\r\n" + 
			"</ns0:name>\r\n" + 
			"<ns0:address>\r\n" + 
			"<ns0:line1>2200 Galvin Dr</ns0:line1>\r\n" + 
			"<ns0:line2>2200 Galvin Dr</ns0:line2>\r\n" + 
			"<ns0:line3>2200 Galvin Dr</ns0:line3>\r\n" + 
			"<ns0:city>BUFORD</ns0:city>\r\n" + 
			"<ns0:state>GA</ns0:state>\r\n" + 
			"<ns0:zipCode>30087</ns0:zipCode>\r\n" + 
			"<ns0:countryCode>USA</ns0:countryCode>\r\n" + 
			"<ns0:seperatorAddress0>0</ns0:seperatorAddress0>\r\n" + 
			"</ns0:address>\r\n" + 
			"<ns0:daytimePhoneNbr>968-789-87642345</ns0:daytimePhoneNbr>\r\n" + 
			"<ns0:homePhoneNbr>968-789-8764</ns0:homePhoneNbr>\r\n" + 
			"<ns0:alternatePhoneNbr>741-119-3501</ns0:alternatePhoneNbr>\r\n" + 
			"<ns0:sendSMSMessage>false</ns0:sendSMSMessage>\r\n" + 
			"<ns0:emailAddress>SUPRAJA.CHIDURAL@MACYS.COM</ns0:emailAddress>\r\n" + 
			"<ns0:seperatorContact0>0</ns0:seperatorContact0>\r\n" + 
			"</ns0:contact>\r\n" + 
			"</ns0:billingAddress>\r\n" + 
			"</ns0:fulfillmentOrder>";
	 
	@Test
	 public void testProduceNewJsonOrder() throws Exception {
		JsonOrderDto mockJsonOrder = new JsonOrderDto("ITEM MASTER 11","ADD","WALLET","FLAT WALLET",2.3,0.5,1.3,
				 1.5,null,"Y",1,"E",null);
		String expectedResult = "Message sent to the RabbitMQ Successfully";

		Mockito.when(orderMessageProducerService.produceNewJsonOrder(Mockito.any(JsonOrderDto.class))).thenReturn(expectedResult);

		
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/produce/jsonorder")
		            .accept(MediaType.APPLICATION_JSON).content(exampleOrderJson)
		            .contentType(MediaType.APPLICATION_JSON);
		 
		 MvcResult result = mockMvc.perform(mockRequest).andReturn();
		 System.out.println("json order response : " + result.getResponse().getContentAsString());
		
		 assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		 
	 }
	
	@Test
	 public void testProduceNewXmlOrder() throws Exception {
		XmlOrderDto mockXmlOrder = new XmlOrderDto(490048480,"Digital4","SAN10000137","Created","2017-08-16T15:20:29.657-04:00",
				 "POOL",110,"IN_PROCESS", 71,139, new SourceDto("MCOM","SITE","MCOM",0,1),
				 new OrderTotalsDto(41.95,0), new BillingAddressDto(new ContactDto(51238851, 
				 new NameDto( "SUPRAJA","CHIDURAL",0,1), new AddressDto("2200 Galvin Dr",
		         "2200 Galvin Dr", "2200 Galvin Dr","BUFORD","GA",30087,"USA",0),
				 "968-789-87642345","968-789-8764","741-119-3501",false,"SUPRAJA.CHIDURAL@MACYS.COM",0)));
		 
		 String expectedResult = "Xml Message sent to the RabbitMQ Successfully";

		 
		 Mockito.when(orderMessageProducerService.produceNewXmlOrder(Mockito.any(XmlOrderDto.class))).thenReturn(expectedResult);

		 MockHttpServletRequestBuilder mockXmlRequest = MockMvcRequestBuilders.post("/produce/xmlorder")
			            .accept(MediaType.APPLICATION_XML).content(exampleOrderXml)
			            .contentType(MediaType.APPLICATION_XML);
			 
		 MvcResult result = mockMvc.perform(mockXmlRequest).andReturn();
		 System.out.println("xml order response : " + result.getResponse().getContentAsString());
			
		 assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
			 	
	 }
	 
	
}

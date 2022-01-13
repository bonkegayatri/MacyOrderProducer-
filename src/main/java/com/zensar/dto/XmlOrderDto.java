package com.zensar.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("XmlOrder Model")
public class XmlOrderDto {
	
	@ApiModelProperty("orderID")
	public int orderID;
	public String orderTypeCode;
	public String partnerOrderID;
	public String orderStatus;
	public String messageCreateTimeStamp;
	public String fulfillmentChannelCode;
	public int orderStatusCode;
	public String orderStatusDescription;
	public int sellZLDivisionNbr;
	public int sellZLLocationNbr;
	public SourceDto source;
	public OrderTotalsDto orderTotals;
	public BillingAddressDto billingAddress;
	
	
	public XmlOrderDto() {
	}


	public XmlOrderDto(int orderID, String orderTypeCode, String partnerOrderID, String orderStatus,
			String messageCreateTimeStamp, String fulfillmentChannelCode, int orderStatusCode,
			String orderStatusDescription, int sellZLDivisionNbr, int sellZLLocationNbr, SourceDto source,
			OrderTotalsDto orderTotals, BillingAddressDto billingAddress) {
		super();
		this.orderID = orderID;
		this.orderTypeCode = orderTypeCode;
		this.partnerOrderID = partnerOrderID;
		this.orderStatus = orderStatus;
		this.messageCreateTimeStamp = messageCreateTimeStamp;
		this.fulfillmentChannelCode = fulfillmentChannelCode;
		this.orderStatusCode = orderStatusCode;
		this.orderStatusDescription = orderStatusDescription;
		this.sellZLDivisionNbr = sellZLDivisionNbr;
		this.sellZLLocationNbr = sellZLLocationNbr;
		this.source = source;
		this.orderTotals = orderTotals;
		this.billingAddress = billingAddress;
	}


	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public String getOrderTypeCode() {
		return orderTypeCode;
	}


	public void setOrderTypeCode(String orderTypeCode) {
		this.orderTypeCode = orderTypeCode;
	}


	public String getPartnerOrderID() {
		return partnerOrderID;
	}


	public void setPartnerOrderID(String partnerOrderID) {
		this.partnerOrderID = partnerOrderID;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public String getMessageCreateTimeStamp() {
		return messageCreateTimeStamp;
	}


	public void setMessageCreateTimeStamp(String messageCreateTimeStamp) {
		this.messageCreateTimeStamp = messageCreateTimeStamp;
	}


	public String getFulfillmentChannelCode() {
		return fulfillmentChannelCode;
	}


	public void setFulfillmentChannelCode(String fulfillmentChannelCode) {
		this.fulfillmentChannelCode = fulfillmentChannelCode;
	}


	public int getOrderStatusCode() {
		return orderStatusCode;
	}


	public void setOrderStatusCode(int orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}


	public String getOrderStatusDescription() {
		return orderStatusDescription;
	}


	public void setOrderStatusDescription(String orderStatusDescription) {
		this.orderStatusDescription = orderStatusDescription;
	}


	public int getSellZLDivisionNbr() {
		return sellZLDivisionNbr;
	}


	public void setSellZLDivisionNbr(int sellZLDivisionNbr) {
		this.sellZLDivisionNbr = sellZLDivisionNbr;
	}


	public int getSellZLLocationNbr() {
		return sellZLLocationNbr;
	}


	public void setSellZLLocationNbr(int sellZLLocationNbr) {
		this.sellZLLocationNbr = sellZLLocationNbr;
	}


	public SourceDto getSource() {
		return source;
	}


	public void setSource(SourceDto source) {
		this.source = source;
	}


	public OrderTotalsDto getOrderTotals() {
		return orderTotals;
	}


	public void setOrderTotals(OrderTotalsDto orderTotals) {
		this.orderTotals = orderTotals;
	}


	public BillingAddressDto getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(BillingAddressDto billingAddress) {
		this.billingAddress = billingAddress;
	}


	@Override
	public String toString() {
		return "OrderHeader [orderID=" + orderID + ", orderTypeCode=" + orderTypeCode + ", partnerOrderID="
				+ partnerOrderID + ", orderStatus=" + orderStatus + ", messageCreateTimeStamp=" + messageCreateTimeStamp
				+ ", fulfillmentChannelCode=" + fulfillmentChannelCode + ", orderStatusCode=" + orderStatusCode
				+ ", orderStatusDescription=" + orderStatusDescription + ", sellZLDivisionNbr=" + sellZLDivisionNbr
				+ ", sellZLLocationNbr=" + sellZLLocationNbr + ", source=" + source + ", orderTotals=" + orderTotals
				+ ", billingAddress=" + billingAddress + "]";
	}
	
	
	
}

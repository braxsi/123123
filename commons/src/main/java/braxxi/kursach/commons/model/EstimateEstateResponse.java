package braxxi.kursach.commons.model;

import java.math.BigDecimal;

public class EstimateEstateResponse {
	private BigDecimal minPrice;
	private BigDecimal avrPrice;
	private BigDecimal maxPrice;

	public EstimateEstateResponse() {
	}

	public EstimateEstateResponse(BigDecimal minPrice, BigDecimal avrPrice, BigDecimal maxPrice) {
		this.minPrice = minPrice;
		this.avrPrice = avrPrice;
		this.maxPrice = maxPrice;
	}

	public BigDecimal getMinPrice() {
		return this.minPrice;
	}

	public BigDecimal getAvrPrice() {
		return this.avrPrice;
	}

	public BigDecimal getMaxPrice() {
		return this.maxPrice;
	}
}

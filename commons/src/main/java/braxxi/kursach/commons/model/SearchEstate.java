package braxxi.kursach.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchEstate {

	private Integer districtId;

	private BigDecimal totalAreaFrom;
	private BigDecimal totalAreaTo;

	private String description;

	public Integer getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public BigDecimal getTotalAreaFrom() {
		return this.totalAreaFrom;
	}

	public void setTotalAreaFrom(BigDecimal totalAreaFrom) {
		this.totalAreaFrom = totalAreaFrom;
	}

	public BigDecimal getTotalAreaTo() {
		return this.totalAreaTo;
	}

	public void setTotalAreaTo(BigDecimal totalAreaTo) {
		this.totalAreaTo = totalAreaTo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

package braxxi.kursach.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchEstate {

	private Integer districtId;

	private BigDecimal totalAreaFrom;
	private BigDecimal totalAreaTo;

	private BigDecimal livingAreaFrom;
	private BigDecimal livingAreaTo;

	private BigDecimal kitchenAreaFrom;
	private BigDecimal kitchenAreaTo;

	private Integer floorFrom;
	private Integer floorTo;

	private Integer roomsFrom;
	private Integer roomsTo;

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

	public BigDecimal getLivingAreaFrom() {
		return this.livingAreaFrom;
	}

	public void setLivingAreaFrom(BigDecimal livingAreaFrom) {
		this.livingAreaFrom = livingAreaFrom;
	}

	public BigDecimal getLivingAreaTo() {
		return this.livingAreaTo;
	}

	public void setLivingAreaTo(BigDecimal livingAreaTo) {
		this.livingAreaTo = livingAreaTo;
	}

	public BigDecimal getKitchenAreaFrom() {
		return this.kitchenAreaFrom;
	}

	public void setKitchenAreaFrom(BigDecimal kitchenAreaFrom) {
		this.kitchenAreaFrom = kitchenAreaFrom;
	}

	public BigDecimal getKitchenAreaTo() {
		return this.kitchenAreaTo;
	}

	public void setKitchenAreaTo(BigDecimal kitchenAreaTo) {
		this.kitchenAreaTo = kitchenAreaTo;
	}

	public Integer getFloorFrom() {
		return this.floorFrom;
	}

	public void setFloorFrom(Integer floorFrom) {
		this.floorFrom = floorFrom;
	}

	public Integer getFloorTo() {
		return this.floorTo;
	}

	public void setFloorTo(Integer floorTo) {
		this.floorTo = floorTo;
	}

	public Integer getRoomsFrom() {
		return this.roomsFrom;
	}

	public void setRoomsFrom(Integer roomsFrom) {
		this.roomsFrom = roomsFrom;
	}

	public Integer getRoomsTo() {
		return this.roomsTo;
	}

	public void setRoomsTo(Integer roomsTo) {
		this.roomsTo = roomsTo;
	}
}

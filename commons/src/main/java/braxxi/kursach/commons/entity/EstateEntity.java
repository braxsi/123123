package braxxi.kursach.commons.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.text.RandomStringGenerator;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EstateEntity {
	private Long id;
	private int districtId;
	private BigDecimal totalArea;
	private BigDecimal livingArea;
	private BigDecimal kitchenArea;
	private int floor;
	private int floors;
	private int distanceToMetro;
	private String description;
	private int rooms;
	private String contacts;
	private Long userId;

	public EstateEntity() {
	}

	public EstateEntity(Long id, int districtId, BigDecimal totalArea, BigDecimal livingArea, BigDecimal kitchenArea, int floor, int floors, int distanceToMetro, String description, int rooms, Long userId) {
		this.id = id;
		this.districtId = districtId;
		this.totalArea = totalArea;
		this.livingArea = livingArea;
		this.kitchenArea = kitchenArea;
		this.floor = floor;
		this.floors = floors;
		this.distanceToMetro = distanceToMetro;
		this.description = description;
		this.rooms = rooms;
		this.userId = userId;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public BigDecimal getTotalArea() {
		return this.totalArea;
	}

	public void setTotalArea(BigDecimal totalArea) {
		this.totalArea = totalArea;
	}

	public BigDecimal getLivingArea() {
		return this.livingArea;
	}

	public void setLivingArea(BigDecimal livingArea) {
		this.livingArea = livingArea;
	}

	public BigDecimal getKitchenArea() {
		return this.kitchenArea;
	}

	public void setKitchenArea(BigDecimal kitchenArea) {
		this.kitchenArea = kitchenArea;
	}

	public int getFloor() {
		return this.floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getFloors() {
		return this.floors;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}

	public int getDistanceToMetro() {
		return this.distanceToMetro;
	}

	public void setDistanceToMetro(int distanceToMetro) {
		this.distanceToMetro = distanceToMetro;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRooms() {
		return this.rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public String getContacts() {
		return this.contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public static EstateEntity generateRandom(Long id) {
		final int totalArea = RandomUtils.nextInt(5, 200);
		final int floors = RandomUtils.nextInt(2, 25);
		final RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder().withinRange('а', 'я').build();
		return new EstateEntity(id, RandomUtils.nextInt(1, 10),
				BigDecimal.valueOf(totalArea),
				BigDecimal.valueOf((int) (totalArea * 0.65)),
				BigDecimal.valueOf((int) (totalArea * 0.25)),
				Math.max(1, Math.round(floors * RandomUtils.nextFloat(0, 1))),
				floors,
				RandomUtils.nextInt(50, 1000),
				"Описание " + stringGenerator.generate(10),
				RandomUtils.nextInt(1, 10),
				-1L
		);
	}
}
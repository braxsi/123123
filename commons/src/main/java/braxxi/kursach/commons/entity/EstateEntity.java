package braxxi.kursach.commons.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.text.RandomStringGenerator;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EstateEntity {
	private Long id;
	private String district;
	private BigDecimal totalArea;
	private BigDecimal livingArea;
	private int floor;
	private int distanceToMetro;
	private String description;
	private Long userId;

	public EstateEntity() {
	}

	public EstateEntity(Long id, String district, BigDecimal totalArea, BigDecimal livingArea, int floor, int distanceToMetro, String description, Long userId) {
		this.id = id;
		this.district = district;
		this.totalArea = totalArea;
		this.livingArea = livingArea;
		this.floor = floor;
		this.distanceToMetro = distanceToMetro;
		this.description = description;
		this.userId = userId;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public int getFloor() {
		return this.floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
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

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public static EstateEntity generateRandom(Long id) {
		final int totalArea = RandomUtils.nextInt(5, 200);
		final RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder().withinRange('а', 'я').build();
		return new EstateEntity(id, stringGenerator.generate(10),
				BigDecimal.valueOf(totalArea),
				BigDecimal.valueOf((int) (totalArea * 0.7)),
				RandomUtils.nextInt(1, 25),
				RandomUtils.nextInt(50, 1000),
				"Описание " + stringGenerator.generate(10),
				-1L
		);
	}
}

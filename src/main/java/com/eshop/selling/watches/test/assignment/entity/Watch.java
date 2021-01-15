package com.eshop.selling.watches.test.assignment.entity;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "watch")
public class Watch {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// Using Java annotation
	@NotEmpty(message = "*Please provide a title")
	private String title;
	// Using Java annotation, not null and min
	@NotNull(message = "Please provide a price")
    @DecimalMin("1.00")
	private BigDecimal price;
	
	private String description;
	private String fountain;
	
	//Default No-argument constructor
	public Watch() {
    }
	
	//Constructor
	public Watch(String title, BigDecimal price, String description, String fountain) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
		this.fountain = fountain;
	}
	
	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public  BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFountain() {
		return fountain;
	}

	public void setFountain(String fountain) {
		this.fountain = fountain;
	}

	@Override
	public String toString() {
		return "WatchDao [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description
				+ ", fountain=" + fountain + "]";
	}
	
	
	
}

package org.java.app.db.pojo;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "This field is required")
	@Length(min = 3, max = 100, message = "Insert between 3 and 100 characters")
	@Column(unique = true, nullable = false, length = 100)
	private String name;
	
	@NotBlank(message = "This field is required")
	@Length(min = 3, max = 2000, message = "Insert between 3 and 2000 characters")
	@Lob
	@Column(columnDefinition = "text", nullable = false)
	private String description;
	
	@NotBlank(message = "This field is required")
	@Length(min = 3, max = 2000, message = "Insert between 3 and 2000 characters")
	@Lob
	@Column(columnDefinition = "text", nullable = false)
	private String url;
	
	@Positive(message = "Price must be a positive number")
	@Column(nullable = false)
	private int price;
	
	public Pizza() {};
	
	public Pizza(String name, String description, String url, int price) {
		setName(name);
		setDescription(description);
		setUrl(url);
		setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return getName() + " - " + String.format("%.02f", ((float) getPrice() / 100f)) + "€\n" + getDescription() + "\n";
	}
}

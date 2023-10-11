package org.java.app.db.pojo;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Deal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	@NotNull
	private LocalDate startDate;
	
	@Column(nullable = false)
	@NotNull
	private LocalDate endDate;
	
	@Column(length = 100)
	@Length(min = 3, max = 100)
	@NotBlank
	private String title;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pizza pizza;
	
	public Deal() {}
	
	public Deal(LocalDate startDate, LocalDate endDate, String title, Pizza pizza) {
		setStartDate(startDate);
		setEndDate(endDate);
		setTitle(title);
		setPizza(pizza);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
}

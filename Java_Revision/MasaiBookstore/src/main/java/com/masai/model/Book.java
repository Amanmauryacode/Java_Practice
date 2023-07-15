package com.masai.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "Title cannot be null")
	private String title;
	@NotEmpty(message = "Author cannot be null")
	private String author;
	@Column(unique = true)
	@Min(value = 10000,message = "Must be size greater than 5")
	private Integer isbn;
	@NotEmpty(message = "Description cannot be null")
	private String description;
	@Min(value = 0,message = "Price must greater then 0")
	private Integer price;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate publication_date;
	private boolean status;
	
}

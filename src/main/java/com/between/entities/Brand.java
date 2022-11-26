package com.between.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand {

	@Id
	public long id;

	@Column(name = "title", nullable = false)
	public String title;
}

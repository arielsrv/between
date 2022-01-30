package com.between.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand {

	@Id
	public long id;

	@Column(name = "title", nullable = false)
	public String title;
}

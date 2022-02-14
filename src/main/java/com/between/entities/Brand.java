package com.between.entities;

import javax.persistence.*;

@Entity
@Table(name = "brands")
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	@Column(name = "title", nullable = false)
	public String title;
}

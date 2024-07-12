package com.rk.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "Employee_Info")
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NonNull
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	@NonNull
	private String lastName;
	@Column(length = 20)
	@NonNull
	private String email;
	@NonNull
	private LocalDate  dob;
	@Column(length = 20)
	@NonNull
	private String gender;
	@NonNull
	@Column(length = 20)
	private String education;
	@NonNull
	@Column(length = 20)
	private String company;
	@NonNull
	private Integer experience;
	@NonNull
	private Integer Package;
}

package com.hcl.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ADRESS")
public class Adress {

	@Id
	@SequenceGenerator(name = "ADRESS_SEQ", sequenceName = "ADRESS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADRESS_SEQ")
	private int id;
	@Column(name = "HOUSE_NO")
	private String h_no;
	private String city;
	private String state;
	private String country;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "PERSON_ID")
	private Person person;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getH_no() {
		return h_no;
	}

	public void setH_no(String h_no) {
		this.h_no = h_no;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Adress [id=" + id + ", h_no=" + h_no + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", person=" + person + "]";
	}

}

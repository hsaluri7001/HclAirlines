package com.hcl.airlines.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author saluri
 *
 */
@Entity
@Table(name="INVENTORY")
public class Inventory {
	public Inventory() {
		
	}
	public Inventory(int invId, int count) {
		super();
		this.invId = invId;
		this.count = count;
	}
	@Id
	@SequenceGenerator(name="INV_SEQ_GENERATOR",sequenceName="INVENTORY_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="INV_SEQ_GENERATOR")
	private int invId;
	@Column(name="COUNT")
	private int count;
	public int getInvId() {
		return invId;
	}
	public void setInvId(int invId) {
		this.invId = invId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Inventory [invId=" + invId + ", count=" + count + "]";
	}
}

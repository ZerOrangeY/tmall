package com.entor.entity;

public class Param {
	private int id;
	private double total;
	private int oid;
	public Param(int id, double total, int oid) {
		super();
		this.id = id;
		this.total = total;
		this.oid = oid;
	}
	public Param() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	@Override
	public String toString() {
		return "Param [id=" + id + ", total=" + total + ", oid=" + oid + "]";
	}
	
	
}

package com.vti.ProductManagement.backend.entity;

public class Manufacturer {
	private int manufactureId;
	private ManufacturerName ManufacturerName;
	
	public Manufacturer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manufacturer(int manufactureId, ManufacturerName ManufacturerName) {
		super();
		this.manufactureId = manufactureId;
		this.ManufacturerName = ManufacturerName;
	}
	public int getManufactureId() {
		return manufactureId;
	}
	public void setManufactureId(int manufactureId) {
		this.manufactureId = manufactureId;
	}
	public ManufacturerName getManufacturerName() {
		return ManufacturerName;
	}
	public void setManufacturerName(ManufacturerName ManufacturerName) {
		this.ManufacturerName = ManufacturerName;
	}
	@Override
	public String toString() {
		return "Manufacturer [manufactureId=" + manufactureId + ", ManufacturerName=" + ManufacturerName + "]";
	}
	
}
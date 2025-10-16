package com.vti.ProductManagement.backend.data_layer;

import java.sql.SQLException;

import com.vti.ProductManagement.backend.entity.Manufacturer;

public interface IManufacturerRepository {

	Manufacturer getManufacturerById(int id) throws SQLException, ClassNotFoundException;
}

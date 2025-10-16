package com.vti.ProductManagement.backend.data_layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.ProductManagement.backend.entity.Manufacturer;
import com.vti.ProductManagement.backend.entity.ManufacturerName;
import com.vti.ProductManagement.utils.JDBCUtils;

public class ManufacturerRepository implements IManufacturerRepository {

	private JDBCUtils jdbcUtils;

	public ManufacturerRepository() {
		jdbcUtils = new JDBCUtils();
	}

	// Method using to get Manufacture by id
	@Override
	public Manufacturer getManufacturerById(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			// Get connection
			Connection conn = jdbcUtils.getConnection();

			// Create a statement object
			String sql = "SELECT * FROM Manufacturer WHERE ManufacturerId = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				int manufacturerId = rs.getInt(1);
				// Convert from string to enum
				String name = rs.getString(2);
				ManufacturerName manufacturerName = ManufacturerName.valueOf(name);
				Manufacturer manufacturer = new Manufacturer(manufacturerId, manufacturerName);

				return manufacturer;
			} else {
				return null;
			}
		} finally {
			// TODO: handle finally clause
			jdbcUtils.disconnect();
		}
	}

}

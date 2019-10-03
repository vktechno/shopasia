package com.product.details.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.details.model.ProductModel;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<String, Object>> getMobileProduct(JSONObject jsonObject) {
		/*int catId = (int) jsonObject.get("catId");
		int subCatId = (int) jsonObject.get("subCatId");
		String mobileBrand = (String) jsonObject.get("mobileBrand");
		String firstPrice = (String)jsonObject.get("firstPrice");
		String secondPrice = (String) jsonObject.get("secondPrice");
		
		String query = "SELECT * FROM product WHERE cat_id = ? AND (sub_cat_id = ? OR mob_brand = ? OR"
				+ " (price BETWEEN ? AND ?)";
		return jdbcTemplate.queryForList(query);*/
		return null;
	}

	@Override
	public Integer insertMobileProduct(ProductModel pm) {
		String query = "INSERT INTO product(client_id, cat_id, sub_cat_id, mob_brand, title, description, price, state, city, Neighbourhood)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, pm.getClientId());
				ps.setInt(2, pm.getCatId());
				ps.setInt(3, pm.getSubCatId());
				ps.setString(4, pm.getMobBrand());
				ps.setString(5, pm.getTitle());
				ps.setString(6, pm.getDescription());
				ps.setInt(7, pm.getPrice());
				ps.setString(8, pm.getState());
				ps.setString(9, pm.getCity());
				ps.setString(10, pm.getNeighbourhood());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer updateMobileProduct(ProductModel pm) {
		String query = "UPDATE product set cat_id = ?, sub_cat_id = ?, mob_brand = ?, title = ?, description = ?,"
				+ " price = ?, state = ?, city = ?, Neighbourhood = ? where product_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, pm.getCatId());
				ps.setInt(2, pm.getSubCatId());
				ps.setString(3, pm.getMobBrand());
				ps.setString(4, pm.getTitle());
				ps.setString(5, pm.getDescription());
				ps.setInt(6, pm.getPrice());
				ps.setString(7, pm.getState());
				ps.setString(8, pm.getCity());
				ps.setString(9, pm.getNeighbourhood());
				ps.setInt(10, pm.getProductId());
				return ps;
			}
		});
	}

	@Override
	public Integer deleteMobileProduct(ProductModel pm) {
		String query = "DELETE FROM product WHERE product_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, pm.getProductId());
				return ps;
			}
		});
	}

	@Override
	public Integer insertImage(int productId, String imageName) {
		String query = "INSERT INTO product_images(product_id, image_name) values(?,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, productId);
				ps.setString(2, imageName);
				return ps;
			}
		});
	}

	@Override
	public Integer deleteImage(int productId) {
		String query = "DELETE FROM product_images WHERE product_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, productId);
				return ps;
			}
		});
	}

	@Override
	public List<Map<String, Object>> getImage(int productId) {
		String query = "SELECT image_id as imageId, image_name as imageName FROM product_images"
				+ " WHERE product_id = ?";
		return jdbcTemplate.queryForList(query, productId);
	}

	@Override
	public List<Map<String, Object>> getTabletProduct(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertTabletProduct(ProductModel pm) {

		String query = "INSERT INTO product(client_id, cat_id, sub_cat_id, tab_type, title, description, price, state, city, Neighbourhood)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, pm.getClientId());
				ps.setInt(2, pm.getCatId());
				ps.setInt(3, pm.getSubCatId());
				ps.setString(4, pm.getTabType());
				ps.setString(5, pm.getTitle());
				ps.setString(6, pm.getDescription());
				ps.setInt(7, pm.getPrice());
				ps.setString(8, pm.getState());
				ps.setString(9, pm.getCity());
				ps.setString(10, pm.getNeighbourhood());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	
	}

	@Override
	public Integer updateTabletProduct(ProductModel pm) {
		String query = "UPDATE product set cat_id = ?, sub_cat_id = ?, tab_type = ?, title = ?, description = ?,"
				+ " price = ?, state = ?, city = ?, Neighbourhood = ? where product_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, pm.getCatId());
				ps.setInt(2, pm.getSubCatId());
				ps.setString(3, pm.getTabType());
				ps.setString(4, pm.getTitle());
				ps.setString(5, pm.getDescription());
				ps.setInt(6, pm.getPrice());
				ps.setString(7, pm.getState());
				ps.setString(8, pm.getCity());
				ps.setString(9, pm.getNeighbourhood());
				ps.setInt(10, pm.getProductId());
				return ps;
			}
		});
	}

	@Override
	public List<Map<String, Object>> getAcceProduct(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertAcceProduct(ProductModel pm) {

		String query = "INSERT INTO product(client_id, cat_id, sub_cat_id, acce_type, title, description, price, state, city, Neighbourhood)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, pm.getClientId());
				ps.setInt(2, pm.getCatId());
				ps.setInt(3, pm.getSubCatId());
				ps.setString(4, pm.getAcceType());
				ps.setString(5, pm.getTitle());
				ps.setString(6, pm.getDescription());
				ps.setInt(7, pm.getPrice());
				ps.setString(8, pm.getState());
				ps.setString(9, pm.getCity());
				ps.setString(10, pm.getNeighbourhood());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	
	}

	@Override
	public Integer updateAcceProduct(ProductModel pm) {
		String query = "UPDATE product set cat_id = ?, sub_cat_id = ?, acce_type = ?, title = ?, description = ?,"
				+ " price = ?, state = ?, city = ?, Neighbourhood = ? where product_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, pm.getCatId());
				ps.setInt(2, pm.getSubCatId());
				ps.setString(3, pm.getAcceType());
				ps.setString(4, pm.getTitle());
				ps.setString(5, pm.getDescription());
				ps.setInt(6, pm.getPrice());
				ps.setString(7, pm.getState());
				ps.setString(8, pm.getCity());
				ps.setString(9, pm.getNeighbourhood());
				ps.setInt(10, pm.getProductId());
				return ps;
			}
		});
	}

	@Override
	public List<Map<String, Object>> getFurnProduct(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertFurnProduct(ProductModel pm) {

		String query = "INSERT INTO product(client_id, cat_id, sub_cat_id, title, description, price, state, city, Neighbourhood)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, pm.getClientId());
				ps.setInt(2, pm.getCatId());
				ps.setInt(3, pm.getSubCatId());
				ps.setString(4, pm.getTitle());
				ps.setString(5, pm.getDescription());
				ps.setInt(6, pm.getPrice());
				ps.setString(7, pm.getState());
				ps.setString(8, pm.getCity());
				ps.setString(9, pm.getNeighbourhood());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	
	}

	@Override
	public Integer updateFurnProduct(ProductModel pm) {
		String query = "UPDATE product set cat_id = ?, sub_cat_id = ?, title = ?, description = ?,"
				+ " price = ?, state = ?, city = ?, Neighbourhood = ? where product_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, pm.getCatId());
				ps.setInt(2, pm.getSubCatId());
				ps.setString(3, pm.getTitle());
				ps.setString(4, pm.getDescription());
				ps.setInt(5, pm.getPrice());
				ps.setString(6, pm.getState());
				ps.setString(7, pm.getCity());
				ps.setString(8, pm.getNeighbourhood());
				ps.setInt(9, pm.getProductId());
				return ps;
			}
		});
	}

	@Override
	public List<Map<String, Object>> getMotorcycleProduct(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertMotorcycleProduct(ProductModel pm) {

		String query = "INSERT INTO product(client_id, cat_id, sub_cat_id, title, description, price, state, city, Neighbourhood,"
				+ "veh_brand, veh_model, veh_year, veh_driven, veh_fuel)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, pm.getClientId());
				ps.setInt(2, pm.getCatId());
				ps.setInt(3, pm.getSubCatId());
				ps.setString(4, pm.getTitle());
				ps.setString(5, pm.getDescription());
				ps.setInt(6, pm.getPrice());
				ps.setString(7, pm.getState());
				ps.setString(8, pm.getCity());
				ps.setString(9, pm.getNeighbourhood());
				ps.setString(10, pm.getVehBrand());
				ps.setString(11, pm.getVehModel());
				ps.setString(12, pm.getVehYear());
				ps.setString(13, pm.getVehDriven());
				ps.setString(14, pm.getVehFuel());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	
	}

	@Override
	public Integer updateMotorcycleProduct(ProductModel pm) {
		String query = "UPDATE product set cat_id = ?, sub_cat_id = ?, title = ?, description = ?,"
				+ " price = ?, state = ?, city = ?, Neighbourhood = ?, veh_brand = ?, veh_model = ?,"
				+ " veh_year = ?, veh_driven = ?, veh_fuel = ? where product_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, pm.getCatId());
				ps.setInt(2, pm.getSubCatId());
				ps.setString(3, pm.getTitle());
				ps.setString(4, pm.getDescription());
				ps.setInt(5, pm.getPrice());
				ps.setString(6, pm.getState());
				ps.setString(7, pm.getCity());
				ps.setString(8, pm.getNeighbourhood());
				ps.setString(9, pm.getVehBrand());
				ps.setString(10, pm.getVehModel());
				ps.setString(11, pm.getVehYear());
				ps.setString(12, pm.getVehDriven());
				ps.setString(13, pm.getVehFuel());
				ps.setInt(14, pm.getProductId());
				return ps;
			}
		});
	}

}
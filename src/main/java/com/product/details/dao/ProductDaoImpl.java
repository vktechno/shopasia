package com.product.details.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.details.model.ProductModel;
import com.product.details.model.RealEstateModel;

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

	@Override
	public List<RealEstateModel> getRealEstateProdut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertRealEstateProduct(RealEstateModel rem) {
		String query = "INSERT INTO product(client_id,cat_id,sub_cat_id,title,description,price,p_type,p_bedrooms,"
				+ "p_bathrooms,p_furnishing,p_con_status,p_listedby,p_sup_bu_area,p_carp_area,p_maintenance,"
				+ "p_total_floors,p_floor_no,p_car_parking,p_facing,p_project_name,p_bachelors,p_washrooms,"
				+ "p_lp_type,p_plot_area,p_length,p_breadth,p_subtype,p_meals,p_address,p_latitude,p_longitude)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, rem.getClientId());
				ps.setInt(2, rem.getCatId());
				ps.setInt(3, rem.getSubCatId());
				ps.setString(4, rem.getTitle());
				ps.setString(5, rem.getDescription());
				ps.setInt(6, rem.getPrice());
				ps.setString(7, rem.getpType());
				ps.setString(8, rem.getpBedrooms());
				ps.setString(9, rem.getpBathrooms());
				ps.setString(10, rem.getpFurnishing());
				ps.setString(11, rem.getpConStatus());
				ps.setString(12, rem.getpListedBy());
				ps.setString(13, rem.getpSupBuArea());
				ps.setString(14, rem.getpCarpArea());
				ps.setString(15, rem.getpMaintenance());
				ps.setString(16, rem.getpTotalFloors());
				ps.setString(17, rem.getpFloorNo());
				ps.setString(18, rem.getpCarParking());
				ps.setString(19, rem.getpFacing());
				ps.setString(20, rem.getpProjectName());
				ps.setString(21, rem.getpBachelors());
				ps.setString(22, rem.getpWashrooms());
				ps.setString(23, rem.getpLpType());
				ps.setInt(24, rem.getpPlotArea());
				ps.setInt(25, rem.getpLength());
				ps.setInt(26, rem.getpBreath());
				ps.setString(27, rem.getpSubType());
				ps.setString(28, rem.getpMeals());
				ps.setString(29, rem.getpAddress());
				ps.setString(30, rem.getLatitude());
				ps.setString(31, rem.getLongitude());
				return ps;
			}
		},keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public Integer updateRealEstateProduct(RealEstateModel rem) {
		String query = "UPDATE product set cat_id = ?, sub_cat_id = ? , title = ? , description = ? , price = ?,"
				+ "p_type = ? , p_bedrooms = ?, p_bathrooms = ?, p_furnishing = ?, p_con_status = ?, p_listedby = ?,"
				+ "p_sup_bu_area = ?, p_carp_area = ?, p_maintenance = ?, p_total_floors = ?, p_floor_no = ?,"
				+ "p_car_parking = ?, p_facing =?, p_project_name = ?, p_bachelors = ?, p_washrooms = ?, p_lp_type =?,"
				+ "p_plot_area =?, p_length = ?, p_breadth = ?, p_subtype = ?, p_meals = ?, p_address = ?,"
				+ "p_latitude =?, p_longitude = ? WHERE product_id = ?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, rem.getCatId());
				ps.setInt(2, rem.getSubCatId());
				ps.setString(3, rem.getTitle());
				ps.setString(4, rem.getDescription());
				ps.setInt(5, rem.getPrice());
				ps.setString(6, rem.getpType());
				ps.setString(7, rem.getpBedrooms());
				ps.setString(8, rem.getpBathrooms());
				ps.setString(9, rem.getpFurnishing());
				ps.setString(10, rem.getpConStatus());
				ps.setString(11, rem.getpListedBy());
				ps.setString(12, rem.getpSupBuArea());
				ps.setString(13, rem.getpCarpArea());
				ps.setString(14, rem.getpMaintenance());
				ps.setString(15, rem.getpTotalFloors());
				ps.setString(16, rem.getpFloorNo());
				ps.setString(17, rem.getpCarParking());
				ps.setString(18, rem.getpFacing());
				ps.setString(19, rem.getpProjectName());
				ps.setString(20, rem.getpBachelors());
				ps.setString(21, rem.getpWashrooms());
				ps.setString(22, rem.getpLpType());
				ps.setInt(23, rem.getpPlotArea());
				ps.setInt(24, rem.getpLength());
				ps.setInt(25, rem.getpBreath());
				ps.setString(26, rem.getpSubType());
				ps.setString(27, rem.getpMeals());
				ps.setString(28, rem.getpAddress());
				ps.setString(29, rem.getLatitude());
				ps.setString(30, rem.getLongitude());
				ps.setInt(31, rem.getProductId());
				return ps;
			}
		});
	}

	@Override
	public List<ProductModel> getCommonProductDetails(Map<String, Object> map) {
		String query = "";
		if(map.get("catId") != null && map.get("catId") != "" && map.get("subCatId") == null && map.get("subCatId") == ""){
			query = "SELECT * FROM product WHERE cat_id = '"+map.get("catId")+"'";
		}else if(map.get("catId") != null && map.get("catId") != "" && map.get("subCatId") != null && map.get("subCatId") != ""){
			query = "SELECT * FROM product WHERE cat_id = '"+map.get("catId")+"' OR sub_cat_id = '"+map.get("subCatId")+"'";
		}else{
			query = "SELECT * FROM product";
		}
		
		return jdbcTemplate.query(query,new RowMapper<ProductModel>(){

			@Override
			public ProductModel mapRow(ResultSet rs, int arg1) throws SQLException {
				ProductModel pm = new ProductModel();
				pm.setProductId(rs.getInt("product_id"));
				pm.setClientId(rs.getInt("client_id"));
				pm.setCatId(rs.getInt("cat_id"));
				pm.setSubCatId(rs.getInt("sub_cat_id"));
				pm.setTitle(rs.getString("title"));
				pm.setDescription(rs.getString("description"));
				pm.setPrice(rs.getInt("price"));
				pm.setVehBrand(rs.getString("veh_brand"));
				pm.setVehModel(rs.getString("veh_model"));
				pm.setVehYear(rs.getString("veh_year"));
				pm.setVehDriven(rs.getString("veh_driven"));
				pm.setVehFuel(rs.getString("veh_fuel"));
				pm.setMobBrand(rs.getString("mob_brand"));
				pm.setTabType(rs.getString("tab_type"));
				pm.setAcceType(rs.getString("acce_type"));
				pm.setpType(rs.getString("p_type"));
				pm.setpBedrooms(rs.getString("p_bedrooms"));
				pm.setpBathrooms(rs.getString("p_bathrooms"));
				pm.setpFurnishing(rs.getString("p_furnishing"));
				pm.setpConStatus(rs.getString("p_con_status"));
				pm.setpListedBy(rs.getString("p_listedby"));
				pm.setpListedBy(rs.getString("p_sup_bu_area"));
				pm.setpCarpArea(rs.getString("p_carp_area"));
				pm.setpMaintenance(rs.getString("p_maintenance"));
				pm.setpTotalFloors(rs.getString("p_total_floors"));
				pm.setpFloorNo(rs.getString("p_floor_no"));
				pm.setpCarParking(rs.getString("p_car_parking"));
				pm.setpFacing(rs.getString("p_facing"));
				pm.setpProjectName(rs.getString("p_project_name"));
				pm.setpBachelors(rs.getString("p_bachelors"));
				pm.setpWashrooms(rs.getString("p_washrooms"));
				pm.setpLpType(rs.getString("p_lp_type"));
				pm.setpPlotArea(rs.getString("p_plot_area"));
				pm.setpLength(rs.getString("p_length"));
				pm.setpBreath(rs.getString("p_breadth"));
				pm.setpSubType(rs.getString("p_subtype"));
				pm.setpMeals(rs.getString("p_meals"));
				pm.setpAddress(rs.getString("p_address"));
				pm.setLatitude(rs.getString("p_latitude"));
				pm.setLongitude(rs.getString("p_latitude"));
				pm.setState(rs.getString("state"));
				pm.setCity(rs.getString("city"));
				pm.setNeighbourhood(rs.getString("Neighbourhood"));
				return pm;
			}
			
		});
	}

}

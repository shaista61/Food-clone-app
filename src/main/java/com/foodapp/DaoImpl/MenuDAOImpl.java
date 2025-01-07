package com.foodapp.DaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.Dao.MenuDAO;
import com.foodapp.model.Menu;
import com.tap.connection.Connect;

public class MenuDAOImpl implements MenuDAO {
	 private static final String InsertQuery = "INSERT INTO menu (restaurant_id, menu_id, name, description, price, is_available, image_path) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    private static final String FetchAllQuery = "SELECT * FROM menu";
	    private static final String FetchOneQuery = "SELECT * FROM menu WHERE menu_id = ?";
	    private static final String UpdateAvailabilityQuery = "UPDATE menu SET is_available = ? WHERE menu_id = ?";
	    private static final String DeleteQuery = "DELETE FROM menu WHERE menu_id = ?";
	    private static final String FetchDeatilsBasedRId="select * from menu where restaurant_Id=?";

	    private static Connection con = Connect.connect();
	    private PreparedStatement pstmt;
	    private Statement stmt;
	    private ResultSet resultSet;
	    private ArrayList<Menu> menuItems = new ArrayList<Menu>();
//	    @Override
	    public int insert(Menu menuItem) {
	        try {
	            pstmt = con.prepareStatement(InsertQuery);
	            pstmt.setInt(1, menuItem.getRestaurantId());
	            pstmt.setInt(2, menuItem.getMenuId());
	            pstmt.setString(3, menuItem.getName());
	            pstmt.setString(4, menuItem.getDescription());
	            pstmt.setInt(5, menuItem.getPrice());
	            pstmt.setInt(6, menuItem.getIsAvailable());
	            pstmt.setString(7, menuItem.getImagePath());
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }
	    
	    
	    public ArrayList<Menu> fetchAll(){
	        try {
	            stmt = con.createStatement();
	            resultSet = stmt.executeQuery(FetchAllQuery);
	            while (resultSet.next()) {
	                menuItems.add(new Menu(
	                    resultSet.getInt("restaurant_id"),
	                    resultSet.getInt("menu_id"),
	                    resultSet.getString("name"),
	                    resultSet.getString("description"),
	                    resultSet.getInt("price"),
	                    resultSet.getInt("is_available"),
	                    resultSet.getString("image_path")
	                ));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return menuItems;
	    }
	    @Override
	    public List<Menu> fetchAllDetailsBasedOnRid(int restaurant_Id) {
	        List<Menu> menuList = new ArrayList<>();
	        try {
	            pstmt = con.prepareStatement(FetchDeatilsBasedRId);
	            pstmt.setInt(1, restaurant_Id);
	            resultSet = pstmt.executeQuery();
	            while (resultSet.next()) {
	            	menuList.add(new Menu(
	                    resultSet.getInt("restaurant_id"),
	                    resultSet.getInt("menu_id"),
	                    resultSet.getString("name"),
	                    resultSet.getString("description"),
	                    resultSet.getInt("price"),
	                    resultSet.getInt("Is_Available"),
	                    resultSet.getString("image_path")
	                ));
	      
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return menuList;
	    }

	    
	    
	    public  Menu fetchOne(int menuId) {
	        try {
	            pstmt = con.prepareStatement(FetchOneQuery);
	            pstmt.setInt(1, menuId);
	            resultSet = pstmt.executeQuery();
	            if (resultSet.next()) {
	            	return new Menu(
	                        resultSet.getInt("restaurant_Id"),
	                        resultSet.getInt("menu_Id"),
	                        resultSet.getString("name"),
	                        resultSet.getString("description"),
	                        resultSet.getInt("price"),
	                        resultSet.getInt("Is_Available"),
	                        resultSet.getString("Image_Path")
	                );
	                		}
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    
	    
	    @Override
	    public int updateAvailability(int menuId, int isAvailable) {
	        try {
	            pstmt = con.prepareStatement(UpdateAvailabilityQuery);
	            pstmt.setInt(1, isAvailable);
	            pstmt.setInt(2, menuId);
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

	    @Override
	    public int delete(int menuId) {
	        try {
	            pstmt = con.prepareStatement(DeleteQuery);
	            pstmt.setInt(1, menuId);
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

		}


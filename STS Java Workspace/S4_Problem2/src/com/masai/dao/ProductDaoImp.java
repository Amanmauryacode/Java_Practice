package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.utility.DBUtil;

public class ProductDaoImp implements ProductDao {

	@Override
	public String addProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		String msg = "Not Inserted ";
		
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?,?)");
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setInt(3, product.getPrice());
			ps.setInt(4, product.getQuantity());
			
			int x = ps.executeUpdate();
			
			if(x> 0)
				msg = "Product Data Inserted Sucessfully";
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			msg = e.getMessage();
		}
		
		return msg;
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		List<Product> products = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("productId");
				String name = rs.getString("productName");
				int price = rs.getInt("price");
				int Quantity = rs.getInt("quantity");
				
				Product prod = new Product();
				
				prod.setProductId(id);
				prod.setProductName(name);
				prod.setPrice(price);
				prod.setQuantity(Quantity);
				
				products.add(prod);
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		if(products.size()==0)throw new ProductException("No Record Found !");
		
		return products;
	}

	@Override
	public List<Product> getAllProductQuantityLessThan(int quantity) throws ProductException {
		List<Product> products = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select * from product where quantity < ?");
			
			ps.setInt(1, quantity);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("productId");
				String name = rs.getString("productName");
				int price = rs.getInt("price");
				int Quantity = rs.getInt("quantity");
				
				Product prod = new Product();
				
				prod.setProductId(id);
				prod.setProductName(name);
				prod.setPrice(price);
				prod.setQuantity(Quantity);
				
				products.add(prod);
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		if(products.size()==0)throw new ProductException("No Record Found For Quantity less than : " +quantity);
		
		return products;
	}

	@Override
	public String addProductQuantity(int productId, int Quantity) throws ProductException {
		String msg = "Not Updated";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("update product set quantity = ? where productId = ?");
			
			ps.setInt(1, Quantity);
			ps.setInt(2, productId);
			
			int x = ps.executeUpdate();
			
			if(x>0)
				msg = "Updated Sucessfully ProductId : "+ productId+" with Quantity : "+Quantity;
			
			if(x==0)throw new ProductException("Product not Found With ID : " + productId);
			
		} catch (SQLException e) {
			// TODO: handle exception
			msg = e.getMessage();
		}
		
		
		return msg;
	}

	@Override
	public String deleteProductByProductName(String pname) throws ProductException {
		String msg = "Not Deleted";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("delete from product where productName = ?");
			
			ps.setString(1, pname);
			
			int x = ps.executeUpdate();
			
			if(x>0)
				msg = "Sucessfully Deleted Product : "+pname;
			else{
				throw new ProductException("Product not found with name : "+pname);			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			msg = e.getMessage();
		}
		
		return msg;
	}

	@Override
	public Product getProductByProductName(String pname) throws ProductException {
		Product product = null;
		
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select * from product where productName = ?");
			
			ps.setString(1, pname);
			ResultSet rs = ps.executeQuery();
			
			boolean flag = true;
			
			if(rs.next()) {
				flag = false;
				int id = rs.getInt("productId");
				String name = rs.getString("productName");
				int price = rs.getInt("price");
				int Quantity = rs.getInt("quantity");
				
				product = new Product();
				
				product.setProductId(id);
				product.setProductName(name);
				product.setPrice(price);
				product.setQuantity(Quantity);
				
			}
			
			if(flag) throw new ProductException("Product not found with name : "+pname); 
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		return product;
	}

	@Override
	public int deleteProductWhoseNameStart(String name) throws ProductException {
		
		int x = 0;
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("delete from product where productName LIKE '"+name+"%'");
			
			
			x = ps.executeUpdate();
			if(x== 0)throw new ProductException("Product not found");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return x ;
	}

}

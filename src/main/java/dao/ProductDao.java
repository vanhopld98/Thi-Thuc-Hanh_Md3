package dao;

import config.DBConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao<Product> {
    public static final String UPDATE_PRODUCT_SQL = "update product set name = ?, color = ? , price = ? , quantity = ? , description = ?,id_category=? where id = ?;";
    public static final String ADD_PRODUCT_SQL = "insert into product( name, color, price, quantity, description,id_category) VALUES (?,?,?,?,?,?);";
    public static final String SELECT_PRODUCT_SQL = "select * from productDetail where id = ?;";
    public static final String DELETE_PRODUCT_SQL = "delete from product where id = ?;";
    Connection connection = DBConnection.getConnection();

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from productDetail");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String categoryName = rs.getString("categoryName");
                productList.add(new Product(id, name, price, quantity, color, description, categoryName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    @Override
    public boolean update(int id, Product product) {
        boolean rowUpdated = false;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);
            statement.setString(1, product.getName());
            statement.setString(2, product.getColor());
            statement.setInt(3, product.getPrince());
            statement.setInt(4, product.getQuantity());
            statement.setString(5, product.getDescription());
            statement.setInt(6,product.getCategoryId());
            statement.setInt(7, id);
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean add(Product product) {
        boolean rowAdd = false;
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_PRODUCT_SQL);
            statement.setString(1, product.getName());
            statement.setString(2, product.getColor());
            statement.setInt(3, product.getPrince());
            statement.setInt(4, product.getQuantity());
            statement.setString(5, product.getDescription());
            statement.setInt(6,product.getCategoryId());
            rowAdd = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAdd;
    }

    @Override
    public Product findById(int id) {
        Product product= new Product();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_SQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String categoryName = rs.getString("categoryName");
                product = new Product(id1, name, price, quantity, color, description, categoryName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findByName(String searchName) {
        String searchValue = "%" + searchName + "%";
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from productDetail where name like ?;");
            statement.setString(1,searchValue);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String categoryName = rs.getString("categoryName");
                productList.add(new Product(id, name, price, quantity, color, description, categoryName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }


}

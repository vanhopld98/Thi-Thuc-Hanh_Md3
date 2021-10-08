package dao;

import config.DBConnection;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoryDao implements IProductDao<Category> {
    Connection connection = DBConnection.getConnection();
    @Override
    public List<Category> getAll() {
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select  * from category");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                categoryList.add(new Category(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(int id, Category category) {
        return false;
    }

    @Override
    public boolean add(Category category) {
        return false;
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public List<Category> findByName(String searchName) {
        return null;
    }
}

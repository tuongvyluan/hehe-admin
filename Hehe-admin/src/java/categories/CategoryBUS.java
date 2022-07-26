/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package categories;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luan Tuong Vy
 */
public class CategoryBUS {

    private CategoryDAO dao;

    public ArrayList<CategoryModel> getCategories(int pageNumber, int rowsOfPage) throws SQLException {
        dao = new CategoryDAO();
        ArrayList<CategoryModel> list = dao.get(pageNumber, rowsOfPage);
        return list;
    }
    
    public ArrayList<CategoryModel> getCategoriesChecked(int pageNumber, int rowsOfPage) throws SQLException {
        dao = new CategoryDAO();
        ArrayList<CategoryModel> list = dao.getChecked(pageNumber, rowsOfPage);
        return list;
    }
    
    public ArrayList<CategoryModel> getCategories() throws SQLException {
        dao = new CategoryDAO();
        ArrayList<CategoryModel> list = dao.getCategories();
        return list;
    }
}

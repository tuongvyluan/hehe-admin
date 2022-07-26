/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class CategoryDAO {

    private CategoryModel categoryModel;

    //CategoryModel fields
    private final String FIELDS = "Id, Name, Description,Status";

    //Pagination
    private final String DECLARE_PAGINATION = "DECLARE @PageNumber as INT "
            + "DECLARE @RowsOfPage as INT " + "SET @PageNumber = ? "
            + "SET @RowsOfPage = ? ";

    private final String PAGINATION = "OFFSET (@PageNumber - 1) * @RowsOfPage "
            + "ROWS FETCH NEXT @RowsOfPage ROWS ONLY";

    //SQL query
    private String GET_CATEGORIES = DECLARE_PAGINATION + "SELECT " + FIELDS
            + " FROM Category ORDER BY UpdatedAt " + PAGINATION;

    private String GET_CATEGORIES_CHECKED = DECLARE_PAGINATION + "SELECT " + FIELDS
            + " FROM Category WHERE Status = 'Active' ORDER BY UpdatedAt " + PAGINATION;

    private String GET_ALL_CATEGORIES = "SELECT " + FIELDS
            + " FROM Category ORDER BY UpdatedAt ";

    public ArrayList<CategoryModel> get(int pageNumber, int rowsOfPage) throws SQLException {
        ArrayList<CategoryModel> list = new ArrayList<>();
        if (pageNumber <= 0) {
            pageNumber = 1;
        }

        if (rowsOfPage <= 0) {
            rowsOfPage = 1;
        }

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_CATEGORIES);
                ptm.setInt(1, pageNumber);
                ptm.setInt(2, rowsOfPage);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    categoryModel = new CategoryModel();
                    categoryModel.setCategoryId(rs.getInt("Id"));
                    categoryModel.setCategoryName(rs.getString("Name"));
                    categoryModel.setDescription(rs.getString("Description"));
                    list.add(categoryModel);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;

    }

    public ArrayList<CategoryModel> getChecked(int pageNumber, int rowsOfPage) throws SQLException {
        ArrayList<CategoryModel> list = new ArrayList<>();
        if (pageNumber <= 0) {
            pageNumber = 1;
        }

        if (rowsOfPage <= 0) {
            rowsOfPage = 1;
        }

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_CATEGORIES_CHECKED);
                ptm.setInt(1, pageNumber);
                ptm.setInt(2, rowsOfPage);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    categoryModel = new CategoryModel();
                    categoryModel.setCategoryId(rs.getInt("Id"));
                    categoryModel.setCategoryName(rs.getString("Name"));
                    categoryModel.setDescription(rs.getString("Description"));
                    list.add(categoryModel);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;

    }

    public ArrayList<CategoryModel> getCategories() throws SQLException {
        ArrayList<CategoryModel> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL_CATEGORIES);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    categoryModel = new CategoryModel();
                    categoryModel.setCategoryId(rs.getInt("Id"));
                    categoryModel.setCategoryName(rs.getString("Name"));
                    categoryModel.setDescription(rs.getString("Description"));
                    list.add(categoryModel);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public static boolean createCAtegory(String name, String description, String status) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO Category (Name, Description,Status) VALUES (?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, description);
                pst.setString(3, status);

                int rs = pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean updateCategoryStatus(int id, String status) {
        Connection cn = null;
        CategoryModel crs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update Category set Status = ? where [Id] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, status);
                pst.setInt(2, id);
                pst.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean updateCategory(int id, String name, String description) {
        Connection cn = null;
        CategoryModel crs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update Category set Name = ?, Description = ? where [Id] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, description);
                pst.setInt(3, id);
                pst.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<CategoryModel> getCategoryBySearch(String name) {
        ArrayList<CategoryModel> list = new ArrayList<>();
        Connection cn = null;
        CategoryModel cate = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select [Id],[Name],[Description],"
                        + "[Status] from Category where [Name] like CONCAT ('%',?,'%') ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);

                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String Name = rs.getString("Name");
                    String des = rs.getString("Description");
                    String Status = rs.getString("Status");
                    cate = new CategoryModel(id, Name, des, Status);
                    list.add(cate);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courses;

import authors.AuthorModel;
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
public class CourseDAO {

    private CourseModel course;

    //Fields
    private final String COURSE_DTO_FIELDS = "Id, Name, CategoryId";
    private final String COURSE_MODEL_FIELDS = "Id, Name,"
            + "Description,Status, Price, Duration";

    //Pagination
    private final String DECLARE_PAGINATION = "DECLARE @PageNumber as INT "
            + "DECLARE @RowsOfPage as INT " + "SET @PageNumber = ? "
            + "SET @RowsOfPage = ? ";

    private final String PAGINATION = "OFFSET (@PageNumber - 1) * @RowsOfPage "
            + "ROWS FETCH NEXT @RowsOfPage ROWS ONLY";

    //SQL query
    private final String GET_COURSES = DECLARE_PAGINATION + "SELECT " + COURSE_MODEL_FIELDS
            + " FROM Course ORDER BY UpdatedAt " + PAGINATION;
    private final String GET_COURSES_BY_CATEGORY = DECLARE_PAGINATION + "SELECT Id, Name"
            + " FROM Course WHERE CategoryId = ? ORDER BY UpdatedAt " + PAGINATION;
    private final String GET_COURSE = "SELECT " + COURSE_MODEL_FIELDS
            + " FROM Course WHERE Id=?";

    public ArrayList<CourseModel> get(int pageNumber, int rowsOfPage) throws SQLException {
        ArrayList<CourseModel> list = new ArrayList<>();
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
                ptm = conn.prepareStatement(GET_COURSES);
                ptm.setInt(1, pageNumber);
                ptm.setInt(2, rowsOfPage);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    course = new CourseModel();
                    course.setCourseId(rs.getInt("Id"));
                    course.setCourseName(rs.getString("Name"));
                    course.setDescription(rs.getString("Description"));
                    course.setStatus(rs.getString("Status"));
                    course.setPrice(rs.getDouble("Price"));
                    course.setDuration(rs.getDouble("Duration"));
                    list.add(course);
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

    public ArrayList<CourseModel> getByCategory(int categoryId, int pageNumber, int rowsOfPage) throws SQLException {
        ArrayList<CourseModel> list = new ArrayList<>();
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
                ptm = conn.prepareStatement(GET_COURSES_BY_CATEGORY);
                ptm.setInt(1, pageNumber);
                ptm.setInt(2, rowsOfPage);
                ptm.setInt(3, categoryId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    course = new CourseModel();
                    course.setCourseId(rs.getInt("Id"));
                    course.setCourseName(rs.getString("Name"));
                    list.add(course);
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

    public CourseModel get(int courseId) throws SQLException {
        CourseModel course = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_COURSE);
                ptm.setInt(1, courseId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    course = new CourseModel();
                    course.setCourseId(rs.getInt("Id"));
                    course.setCourseName(rs.getString("Name"));
                    course.setCategoryId(rs.getInt("CategoryId"));
                    course.setAuthorId(rs.getInt("AuthorId"));
                    course.setDescription(rs.getString("Description"));
                    course.setPrice(rs.getDouble("Price"));
                    course.setDuration(rs.getDouble("Duration"));
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
        return course;
    }

    public static boolean createCourse(int authorId, int categoryId, String name, String description, String status, double price, double duration) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO Course (AuthorId, CategoryId, [Name], [Description], [Status], Price, Duration) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, authorId);
                pst.setInt(2, categoryId);
                pst.setString(3, name);
                pst.setString(4, description);
                pst.setString(5, status);
                pst.setDouble(6, price);
                pst.setDouble(7, duration);
                int rs = pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean editCourse(int courseId, int newCategoryId, String newName, String newDescription, String newStatus, double newPrice, double newDuration) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Course SET CategoryId = ?, Name = ?, Description = ?, Status = ?, Price = ?, Duration = ? "
                        + "WHERE Id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, newCategoryId);
                pst.setString(2, newName);
                pst.setString(3, newDescription);
                pst.setString(4, newStatus);
                pst.setDouble(5, newPrice);
                pst.setDouble(6, newDuration);
                pst.setInt(7, courseId);
                int rs = pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean deleteCourse(int courseId) {
        Connection cn = null;
        CourseDTO course = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "DELETE FROM Course WHERE Id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, courseId);
                int rs = pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean updateCourseStatus(int id, String status) {
        Connection cn = null;
        CourseModel crs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update Course set Status = ? where [Id] = ?";
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

    public static List<CourseModel> getCourseBySearch(String name) {
        ArrayList<CourseModel> list = new ArrayList<>();
        Connection cn = null;
        CourseModel crs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select Id, Name,"
                        + "Description,Status, Price, Duration from Course where [Name] like CONCAT('%',?,'%')";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);

                ResultSet rs = pst.executeQuery();
                while(rs.next()) {
                    int id = rs.getInt("Id");
                    String CourseName = rs.getString("Name");
                    String Description = rs.getString("Description");
                    String Status = rs.getString("Status");
                    double Price = rs.getDouble("Price");
                    double Duration = rs.getDouble("Duration");
                    crs = new CourseModel(id, CourseName, Description, Status, Price, Duration);
                    list.add(crs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

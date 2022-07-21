/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class CourseDAO {

    private CourseDTO courseDTO;

    //Fields
    private final String COURSE_DTO_FIELDS = "Id, Name, CategoryId";
    private final String COURSE_MODEL_FIELDS = "Id, Name, CategoryId, AuthorId,"
            + "Description, Price, Duration";

    //Pagination
    private final String DECLARE_PAGINATION = "DECLARE @PageNumber as INT "
            + "DECLARE @RowsOfPage as INT " + "SET @PageNumber = ? "
            + "SET @RowsOfPage = ? ";

    private final String PAGINATION = "OFFSET (@PageNumber - 1) * @RowsOfPage "
            + "ROWS FETCH NEXT @RowsOfPage ROWS ONLY";

    //SQL query
    private final String GET_COURSES = DECLARE_PAGINATION + "SELECT " + COURSE_DTO_FIELDS
            + " FROM Course ORDER BY UpdatedAt " + PAGINATION;
    private final String GET_COURSES_BY_CATEGORY = DECLARE_PAGINATION + "SELECT Id, Name"
            + " FROM Course WHERE CategoryId = ? ORDER BY UpdatedAt " + PAGINATION;
    private final String GET_COURSES_BY_AUTHOR = "SELECT Id, Name"
            + " FROM Course WHERE AuthorId = ? ORDER BY UpdatedAt ";
    private final String GET_COURSES_BY_AUTHOR_CATE = "SELECT Id, Name, Duration"
            + " FROM Course WHERE AuthorId = ? AND CategoryId = ? ORDER BY UpdatedAt ";
    private final String GET_COURSE = "SELECT " + COURSE_MODEL_FIELDS
            + " FROM Course WHERE Id=?";

    public ArrayList<CourseDTO> get(int pageNumber, int rowsOfPage) throws SQLException {
        ArrayList<CourseDTO> list = new ArrayList<>();
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
                    courseDTO = new CourseDTO();
                    courseDTO.setCourseId(rs.getInt("Id"));
                    courseDTO.setCourseName(rs.getString("Name"));
                    courseDTO.setCategoryId(rs.getInt("CategoryId"));
                    list.add(courseDTO);
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

    public ArrayList<CourseDTO> getByCategory(int categoryId, int pageNumber, int rowsOfPage) throws SQLException {
        ArrayList<CourseDTO> list = new ArrayList<>();
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
                    courseDTO = new CourseDTO();
                    courseDTO.setCourseId(rs.getInt("Id"));
                    courseDTO.setCourseName(rs.getString("Name"));
                    list.add(courseDTO);
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

    public ArrayList<CourseDTO> getByAuthor(int authorId) throws SQLException {
        ArrayList<CourseDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_COURSES_BY_AUTHOR);
                ptm.setInt(1, authorId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    courseDTO = new CourseDTO();
                    courseDTO.setCourseId(rs.getInt("Id"));
                    courseDTO.setCourseName(rs.getString("Name"));
                    list.add(courseDTO);
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

    public ArrayList<CourseDTO> getByAuthorCate(int authorId, int categoryId) throws SQLException {
        ArrayList<CourseDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT CO.Id AS Id, CO.AuthorId AS AuthorId, "
                        + "CO.CategoryId AS CategoryId, CO.[Name] AS CourseName, CO.Status AS CourseStatus, "
                        + "CO.Duration AS CourseDuration, CA.Name AS CategoryName, CA.Status AS CategoryStatus\n"
                        + "FROM Course CO JOIN Category CA ON CO.CategoryId = CA.Id \n"
                        + "WHERE CO.AuthorId = ? AND CO.CategoryId = ?");
                ptm.setInt(1, authorId);
                ptm.setInt(2, categoryId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int courseId = rs.getInt("Id");
                    String courseName = rs.getString("CourseName");
                    String courseStatus = rs.getString("CourseStatus");
                    double duration = rs.getDouble("CourseDuration");
                    String categoryName = rs.getString("CategoryName");
                    String categoryStatus = rs.getString("CategoryStatus");
                    list.add(new CourseDTO(courseId, categoryId, authorId, courseName, duration, courseStatus, categoryStatus, categoryName));
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
                String sql = "UPDATE Course SET Status = 'Inactive' WHERE Id = ?";
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

    public static boolean reactivateCourse(int courseId) {
        Connection cn = null;
        CourseDTO course = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Course SET Status = 'Active' WHERE Id = ?";
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
}

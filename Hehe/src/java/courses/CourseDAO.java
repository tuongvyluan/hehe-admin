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
    private final String COURSE_DTO_FIELDS = "Id, CourseId, Name";
    
    //Pagination
    private final String DECLARE_PAGINATION = "DECLARE @PageNumber as INT " +
            "DECLARE @RowsOfPage as INT " + "SET @PageNumber = ? "
            + "SET @RowsOfPage = ? ";

    private final String PAGINATION = "OFFSET (@PageNumber - 1) * @RowsOfPage "
            + "ROWS FETCH NEXT @RowsOfPage ROWS ONLY";
    
    //SQL query
    private String GET_COURSES = DECLARE_PAGINATION + "SELECT " + COURSE_DTO_FIELDS
            + " FROM Course ORDER BY UpdatedAt " + PAGINATION;
    
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
    
}

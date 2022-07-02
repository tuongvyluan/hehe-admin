/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sections;

import courses.CourseDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class SectionDAO {
    
    private SectionDTO sectionDTO;
    
    //Fields
    private final String SECTION_DTO_FIELDS = "Id, Name, DisplayIndex";
    
    //Sql queries
    private final String GET_SECTIONS_BY_COURSE = "SELECT " + SECTION_DTO_FIELDS
            + " FROM Section WHERE CourseId=? ORDER BY DisplayIndex";
    
    private final String GET_SECTIONS = "SELECT" + SECTION_DTO_FIELDS + "FROM Section";
    
    public ArrayList<SectionDTO> get(int courseId) throws SQLException {
        ArrayList<SectionDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_SECTIONS_BY_COURSE);
                ptm.setInt(1, courseId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    sectionDTO = new SectionDTO();
                    sectionDTO.setCourseId(courseId);
                    sectionDTO.setSectionId(rs.getInt("Id"));
                    sectionDTO.setSectionName(rs.getString("Name"));
                    sectionDTO.setDisplayIndex(rs.getInt("DisplayIndex"));
                    list.add(sectionDTO);
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
    
    public ArrayList<SectionDTO> get() throws SQLException {
        ArrayList<SectionDTO> list = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT Id, Name, DisplayIndex FROM SECTION";
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    sectionDTO = new SectionDTO();
                    sectionDTO.setSectionId(rs.getInt("Id"));
                    sectionDTO.setSectionName(rs.getString("Name"));
                    sectionDTO.setDisplayIndex(rs.getInt("DisplayIndex"));
                    list.add(sectionDTO);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public static boolean createSection(int sectionCourseId, String sectionName, String sectionDescription, int sectionDisplayIndex) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO Section (CourseId, Name, Description, DisplayIndex) VALUES (?,?,?,?)"; 
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, sectionCourseId);
                pst.setString(2, sectionName);
                pst.setString(3, sectionDescription);
                pst.setInt(4, sectionDisplayIndex);
                int rs = pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean deleteSection(int sectionId) {
        Connection cn = null;
        CourseDTO section = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "DELETE FROM Section WHERE Id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, sectionId);
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

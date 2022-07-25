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
    private final String SECTION_DTO_FIELDS = "Id, Name, DisplayIndex, Status";

    //Sql queries
    private final String GET_SECTIONS_BY_COURSE = "SELECT " + SECTION_DTO_FIELDS
            + " FROM Section WHERE CourseId=? ORDER BY DisplayIndex";
    
    private final String GET_SECTIONS_BY_COURSE_CHECKED = "SELECT " + SECTION_DTO_FIELDS
            + " FROM Section WHERE CourseId = ? AND Status = 'Active' ORDER BY DisplayIndex";

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
                    sectionDTO.setStatus(rs.getString("Status"));
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
    
    public ArrayList<SectionDTO> getWithChecked(int courseId) throws SQLException {
        ArrayList<SectionDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_SECTIONS_BY_COURSE_CHECKED);
                ptm.setInt(1, courseId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    sectionDTO = new SectionDTO();
                    sectionDTO.setCourseId(courseId);
                    sectionDTO.setSectionId(rs.getInt("Id"));
                    sectionDTO.setSectionName(rs.getString("Name"));
                    sectionDTO.setDisplayIndex(rs.getInt("DisplayIndex"));
                    sectionDTO.setStatus(rs.getString("Status"));
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

    public static boolean createSection(int sectionCourseId, String sectionName, String sectionDescription, String status, int sectionDisplayIndex) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO Section (CourseId, Name, Description, Status, DisplayIndex) VALUES (?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, sectionCourseId);
                pst.setString(2, sectionName);
                pst.setString(3, sectionDescription);
                pst.setString(4, status);
                pst.setInt(5, sectionDisplayIndex);
                int rs = pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static int getDisplayIndex(int courseId){
        Connection cn = null;
        ResultSet rs = null;
        int displayIndex = 0;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT TOP 1 DisplayIndex FROM Section WHERE CourseId = ? ORDER BY DisplayIndex DESC";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, courseId);
                rs = pst.executeQuery();
                if (rs.next()) {
                    displayIndex = rs.getInt("DisplayIndex");
                }
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -100;
        }
        return displayIndex;
    }

    public static boolean editSection(int id, String name, String description, int displayIndex) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Section SET Name = ?, Description = ?, DisplayIndex = ? WHERE Id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                pst.setString(2, name);
                pst.setString(3, description);
                pst.setInt(4, displayIndex);
                int rs = pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean editSectionName(int id, String name) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Section SET Name = ? WHERE Id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setInt(2, id);
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
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Section SET Status = 'Inactive' FROM Section WHERE Id = ?";
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

    public static boolean AddSectionToCourse(int courseId, int sectionId) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Section SET CourseId = ? WHERE Id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, courseId);
                pst.setInt(2, sectionId);
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

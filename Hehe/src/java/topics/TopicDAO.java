/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package topics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author Luan Tuong Vy
 */
public class TopicDAO {
    // SQL query
    private final String GET_TOPIC = "SELECT TopicId, SectionId, CourseId, Name, "
            + "Description, Status, DisplayIndex FROM Topic";
    
    public static ArrayList<TopicDTO> get() throws SQLException {
        ArrayList<TopicDTO> list = new ArrayList<>();
        TopicDTO topic = null;
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT Id, SectionId, CourseId, Name, "
            + "Description, Status, DisplayIndex FROM Topic";
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    int topicId = rs.getInt("Id");
                    int sectionId = rs.getInt("SectionId");
                    int courseId = rs.getInt("CourseId");
                    String name = rs.getString("Name");
                    String description = rs.getString("Description");
                    String status = rs.getString("Status");
                    int displayIndex = rs.getInt("DisplayIndex");
                    topic = new TopicDTO(topicId, sectionId, courseId, name, description, status, displayIndex);
                    list.add(topic);
                }
            }
        } catch (Exception e) {
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
    
    public static boolean createTopic(int sectionId, int courseId, String name, String description, String status, int displayIndex) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO Topic (SectionId, CourseId, Name, "
                        + "Description, Status, DisplayIndex) VALUES (?,?,?,?,?,?)"; 
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, sectionId);
                pst.setInt(2, courseId);
                pst.setString(3, name);
                pst.setString(4, description);
                pst.setString(5, status);
                pst.setInt(6, displayIndex);
                int rs = pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean editTopic(int topicId, int sectionId, int courseId, String name, String description, String status, int displayIndex) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Topic SET SectionId = ?, CourseId = ?, Name = ?, Description = ?, Status = ?, DisplayIndex = ? WHERE Id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, sectionId);
                pst.setInt(2, courseId);
                pst.setString(3, name);
                pst.setString(4, description);
                pst.setString(5, status);
                pst.setInt(6, displayIndex);
                pst.setInt(7, topicId);
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

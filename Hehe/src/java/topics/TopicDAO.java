/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package topics;

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
public class TopicDAO {
    
    private TopicDTO topicDTO;
    
    //Fields
    private final String TOPIC_DTO_FIELDS = "Id, SectionId, CourseId, Name, DisplayIndex";
    private final String TOPIC_MODEL_FIELDS = "Id, SectionId, CourseId, Name, DisplayIndex, Description, Status";
    
    //Sql queries
    
    private final String GET_TOPIC_BY_SECTION = "SELECT " + TOPIC_DTO_FIELDS
            + " FROM Topic WHERE SectionId=? ORDER BY DisplayIndex";
    private final String GET_TOPIC = "SELECT " + TOPIC_MODEL_FIELDS
            + " FROM Topic WHERE Id=?";
    
    public ArrayList<TopicDTO> getBySection(int sectionId) throws SQLException {
        ArrayList<TopicDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_TOPIC_BY_SECTION);
                ptm.setInt(1, sectionId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    topicDTO = new TopicDTO();
                    topicDTO.setTopicId(rs.getInt("Id"));
                    topicDTO.setCourseId(rs.getInt("CourseId"));
                    topicDTO.setSectionId(sectionId);
                    topicDTO.setTopicName(rs.getString("Name"));
                    topicDTO.setDisplayIndex(rs.getInt("DisplayIndex"));
                    list.add(topicDTO);
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
    
    public TopicModel get(int topicId) throws SQLException {
        TopicModel topic = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_TOPIC);
                ptm.setInt(1, topicId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    topic = new TopicModel();
                    topic.setTopicId(rs.getInt("Id"));
                    topic.setSectionId(rs.getInt("SectionId"));
                    topic.setCourseId(rs.getInt("CourseId"));
                    topic.setTopicName(rs.getString("Name"));
                    topic.setDescription(rs.getString("Description"));
                    topic.setDisplayIndex(rs.getInt("DisplayIndex"));
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
        return topic;
    }
}

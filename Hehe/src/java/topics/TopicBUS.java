/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package topics;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luan Tuong Vy
 */
public class TopicBUS {
    private TopicDAO dao;
    private TopicDTO topicDTO;
    private TopicModel topicModel;
    
    public ArrayList<TopicDTO> getBySection(int sectionId) throws SQLException {
        dao = new TopicDAO();
        ArrayList<TopicDTO> list = dao.getBySection(sectionId);
        return list;
    }
}

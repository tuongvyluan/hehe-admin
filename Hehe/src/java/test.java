
import courses.CourseDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import topics.TopicDAO;
import topics.TopicDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harry
 */
public class test {
    public static void main(String[] args) throws SQLException{
        ArrayList<TopicDTO> list = TopicDAO.get();
        for (TopicDTO topicDTO : list) {
            System.out.println(topicDTO.getTopicName());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizzes;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class QuizBUS {
    private QuizDAO dao;
    private QuizDTO quizDTO;
    private QuizModel quizModel;
    
    public QuizDTO getByTopic (int topicId) throws SQLException{
        dao = new QuizDAO();
        quizDTO= dao.getByTopic(topicId);
        return quizDTO;
    }
}

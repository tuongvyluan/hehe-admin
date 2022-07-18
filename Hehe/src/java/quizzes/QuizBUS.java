package quizzes;

import java.sql.SQLException;

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

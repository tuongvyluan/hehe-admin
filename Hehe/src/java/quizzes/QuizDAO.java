package quizzes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

public class QuizDAO {
    private QuizDTO quizDTO = null;

    //Fields
    private final String QUIZ_DTO_FIELDS = "Id, TopicId, Content";

    //Sql queries
    private final String GET_QUIZ_BY_TOPIC = "SELECT " + QUIZ_DTO_FIELDS + " FROM Quiz Where TopicId=?";

    public QuizDTO getByTopic(int topicId) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_QUIZ_BY_TOPIC);
                ptm.setInt(1, topicId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    quizDTO = new QuizDTO();
                    quizDTO.setQuizId(rs.getInt("Id"));
                    quizDTO.setTopicId(rs.getInt("TopicId"));
                    quizDTO.setContent(rs.getString("Content"));
                    quizDTO.setDate(rs.getDate("Date"));
                    quizDTO.setNumberAnswers(rs.getInt("NumberAnswers"));
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
        return quizDTO;
    }
}

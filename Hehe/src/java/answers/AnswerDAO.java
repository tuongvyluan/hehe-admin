package answers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DBUtils;

public class AnswerDAO {
    // SQL query
    private final String ANSWER_DTO_FIELDS = "Id, QuizId, Content, IsCorrect";
    private final String GET_ANSWER_BY_QUIZ = "SELECT " + ANSWER_DTO_FIELDS + " FROM Answer Where QuizId=?";
    private AnswerDTO answerDTO;

    public ArrayList<AnswerDTO> getByQuiz(int quizId) throws SQLException {
        ArrayList<AnswerDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ANSWER_BY_QUIZ);
                ptm.setInt(1, quizId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    answerDTO = new AnswerDTO();
                    answerDTO.setAnswerId(rs.getInt("Id"));
                    answerDTO.setQuizId(rs.getInt("QuizId"));
                    answerDTO.setContent(rs.getString("Content"));
                    answerDTO.setCorrect(rs.getBoolean("IsCorrect"));
                    list.add(answerDTO);
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

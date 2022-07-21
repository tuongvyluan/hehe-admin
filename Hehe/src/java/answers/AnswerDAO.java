package answers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DBUtils;

public class AnswerDAO {

    // SQL query
    private final String ANSWER_DTO_FIELDS = "Id, QuizId, Content, IsCorrect, Status";
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
                    answerDTO.setStatus(rs.getString("Status"));
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

    public static boolean editAnswer(int answerId, String answerContent, boolean IsCorrect) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Answer SET Content=?, IsCorrect=? WHERE Id = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, answerContent);
                pst.setBoolean(2, IsCorrect);
                pst.setInt(3, answerId);
                int rs = pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean deleteAnswer(int answerId) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Answer SET Status = 'Inactive' WHERE Id = ?";
                String sql1 = "DELETE FROM Answer WHERE Id=?";
                PreparedStatement pst = cn.prepareStatement(sql1);
                pst.setInt(1, answerId);
                int rs = pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean addAnswerToQuiz(int quizId, String answerContent, boolean isCorrect) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO Answer(QuizId, Content, IsCorrect, Status) VALUES (?,?,?,'Active') ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, quizId);
                pst.setString(2, answerContent);
                pst.setBoolean(3, isCorrect);
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

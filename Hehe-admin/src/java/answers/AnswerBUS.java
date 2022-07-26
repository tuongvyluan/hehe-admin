package answers;

import java.sql.SQLException;
import java.util.ArrayList;

public class AnswerBUS {
    private AnswerDAO dao;
    public ArrayList<AnswerDTO> getByQuiz(int quizId) throws SQLException {
        dao = new AnswerDAO();
        ArrayList<AnswerDTO> list = dao.getByQuiz(quizId);
        return list;
    }
}

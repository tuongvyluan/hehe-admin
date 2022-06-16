package students;

import java.sql.SQLException;

public class StudentBUS implements IStudentBUS {

    @Override
    public StudentModel checkLogin(String email, String password) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public StudentModel checkLogin(String email) throws SQLException {
	// TODO Auto-generated method stub
	StudentDAO dao = new StudentDAO();
	System.out.println("Email in BUS: " + email);
	StudentModel student = dao.get(email);
	return student;
    }

    public StudentDTO getStudent(String email) {
	StudentDTO student = null;
	// TODO Auto-generated method stub
	return student;
    }
    
    public StudentDTO getStudent(int id) {
	StudentDTO student = null;
	// TODO Auto-generated method stub
	return student;
    }
}

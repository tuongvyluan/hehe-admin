package students;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;

class StudentDAOTest {
    
    static StudentDAO dao;

    @BeforeClass
    static void setUpBeforeClass() throws Exception {
	dao = new StudentDAO();
    }

    @Test
    void testGetIntInt() throws SQLException {
	ArrayList<StudentModel> list = new ArrayList<>();
	list = (ArrayList<StudentModel>) dao.get(1, 5);
	assertTrue(list.size() == 5);
    }

    @Test
    void testGetInt() {
	fail("Not yet implemented");
    }
    
    @Test
    void testGetString() throws SQLException {
	StudentDAO dao = new StudentDAO();
	assertNotNull(dao.get("mbier1@google.cn"));
    }

    @Test
    void testAdd() {
	fail("Not yet implemented");
    }

    @Test
    void testUpdate() {
	fail("Not yet implemented");
    }

    @Test
    void testDeleteStudentModel() {
	fail("Not yet implemented");
    }

    @Test
    void testDeleteInt() {
	fail("Not yet implemented");
    }

}

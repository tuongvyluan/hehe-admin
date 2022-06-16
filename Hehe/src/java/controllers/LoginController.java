package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import students.StudentBUS;
import students.StudentModel;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String STUDENT_PAGE = "studentInfo.jsp";
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        String url = STUDENT_PAGE;
		System.out.print("LoginController");
	        try {
	            String email = request.getParameter("email");
	            //String password = request.getParameter("password");
	            StudentBUS studentBUS = new StudentBUS();
	    	System.out.println("Email in LoginController: " + email);
	            StudentModel student = studentBUS.checkLogin(email);
	            if (student != null) {
	        	System.out.println("Found Student");
	        	HttpSession session = request.getSession();
	        	session.setAttribute("STUDENT", student);
	            }
	        } catch (Exception e) {
	            log("Error at LoginController: " + e.toString());
	        } finally {
	            request.getRequestDispatcher(url).forward(request, response);
	        }
	    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    processRequest(request, response);
	    response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

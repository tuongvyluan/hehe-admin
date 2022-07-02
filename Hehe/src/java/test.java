
import courses.CourseDAO;

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
    public static void main(String[] args) {
        boolean result = CourseDAO.createCourse(8, 2, "asd", "asd", "active", 0, 0.5);
        if (result = true) {
            System.out.println("Ok");
        } else {
            System.out.println("Cac djt me");
        }
    }
}

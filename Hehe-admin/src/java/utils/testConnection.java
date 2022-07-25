/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import authors.AuthorDAO;
import authors.AuthorModel;
import courses.CourseModel;
import java.time.LocalDate;
import java.util.List;
import students.StudentModel;

/**
 *
 * @author triud
 */
public class testConnection {
    public static void main(String[] args) {
//        boolean tmp = students.StudentDAO.editStudent(1, "John", "King", "johnking@fpt.edu.vn", "lmao", "0909096080");
//        if(tmp == true){
//            System.out.println("Doi thanh cong");
//        }else{
//            System.out.println("Doi khong thanh cong");
//        }

// Test ban
//    boolean tmp = students.StudentDAO.updateStudentStatus(2, "Inactive");
//    if(tmp) System.out.println("Doi thanh cong");
//    else System.out.println("Doi khong thanh cong");
//test search
//        List<CourseModel> tmp;
//        tmp = courses.CourseDAO.getCourseBySearch("C");
//        if(tmp != null){
//            for (CourseModel courseModel : tmp) {
//                System.out.println("Tim duoc ne: \n" + courseModel);
//            }
//        }
//        else System.out.println("K tim duoc");

//test add author
        boolean tmp = AuthorDAO.createAuthor("kent", "vu","123", "duong@gmail.com", "Active", "0199199911");
        if(tmp) System.out.println("Add roi ne: \n" + tmp);
        else System.out.println("khong add duoc r");
        
    }
}

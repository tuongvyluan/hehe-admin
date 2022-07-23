/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import courses.CourseBUS;
import courses.CourseDAO;
import courses.CourseDTO;
import courses.CourseModel;
import java.sql.SQLException;
import java.util.ArrayList;
import sections.SectionDAO;
import topics.TopicDAO;

/**
 *
 * @author Harry
 */
public class test {

    public static void main(String[] args) throws SQLException {
        boolean result = CourseDAO.editCourseDesc(7, "For fun");
        if (result == true) {
            System.out.println("Ok");
        } else {
            System.out.println("Cc");
        }
    }
}

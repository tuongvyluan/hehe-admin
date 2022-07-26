/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import authors.AuthorDAO;
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
        boolean result = AuthorDAO.changePassword(1, "123");
        if (result == true) {
            System.out.println("Ok");
        } else {
            System.out.println("Ko");
        }
    }
}

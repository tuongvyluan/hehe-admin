/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import courses.CourseBUS;
import courses.CourseDAO;
import courses.CourseDTO;
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
        CourseBUS courseBUS = new CourseBUS();
        ArrayList<CourseDTO> list = courseBUS.getCoursesByAuthorCate(1, 1);
        for (CourseDTO o : list) {
            System.out.println(o.getCourseName());
        }
    }
}

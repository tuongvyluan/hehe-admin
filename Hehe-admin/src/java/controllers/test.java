/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import courses.CourseDAO;
import sections.SectionDAO;
import topics.TopicDAO;

/**
 *
 * @author Harry
 */
public class test {

    public static void main(String[] args) {
        boolean result = SectionDAO.AddSectionToCourse(10, 61);
        if (result == true) {
            System.out.println("Ok");
        } else {
            System.out.println("Cc");
        }
    }
}

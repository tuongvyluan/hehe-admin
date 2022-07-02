/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import courses.CourseDAO;

/**
 *
 * @author Harry
 */
public class test {

    public static void main(String[] args) {
        boolean result = CourseDAO.editCourse(28, 3, "Tasukete kudasai", "Help me", "Active", 2.20, 3.24);
        if (result == true) {
            System.out.println("Ok");
        } else {
            System.out.println("Cc");
        }
    }
}

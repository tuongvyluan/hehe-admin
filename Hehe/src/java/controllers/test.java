/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import courses.CourseDAO;
import topics.TopicDAO;

/**
 *
 * @author Harry
 */
public class test {

    public static void main(String[] args) {
        boolean result = TopicDAO.editTopic(37, 1, 1, "ASD", "ASD", "Active", 2);
        if (result == true) {
            System.out.println("Ok");
        } else {
            System.out.println("Cc");
        }
    }
}

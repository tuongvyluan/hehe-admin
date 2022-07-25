/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luan Tuong Vy
 */
public class CourseBUS {

    private CourseDAO dao;
    private CourseDTO courseDTO;
    private CourseModel courseModel;

 
    
   

    public CourseDTO getCourse(int id) {
        CourseDTO crs = null;
        // TODO Auto-generated method stub
        return crs;
    }
    public List<CourseModel> get(int pageNumber, int rowsOfPage) throws SQLException {
        CourseDAO crs = new CourseDAO();
        ArrayList<CourseModel> list = crs.get(pageNumber, rowsOfPage);
        return list;
    }
}

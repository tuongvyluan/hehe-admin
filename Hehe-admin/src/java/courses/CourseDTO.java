/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courses;

/**
 *
 * @author Luan Tuong Vy
 */
public class CourseDTO {

    private int courseId;
    private int categoryId;
    private int authorId;
    private String courseName;
    private double duration;
    private String courseStatus;
    private String categoryStatus;
    private String categoryName;

    public CourseDTO() {
    }

    public CourseDTO(int courseId, int categoryId, int authorId, String courseName, double duration, String courseStatus, String categoryStatus, String categoryName) {
        this.courseId = courseId;
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.courseName = courseName;
        this.duration = duration;
        this.courseStatus = courseStatus;
        this.categoryStatus = categoryStatus;
        this.categoryName = categoryName;
    }

    public CourseDTO(int courseId, int categoryId, String courseName) {
        this.courseId = courseId;
        this.categoryId = categoryId;
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "CourseDTO{" + "courseId=" + courseId + ", categoryId=" + categoryId + ", courseName=" + courseName + '}';
    }

}

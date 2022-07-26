/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package topics;

import courses.CourseDTO;
import sections.SectionDTO;

/**
 *
 * @author Luan Tuong Vy
 */
public class TopicDTO {
    
    private int topicId;
    private int sectionId;
    private int courseId;
    private String topicName;
    private String topicDescription;
    private String status;
    private int displayIndex;

    public TopicDTO() {
    }

    public TopicDTO(int topicId, int sectionId, int courseId,
            String topicName, String topicDescription, String status, int displayIndex) {
        this.topicId = topicId;
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
        this.status = status;
        this.displayIndex = displayIndex;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    @Override
    public String toString() {
        return "TopicDTO{" + "topicId=" + topicId + ", sectionId=" + sectionId +
                ", courseId=" + courseId + ", topicName=" + topicName + ", status=" +
                status + ", displayIndex=" + displayIndex + '}';
    }
}

package topics;

import courses.CourseModel;
import java.time.LocalDate;
import sections.SectionModel;

public class TopicModel {

    private int topicId;
    private int sectionId;
    private int courseId;
    private String topicName;
    private String description;
    private int status;
    private int displayIndex;

    public TopicModel() {

    }

    public TopicModel(int topicId, int sectionId, int courseId,
            String topicName, String description, int status, int displayIndex) {
        this.topicId = topicId;
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.topicName = topicName;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    public TopicDTO toDTO() {
        return new TopicDTO(topicId, sectionId, courseId, topicName, description, topicName, displayIndex);
    }

    @Override
    public String toString() {
        return "TopicModel{" + "topicId=" + topicId + ", sectionId=" + sectionId
                + ", courseId=" + courseId + ", topicName=" + topicName + ", description="
                + description + ", status=" + status + ", displayIndex=" + displayIndex
                + '}';
    }
}

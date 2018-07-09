package xyh.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Objects;

public class Item implements Serializable {
    private Integer id;
    private String projectName;
    private String projectId;
    private String name;
    private String dept;
    private Integer gender;
    private String age;
    private Timestamp startTime;
    private Timestamp enrollTime;
    private String phone;

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        //在视图中查询到的项目编号格式化为sport001形式
        DecimalFormat df = new DecimalFormat("000");
        String s = df.format(Integer.parseInt(projectId));
        this.projectId = "sport"+s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEnrollTime() {
        return enrollTime;
    }

    public void setEnrollTime(Timestamp enrollTime) {
        this.enrollTime = enrollTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectId='" + projectId + '\'' +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", gender=" + gender +
                ", age='" + age + '\'' +
                ", startTime=" + startTime +
                ", enrollTime=" + enrollTime +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(projectName, item.projectName) &&
                Objects.equals(projectId, item.projectId) &&
                Objects.equals(name, item.name) &&
                Objects.equals(dept, item.dept) &&
                Objects.equals(gender, item.gender) &&
                Objects.equals(age, item.age) &&
                Objects.equals(startTime, item.startTime) &&
                Objects.equals(enrollTime, item.enrollTime) &&
                Objects.equals(phone, item.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, projectName, projectId, name, dept, gender, age, startTime, enrollTime, phone);
    }
}

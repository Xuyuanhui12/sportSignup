package xyh.service;

import xyh.bean.Item;
import xyh.bean.Project;
import xyh.bean.Rel;
import xyh.bean.Student;

import java.util.List;

public interface IMainService {

    void addProject(Project project);

    /**
     * 添加一个学生,并返回该学生的id
     * @param student
     * @return
     */
    Integer addStudent(Student student);

    void addRel(Rel rel);

    Integer getPidByProjectName(String name);

    Integer getSidByStudentName(String name);

    /**
     * 判断该项目当天的报名人数是否大于2人
     * @param rel
     * @return
     */
    boolean isNumberExceed(Rel rel);

    List<Item> getAllItem();

    List<Item> getItemByName(String name);

    String[] getMaxProject();

    String getAvgAge();
}

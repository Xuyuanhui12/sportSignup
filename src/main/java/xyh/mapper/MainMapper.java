package xyh.mapper;

import xyh.bean.Item;
import xyh.bean.Project;
import xyh.bean.Rel;
import xyh.bean.Student;

import java.util.List;

public interface MainMapper {

    void insertProject(Project project);

    void insertStudent(Student student);

    void insertRel(Rel rel);

    Project selectProjectByName(String name);

    Student selectStudentByName(String name);

    /**
     * 得到当天该项目的报名人数
     */
    Integer selectCountOneDay(Rel rel);

    /**
     * 查询所有报名信息
     * @return
     */
    List<Item> selectAll();

    /**
     * 根据运动项目名称,完成模糊查询
     * @param name
     * @return
     */
    List<Item> selectItemByName(String pname);

    /**
     * 得到报名人数最多的项目
     * @return
     */
    String[] selectMax();

    /**
     * 得到参赛者的平均年龄
     * @return
     */
    String selectAvgAge();
}

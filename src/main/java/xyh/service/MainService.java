package xyh.service;

import org.springframework.stereotype.Service;
import xyh.bean.Item;
import xyh.bean.Project;
import xyh.bean.Rel;
import xyh.bean.Student;
import xyh.mapper.MainMapper;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.List;

@Service
public class MainService implements IMainService {
    @Resource
    private MainMapper mapper;

    @Override
    public void addProject(Project project) {

        mapper.insertProject(project);

    }

    //添加一个学生并返回该学生的id
    @Override
    public Integer addStudent(Student student) {
        //如果已经有该学生了则直接返回
        Student student1 = mapper.selectStudentByName(student.getName());
        if(student1!=null && student1.equals(student)){
            return student1.getId();
        }
        //若有重复,则在学生姓名后加上院系来保存
        if(student1!=null){
            student.setName(student.getName()+"("+student.getDept()+")");
        }
        mapper.insertStudent(student);
        return mapper.selectStudentByName(student.getName()).getId();
    }

    @Override
    public void addRel(Rel rel) {

        mapper.insertRel(rel);
    }

    @Override
    public Integer getPidByProjectName(String name) {
        Project project = mapper.selectProjectByName(name);
        return project.getId();
    }

    @Override
    public Integer getSidByStudentName(String name) {
        Student student = mapper.selectStudentByName(name);
        return student.getId();
    }

    @Override
    public boolean isNumberExceed(Rel rel) {
        Integer count = mapper.selectCountOneDay(rel);
        if(count>=2){
            return true;
        }
        return false;
    }


    @Override
    public List<Item> getAllItem() {
        List<Item> list = mapper.selectAll();
        return list;
    }

    @Override
    public List<Item> getItemByName(String name) {
        return mapper.selectItemByName(name);
    }

    @Override
    public String[] getMaxProject() {
        return mapper.selectMax();
    }

    @Override
    public String getAvgAge() {
        return mapper.selectAvgAge();
    }


}

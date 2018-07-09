package xyh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyh.bean.*;
import xyh.service.IMainService;

import javax.annotation.Resource;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sport")
public class MainController {
    @Resource
    private IMainService mainService;

    @RequestMapping("/showList.do")
    public String showList(){
        return "list";
    }

    @RequestMapping("/showAdd.do")
    public String showAdd(){
        return "add";
    }

    @RequestMapping("/showAddSport.do")
    public String showAddSport(){
        return "addSport";
    }

    //增加运动会项目
    @RequestMapping("/addProject.do")
    @ResponseBody
    public ResponseResult<Void> addProject(String name, String startTime) throws ParseException {
        System.out.println(startTime);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(startTime,dtf);
        Timestamp ts = Timestamp.valueOf(ldt);
        ResponseResult<Void> rr = new ResponseResult<Void>();
        Project project = new Project();
        project.setName(name);
        project.setStartTime(ts);
        mainService.addProject(project);

        rr.setState(1);
        rr.setMessage("添加运动项目成功");
        return rr;
    }

    //增加一条报名信息
    @RequestMapping("/addItem.do")
    @ResponseBody
    public ResponseResult<Void> addItem(
            String projectName,String name,String dept,Integer gender,Integer age,String phone
    ){
        ResponseResult<Void> rr = new ResponseResult<Void>();
        Student student = new Student();
        student.setName(name);
        student.setDept(dept);
        student.setGender(gender);
        student.setAge(age);
        student.setPhone(phone);

        Integer sid = mainService.addStudent(student);
        Rel rel = new Rel();
        rel.setPid(mainService.getPidByProjectName(projectName));
        rel.setSid(sid);
        rel.setEnrollTime(new Timestamp(System.currentTimeMillis()));
        //若报名人数超过2人,则返回错误信息
        if(mainService.isNumberExceed(rel)){
            rr.setState(0);
            rr.setMessage("该项目今天已经报名2人,请明天再来");
            return rr;
        }
        mainService.addRel(rel);
        rr.setState(1);
        rr.setMessage("报名成功");
        return rr;
    }

    @RequestMapping("/getAll.do")
    @ResponseBody
    public ResponseResult<List<Item>> listAllItem(){
        ResponseResult<List<Item>> rr = new ResponseResult<List<Item>>();
        List<Item> list = mainService.getAllItem();
        rr.setState(1);
        rr.setMessage("成功");
        rr.setData(list);

        return rr;
    }

    //实现模糊查询
    @RequestMapping("/getItemByName.do")
    @ResponseBody
    public ResponseResult<List<Item>> listItemByName(String itemName){
        ResponseResult<List<Item>> rr = new ResponseResult<List<Item>>();
        List<Item> list = mainService.getItemByName(itemName);
        rr.setState(1);
        rr.setMessage("成功");
        rr.setData(list);

        return rr;
    }

    //得到聚合函数
    @RequestMapping("/getAggre.do")
    @ResponseBody
    public ResponseResult<String[]> listAggre(){
        ResponseResult<String[]> rr = new ResponseResult<String[]>();
        String[] max = mainService.getMaxProject();
        String avg = mainService.getAvgAge();
        rr.setState(1);
        rr.setMessage(avg);
        rr.setData(max);

        return rr;
    }












}

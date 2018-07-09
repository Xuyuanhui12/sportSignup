package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyh.bean.Item;
import xyh.bean.Project;
import xyh.bean.Rel;
import xyh.bean.Student;
import xyh.mapper.MainMapper;
import xyh.service.MainService;

import java.sql.Timestamp;
import java.util.List;

public class mainTest {
    private ClassPathXmlApplicationContext ac;
    private MainMapper mm;
    private MainService ms;

    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
        mm = (MainMapper) ac.getBean("mainMapper");
        ms = (MainService) ac.getBean("mainService");
    }

    @After
    public void after(){
        ac.close();
    }

    @Test
    public void testInsert(){
        Project project = new Project();
        project.setName("aaa");
        project.setStartTime(new Timestamp(System.currentTimeMillis()));
        mm.insertProject(project);
    }

    @Test
    public void testSelectByName(){
        Project project = mm.selectProjectByName("接力");
        System.out.println(project);

        //Student student = mm.selectStudentByName("张三");

    }

    @Test
    public void testSelectCount(){
        Rel rel = new Rel();
        rel.setSid(2);
        rel.setPid(2);
        rel.setEnrollTime(new Timestamp(System.currentTimeMillis()));
        Integer c = mm.selectCountOneDay(rel);
        System.out.println(c);
    }

    @Test
    public void testSelectAll(){
        List<Item> list = mm.selectAll();
        for(Item i:list){
            System.out.println(i);
        }
    }

    @Test
    public void testSelecItemtByName(){
        List<Item> list = mm.selectItemByName("跳远");
        for(Item i:list){
            System.out.println(i);
        }
    }

    @Test
    public void testSelectMax(){
        String[] str = mm.selectMax();
        System.out.println(str[1]);
    }

    @Test
    public void testSelectAvgAge(){
        String str = mm.selectAvgAge();
        System.out.println(str);
    }
}

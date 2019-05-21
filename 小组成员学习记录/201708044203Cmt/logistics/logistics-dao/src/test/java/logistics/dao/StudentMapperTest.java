package logistics.dao;

import logistics.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-dao.xml")
@Transactional
public class StudentMapperTest {

    private  StudentMapper studentMapper;

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Test
    @Commit
    public  void  saveOneTest()
    {
        Student stu=new Student();
        stu.setStuNum("201708044110");
        stu.setStuName("hhhh");
        stu.setStuSex(1);
        stu.setStuClass("20170804401");
        studentMapper.saveOne(stu);
    }

}

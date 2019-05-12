package logistics.dao;

import logistics.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    Integer saveOne(Student student);
    List<Student> getAllStudent();
    Integer saveAllStudent(List<Student> studentList);
    Student getStuById(Integer id);
    Integer deleteStuById(Integer id);
    Integer updateStuById(Student student);
}

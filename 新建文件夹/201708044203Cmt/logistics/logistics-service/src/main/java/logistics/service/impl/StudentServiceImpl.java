package logistics.service.impl;

import logistics.dao.StudentMapper;
import logistics.entity.Student;
import logistics.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentMapper studentMapper;

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> list=studentMapper.getAllStudent();
        return list;
    }

    @Override
    public Integer saveAllStudent(List<Student> studentList) {
        return studentMapper.saveAllStudent(studentList);

    }
    @Override
    public Student getStuById(Integer id){
        return studentMapper.getStuById(id);
    }
    @Override
    public Integer deleteStuById(Integer id) {
        return studentMapper.deleteStuById(id);
    }
    @Override
    public  Integer updateStuById(Student student){
        return studentMapper.updateStuById(student);
    }
}

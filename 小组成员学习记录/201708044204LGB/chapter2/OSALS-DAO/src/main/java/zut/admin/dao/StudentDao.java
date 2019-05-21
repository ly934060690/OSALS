package zut.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import zut.admin.domain.Student;

public interface StudentDao extends JpaRepository<Student,Long> , JpaSpecificationExecutor<Student> {

    void findByNumber(int Number);

}

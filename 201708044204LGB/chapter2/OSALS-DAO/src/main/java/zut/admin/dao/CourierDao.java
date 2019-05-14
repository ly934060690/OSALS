package zut.admin.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import zut.admin.domain.Courier;

public interface CourierDao extends JpaRepository<Courier,String> {

}

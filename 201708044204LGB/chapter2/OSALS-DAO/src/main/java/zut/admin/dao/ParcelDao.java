package zut.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import zut.admin.domain.Courier;
import zut.admin.domain.Parcel;

public interface ParcelDao extends JpaRepository<Parcel,String> {
}

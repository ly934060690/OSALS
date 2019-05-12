package zut.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import zut.base.domain.BaseEntity;

import java.io.Serializable;

public interface GenericDao <T extends BaseEntity, PK extends Serializable>
        extends JpaRepository<T, PK>, JpaSpecificationExecutor<T> {
}

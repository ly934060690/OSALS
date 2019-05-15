package edu.zut.cs.OSALS.base.dao;

import edu.zut.cs.OSALS.base.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;


/**
 *让持久层接口 UserDao 继承 Repository 接口。
 * 该接口使用了泛型，需要为其提供两个类型：第一个为该接口处理的域对象类型，第二个为该域对象的主键类型。
 *
 * 此处定义的GenericDao继承了JpaRepository，这样GenericDao接口就具备了通用的数据访问控制层的能力。
 * @param <T>
 * @param <PK>
 */
@NoRepositoryBean
public interface GenericDao<T extends BaseEntity, PK extends Serializable>
        extends JpaRepository<T, PK>, JpaSpecificationExecutor<T> {
}

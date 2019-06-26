package edu.zut.cs.software.osals.warehouse.service.impl;


import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.osals.warehouse.dao.WarehouseDao;
import edu.zut.cs.software.osals.warehouse.daomain.Goods;
import edu.zut.cs.software.osals.warehouse.daomain.Warehouse;
import edu.zut.cs.software.osals.warehouse.service.WarehouseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/5/16
 * @Description: edu.zut.cs.software.OSALS.warehouse.service.impl
 * @version: 1.0
 */
@Service("WarehouseManager")
@Transactional
public class WarehouseManagerImpl extends GenericTreeManagerImpl<Warehouse, Long> implements WarehouseManager {


    WarehouseDao warehouseDao;

    @Autowired
    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
        this.treeDao = this.warehouseDao;
        this.dao = this.treeDao;
    }
    @Override
    public List<Warehouse> findByName(String name) {
        Warehouse queryObject = new Warehouse();
        queryObject.setHousename(name);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("housename", ExampleMatcher.GenericPropertyMatchers.startsWith()).withIgnorePaths("dateCreated", "dateModified");
        Example<Warehouse> example = Example.of(queryObject, exampleMatcher);
        List<Warehouse> result = this.dao.findAll(example);
        return result;
    }

//    /**
//     * 这里是查询所有
//     * @return List<Warehouse>
//     */
//    @Override
//    public  List<Warehouse> findAll(){
//        return warehouseDao.findAll();
//    }
//
//    /**
//     * 这里是按照id值来删除
//     * @param id
//     */
//    @Override
//    public void deleteById(Long id)
//    {
//        warehouseDao.deleteById(id);
//    }
//
//    /**
//     * 保存&增加
//     * @param warehouse
//     * @return Warehouse
//     */
//    @Override
//    public Warehouse save(Warehouse warehouse)
//    {
//        return warehouseDao.save(warehouse);
//    }

}

package edu.zut.cs.software.osals.poststation.service;


import edu.zut.cs.software.base.service.GenericTreeManager;
import edu.zut.cs.software.osals.poststation.domain.PostStation;

public interface PostStationManager extends GenericTreeManager<PostStation, Long> {

    PostStation findByIdnumber(String idnumber);

    PostStation findByName(String entityname);

}

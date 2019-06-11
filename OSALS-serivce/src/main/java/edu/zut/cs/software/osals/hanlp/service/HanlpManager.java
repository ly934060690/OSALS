package edu.zut.cs.software.osals.hanlp.service;

import com.hankcs.hanlp.seg.common.Term;
import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.hanlp.domain.Hanlp;

import java.util.List;

public interface HanlpManager extends GenericManager<Hanlp, Long> {

    List<Term> normWord(String text);

}

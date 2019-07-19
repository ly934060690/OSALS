package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.nlp.domain.NlpEntityRelation;

public interface NlpEntityRelationManager extends GenericManager<NlpEntityRelation,Long> {
  public String getEntity(String text);
}

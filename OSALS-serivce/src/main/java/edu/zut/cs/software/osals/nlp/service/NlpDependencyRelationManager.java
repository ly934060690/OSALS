package edu.zut.cs.software.osals.nlp.service;

import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TypedDependency;
import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.nlp.domain.NlpDependencyRelation;

import java.util.Collection;

/**
 * @Author: hyh
 * @Description: NlpDependencyRelation Manager
 * @Date:CreaReferenceted in 11:48 2019/6/13
 * @Modified By:
 */
public interface NlpDependencyRelationManager extends GenericManager<NlpDependencyRelation,Long> {

    /**
     *@Description: StanfordParser 创建语法树
     *@Date: 10:35 2019/6/14
     */
    Tree stanfordParseTree(String text);

    /**
     *@Description: StanfordParser 依存关系
     *@Date: 10:45 2019/6/14
     */
    Collection<TypedDependency> stanfordDependencyRelation(String text);

    /**
     *@Description: StanfordParser 标注指代
     *@Date: 10:45 2019/6/14
     */
    String stanfordAnnotatedReference(String text);
}

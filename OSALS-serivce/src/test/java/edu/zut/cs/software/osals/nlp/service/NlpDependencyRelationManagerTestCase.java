package edu.zut.cs.software.osals.nlp.service;

import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TypedDependency;
import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpDependencyRelation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * @Author: hyh
 * @Description: NlpDependencyRelationManager Test Case
 * @Date:Created in 16:05 2019/6/13
 * @Modified By:
 */
public class NlpDependencyRelationManagerTestCase extends GenericManagerTestCase<Long, NlpDependencyRelation,NlpDependencyRelationManager> {

    public NlpDependencyRelationManagerTestCase() {
        super(NlpDependencyRelation.class);
    }
    NlpDependencyRelationManager nlpDependencyRelationManager;

    @Autowired
    public void setHanlpManager(NlpDependencyRelationManager nlpDependencyRelationManager) {
        this.nlpDependencyRelationManager = nlpDependencyRelationManager;
        this.manager = this.nlpDependencyRelationManager;
    }

    /**
     *@Description: Test StanfordParser
     *@Date: 15:52 2019/6/14
     */
    @Test
    public void testStanfordParser(){
        Tree tree=this.manager.stanfordParseTree("这是语法树。");
        tree.pennPrint();

        Collection<TypedDependency> collection= this.manager.stanfordDependencyRelation("这是依存关系。");
        System.out.println(collection.toString());

        String s=this.manager.stanfordAnnotatedReference("这是标注指代");
        System.out.println(s);

        if (logger.isInfoEnabled()) {
            logger.info("StanfordParseTree() - Tree tree", tree); //$NON-NLS-1$
        }
        if (logger.isInfoEnabled()) {
            logger.info("StanfordDependencyRelation() - Collection<TypedDependency> collection={}", collection); //$NON-NLS-1$
        }
        if (logger.isInfoEnabled()) {
            logger.info("StanfordAnnotatedReference -  String s", s); //$NON-NLS-1$
        }
    }

}

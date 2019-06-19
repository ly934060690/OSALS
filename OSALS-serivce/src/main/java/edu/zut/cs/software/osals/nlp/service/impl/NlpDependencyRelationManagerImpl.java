package edu.zut.cs.software.osals.nlp.service.impl;

import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.trees.international.pennchinese.ChineseGrammaticalStructure;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.nlp.dao.NlpDependencyRelationDao;
import edu.zut.cs.software.osals.nlp.domain.NlpDependencyRelation;
import edu.zut.cs.software.osals.nlp.service.NlpDependencyRelationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * @Author: hyh
 * @Description: NlpDependencyRelationManager Impl
 * @Date:Created in 11:50 2019/6/13
 * @Modified By:
 */
@Component
@Transactional
public class NlpDependencyRelationManagerImpl extends GenericManagerImpl<NlpDependencyRelation, Long> implements NlpDependencyRelationManager {

    NlpDependencyRelationDao nlpDependencyRelationDao;

    @Autowired
    public void setHanLPDao(NlpDependencyRelationDao nlpDependencyRelationDao) {
        this.nlpDependencyRelationDao = nlpDependencyRelationDao;
        this.dao = this.nlpDependencyRelationDao;
    }

    /**
     *@Description: StanfordParser 创建语法树 impl
     *@Date: 10:35 2019/6/14
     */
    @Override
    public Tree stanfordParseTree(String text) {
        String modelpath="edu/stanford/nlp/models/lexparser/xinhuaFactoredSegmenting.ser.gz";
        LexicalizedParser lexicalizedParser=LexicalizedParser.loadModel(modelpath);
        Tree tree=lexicalizedParser.parse(text);
        return tree;
    }

    /**
     *@Description: StanfordParser 创建依存关系 impl
     *@Date: 10:35 2019/6/14
     */
    @Override
    public Collection<TypedDependency> stanfordDependencyRelation(String text) {
        Tree tree=stanfordParseTree(text);
        ChineseGrammaticalStructure cgs=new ChineseGrammaticalStructure(tree);
        Collection<TypedDependency> tdl=cgs.typedDependenciesCollapsed();
        return tdl;
    }

    /**
     *@Description: StanfordParser 创建标注指代 impl
     *@Date: 10:35 2019/6/14
     */
    @Override
    public String stanfordAnnotatedReference(String text) {
        String s="";
        Collection<TypedDependency> typedDependencies=stanfordDependencyRelation(text);
        for(int i=0;i<typedDependencies.size()-1;i++){
            TypedDependency td=(TypedDependency)typedDependencies.toArray()[i];
            String stringAnnotated=td.dep().toString();
            s+=stringAnnotated+",";
        }
        TypedDependency td=(TypedDependency)typedDependencies.toArray()[typedDependencies.size()-1];
        String stringAnnotated=td.dep().toString();
        s+=stringAnnotated;
        return s;
    }

    /**
     *@Description: StanfordParser 返回NlpDependenceRelation impl
     *@Date: 10:35 2019/6/14
     */
    @Override
    public NlpDependencyRelation stanfordTextNlp(String text) {
        Collection<TypedDependency> collection=stanfordDependencyRelation(text);
        String annotated=stanfordAnnotatedReference(text);
        String relation=collection.toString();

        NlpDependencyRelation nlp=new NlpDependencyRelation();
        nlp.setText(text);
        nlp.setRelation(relation);
        nlp.setAnnotated(annotated);

        return nlp;
    }
}

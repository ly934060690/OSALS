package edu.zut.cs.software.osals.nlp.service.impl;


import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.nlp.dao.NlpEntityRelationDao;
import edu.zut.cs.software.osals.nlp.domain.NlpEntityRelation;

import edu.zut.cs.software.osals.nlp.service.NlpEntityRelationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Properties;
import java.util.stream.Collectors;

@Component
@Transactional
public class NlpEntityRalationManagerImpl extends GenericManagerImpl<NlpEntityRelation,Long> implements NlpEntityRelationManager {

    NlpEntityRelationDao nlpEntityRelationDao;

    @Autowired
    public void setNlpEntityRelationDao(NlpEntityRelationDao nlpEntityRelationDao) {
        this.nlpEntityRelationDao = nlpEntityRelationDao;
        this.dao = this.nlpEntityRelationDao;
    }


    @Override
    public String getEntity( String pra) {
        // set up pipeline properties
        String resultGet="";
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
        // example customizations (these are commented out but you can uncomment them to see the results

        // disable fine grained ner
        //props.setProperty("ner.applyFineGrained", "false");

        // customize fine grained ner
        //props.setProperty("ner.fine.regexner.mapping", "example.rules");
        //props.setProperty("ner.fine.regexner.ignorecase", "true");

        // add additional rules
        //props.setProperty("ner.additional.regexner.mapping", "example.rules");
        //props.setProperty("ner.additional.regexner.ignorecase", "true");

        // add 2 additional rules files ; set the first one to be case-insensitive
        //props.setProperty("ner.additional.regexner.mapping", "ignorecase=true,example_one.rules;example_two.rules");

        // set up pipeline
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        // make an example document
       //CoreDocument doc = new CoreDocument("Joe Smith is from Seattle.");
        CoreDocument doc = new CoreDocument(pra);
       // CoreDocument doc = new CoreDocument("Xiaoming is living in Zhengzhou.");
       // CoreDocument doc = new CoreDocument("小明生活在郑州.");
        // annotate the document
        pipeline.annotate(doc);
        // view results
        //System.out.println("entities found");
        for (CoreEntityMention em : doc.entityMentions()) {
          resultGet= resultGet+em.text() + "\t" + em.entityType()+"\n";
           // System.out.println("\t" + em.text() + "\t" + em.entityType());
        }
      System.out.println(resultGet);
           // System.out.println("\tdetected entity: \t" + em.text() + "\t" + em.entityType());
        //System.out.println("---");
       // System.out.println("tokens and ner tags");
        String tokensAndNERTags = doc.tokens().stream().map(token -> "(" + token.word() + "," + token.ner() + ")").collect(
                Collectors.joining(" "));
        //return tokensAndNERTags;
        return resultGet;
    }

}

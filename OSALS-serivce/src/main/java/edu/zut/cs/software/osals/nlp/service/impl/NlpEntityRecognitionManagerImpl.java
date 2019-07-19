//package edu.zut.cs.software.osals.nlp.service.impl;
//
//
//import com.hankcs.hanlp.HanLP;
//import com.hankcs.hanlp.seg.Segment;
//import edu.stanford.nlp.ie.AbstractSequenceClassifier;
//import edu.stanford.nlp.pipeline.CoreDocument;
//import edu.stanford.nlp.pipeline.CoreEntityMention;
//import edu.stanford.nlp.pipeline.StanfordCoreNLP;
//import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
//import edu.zut.cs.software.osals.nlp.dao.NlpEntityRecognitionDao;
//import edu.zut.cs.software.osals.nlp.domain.NlpEntityRecognition;
//import edu.zut.cs.software.osals.nlp.service.NlpEntityRecognitionManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Properties;
//import java.util.stream.Collectors;
//
//import edu.stanford.nlp.ie.crf.CRFClassifier;
//import edu.stanford.nlp.ling.CoreLabel;
//
//
//@Component
//@Transactional
//public class NlpEntityRecognitionManagerImpl extends GenericManagerImpl<NlpEntityRecognition,Long>implements NlpEntityRecognitionManager {
//    NlpEntityRecognitionDao nlpEntityRecognitionDao;
//
//    @Autowired
//    public void setNlpEntityRecognitionDao(NlpEntityRecognitionDao nlpEntityRecognitionDao) {
//        this.nlpEntityRecognitionDao = nlpEntityRecognitionDao;
//        this.dao=this.nlpEntityRecognitionDao;
//    }
//
//
//    @Override
//    public List<NlpEntityRecognition> findAll()
//    {
//        return nlpEntityRecognitionDao.findAll();
//    }
//
//    @Override
//    public NlpEntityRecognition save(NlpEntityRecognition nlpEntityRecognition) {
//        return nlpEntityRecognitionDao.save(nlpEntityRecognition);
//    }
//
//    @Override
//    public String getEntityRecognition(String Sentence) {
//        String result = "";
//        // set up pipeline properties
//        Properties props = new Properties();
//        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
//        // example customizations (these are commented out but you can uncomment them to see the results
//
//        // disable fine grained ner
//        //props.setProperty("ner.applyFineGrained", "false");
//
//        // customize fine grained ner
//        //props.setProperty("ner.fine.regexner.mapping", "example.rules");
//        //props.setProperty("ner.fine.regexner.ignorecase", "true");
//
//        // add additional rules
//        //props.setProperty("ner.additional.regexner.mapping", "example.rules");
//        //props.setProperty("ner.additional.regexner.ignorecase", "true");
//
//        // add 2 additional rules files ; set the first one to be case-insensitive
//        //props.setProperty("ner.additional.regexner.mapping", "ignorecase=true,example_one.rules;example_two.rules");
//
//        // set up pipeline
//        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
//        // make an example document
//        CoreDocument doc = new CoreDocument(Sentence);
//        // annotate the document
//        pipeline.annotate(doc);
//        // view results
//        /*System.out.println("---");
//        System.out.println("entities found");*/
//        for (CoreEntityMention em : doc.entityMentions())
//            result = result + em.text() + "\t" + em.entityType() + '\n';
//        /*System.out.println("---");
//        System.out.println("tokens and ner tags");*/
//        //System.out.println(result);
//        String tokensAndNERTags = doc.tokens().stream().map(token -> "(" + token.word() + "," + token.ner() + ")").collect(
//                Collectors.joining(" "));
//        /*System.out.println(tokensAndNERTags);*/
//        return result;
//    }
//
//
//
//    public static CRFClassifier<CoreLabel> segmenter;
//    static {
//// 设置一些初始化参数
//        Properties props = new Properties();
//        props.setProperty("sighanCorporaDict", "data");
//        props.setProperty("serDictionary", "data/dict-chris6.ser.gz");
//        props.setProperty("inputEncoding", "UTF-8");
//        props.setProperty("sighanPostProcessing", "true");
//        segmenter = new CRFClassifier<CoreLabel>(props);
//        segmenter.loadClassifierNoExceptions("data/ctb.gz", props);
//        segmenter.flags.setProperties(props);
//    }
//    public static String doSegment(String sent) {
//        String[] strs = (String[]) segmenter.segmentString(sent).toArray();
//        String str="";
//        for (String s : strs) {
//            str=str+s+" ";
//        }
//        return str;
//    }
//
//    public class Stanford_Test {
//
//        private  AbstractSequenceClassifier<CoreLabel> ner;
//        public Stanford_Test() {
//            InitNer();
//        }
//        public void InitNer() {
//            String serializedClassifier = "classifiers/chinese.misc.distsim.crf.ser.gz"; // chinese.misc.distsim.crf.ser.gz
//            if (ner == null) {
//                ner = CRFClassifier.getClassifierNoExceptions(serializedClassifier);
//            }
//        }
//        public String doNer(String sent) {
//            return ner.classifyWithInlineXML(sent);
//        }
//    }
//    @Override
//    public String Stanford(String Sentence)
//    {
//        String result="";
//        String doSegment = doSegment(Sentence);
//        Stanford_Test stanford_test=new Stanford_Test();
//        result=stanford_test.doNer(doSegment);
//        return result;
//    }
//
//    @Override
//    public String HanLP(String Sentence)
//    {
//        String result="";
//        Segment segment = HanLP.newSegment().enableNameRecognize(true).enableOrganizationRecognize(true).enablePlaceRecognize(true);
//        result =result+ segment.seg(Sentence);
//        return result;
//    }
//}

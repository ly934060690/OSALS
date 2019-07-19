package edu.zut.cs.software.osals.nlp.service.impl;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;

import edu.zut.cs.software.osals.nlp.dao.NlpTextClassifyDao;
import edu.zut.cs.software.osals.nlp.domain.NlpTextClassify;
import edu.zut.cs.software.osals.nlp.service.NlpTextClassifyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class NlpTextClassifyManagerImpl extends GenericManagerImpl<NlpTextClassify,Long> implements NlpTextClassifyManager {

    NlpTextClassifyDao nlpTextClassifyDao;

    @Autowired
    public void setHanLPDao(NlpTextClassifyDao nlpTextClassifyDao) {
        this.nlpTextClassifyDao = nlpTextClassifyDao;
        this.dao = this.nlpTextClassifyDao;
    }

    @Override
    public NlpTextClassify findById(Long id)
    {
        return nlpTextClassifyDao.getOne(id);
    }
    @Override
    public List<NlpTextClassify> findAll()
    {
        return nlpTextClassifyDao.findAll();
    }
    @Override
    public void deleteById(Long id)
    {
        nlpTextClassifyDao.deleteById(id);
    }
    @Override
    public NlpTextClassify save(NlpTextClassify nlpTextClassify)
    {
        return nlpTextClassifyDao.save( nlpTextClassify);
    }

    @Override
    public NlpTextClassify save(NlpTextClassifyDao nlpTextClassifyDao) {
        return null;
    }

//    NlpTextClassifyDao nlpTextClassifyDao;
//    @Autowired
//    public void setHanLPDao(NlpTextClassifyDao nlpTextClassifyDao) {
//        this.nlpTextClassifyDao = nlpTextClassifyDao;
//        this.dao = this.nlpTextClassifyDao;
//    }
    /*@Override
    public String thuctc(String text)
    {
        //return null;
        // 新建分类器对象
        BasicTextClassifier classifier = new BasicTextClassifier();

        // 设置分类种类，并读取模型
        classifier.loadCategoryListFromFile("D:/JAVA/source/Classify/THUCNews_model/news_model/category");
        classifier.setTextClassifier(new LinearBigramChineseTextClassifier(classifier.getCategorySize()));
        classifier.getTextClassifier().loadModel("D:/JAVA/source/Classify/THUCNews_model/news_model");
        int topN = 1;  // 保留最有可能的3个结果
        String str;
        ClassifyResult[] result = classifier.classifyText(text, topN);
        str = classifier.getCategoryName(result[0].label);
        return str;
    }*/
    @Override
    public String EasyDL(String text) throws Exception {
        final String TEXT_CLS_API ="https://aip.baidubce.com/rpc/2.0/ai_custom/v1/text_cls/Text_Classify_v1";
        final String ACCESS_TOKEN = "24.9536a6b7b2fc52f4d1d17e38c01a3d8c.2592000.1563430987.282335-16551524";
        String params = "{\"text\":\"" + text + "\",\"top_num\":1}";
        String result = HttpUtil.post(TEXT_CLS_API, ACCESS_TOKEN, params);
        return result;
    }
    /*@Override
    public String Fudanlp(String text) throws Exception {

        //训练数据路径
        String trainDataPath = "D:/JAVA/IDEA_Project/NLP/example-data/text-classification/";


         // 模型文件

        String modelFile = "D:/JAVA/IDEA_Project/NLP/example-data/text-classification/model.gz";
        //建立字典管理器
        AlphabetFactory af = AlphabetFactory.buildFactory();

        //使用n元特征
        Pipe ngrampp = new NGram(new int[] {2,3});
        //将字符特征转换成字典索引
        Pipe indexpp = new StringArray2IndexArray(af);
        //将目标值对应的索引号作为类别
        Pipe targetpp = new Target2Label(af.DefaultLabelAlphabet());

        //建立pipe组合
        SeriesPipes pp = new SeriesPipes(new Pipe[]{ngrampp,targetpp,indexpp});

        InstanceSet instset = new InstanceSet(pp,af);

        //用不同的Reader读取相应格式的文件
        Reader reader = new FileReader(trainDataPath,"UTF-8",".data");

        //读入数据，并进行数据处理
        instset.loadThruStagePipes(reader);

        float percent = 0.8f;

        //将数据集分为训练是和测试集
        InstanceSet[] splitsets = instset.split(percent);

        InstanceSet trainset = splitsets[0];
        InstanceSet testset = splitsets[1];

          //建立分类器

        OnlineTrainer trainer = new OnlineTrainer(af);
        Linear pclassifier = trainer.train(trainset);
        pp.removeTargetPipe();
        pclassifier.setPipe(pp);
        af.setStopIncrement(true);

        //将分类器保存到模型文件
        pclassifier.saveTo(modelFile);
        pclassifier = null;

        //从模型文件读入分类器
        Linear cl =Linear.loadFrom(modelFile);

        //性能评测
        Evaluation eval = new Evaluation(testset);
        eval.eval(cl,1);

          //分类器使用

        String str =text;
        System.out.println("============\n待分类的文本："+ str);
        Pipe p = cl.getPipe();
        Instance inst = new Instance(str);
        try {
            //特征转换
            p.addThruPipe(inst);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String res = cl.getStringLabel(inst);
        System.out.println("类别："+ res);
        //清除模型文件
        (new File(modelFile)).deleteOnExit();
        System.exit(0);
        return res;
    }*/
    public static class HttpUtil {

        public static String post(String requestUrl, String accessToken, String params)
                throws Exception {
            String contentType = "application/x-www-form-urlencoded";
            return HttpUtil.post(requestUrl, accessToken, contentType, params);
        }

        public static String post(String requestUrl, String accessToken, String contentType, String params)
                throws Exception {
            String encoding = "UTF-8";
            if (requestUrl.contains("nlp")) {
                encoding = "GBK";
            }
            return HttpUtil.post(requestUrl, accessToken, contentType, params, encoding);
        }

        public static String post(String requestUrl, String accessToken, String contentType, String params, String encoding)
                throws Exception {
            String url = requestUrl + "?access_token=" + accessToken;
            return HttpUtil.postGeneralUrl(url, contentType, params, encoding);
        }

        public static String postGeneralUrl(String generalUrl, String contentType, String params, String encoding)
                throws Exception {
            URL url = new URL(generalUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            // 设置通用的请求属性
            connection.setRequestProperty("Content-Type", contentType);
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // 得到请求的输出流对象
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(params.getBytes(encoding));
            out.flush();
            out.close();

            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> headers = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : headers.keySet()) {
                System.err.println(key + "--->" + headers.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = null;
            in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), encoding));
            String result = "";
            String getLine;
            while ((getLine = in.readLine()) != null) {
                result += getLine;
            }
            in.close();
            System.err.println("result:" + result);
            return result;
        }
    }
}

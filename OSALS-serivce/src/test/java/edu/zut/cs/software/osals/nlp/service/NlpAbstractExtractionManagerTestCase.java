package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpAbstractExtraction;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class NlpAbstractExtractionManagerTestCase extends GenericManagerTestCase<Long, NlpAbstractExtraction, NlpAbstractExtractionManager> {

    public NlpAbstractExtractionManagerTestCase(){
        super(NlpAbstractExtraction.class);
    }

    NlpAbstractExtractionManager nlpAbstractExtractionManager;

    @Autowired
    public void setNlpAbstractExtractionManager(NlpAbstractExtractionManager nlpAbstractExtractionManager){
        this.nlpAbstractExtractionManager = nlpAbstractExtractionManager;
        this.manager = this.nlpAbstractExtractionManager;
    }

    @Test
    public void testHanlp(){
        String document = "原标题：专访：俄方希望与中方寻找双边贸易新增长点——访俄罗斯工业和贸易部长曼图罗夫\n" +
                "新华社记者栾海高兰\n" +
                "“在当前贸易保护主义抬头背景下，俄方希望与中方共同应对风险，化消极因素为机遇，寻找俄中贸易的新增长点”，俄罗斯工业和贸易部长丹尼斯·曼图罗夫日前在接受新华社记者专访时说。\n" +
                "曼图罗夫表示，中国一直是俄重要的战略协作伙伴。当前俄中关系保持快速发展，双方不断在贸易和工业领域寻找新的合作点。据他介绍，今年1月至7月，俄中双边贸易额同比增长超25%，达近600亿美元。\n" +
                "曼图罗夫说，俄中两国正在飞机轮船和其他交通工具制造、无线电设备研发、制药和化工等工业领域开展合作。俄中投资基金支持了两国众多开发项目，投资方对该基金继续注资的兴趣十分浓厚。\n" +
                "在回顾日前结束的第四届东方经济论坛时，曼图罗夫表示，这一论坛已成为俄与中国和其他东北亚国家讨论重大经济合作议题的平台。“在本届论坛期间，俄方与海外企业共签署220项各类协议，协议总金额达3.1万亿卢布（1美元约合66卢布）”。\n" +
                "曼图罗夫说，俄工业和贸易部在本届论坛上与俄外贝加尔边疆区的一家矿业公司负责人进行磋商，以落实中方企业持有该公司股份的相关事宜。根据相关协议，俄中企业将在外贝加尔边疆区的金矿区联合勘探。据俄方估算，这一俄中合作项目有望年产黄金约6.5吨，在2020年前使该边疆区贵金属开采量比目前增加约40%，从而有力促进当地经济发展。\n" +
                "责任编辑：张义凌";
//        List<String> sentenceList = HanLP.extractSummary(document, 3);
//        System.out.println(sentenceList);
        System.out.println(this.nlpAbstractExtractionManager.AbstractExtractionHanlp(document));
    }

    @Test
    public void testAnsj(){
        String content = "7月份一线城市房价趋于稳定 二三线城市环比涨幅明显回落——国家统计局城市司高级统计师刘建伟解读7月份房价数据"+
        "国家统计局今日发布了2017年7月份70个大中城市住宅销售价格统计数据。对此，国家统计局城市司高级统计师刘建伟进行了解读。"+
        "一、15个一线和热点二线城市新建商品住宅价格同比涨幅继续全部回落，10个城市环比下降或持平"+
        "7月份，因地制宜、因城施策的房地产调控政策持续发挥作用，15个一线和热点二线城市房地产市场总体稳定。从同比看，15个城市新建商品住宅价格涨幅均比上月回落，回落幅度在0.8至4.9个百分点之间。从环比看，10个城市新建商品住宅价格下降或持平；5个城市微涨，最高涨幅为0.4%。"+
        "二、70个大中城市中一二线城市房价同比涨幅持续回落"+
        "据测算，一线城市新建商品住宅和二手住宅价格同比涨幅均连续10个月回落，7月份比6月份分别回落1.7和2.0个百分点。二线城市新建商品住宅价格同比涨幅连续8个月回落，7月份比6月份回落0.8个百分点；二手住宅价格同比涨幅连续6个月回落，7月份比6月份回落0.5个百分点。"+
        "三、70个大中城市中环比持平或下降城市个数增加7月份，14个城市新建商品住宅价格环比持平或下降，比上月增加4个。";
        //String title = "国家统计局解读：一二线城市房价同比涨幅持续回落";
//        SummaryComputer summaryComputer = new SummaryComputer(100, "", content);
//        Summary summary = summaryComputer.toSummary();
        System.out.println(this.nlpAbstractExtractionManager.AbstractExtractionAnsj(content));
    }
}

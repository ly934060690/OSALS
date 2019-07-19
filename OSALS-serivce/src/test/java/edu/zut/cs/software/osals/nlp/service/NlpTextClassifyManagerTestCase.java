package edu.zut.cs.software.osals.nlp.service;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.nlp.domain.NlpTextClassify;
//import edu.zut.cs.software.osals.nlp.service.impl.HttpUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class NlpTextClassifyManagerTestCase extends GenericManagerTestCase<Long, NlpTextClassify,NlpTextClassifyManager> {

    static final String TEXT_CLS_API ="https://aip.baidubce.com/rpc/2.0/ai_custom/v1/text_cls/Text_Classify_v1";
    static final String ACCESS_TOKEN = "24.9536a6b7b2fc52f4d1d17e38c01a3d8c.2592000.1563430987.282335-16551524";

    public NlpTextClassifyManagerTestCase() {
        super(NlpTextClassify.class);
    }
    NlpTextClassifyManager nlpTextClassifyManager;

    @Autowired
    public void setnlpManager(NlpTextClassifyManager nlpTextClassifyManager) {
        this.nlpTextClassifyManager = nlpTextClassifyManager;
        this.manager = this.nlpTextClassifyManager;
    }
    @Test
    public void testEasyDL() throws Exception {
        NlpTextClassify nlpTextClassify = new NlpTextClassify();
        String text = "国务院纠风办：纠正银行业金融机构等乱收费问题";
        String url = TEXT_CLS_API;
        // access_token获取方法请详见API使用说明，请注意access_token有效期为30天
        String access_token = ACCESS_TOKEN;
        // 返回分类数量top_num设置为5 如不设置默认返回6条结果
        String params = "{\"text\":\"" + text + "\",\"top_num\":1}";
        //String result = HttpUtil.post(url, access_token, params);
        String result = this.nlpTextClassifyManager.EasyDL(text);
        // 输出识别结果
        //System.out.println(result);
    }
    /*
    @Test
    public void testFudanNlp() throws Exception {
        String text = "国务院纠风办：纠正银行业金融机构等乱收费问题";
        this.nlpTextClassifyManager.Fudanlp(text);
    }
    */
    /*@Test
    public void testTHUCTC()
    {
        String text = "原标题：专访：俄方希望与中方寻找双边贸易新增长点——访俄罗斯工业和贸易部长曼图罗夫\n" +
                "新华社记者栾海高兰\n" +
                "“在当前贸易保护主义抬头背景下，俄方希望与中方共同应对风险，化消极因素为机遇，寻找俄中贸易的新增长点”，俄罗斯工业和贸易部长丹尼斯·曼图罗夫日前在接受新华社记者专访时说。\n" +
                "曼图罗夫表示，中国一直是俄重要的战略协作伙伴。当前俄中关系保持快速发展，双方不断在贸易和工业领域寻找新的合作点。据他介绍，今年1月至7月，俄中双边贸易额同比增长超25%，达近600亿美元。\n" +
                "曼图罗夫说，俄中两国正在飞机轮船和其他交通工具制造、无线电设备研发、制药和化工等工业领域开展合作。俄中投资基金支持了两国众多开发项目，投资方对该基金继续注资的兴趣十分浓厚。\n" +
                "在回顾日前结束的第四届东方经济论坛时，曼图罗夫表示，这一论坛已成为俄与中国和其他东北亚国家讨论重大经济合作议题的平台。“在本届论坛期间，俄方与海外企业共签署220项各类协议，协议总金额达3.1万亿卢布（1美元约合66卢布）”。\n" +
                "曼图罗夫说，俄工业和贸易部在本届论坛上与俄外贝加尔边疆区的一家矿业公司负责人进行磋商，以落实中方企业持有该公司股份的相关事宜。根据相关协议，俄中企业将在外贝加尔边疆区的金矿区联合勘探。据俄方估算，这一俄中合作项目有望年产黄金约6.5吨，在2020年前使该边疆区贵金属开采量比目前增加约40%，从而有力促进当地经济发展。\n" +
                "责任编辑：张义凌";
        System.out.println(this.nlpTextClassifyManager.thuctc(text));
    }*/
}
/* 原标题：专访：俄方希望与中方寻找双边贸易新增长点——访俄罗斯工业和贸易部长曼图罗夫\n" +
                "新华社记者栾海高兰\n" +
                "“在当前贸易保护主义抬头背景下，俄方希望与中方共同应对风险，化消极因素为机遇，寻找俄中贸易的新增长点”，俄罗斯工业和贸易部长丹尼斯·曼图罗夫日前在接受新华社记者专访时说。\n" +
                "曼图罗夫表示，中国一直是俄重要的战略协作伙伴。当前俄中关系保持快速发展，双方不断在贸易和工业领域寻找新的合作点。据他介绍，今年1月至7月，俄中双边贸易额同比增长超25%，达近600亿美元。\n" +
                "曼图罗夫说，俄中两国正在飞机轮船和其他交通工具制造、无线电设备研发、制药和化工等工业领域开展合作。俄中投资基金支持了两国众多开发项目，投资方对该基金继续注资的兴趣十分浓厚。\n" +
                "在回顾日前结束的第四届东方经济论坛时，曼图罗夫表示，这一论坛已成为俄与中国和其他东北亚国家讨论重大经济合作议题的平台。“在本届论坛期间，俄方与海外企业共签署220项各类协议，协议总金额达3.1万亿卢布（1美元约合66卢布）”。\n" +
                "曼图罗夫说，俄工业和贸易部在本届论坛上与俄外贝加尔边疆区的一家矿业公司负责人进行磋商，以落实中方企业持有该公司股份的相关事宜。根据相关协议，俄中企业将在外贝加尔边疆区的金矿区联合勘探。据俄方估算，这一俄中合作项目有望年产黄金约6.5吨，在2020年前使该边疆区贵金属开采量比目前增加约40%，从而有力促进当地经济发展。\n" +
                "责任编辑：张义凌*/

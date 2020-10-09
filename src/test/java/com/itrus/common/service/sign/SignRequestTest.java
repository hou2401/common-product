/*package com.itrus.common.service.sign;

import com.alibaba.fastjson.JSONObject;
import com.itrus.common.WebApplication;
import com.itrus.common.dto.CallApiAllUrlDTO;
import com.itrus.common.http.CommonRequest;
import com.itrus.common.params.sign.PagesSignItem;
import com.itrus.common.params.sign.PdfBatchSign;
import com.itrus.common.params.sign.Signers;
import com.itrus.common.report.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

*//**
 * @ClassName SignRequestTest
 * @Author: Yuliu
 * @Description:
 * @Date:Created in 9:49 2020/4/22
 * @Modified By:
 * @Version 1.0
 **//*
@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)// 指定启动类
public class SignRequestTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private CommonRequest commonRequest;

    @Autowired
    private CallApiAllUrlDTO callApiUrl;

    private final static  String appId = "a929cd69afae46";

    private final static String  secretKey = "7d837a8f7b164c8887802cc94815b6db";

    private final static String url = "http://demo-open.itruscloud.com/apigate/authapi";


    @Test(groups = "内部接口", testName = "批量签署", description = "批量签署")
    @Author(names = "liu_yu")
    public void batchSign() throws Exception {

        PdfBatchSign pdfBatchSign = new PdfBatchSign();
        // 企业印章
        Signers signers1 = new Signers();
        signers1.setCertId(22098842618232832L);
        PagesSignItem pagesSignItem11 = new PagesSignItem();
        pagesSignItem11.setPages("1");
        pagesSignItem11.setSealURI("fss://44198953318612995");
        pagesSignItem11.setX(0.69881F);
        pagesSignItem11.setY(0.16175F);
        List<PagesSignItem> pagesSignItems11 = new ArrayList<>();
        pagesSignItems11.add(pagesSignItem11);
        signers1.setPagesSignatures(pagesSignItems11);

//        个人签名
        Signers signers2 = new Signers();
        signers2.setCertId(22098915100262420L);
        PagesSignItem pagesSignItem21 = new PagesSignItem();
        pagesSignItem11.setPages("1");
        pagesSignItem11.setSealURI("fss://44291557108482112");
        pagesSignItem11.setX(0.49881F);
        pagesSignItem11.setY(0.15175F);
        List<PagesSignItem> pagesSignItems21 = new ArrayList<>();
        pagesSignItems21.add(pagesSignItem21);
        signers2.setPagesSignatures(pagesSignItems21);



        List<Signers> signersList = new ArrayList<>();
        signersList.add(signers1);
        signersList.add(signers2);
        pdfBatchSign.setSigners(signersList);
        pdfBatchSign.setPdfURI("fss://44291028827504703");
        pdfBatchSign.setReturnType("fss");

        JSONObject jsonObject =  commonRequest.batchSign(pdfBatchSign);

    }




}
*/
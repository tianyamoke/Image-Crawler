package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;

/**
 *
 *
 * @author lixing
 * @date 2021/1/6
 */
public class AssignmentDownload {

    public static void main(String[] args) throws Exception {
        //匹配程度一般
        Map<String,Object> map = new HashMap<>();
        parseSomething("梧桐");
    }

    public static void parseSomething(String key) throws Exception {
        int curIndex=0;
        int i=1;
        int total=1;
//        while (true){
            String result = "{\n" +
                    "  \"title\" : \"Hadoop技术_淘宝用户行为分析(大作业+答辩视频)\",\n" +
                    "  \"assetList\" : [ {\n" +
                    "    \"assetId\" : \"1789952\",\n" +
                    "    \"viewableId\" : \"58701199\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"第四组_邓根福_1802211026.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"124135038\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"第四组_邓根福_1802211026.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/d43d3e9095a04754ae661bf94b42c36a.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E9%82%93%E6%A0%B9%E7%A6%8F_%E7%AC%AC%E5%9B%9B%E7%BB%84_%E9%82%93%E6%A0%B9%E7%A6%8F_1802211026.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790223\",\n" +
                    "    \"viewableId\" : \"58719571\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211021周冕.pdf\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"1042487\",\n" +
                    "    \"attachmentContentType\" : \"application/pdf\",\n" +
                    "    \"attachmentFileName\" : \"1802211021周冕.pdf\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/edcba384499d412187d49df4627b79c2.pdf?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%91%A8%E5%86%95_1802211021%E5%91%A8%E5%86%95.pdf\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790224\",\n" +
                    "    \"viewableId\" : \"58719571\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211021周冕.mp4\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"6229025\",\n" +
                    "    \"attachmentContentType\" : \"video/mp4\",\n" +
                    "    \"attachmentFileName\" : \"1802211021周冕.mp4\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/44e86ca8ac5a4258a1def0ea13a6da68.mp4?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%91%A8%E5%86%95_1802211021%E5%91%A8%E5%86%95.mp4\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790225\",\n" +
                    "    \"viewableId\" : \"58719571\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211021周冕.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"6301177\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"1802211021周冕.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/10c79669b76d4320b9b78ca8a8f20a8a.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%91%A8%E5%86%95_1802211021%E5%91%A8%E5%86%95.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790323\",\n" +
                    "    \"viewableId\" : \"58721534\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211023李世良（第五组）.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"63349916\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"1802211023李世良（第五组）.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/84f3a805fc3744768b7b9a569dca43de.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E6%9D%8E%E4%B8%96%E8%89%AF_1802211023%E6%9D%8E%E4%B8%96%E8%89%AF%EF%BC%88%E7%AC%AC%E4%BA%94%E7%BB%84%EF%BC%89.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790344\",\n" +
                    "    \"viewableId\" : \"58722024\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211013彭辉鹏.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"61808043\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"1802211013彭辉鹏.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/7ab4b5bbd6f948be892227b730a75ee9.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%BD%AD%E8%BE%89%E9%B9%8F_1802211013%E5%BD%AD%E8%BE%89%E9%B9%8F.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790450\",\n" +
                    "    \"viewableId\" : \"58724066\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"计科一班第五组朱基伟.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"16272482\",\n" +
                    "    \"attachmentContentType\" : \"application/zip\",\n" +
                    "    \"attachmentFileName\" : \"计科一班第五组朱基伟.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/09ee11804349449caff4f2bfece2eefc.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E6%9C%B1%E5%9F%BA%E4%BC%9F_%E8%AE%A1%E7%A7%91%E4%B8%80%E7%8F%AD%E7%AC%AC%E4%BA%94%E7%BB%84%E6%9C%B1%E5%9F%BA%E4%BC%9F.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790452\",\n" +
                    "    \"viewableId\" : \"58724179\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"hadoop第六组1802211016余弘文.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"118696414\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"hadoop第六组1802211016余弘文.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/f2cf6252436e4c25ba24a8bcec5cf423.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E4%BD%99%E5%BC%98%E6%96%87_hadoop%E7%AC%AC%E5%85%AD%E7%BB%841802211016%E4%BD%99%E5%BC%98%E6%96%87.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790462\",\n" +
                    "    \"viewableId\" : \"58724377\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211018刘源.rar\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"13364319\",\n" +
                    "    \"attachmentContentType\" : null,\n" +
                    "    \"attachmentFileName\" : \"1802211018刘源.rar\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/32e91f6a4ec24c7db9f6d56a7afb6f50.rar?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%88%98%E6%BA%90_1802211018%E5%88%98%E6%BA%90.rar\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790466\",\n" +
                    "    \"viewableId\" : \"58724421\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"第五组1802211020程志雄.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"65853947\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"第五组1802211020程志雄.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/14c9c09ec9a24ead919400b4df3f3b0a.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E7%A8%8B%E5%BF%97%E9%9B%84_%E7%AC%AC%E4%BA%94%E7%BB%841802211020%E7%A8%8B%E5%BF%97%E9%9B%84.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790499\",\n" +
                    "    \"viewableId\" : \"58724891\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211012赖斌.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"123051067\",\n" +
                    "    \"attachmentContentType\" : \"application/zip\",\n" +
                    "    \"attachmentFileName\" : \"1802211012赖斌.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/ba20a375a3a64ac89cc41d00a3394281.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E8%B5%96%E6%96%8C_1802211012%E8%B5%96%E6%96%8C.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790542\",\n" +
                    "    \"viewableId\" : \"58725754\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"18计科一班第六组肖灵勇.rar\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"182175310\",\n" +
                    "    \"attachmentContentType\" : null,\n" +
                    "    \"attachmentFileName\" : \"18计科一班第六组肖灵勇.rar\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/c9162e6456ce4654884b65f8eae63045.rar?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E8%82%96%E7%81%B5%E5%8B%87_18%E8%AE%A1%E7%A7%91%E4%B8%80%E7%8F%AD%E7%AC%AC%E5%85%AD%E7%BB%84%E8%82%96%E7%81%B5%E5%8B%87.rar\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790728\",\n" +
                    "    \"viewableId\" : \"58729166\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"第五组1802211022张鑫.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"36086329\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"第五组1802211022张鑫.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/3ef364c2fe8e4c8a9a090003e350efa4.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%BC%A0%E9%91%AB_%E7%AC%AC%E4%BA%94%E7%BB%841802211022%E5%BC%A0%E9%91%AB.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790848\",\n" +
                    "    \"viewableId\" : \"58730964\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211024张瑞.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"39347832\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"1802211024张瑞.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/45567199ec54462b921a31a8899f90ce.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%BC%A0%E7%91%9E_1802211024%E5%BC%A0%E7%91%9E.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1790972\",\n" +
                    "    \"viewableId\" : \"58732951\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"刘泽铭.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"89441504\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"刘泽铭.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/9159959c82ea4ad88be38385e0b6b88a.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%88%98%E6%B3%BD%E9%93%AD_%E5%88%98%E6%B3%BD%E9%93%AD.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791645\",\n" +
                    "    \"viewableId\" : \"58735313\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211025\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"38020995\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"1802211025\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/3a6e0a9209b941ae95ff731c40adf2a1.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E7%8E%8B%E7%99%BB%E9%AB%98_1802211025.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791191\",\n" +
                    "    \"viewableId\" : \"58737922\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"18计科一班第六组程祥龙.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"47814803\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"18计科一班第六组程祥龙.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/37d8eb0e9ec1423d933c3f1491f533ee.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E7%A8%8B%E7%A5%A5%E9%BE%99_18%E8%AE%A1%E7%A7%91%E4%B8%80%E7%8F%AD%E7%AC%AC%E5%85%AD%E7%BB%84%E7%A8%8B%E7%A5%A5%E9%BE%99.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791528\",\n" +
                    "    \"viewableId\" : \"58740090\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"4组黎志斌.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"15584192\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"4组黎志斌.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/f3af98e5bfa14ec3abf716ae58c7aeea.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E9%BB%8E%E5%BF%97%E6%96%8C_4%E7%BB%84%E9%BB%8E%E5%BF%97%E6%96%8C.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791583\",\n" +
                    "    \"viewableId\" : \"58740412\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"18计科一班1802211043谢嘉欣.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"92843700\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"18计科一班1802211043谢嘉欣.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/863b5a3890b04b57acce88cbad0e0da1.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E8%B0%A2%E5%98%89%E6%AC%A3_18%E8%AE%A1%E7%A7%91%E4%B8%80%E7%8F%AD1802211043%E8%B0%A2%E5%98%89%E6%AC%A3.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791650\",\n" +
                    "    \"viewableId\" : \"58741057\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"18计科一班第二组张静.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"60814668\",\n" +
                    "    \"attachmentContentType\" : \"application/zip\",\n" +
                    "    \"attachmentFileName\" : \"18计科一班第二组张静.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/e6c625ccbc4943bc8c2a3144991370f0.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%BC%A0%E9%9D%99_18%E8%AE%A1%E7%A7%91%E4%B8%80%E7%8F%AD%E7%AC%AC%E4%BA%8C%E7%BB%84%E5%BC%A0%E9%9D%99.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791660\",\n" +
                    "    \"viewableId\" : \"58741402\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"第七组江浩.rar\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"46668060\",\n" +
                    "    \"attachmentContentType\" : null,\n" +
                    "    \"attachmentFileName\" : \"第七组江浩.rar\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/998e8ab696d04effaa70c0331aa962ec.rar?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E6%B1%9F%E6%B5%A9_%E7%AC%AC%E4%B8%83%E7%BB%84%E6%B1%9F%E6%B5%A9.rar\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791711\",\n" +
                    "    \"viewableId\" : \"58743148\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211034童周琨.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"79988446\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"1802211034童周琨.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/57fc1c09569848bd95b8baa7af9449f5.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E7%AB%A5%E5%91%A8%E7%90%A8_1802211034%E7%AB%A5%E5%91%A8%E7%90%A8.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791724\",\n" +
                    "    \"viewableId\" : \"58743243\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211031肖明\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"55148951\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"1802211031肖明\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/cfc758367c054a31a7542c7ae1394793.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E8%82%96%E6%98%8E_1802211031%E8%82%96%E6%98%8E.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791745\",\n" +
                    "    \"viewableId\" : \"58743717\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"一组1802211005陈文玲.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"97587525\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"一组1802211005陈文玲.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/556ac5e7ee274079aad9cd5503232533.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E9%99%88%E6%96%87%E7%8E%B2_%E4%B8%80%E7%BB%841802211005%E9%99%88%E6%96%87%E7%8E%B2.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791873\",\n" +
                    "    \"viewableId\" : \"58743858\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"Hadoop大作业.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"21777272\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"Hadoop大作业.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/91c55fbe9ae34f23b3e6d7ee2b069b12.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E7%8E%8B%E5%A7%9D%E9%BD%90_Hadoop%E5%A4%A7%E4%BD%9C%E4%B8%9A.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791821\",\n" +
                    "    \"viewableId\" : \"58745258\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"18计科吴晓阳第一组.rar\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"119499722\",\n" +
                    "    \"attachmentContentType\" : null,\n" +
                    "    \"attachmentFileName\" : \"18计科吴晓阳第一组.rar\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/f80ef68e4d964b1896883ea5a388f059.rar?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%90%B4%E6%99%93%E9%98%B3_18%E8%AE%A1%E7%A7%91%E5%90%B4%E6%99%93%E9%98%B3%E7%AC%AC%E4%B8%80%E7%BB%84.rar\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791879\",\n" +
                    "    \"viewableId\" : \"58745446\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"7组王鸿优.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"25371510\",\n" +
                    "    \"attachmentContentType\" : \"application/zip\",\n" +
                    "    \"attachmentFileName\" : \"7组王鸿优.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/41b279f937d94b7cace25e21720f3ad9.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E7%8E%8B%E9%B8%BF%E4%BC%98_7%E7%BB%84%E7%8E%8B%E9%B8%BF%E4%BC%98.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791949\",\n" +
                    "    \"viewableId\" : \"58746243\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"hadoop第三组1802211042邱永图.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"64508106\",\n" +
                    "    \"attachmentContentType\" : \"application/zip\",\n" +
                    "    \"attachmentFileName\" : \"hadoop第三组1802211042邱永图.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/a01f124a934544d0a26834bf95ef9321.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E9%82%B1%E6%B0%B8%E5%9B%BE_hadoop%E7%AC%AC%E4%B8%89%E7%BB%841802211042%E9%82%B1%E6%B0%B8%E5%9B%BE.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791951\",\n" +
                    "    \"viewableId\" : \"58746251\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211033刘光辉第七组.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"56707466\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"1802211033刘光辉第七组.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/80e31ba335af4f298e5cf90a8c0ab77a.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%88%98%E5%85%89%E8%BE%89_1802211033%E5%88%98%E5%85%89%E8%BE%89%E7%AC%AC%E4%B8%83%E7%BB%84.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1791971\",\n" +
                    "    \"viewableId\" : \"58746292\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"hadoop第三组艾家荣.rar\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"55409541\",\n" +
                    "    \"attachmentContentType\" : null,\n" +
                    "    \"attachmentFileName\" : \"hadoop第三组艾家荣.rar\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/f24f1af9d32f4080b06f15eff87b47fc.rar?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E8%89%BE%E5%AE%B6%E8%8D%A3_hadoop%E7%AC%AC%E4%B8%89%E7%BB%84%E8%89%BE%E5%AE%B6%E8%8D%A3.rar\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1792033\",\n" +
                    "    \"viewableId\" : \"58746550\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"第一组1802211006张小丽.rar\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"33062406\",\n" +
                    "    \"attachmentContentType\" : null,\n" +
                    "    \"attachmentFileName\" : \"第一组1802211006张小丽.rar\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/80d7619cf9c9492e9cebc966db7943ad.rar?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%BC%A0%E5%B0%8F%E4%B8%BD_%E7%AC%AC%E4%B8%80%E7%BB%841802211006%E5%BC%A0%E5%B0%8F%E4%B8%BD.rar\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1792064\",\n" +
                    "    \"viewableId\" : \"58746885\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"Hadoop万琳1803232022.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"195170914\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"Hadoop万琳1803232022.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/26533e2a2ffe494d9a119145ef828cde.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E4%B8%87%E7%90%B3_Hadoop%E4%B8%87%E7%90%B31803232022.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1792065\",\n" +
                    "    \"viewableId\" : \"58746908\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211014顾海锋.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"71572680\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"1802211014顾海锋.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/41cd3cdac4d44a4aa1d77b1234491183.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E9%A1%BE%E6%B5%B7%E9%94%8B_1802211014%E9%A1%BE%E6%B5%B7%E9%94%8B.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1792090\",\n" +
                    "    \"viewableId\" : \"58747019\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"hadoop\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"60523731\",\n" +
                    "    \"attachmentContentType\" : null,\n" +
                    "    \"attachmentFileName\" : \"hadoop\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/c2cbbd347d474bb5ad8b0972de3da439.rar?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%BC%A0%E5%87%AF_hadoop.rar\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1792087\",\n" +
                    "    \"viewableId\" : \"58747146\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"吴华珍第二组.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"329706525\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"吴华珍第二组.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/828dad1bb90c43b89b9364910b944bb7.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%90%B4%E5%8D%8E%E7%8F%8D_%E5%90%B4%E5%8D%8E%E7%8F%8D%E7%AC%AC%E4%BA%8C%E7%BB%84.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1792088\",\n" +
                    "    \"viewableId\" : \"58747161\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"第三组吴佳隆.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"60372295\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"第三组吴佳隆.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/ab06fdba34df416b9b8c0d60c2e289ff.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%90%B4%E4%BD%B3%E9%9A%86_%E7%AC%AC%E4%B8%89%E7%BB%84%E5%90%B4%E4%BD%B3%E9%9A%86.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1792095\",\n" +
                    "    \"viewableId\" : \"58747376\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211004喻颖洁.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"10469940\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"1802211004喻颖洁.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/22904dec67d8478dad34e7b7e3b359aa.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%96%BB%E9%A2%96%E6%B4%81_1802211004%E5%96%BB%E9%A2%96%E6%B4%81.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1792164\",\n" +
                    "    \"viewableId\" : \"58748139\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"第三组1802211037王路宏.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"54412044\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"第三组1802211037王路宏.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/889225b3615743fc918e3fc03c906387.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E7%8E%8B%E8%B7%AF%E5%AE%8F_%E7%AC%AC%E4%B8%89%E7%BB%841802211037%E7%8E%8B%E8%B7%AF%E5%AE%8F.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1792170\",\n" +
                    "    \"viewableId\" : \"58748432\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211038钟若虚.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"37402472\",\n" +
                    "    \"attachmentContentType\" : \"application/zip\",\n" +
                    "    \"attachmentFileName\" : \"1802211038钟若虚.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/d280486f49104e18aec4f5c73b3068bc.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E9%92%9F%E8%8B%A5%E8%99%9A_1802211038%E9%92%9F%E8%8B%A5%E8%99%9A.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1792212\",\n" +
                    "    \"viewableId\" : \"58749418\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211011吴肖剑.rar\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"56669172\",\n" +
                    "    \"attachmentContentType\" : null,\n" +
                    "    \"attachmentFileName\" : \"1802211011吴肖剑.rar\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/dca78c9739ea436a8b2c43e953cf3369.rar?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%90%B4%E8%82%96%E5%89%91_1802211011%E5%90%B4%E8%82%96%E5%89%91.rar\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1792225\",\n" +
                    "    \"viewableId\" : \"58749759\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"18计科一班第七组1802211003章佳丽.rar\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"11755834\",\n" +
                    "    \"attachmentContentType\" : null,\n" +
                    "    \"attachmentFileName\" : \"18计科一班第七组1802211003章佳丽.rar\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/6a76af8e4d004264a298d2abd7303ad9.rar?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E7%AB%A0%E4%BD%B3%E4%B8%BD_18%E8%AE%A1%E7%A7%91%E4%B8%80%E7%8F%AD%E7%AC%AC%E4%B8%83%E7%BB%841802211003%E7%AB%A0%E4%BD%B3%E4%B8%BD.rar\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1793827\",\n" +
                    "    \"viewableId\" : \"58772467\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"18计科一班第二组刘云.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"260034\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"18计科一班第二组刘云.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/dccf30fad3924cfcb2c5c953f822f6a1.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%88%98%E4%BA%91_18%E8%AE%A1%E7%A7%91%E4%B8%80%E7%8F%AD%E7%AC%AC%E4%BA%8C%E7%BB%84%E5%88%98%E4%BA%91.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1793828\",\n" +
                    "    \"viewableId\" : \"58772467\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"18计科一班第二组刘云.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"419105\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"18计科一班第二组刘云.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/c8de7bfb738b4d99a9879796508ee637.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E5%88%98%E4%BA%91_18%E8%AE%A1%E7%A7%91%E4%B8%80%E7%8F%AD%E7%AC%AC%E4%BA%8C%E7%BB%84%E5%88%98%E4%BA%91.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1794164\",\n" +
                    "    \"viewableId\" : \"58776783\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"7组耿超.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"201055018\",\n" +
                    "    \"attachmentContentType\" : \"application/x-zip-compressed\",\n" +
                    "    \"attachmentFileName\" : \"7组耿超.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/2d497d016ebe4bfd84d2ae3d1b7bc259.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E8%80%BF%E8%B6%85_7%E7%BB%84%E8%80%BF%E8%B6%85.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  }, {\n" +
                    "    \"assetId\" : \"1794238\",\n" +
                    "    \"viewableId\" : \"58777493\",\n" +
                    "    \"viewableType\" : \"Submission\",\n" +
                    "    \"title\" : \"1802211007许欢.zip\",\n" +
                    "    \"attachmentWidth\" : null,\n" +
                    "    \"attachmentHeight\" : null,\n" +
                    "    \"attachmentFileSize\" : \"41289493\",\n" +
                    "    \"attachmentContentType\" : \"application/zip\",\n" +
                    "    \"attachmentFileName\" : \"1802211007许欢.zip\",\n" +
                    "    \"attachmentUpdatedAt\" : null,\n" +
                    "    \"link\" : \"https://gxbfile-gs.gaoxiaobang.com/lcms/attachment/link/4da9ecefa95e4fc5983f1dd57562d618.zip?contentdisposition=18%E8%AE%A1%E7%A7%911%E7%8F%AD_%E8%AE%B8%E6%AC%A2_1802211007%E8%AE%B8%E6%AC%A2.zip\",\n" +
                    "    \"alt\" : null,\n" +
                    "    \"type\" : \"AssignmentAttachment\",\n" +
                    "    \"position\" : null,\n" +
                    "    \"status\" : null,\n" +
                    "    \"uuid\" : null,\n" +
                    "    \"list\" : null\n" +
                    "  } ]\n" +
                    "}";
            JSONObject obj = JSON.parseObject(result);
            JSONArray arr = JSONArray.parseArray(obj.get("assetList").toString());

        total = arr.size();
            for(Object object: arr){
                JSONObject json = (JSONObject)object;
                if(json!=null && json.get("link")!=null && !"".equals(json.get("link").toString())){
                    System.out.println("正在下载第"+i+"/"+total+"个附件");
                    HttpUtils2.downloadPicture(json.get("link").toString(),"zuoye",json.get("title").toString());
                }
                i++;
            }


    }


}

/**
 * projectName: chunjiang
 * fileName: GetHtmlMeta.java
 * packageName: com.jiehui.chunjiang.common.utils
 * date: 2021-05-14 16:34
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.jiehui.chunjiang.dao.SysConfigDao;
import com.jiehui.chunjiang.entity.SysConfigEntity;
import com.jiehui.chunjiang.vo.HtmlMetaVO;
import org.springframework.beans.factory.annotation.Autowired;

public class GetHtmlMeta {

    private SysConfigDao sysConfigDao;

    public HtmlMetaVO getHtmlMetaZH() {
        SysConfigEntity sysConfigEntity = SpringUtil.querySysConfigEntityZH();
        HtmlMetaVO htmlMetaVO = new HtmlMetaVO();
        String content = sysConfigEntity.getParamValue();
        JSONObject jsonObject = JSONObject.parseObject(content);
        String description = jsonObject.getString("descri");
        String iconUrl = jsonObject.getString("iconurl");
        String keywords = jsonObject.getString("keyword");
        String websiteName = jsonObject.getString("webname");
        String title = jsonObject.getString("title");
        String record = jsonObject.getString("record");
        String slogan = jsonObject.getString("slogan");
        htmlMetaVO.setDescription(description);
        htmlMetaVO.setIconUrl(iconUrl);
        htmlMetaVO.setKeyWords(keywords);
        htmlMetaVO.setTitle(title);
        htmlMetaVO.setWebsiteName(websiteName);
        htmlMetaVO.setRecord(record);
        htmlMetaVO.setSlogan(slogan);
        return htmlMetaVO;
    }

    public HtmlMetaVO getHtmlMetaEN() {
        SysConfigEntity sysConfigEntity = SpringUtil.querySysConfigEntityEN();
        HtmlMetaVO htmlMetaVO = new HtmlMetaVO();
        String content = sysConfigEntity.getParamValue();
        JSONObject jsonObject = JSONObject.parseObject(content);
        String description = jsonObject.getString("descri");
        String iconUrl = jsonObject.getString("iconurl");
        String keywords = jsonObject.getString("keyword");
        String websiteName = jsonObject.getString("webname");
        String title = jsonObject.getString("title");
        String record = jsonObject.getString("record");
        String slogan = jsonObject.getString("slogan");
        htmlMetaVO.setDescription(description);
        htmlMetaVO.setIconUrl(iconUrl);
        htmlMetaVO.setKeyWords(keywords);
        htmlMetaVO.setTitle(title);
        htmlMetaVO.setWebsiteName(websiteName);
        htmlMetaVO.setRecord(record);
        htmlMetaVO.setSlogan(slogan);
        return htmlMetaVO;
    }

}

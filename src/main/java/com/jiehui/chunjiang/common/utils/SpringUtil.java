/**
 * projectName: chunjiang
 * fileName: SpringUtil.java
 * packageName: com.jiehui.chunjiang.common.utils
 * date: 2021-05-14 17:08
 * copyright(c) 2017-2020 xxx公司
 */
package com.jiehui.chunjiang.common.utils;


import com.jiehui.chunjiang.dao.SysConfigDao;
import com.jiehui.chunjiang.entity.SysConfigEntity;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/3 21:57
 * @Version 1.0
 */
@Component
public class SpringUtil {

    @Autowired
    private SysConfigDao sysConfigDao;

    public static SpringUtil springUtil;

    @PostConstruct
    public void init(){
        springUtil = this;
        springUtil.sysConfigDao = this.sysConfigDao;
    }

    public static SysConfigEntity querySysConfigEntityZH(){
        return springUtil.sysConfigDao.queryByKey("WEBASE_KEY");
    }

    public static SysConfigEntity querySysConfigEntityEN(){
        return springUtil.sysConfigDao.queryByKey("WEBASE_KEY_EN");
    }
}

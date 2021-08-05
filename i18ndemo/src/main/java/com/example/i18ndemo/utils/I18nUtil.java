package com.example.i18ndemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @program: website
 * @description: 获取国际化配置文件
 **/


public class I18nUtil {

    private static ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

    static {
        //指定国家化资源文件路径
        messageSource.setBasename("i18n/mymessage");
        //指定将用来加载对应资源文件时使用的编码，默认为空，表示将使用默认的编码进行获取。
        messageSource.setDefaultEncoding("UTF-8");
    }

    public static String getCnByKey(String key){

        return messageSource.getMessage(key, null, Locale.CHINA);
    }

    public static String getDeafultByKey(String key){

        return messageSource.getMessage(key, null, null);
    }

    public static String getEnByKey(String key){

        return messageSource.getMessage(key, null, Locale.US);
    }

    public static String getValueAndPlaceholder(String key){

        return messageSource.getMessage(key, new Object[]{"安全"}, null);
    }

}

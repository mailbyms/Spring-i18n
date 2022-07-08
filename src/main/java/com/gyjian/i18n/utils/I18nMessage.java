package com.gyjian.i18n.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;

/**
 * 多语言国际化消息工具类
 */
@Slf4j
public class I18nMessage {
    private static final String BASE_NAME = "i18n/messages";

    private static MessageSourceAccessor accessor;

    static{
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasenames(BASE_NAME);
        reloadableResourceBundleMessageSource.setCacheSeconds(5);
        reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
        accessor = new MessageSourceAccessor(reloadableResourceBundleMessageSource);
    }


    /**
     * 获取一条语言配置信息
     *
     * @param message 配置信息属性名,eg: api.response.code.user.signUp
     */
    public static String getMessage(String message) {


        Locale locale = LocaleContextHolder.getLocale();

        log.info("LocaleContextHolder.getLocale(): " + locale.getLanguage());
        try {
            return accessor.getMessage(message,locale);
        }catch (Exception e){
            return message;
        }
    }

    /**
     * 获取一条语言配置信息（后台管理）
     *
     * @return
     * @throws IOException
     */
    public static Integer getLang() {
        Locale locale = LocaleContextHolder.getLocale();
        return LanguageEnum.valueOf(locale).getLang();
    }

    /**
     * 获取一条语言配置信息(小程序、pc)
     *
     * @return
     * @throws IOException
     */
    public static Integer getDbLang() {
        Integer lang = getLang();
        if (Objects.equals(lang, 0)) {
            return LanguageEnum.LANGUAGE_ZH_CN.getLang();
        }
        return lang;
    }

}

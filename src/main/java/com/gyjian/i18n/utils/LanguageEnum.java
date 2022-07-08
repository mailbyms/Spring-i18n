package com.gyjian.i18n.utils;


import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Locale;
import java.util.Objects;

/**
 * 国际化 语言枚举类
 */
@AllArgsConstructor
public enum LanguageEnum {
    /**
     * 简体中文
     */
    LANGUAGE_ZH_CN("zh", 0),
    /**
     * 英文
     */
    LANGUAGE_EN("en", 1)

    ;

    public Integer getLang() {
        return lang;
    }

    private String language;

    private Integer lang;


    /**
     * 获取指定语言类型(如果没有对应的语言类型,则返回中文)
     *
     * @param language 语言类型
     * @return
     */
    public static String getLanguageType(String language){
        if (StringUtils.isEmpty(language)) {
            return LANGUAGE_ZH_CN.language;
        }
        for (LanguageEnum languageEnum : LanguageEnum.values()) {
            if (languageEnum.language.equalsIgnoreCase(language)) {
                return languageEnum.language;
            }
        }
        return LANGUAGE_ZH_CN.language;
    }


    public static LanguageEnum valueOf(int lang) {
        for (LanguageEnum languageEnum : values()) {
            if (languageEnum.lang == lang) {
                return languageEnum;
            }
        }
        return LanguageEnum.LANGUAGE_ZH_CN;
    }

    public static LanguageEnum valueOf(Locale locale) {
        for (LanguageEnum languageEnum : values()) {
            if (Objects.equals(languageEnum.language, locale.toString())) {
                return languageEnum;
            }
        }
        return LanguageEnum.LANGUAGE_ZH_CN;
    }

}

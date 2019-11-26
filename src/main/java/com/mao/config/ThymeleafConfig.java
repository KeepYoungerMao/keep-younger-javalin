package com.mao.config;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * thymeleaf模板配置
 * @author mao by 15:43 2019/11/26
 */
public class ThymeleafConfig {

    public static TemplateEngine thymeleafConfig(){
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("HTML");
        templateResolver.setPrefix("/pages/");
        templateResolver.setSuffix(".html");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

}
package com.zben.config;

/**
 * @Author:zben
 * @Date: 2018/4/21/021 11:56
 */

/*
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter implements
        ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

*/
/**
     * 模板资源解析器
     * @return
     *//*


    @Bean
    @ConfigurationProperties(prefix = "spring.thymeleaf")
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);

        return templateResolver;
    }

*/
/**
     * Thymeleaf标准方言解释器
     *//*


    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        // 支持Spring EL表达式
        //templateEngine.setEnableSpringELCompiler(true);

        //支持springSecurity方言
        SpringSecurityDialect springSecurityDialect = new SpringSecurityDialect();
        templateEngine.addDialect(springSecurityDialect);
        return templateEngine;
    }

*/
/**
     * 视图解析器
     *//*


    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }
}
*/


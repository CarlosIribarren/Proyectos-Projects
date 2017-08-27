package net.hge.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


@EnableWebMvc // <mvc:annotation-driven />
@Configuration
@ComponentScan({ "net.hge.*" })
@EnableTransactionManagement
public abstract class GestionModelosWebMvc extends WebMvcConfigurerAdapter {

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/estatico/**").addResourceLocations("/estatico/");
  }

  @Bean
  public TilesViewResolver tilesViewResolver() {
    final TilesViewResolver tilesViewResolver = new TilesViewResolver();
    tilesViewResolver.setViewClass(TilesView.class);
    tilesViewResolver.setRequestContextAttribute("springRequestContext");
    tilesViewResolver.setOrder(1);
    return tilesViewResolver;
  }

  @Bean
  public TilesConfigurer tilesConfigurer() {
    final TilesConfigurer tilesConfigurer = new TilesConfigurer();
    tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles-defs.xml" });
    return tilesConfigurer;
  }

  @Bean
  public MessageSource messageSource() {
    final String[] baseNames = this.addMessageSourceBaseNames();
    final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setBasenames(baseNames);
    return messageSource;
  }

  @Bean
  public LocaleResolver localeResolver() {
    return new SessionLocaleResolver();
  }

  @Override
  public void addInterceptors(final InterceptorRegistry registry) {
    // registrar el parametro locale que pasamos para el multilenguaje
    final LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
    localeInterceptor.setParamName("locale");

    registry.addInterceptor(localeInterceptor).addPathPatterns("/*");
  }

  public String[] addMessageSourceBaseNames() {
    return new String[] { "net/hge/gestionmodeloszerga/web/resources/ApplicationResources" };
  }

}

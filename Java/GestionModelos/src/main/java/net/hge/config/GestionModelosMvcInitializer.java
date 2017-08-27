package net.hge.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class GestionModelosMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] { GestionModelosConfig.class, DataConfig.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] { GestionModelosWebMvc.class };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}

package net.eurohelp.hge.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class GestionModelosZergaMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] { GestionModelosZergaConfig.class, DataConfig.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] { GestionModelosZergaWebMvc.class };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}

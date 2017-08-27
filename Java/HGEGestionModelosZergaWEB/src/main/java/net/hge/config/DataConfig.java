package net.eurohelp.hge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;


/**
 * Beans que son sensibles al entorno (desa/producción y local). Por ejemplo,
 * filenet, base de datos, etc.
 */
public final class DataConfig {
  private static final String JNDI = "jdbc/HGFZergaBideaDS";

  private DataConfig() {
  }

  @Configuration
  public static class LocalDataConfig {

    @Bean
    public JndiObjectFactoryBean dataSource() {
      final JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
      jndiObjectFactoryBean.setJndiName(JNDI);
      jndiObjectFactoryBean.setResourceRef(true);
      return jndiObjectFactoryBean;
    }
  }
}

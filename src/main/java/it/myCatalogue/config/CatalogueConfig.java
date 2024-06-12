package it.myCatalogue.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import it.myCatalogue.dao.ProdottoService;
import it.myCatalogue.dao.impl.ProdottoServiceImpl;
import it.myCatalogue.model.Prodotto;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "it.myCatalogue.controller")
@PropertySource("classpath:myCatalogueDBProperties.properties")
@EnableTransactionManagement
public class CatalogueConfig {
	
	@Bean
	public FreeMarkerViewResolver getViewResolver() {
		
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setPrefix("");
		resolver.setSuffix(".ftl");
		
		return resolver;
		
	}
	
	@Bean
	public FreeMarkerConfigurer getViewConfigurer() {
		
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		
		configurer.setTemplateLoaderPath("/WEB-INF/view/");
		
		return configurer;
		
	}
	
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("myCatalogue.DBDriver");
		ds.setUrl("myCatalogue.DBUrl");
		ds.setUsername("myCatalogue.DBUsername");
		
		return ds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManager() {
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setGenerateDdl(true);
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(getDataSource());
		em.setJpaVendorAdapter(adapter);
		em.setPackagesToScan(getClass().getPackage().getName());
		
		return em;
		
	}
	
	@Bean
	public PlatformTransactionManager getTransactionManager() {
		
		return new JpaTransactionManager(getEntityManager().getObject());
		
	}
	
	@Bean
	public ProdottoService getProdottoService() {
		return new ProdottoServiceImpl();
		}

}

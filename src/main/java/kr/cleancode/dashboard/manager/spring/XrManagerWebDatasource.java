package kr.cleancode.dashboard.manager.spring;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "kr.cleancode.dashboard.manager.web", sqlSessionFactoryRef="sqlSessionFactoryWeb")
@EnableTransactionManagement
public class XrManagerWebDatasource {

	@Primary
    @Bean(name="dataSourceWeb")
    @ConfigurationProperties(prefix="spring.datasource.web")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
 
    @Primary
    @Bean(name="sqlSessionFactoryWeb")
    public SqlSessionFactory sqlSessionFactoryBean(@Autowired @Qualifier("dataSourceWeb") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
        final SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:sql/web/mybatis-config.xml"));
//        factoryBean.setMapperLocations(applicationContext.getResources("classpath:sql/web/**/*.xml"));
        
        return factoryBean.getObject();
    }
 
    @Primary
    @Bean(name="sqlSessionWeb")
    public SqlSessionTemplate sqlSession(@Autowired @Qualifier("sqlSessionFactoryWeb") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
 
    @Primary
    @Bean(name="transactionManagerWeb")
    public DataSourceTransactionManager transactionManager(@Autowired @Qualifier("dataSourceWeb") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
}

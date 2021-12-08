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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "kr.cleancode.dashboard.manager.global", sqlSessionFactoryRef="sqlSessionFactoryGlobal")
@EnableTransactionManagement
public class XrManagerGlobalDatasource {

	@Bean(name="dataSourceGlobal")
    @ConfigurationProperties(prefix="spring.datasource.global")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
 
    @Bean(name="sqlSessionFactoryGlobal")
    public SqlSessionFactory sqlSessionFactoryBean(@Autowired @Qualifier("dataSourceGlobal") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
        final SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:sql/global/mybatis-config.xml"));
//        factoryBean.setMapperLocations(applicationContext.getResources("classpath:sql/global/**/*.xml"));
        
        return factoryBean.getObject();
    }
 
    @Bean(name="sqlSessionGlobal")
    public SqlSessionTemplate sqlSession(@Autowired @Qualifier("sqlSessionFactoryGlobal") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
 
    @Bean(name="transactionManagerGlobal")
    public DataSourceTransactionManager transactionManager(@Autowired @Qualifier("dataSourceGlobal") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
}

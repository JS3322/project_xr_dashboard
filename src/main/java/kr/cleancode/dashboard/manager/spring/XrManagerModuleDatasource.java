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
@MapperScan(value = "kr.cleancode.dashboard.manager.module", sqlSessionFactoryRef="sqlSessionFactoryModule")
@EnableTransactionManagement
public class XrManagerModuleDatasource {

	@Bean(name="dataSourceModule")
    @ConfigurationProperties(prefix="spring.datasource.module")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
 
    @Bean(name="sqlSessionFactoryModule")
    public SqlSessionFactory sqlSessionFactoryBean(@Autowired @Qualifier("dataSourceModule") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
        final SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:sql/module/mybatis-config.xml"));
//        factoryBean.setMapperLocations(applicationContext.getResources("classpath:sql/global/**/*.xml"));
        
        return factoryBean.getObject();
    }
 
    @Bean(name="sqlSessionModule")
    public SqlSessionTemplate sqlSession(@Autowired @Qualifier("sqlSessionFactoryModule") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
 
    @Bean(name="transactionManagerModule")
    public DataSourceTransactionManager transactionManager(@Autowired @Qualifier("dataSourceModule") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
}

package imcs.trng.raghu.dao.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"imcs.trng.raghu.dao"})
public class DbConfig {

	@Bean
	public DataSource getDataSource() {
		org.apache.commons.dbcp2.BasicDataSource dataSoruce = new BasicDataSource();
		dataSoruce.setDriverClassName("com.mysql.jdbc.Driver");
		dataSoruce.setUrl("jdbc:mysql://localhost:3306/imcs2?useSSL=true");
		dataSoruce.setUsername("root");
		dataSoruce.setPassword("root");
		
		return dataSoruce;
	}
	
}

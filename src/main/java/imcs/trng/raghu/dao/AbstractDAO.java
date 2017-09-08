package imcs.trng.raghu.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO {
	
	@Autowired
	public DataSource dataSource;
	
}

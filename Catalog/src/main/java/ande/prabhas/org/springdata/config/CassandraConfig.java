package ande.prabhas.org.springdata.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;

@Configuration
@PropertySource(value = { "classpath:cassandra.properties" })
public class CassandraConfig  extends AbstractCassandraConfiguration {
	private static final Log LOGGER = LogFactory.getLog(CassandraConfig.class);
	
	@Autowired
    private Environment environment;

	@Override
	protected String getKeyspaceName() {
		return environment.getProperty("cassandra.keyspace");
	}

	
	@Override
    @Bean
    public CassandraClusterFactoryBean cluster() {
		LOGGER.info("Inside Cluster()");
        final CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(environment.getProperty("cassandra.contactpoints"));
        cluster.setPort(Integer.parseInt(environment.getProperty("cassandra.port")));
        cluster.setUsername(environment.getProperty("cassandra.username"));
        cluster.setPassword(environment.getProperty("cassandra.password"));
        LOGGER.info("Cluster created with contact points [" + environment.getProperty("cassandra.contactpoints") + "] " + "& port [" + Integer.parseInt(environment.getProperty("cassandra.port")) + "].");
        return cluster;
    }
	
}

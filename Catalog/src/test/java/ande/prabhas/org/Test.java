package ande.prabhas.org;

import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.test.context.ContextConfiguration;

import ande.prabhas.org.springdata.config.CassandraConfig;

@ContextConfiguration(classes = CassandraConfig.class)
public class Test {

	public static void main(String[] args) {
		
		System.out.println("This is SpringBoot");
		
		CassandraConfig cfg=new CassandraConfig();
		
		
		
		CassandraClusterFactoryBean fBean=cfg.cluster();
		
		System.out.println("@@@@@@@@@@@"+fBean.getKeyspaceActions());

	}

}

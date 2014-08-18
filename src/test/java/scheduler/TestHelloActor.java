package scheduler;

import org.junit.Test;
import java.util.*;

public class TestHelloActor {
	//@Test
	public void testGreetingActor() {
		new HelloWordCountWithActor();
		
		try {
		Thread.sleep(1000 * 30);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testMySQLConnection() {
		new HelloMySQL();
	}
	
	
	//@Test
	public void testSqueryL() {
		new HelloSqueryl();
	}
	
	//@Test
	public void testHibernate() {
		HelloHibernate.main(null);
	}
	
	//@Test
	public void testEmail() {
		HelloEmail.main(null);
	}
	
	//@Test
	public void testRemoteActor() {
		WorkerSystem.main(null);
	}
	
	//@Test
	public void testHelloActor() {
		new HelloActor();
	}
	
	//@Test
	public void testRaftLeaderElection() {
		new RaftLeaderElection();
	}
	
	//@Test
	public void testJetty() throws Exception {
		rest.TestJettyWithJerseyAndJson.main(null);
	}
	
	@Test
	public void testSlick() throws Exception {
		new dao.ScalaORM().testCase();
	}
}

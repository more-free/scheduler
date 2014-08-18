package rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import rest.JersyRest;


public class TestJettyWithJerseyAndJson {
	public static void main(String [] args) throws Exception {
		di();
		Main.main(args);
	}
	
	static void di() {
	//	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(config.DIConfiguration.class);
   //     MyApplication app = context.getBean(MyApplication.class);
         
     //   app.processMessage("Hi Pankaj", "pankaj@abc.com");
         
        //close the context
       // context.close();
	}
}

class Main {
	


	private static final int DEFAULT_PORT = 8080;
	
	private int serverPort;
	
	public Main(int serverPort) throws Exception {
		this.serverPort = serverPort;
	
		
		Server server = configureServer();	        
        server.start();
        server.join();
	}	

	private Server configureServer() {
		ResourceConfig resourceConfig = new ResourceConfig();		
	//	resourceConfig.packages(JersyRest.class.getPackage().getName());
		
		//resourceConfig.register(rest.JersyRest.class);
		AnnotationConfigApplicationContext context0 = new AnnotationConfigApplicationContext(config.DIConfiguration.class);
		
		
		
		JersyRest s = context0.getBean(rest.JersyRest.class);
		
		resourceConfig.register(s);
		
		resourceConfig.register(JacksonFeature.class);
		ServletContainer servletContainer = new ServletContainer(resourceConfig);
		ServletHolder sh = new ServletHolder(servletContainer);                
		Server server = new Server(serverPort);		
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(sh, "/*");
		server.setHandler(context);
		return server;
	}
	
	public static void main(String[] args) throws Exception {
		
		int serverPort = DEFAULT_PORT;
		new Main(serverPort);	
	}
	
	class T extends ServletContainer {
		public void t() {
			
		}
	}
	

}
package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/ser")
public class JersyRest {
	
	@Autowired
	private SomeService ss;
	
	
	@GET
	@Path("/hello/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person produceJSON(@PathParam("name") String name) {
		Person p = new Person();
		p.setName(name);
		p.setAge(27);
		return p;
	}
	
	
	@GET
	@Path("/ss")
	@Produces(MediaType.APPLICATION_JSON)
	public Person produceJSON2() {
		Person p = new Person();
		p.setName(ss.toString());
		p.setAge(27);
		return p;
	}
}

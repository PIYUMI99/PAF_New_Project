package org.restapi.billing.post.postbillresource;


//Java Imports
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Package Imports
import org.restapi.billing.post.postbillmodel.postbillmodel;
import org.restapi.billing.post.postbillservice.postbillservice;

//API Methods
import jakarta.ws.rs.POST;
import jakarta.ws.rs.GET;
import jakarta.websocket.server.PathParam;
//Jakarta Methods
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;


//POST Method 
@Path("/postbill")
public class postbillresource {
	
	postbillservice service = new postbillservice();

	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public postbillmodel addBill(postbillmodel bill) {
		return service.insertBill(bill);		
	}
		
	
//GET Method	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList <postbillmodel> getUser() throws SQLException {
		return service.getBill();		
	}
	
	@Path("/retrieveById/(id)")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList <postbillmodel> getUser(@PathParam("id") int id) throws SQLException {
		return service.getBilById(id);		
	}
	
	@Path("/updateBill")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public postbillmodel updateBill(postbillmodel bill) {
		return service.updateBill(bill);
	}
		
	@Path("/deleteUserById/(id)")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteBill(@PathParam("id") int id) {
		return service.deleteBill(id); 
	}	
	
	

}

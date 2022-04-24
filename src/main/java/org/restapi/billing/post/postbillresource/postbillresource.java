package org.restapi.billing.post.postbillresource;

import org.restapi.billing.post.postbillmodel.postbillmodel;
import org.restapi.billing.post.postbillservice.postbillservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/postbill")
public class postbillresource {
	
	postbillservice service = new postbillservice();

	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public postbillmodel addBill(postbillmodel bill) {
		return service.insertBill(bill);
		
	}

}

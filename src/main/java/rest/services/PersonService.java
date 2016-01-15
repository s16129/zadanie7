package rest.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.MockRepositoryCatalog;
import dao.RepositoryCatalog;
import domain.Person;
import rest.dto.PersonDto;
import rest.dto.PersonSummaryDto;

@Path("people")
public class PersonService {

	RepositoryCatalog db = new MockRepositoryCatalog();
	
	@PUT
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(PersonDto dto){
		
		Person p = new Person();
		
		p.setAge(dto.getAge());
		p.setName(dto.getName());
		db.people().add(p);
		
		return Response.status(201).build();
	}
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonSummaryDto> getAll(){
		List<PersonSummaryDto> result = new ArrayList<PersonSummaryDto>();
		
		for(Person p: db.people().getAll()){
			PersonSummaryDto dto = new PersonSummaryDto();
			dto.setName(p.getName());
			dto.setId(p.getId());
			result.add(dto);
		}
		
		return result;
	}
}

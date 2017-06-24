
package rest.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Person;

@Path("people")
@Stateless
public class PersonResource {

	
	@PersistenceContext
	EntityManager em;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAll(@DefaultValue("1") @QueryParam("page") int page) {
		if(page < 1){
			page = 1;
		}
		
		int limit = 10;
		int offset = limit * (page - 1);
		
		return em.createNamedQuery("person.all", Person.class)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.getResultList();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Add(Person person) {
		em.persist(person);
		return Response.ok(person.getId()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id){
		//Person result = db.get(id);
		Person result = em.createNamedQuery("person.id", Person.class)
				.setParameter("personId", id)
				.getSingleResult();
		
		if(result==null){
			return Response.status(404).build();
		}
		return Response.ok(result).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Person p){
		Person result = em.createNamedQuery("person.id", Person.class)
				.setParameter("personId", id)
				.getSingleResult();
		if(result==null){
			return Response.status(404).build();
		}
		result.setFirstName(p.getFirstName());
		result.setLastName(p.getLastName());
		result.setGender(p.getGender());
		result.setAge(p.getAge());
		result.setBirthday(p.getBirthday());
		result.setEmail(p.getEmail());
		em.persist(result);
		
		//p.setId(id);
		//db.update(p);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		Person result = em.createNamedQuery("person.id", Person.class)
				.setParameter("personId", id)
				.getSingleResult();
		if(result==null){
			return Response.status(404).build();
		}
		em.remove(result);
		return Response.ok().build();
	}
}


package dao;

import java.util.ArrayList;
import java.util.List;

import domain.Person;

public class PersonRepository implements Repository<Person>{

	private static List<Person> people = new ArrayList<Person>();
	private int currentId=1;
	@Override
	public synchronized void add(Person entity) {

		entity.setId(currentId);
		people.add(entity);
		currentId++;
	}

	@Override
	public void delete(Person entity) {
		people.remove(entity);
	}

	@Override
	public Person get(int id) {
		for(Person p : people){
			if(p.getId()==id) return p;
		}
		return null;
	}

	@Override
	public List<Person> getAll() {
		return people;
	}

}

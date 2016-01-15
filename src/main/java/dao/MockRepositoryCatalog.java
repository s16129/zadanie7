package dao;

import domain.Person;

public class MockRepositoryCatalog implements RepositoryCatalog{

	@Override
	public Repository<Person> people() {
		return new PersonRepository();
	}

}

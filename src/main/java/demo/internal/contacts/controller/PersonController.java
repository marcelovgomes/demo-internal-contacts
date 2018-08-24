package demo.internal.contacts.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import demo.internal.contacts.domain.Person;
import demo.internal.contacts.utility.RandomString;

@RestController
public class PersonController {

	@Autowired
	private IPersonRepository repository;	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "Internal Contacts";
	}

	@RequestMapping(value="/add/{autoinsert}", method=RequestMethod.GET)
	public void insert_start(@PathVariable int autoinsert) {
		RandomString randomStr = new RandomString(8);
		Random randomInt = new Random(autoinsert);
		
		for(int i=0; i < autoinsert; i++ ) {
			Person person = new Person();
			
			person.setName(randomStr.nextString());
			person.setLastname(randomStr.nextString());
			person.setEmail(randomStr.nextString() + "@test.com");
			person.setTelephone(Math.abs(randomInt.nextInt()));
			
			repository.save(person);
		}
	}
	
	@RequestMapping(value="/add", method=RequestMethod.PUT)
	public @ResponseBody Person insert(@RequestBody Person person) {
		repository.save(person);

		return person;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Person> get() {
		List<Person> result = new ArrayList<Person>();
		Iterator<Person> iterator = repository.findAll().iterator();

		while (iterator.hasNext()) {
			result.add(iterator.next());
		}

		return result;
	}
}
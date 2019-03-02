package thrift.demo;

import org.apache.thrift.TException;


public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByName(String name) throws DataException, TException {
        System.out.println("Got param " + name);
        Person person = new Person();
        person.setName("李四");
        person.setAge(20);
        
        return person;
    }

    @Override
    public void removePerson(String name) throws DataException, TException {
        System.out.println("removed Person");
    }
}

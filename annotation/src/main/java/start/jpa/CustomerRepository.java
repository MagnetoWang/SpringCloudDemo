package start.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Create simple queries
 * Spring Data JPA focuses on using JPA to store data in a relational database. Its most compelling feature is the ability to create repository implementations automatically, at runtime, from a repository interface.
 *
 * To see how this works, create a repository interface that works with Customer entities:
 *
 *
 * CustomerRepository extends the CrudRepository interface. The type of entity and ID that it works with,Customer and Long, are specified in the generic parameters on CrudRepository. By extending CrudRepository, CustomerRepository inherits several methods for working with Customer persistence, including methods for saving, deleting, and finding Customer entities.
 *
 * Spring Data JPA also allows you to define other query methods by simply declaring their method signature. In the case of CustomerRepository, this is shown with a findByLastName() method.
 *
 * In a typical Java application, you’d expect to write a class that implements CustomerRepository. But that’s what makes Spring Data JPA so powerful: You don’t have to write an implementation of the repository interface. Spring Data JPA creates an implementation on the fly when you run the application.
 *
 * Let’s wire this up and see what it looks like!
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
package start.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Here you have a Customer class with three attributes, the id, the firstName, and the lastName. You also have two constructors. The default constructor only exists for the sake of JPA. You won’t use it directly, so it is designated as protected. The other constructor is the one you’ll use to create instances of Customer to be saved to the database.
 *
 * In this guide, the typical getters and setters have been left out for brevity.
 * The Customer class is annotated with @Entity, indicating that it is a JPA entity. For lack of a @Table annotation, it is assumed that this entity will be mapped to a table named Customer.
 *
 * The Customer’s id property is annotated with @Id so that JPA will recognize it as the object’s ID. The id property is also annotated with @GeneratedValue to indicate that the ID should be generated automatically.
 *
 * The other two properties, firstName and lastName are left unannotated. It is assumed that they’ll be mapped to columns that share the same name as the properties themselves.
 *
 * The convenient toString() method will print out the customer’s properties.
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

// end::sample[]

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
package lesson30.hometask;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Valik on 06.10.2018.
 */
public class Firm {
    private Date dateFounded;
    private Collection departments;
    private Collection customers;

    public Firm(Date dateFounded, Collection departments, Collection customers) {
        this.dateFounded = dateFounded;
        this.departments = departments;
        this.customers = customers;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public Collection getDepartments() {
        return departments;
    }

    public Collection getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "dateFounded=" + dateFounded +
                ", departments=" + departments +
                ", customers=" + customers +
                '}';
    }
}

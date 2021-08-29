package project.interfaces.query;

import project.listeners.IProjectListener;

import java.util.List;
import java.util.Set;

public interface IQueryCustomersByContract extends IProjectListener {

    List<Integer> getContractors();
    int getNumberOfCustomers(int contractID);
}

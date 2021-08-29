package project.query;

import project.interfaces.IProject;
import project.interfaces.query.ICustomersByContractQueryService;

import java.util.*;

/**
 * Provides number of customers for a given contractId.
 */
public class CustomersByContractQueryService implements ICustomersByContractQueryService {

    Map<Integer, Set<Integer>> customerMap;

    public CustomersByContractQueryService() {
        customerMap = new HashMap<>();
    }

    @Override
    public List<Integer> getContractors() {
        return List.copyOf(customerMap.keySet());
    }

    @Override
    public int getNumberOfCustomers(int contractID) {
        Set<Integer> customers=  customerMap.get(contractID);
        if(customers != null){
            return customers.size();
        }
        return 0;
    }

    @Override
    public void projectAdded(IProject project) {
        Set<Integer> customers = customerMap.computeIfAbsent(project.getContractId(), contractId->new HashSet<>());
        customers.add(project.getCustomerId());
    }
}

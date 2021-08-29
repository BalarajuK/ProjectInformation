package project.query;

import project.interfaces.IProject;
import project.interfaces.query.IQueryCustomersByContract;

import java.util.*;

public class QueryCustomersByContract implements IQueryCustomersByContract {

    Map<Integer, Set<Integer>> customerMap;

    public QueryCustomersByContract() {
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

package project.interfaces.query;

import project.listeners.IProjectListener;

import java.util.List;

/**
 * Provides number of customers for a given contractId.
 */
public interface ICustomersByContractQueryService extends IProjectListener {

    /**
     * Gets the all the contracts for all the projects in the system.
     *
     * @return list of contractorIds
     */
    List<Integer> getContractors();

    /**
     * Number of customers for a given contractId.
     *
     * @param contractID contract Id.
     * @return number of customers.
     */
    int getNumberOfCustomers(int contractID);
}

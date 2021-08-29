package project.reporting;

import project.interfaces.query.IBuildDurationQueryService;
import project.interfaces.query.ICustomersByContractQueryService;
import project.interfaces.query.ICustomersByGeoZoneQueryService;

/**
 * The interface can be implemented by classes that wants report project details.
 */
public interface IProjectReporting {
    /**
     * Reports number of unique customers for each contractID.
     *
     * @param service query service.
     */
    void reportCustomerIDsForEachContranctId(ICustomersByContractQueryService service);

    /**
     * Reports customer details like number of unique customers and list of customers for each geo zone.
     *
     * @param service query service.
     */
    void reportCustomersForEachGeoZone(ICustomersByGeoZoneQueryService service);

    /**
     * Reports average build duration for each geo zone.
     *
     * @param service query service.
     */
    void reportAverageBuildDuration(IBuildDurationQueryService service);
}

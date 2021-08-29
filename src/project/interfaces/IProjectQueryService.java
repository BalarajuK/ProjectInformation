package project.interfaces;

import project.interfaces.query.IBuildDurationQueryService;
import project.interfaces.query.ICustomersByContractQueryService;
import project.interfaces.query.ICustomersByGeoZoneQueryService;

/**
 * Query service which provides specific sub queries by which required project details can be queried.
 */
public interface IProjectQueryService {

    /**
     * Gets sub query which provides average duration for a given geo zone.
     *
     * @return subquery
     */
    IBuildDurationQueryService getAverageBuildDurationQueryService();

    /**
     * Gets sub query which provides customer details for a given contract.
     *
     * @return subquery
     */
    ICustomersByContractQueryService getCustomersByContractQueryService();

    /**
     * Gets sub query which provides customer details for a geo zone.
     *
     * @return subquery
     */
    ICustomersByGeoZoneQueryService getCustomersByGeoZoneService();
}

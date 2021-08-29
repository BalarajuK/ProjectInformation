package project.factory;

import project.interfaces.IProjectQueryService;
import project.interfaces.query.IBuildDurationQueryService;
import project.interfaces.query.ICustomersByContractQueryService;
import project.interfaces.query.ICustomersByGeoZoneQueryService;

/**
 * Factory for creating Project query services.
 */
public interface IProjectQueryFactory {

    /**
     * Creates a query service for getting customers by geo zone.
     *
     * @return query service.
     */
    ICustomersByGeoZoneQueryService createCustomersByGeoQueryService();

    /**
     * Creates a query service for getting customers by contractId.
     *
     * @return query service.
     */
    ICustomersByContractQueryService createCustomersByContractQueryService();

    /**
     * Creates a query service for finding average build duration for a given geo zone.
     *
     * @return query service.
     */
    IBuildDurationQueryService crateBuildDurationQueryService();

    /**
     * Creates a query service for querying project details by various criteria.
     *
     * @param queryByGeoZone Query service which gets customers for given geo zone.
     * @param queryByContract Query service which gets customers for given contractId.
     * @param buildDurationQuery Query service which gets build duration for given geo zone.
     * @return Project query service.
     */
    IProjectQueryService createProjectQuery(ICustomersByGeoZoneQueryService queryByGeoZone, ICustomersByContractQueryService queryByContract, IBuildDurationQueryService buildDurationQuery);

}
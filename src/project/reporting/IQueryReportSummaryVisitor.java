package project.reporting;

import project.interfaces.IProjectQueryService;
import project.interfaces.query.IBuildDurationQueryService;
import project.interfaces.query.ICustomersByContractQueryService;
import project.interfaces.query.ICustomersByGeoZoneQueryService;

/**
 * The interface can be implemented by classes that wants report project details.
 */
public interface IQueryReportSummaryVisitor {
    /**
     * Reports number of unique customers for each contractID.
     *
     * @param service query service.
     */
    void visit(ICustomersByContractQueryService service);

    /**
     * Reports customer details like number of unique customers and list of customers for each geo zone.
     *
     * @param service query service.
     */
    void visit(ICustomersByGeoZoneQueryService service);

    /**
     * Reports average build duration for each geo zone.
     *
     * @param service query service.
     */
    void visit(IBuildDurationQueryService service);

    /**
     * Reports summary of projects.
     * @param service query service
     */
    void visit(IProjectQueryService service);
}

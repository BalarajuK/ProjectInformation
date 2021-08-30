package project.query;

import project.interfaces.IProjectQueryService;
import project.interfaces.query.IBuildDurationQueryService;
import project.interfaces.query.ICustomersByContractQueryService;
import project.interfaces.query.ICustomersByGeoZoneQueryService;
import project.reporting.IQueryReportSummaryVisitor;

public class ProjectQueryService implements IProjectQueryService {
    private final ICustomersByGeoZoneQueryService customersByGeo;
    private final ICustomersByContractQueryService customersByContract;
    private final IBuildDurationQueryService buildDurationQuery;

    public ProjectQueryService(ICustomersByGeoZoneQueryService queryByGeoZone, ICustomersByContractQueryService customersByContract, IBuildDurationQueryService buildDurationQuery) {
        this.customersByGeo = queryByGeoZone;
        this.customersByContract = customersByContract;
        this.buildDurationQuery = buildDurationQuery;
    }

    @Override
    public IBuildDurationQueryService getAverageBuildDurationQueryService() {
        return buildDurationQuery;
    }

    @Override
    public ICustomersByContractQueryService getCustomersByContractQueryService() {
        return customersByContract;
    }

    @Override
    public ICustomersByGeoZoneQueryService getCustomersByGeoZoneService() {
        return customersByGeo;
    }

    @Override
    public void accept(IQueryReportSummaryVisitor visitor) {
        visitor.visit(this);
    }
}

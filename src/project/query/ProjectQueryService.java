package project.query;

import project.interfaces.IProjectQueryService;
import project.interfaces.query.IBuildDurationQueryService;
import project.interfaces.query.ICustomersByContractQueryService;
import project.interfaces.query.ICustomersByGeoZoneQueryService;

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
    public IBuildDurationQueryService getAverageBuildDurationQuery() {
        return buildDurationQuery;
    }

    @Override
    public ICustomersByContractQueryService getQueryCustomersByContract() {
        return customersByContract;
    }

    @Override
    public ICustomersByGeoZoneQueryService getQueryCustomersByGeo() {
        return customersByGeo;
    }
}

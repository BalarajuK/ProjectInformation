package project.factory;

import project.interfaces.query.IBuildDurationQueryService;
import project.interfaces.query.ICustomersByContractQueryService;
import project.query.BuildDurationQueryService;
import project.query.ProjectQueryService;
import project.interfaces.IProjectQueryService;
import project.interfaces.query.ICustomersByGeoZoneQueryService;
import project.query.CustomersByContractQueryService;
import project.query.CustomersByGeoZoneQueryService;

public class DynamicProjectQueryFactory implements IProjectQueryFactory {
    @Override
    public ICustomersByGeoZoneQueryService createCustomersByGeoQueryService() {
        return new CustomersByGeoZoneQueryService();
    }

    public IProjectQueryService createProjectQuery(ICustomersByGeoZoneQueryService customersByGeoZone, ICustomersByContractQueryService customersByContract, IBuildDurationQueryService buildDurationQuery) {
        return new ProjectQueryService(customersByGeoZone, customersByContract, buildDurationQuery);
    }

    @Override
    public ICustomersByContractQueryService createCustomersByContractQueryService() {
        return new CustomersByContractQueryService();
    }

    @Override
    public IBuildDurationQueryService crateBuildDurationQueryService() {
        return new BuildDurationQueryService();
    }
}

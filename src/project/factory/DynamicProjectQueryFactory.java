package project.factory;

import project.interfaces.query.IBuildDurationQuery;
import project.interfaces.query.IQueryCustomersByContract;
import project.query.BuildDurationQuery;
import project.query.ProjectQueryService;
import project.interfaces.IProjectQueryService;
import project.interfaces.query.IQueryCustomersByGeo;
import project.query.QueryCustomersByContract;
import project.query.QueryCustomersByGeoZone;

public class DynamicProjectQueryFactory implements IProjectQueryFactory {
    @Override
    public IQueryCustomersByGeo createCustomersByGeo() {
        return new QueryCustomersByGeoZone();
    }

    public IProjectQueryService createProjectQuery(IQueryCustomersByGeo customersByGeoZone, IQueryCustomersByContract customersByContract, IBuildDurationQuery buildDurationQuery) {
        return new ProjectQueryService(customersByGeoZone, customersByContract, buildDurationQuery);
    }

    @Override
    public IQueryCustomersByContract createCustomersByContract() {
        return new QueryCustomersByContract();
    }

    @Override
    public IBuildDurationQuery crateBuildDurationQuery() {
        return new BuildDurationQuery();
    }
}

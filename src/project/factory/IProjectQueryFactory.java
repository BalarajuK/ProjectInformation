package project.factory;

import project.interfaces.IProjectQueryService;
import project.interfaces.query.IBuildDurationQuery;
import project.interfaces.query.IQueryCustomersByContract;
import project.interfaces.query.IQueryCustomersByGeo;

public interface IProjectQueryFactory {

    IQueryCustomersByGeo createCustomersByGeo();

    IQueryCustomersByContract createCustomersByContract();

    IBuildDurationQuery crateBuildDurationQuery();

    IProjectQueryService createProjectQuery(IQueryCustomersByGeo queryByGeoZone, IQueryCustomersByContract customersByContract, IBuildDurationQuery buildDurationQuery);

}

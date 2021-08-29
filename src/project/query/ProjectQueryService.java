package project.query;

import project.interfaces.IProjectQueryService;
import project.interfaces.query.IBuildDurationQuery;
import project.interfaces.query.IQueryCustomersByContract;
import project.interfaces.query.IQueryCustomersByGeo;

import java.util.List;

public class ProjectQueryService implements IProjectQueryService {
    private final IQueryCustomersByGeo customersByGeo;
    private final IQueryCustomersByContract customersByContract;
    private final IBuildDurationQuery buildDurationQuery;

    public ProjectQueryService(IQueryCustomersByGeo queryByGeoZone, IQueryCustomersByContract customersByContract, IBuildDurationQuery buildDurationQuery) {
        this.customersByGeo = queryByGeoZone;
        this.customersByContract = customersByContract;
        this.buildDurationQuery = buildDurationQuery;
    }

    @Override
    public int getNumberOfCustomers(int contractId) {
        return customersByContract.getNumberOfCustomers(contractId);
    }

    @Override
    public int getNumberOfCustomers(String geoZone) {
        return customersByGeo.getNumberOfCustomers(geoZone);
    }

    @Override
    public List<Integer> getCustomers(String geoZone) {
        return customersByGeo.getCustomers(geoZone);
    }

    @Override
    public long getAverageBuildDuration(String geoZone) {
        return buildDurationQuery.getAverageBuildDuration(geoZone);
    }

    @Override
    public IBuildDurationQuery getBuildDurationQuery() {
        return buildDurationQuery;
    }

    @Override
    public IQueryCustomersByContract getQueryCustomersByContract() {
        return customersByContract;
    }

    @Override
    public IQueryCustomersByGeo getQueryCustomersByGeo() {
        return customersByGeo;
    }
}

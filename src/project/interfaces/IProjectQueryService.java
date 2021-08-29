package project.interfaces;

import project.interfaces.query.IBuildDurationQuery;
import project.interfaces.query.IQueryCustomersByContract;
import project.interfaces.query.IQueryCustomersByGeo;

import java.util.List;

public interface IProjectQueryService {

    int getNumberOfCustomers(int contractId);

    int getNumberOfCustomers(String geoZone);

    List<Integer> getCustomers(String geoZone);

    long getAverageBuildDuration(String geoZone);

    IBuildDurationQuery getBuildDurationQuery();

    IQueryCustomersByContract getQueryCustomersByContract();

    IQueryCustomersByGeo getQueryCustomersByGeo();
}

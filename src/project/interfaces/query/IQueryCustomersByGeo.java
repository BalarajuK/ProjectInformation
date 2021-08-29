package project.interfaces.query;

import project.listeners.IProjectListener;

import java.util.List;

public interface IQueryCustomersByGeo extends IProjectListener {
    List<Integer> getCustomers(String geoZone);

    int getNumberOfCustomers(String geoZone);

    List<String> getGeoZones();
}

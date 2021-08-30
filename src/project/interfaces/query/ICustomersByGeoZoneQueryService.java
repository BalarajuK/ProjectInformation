package project.interfaces.query;

import project.listeners.IProjectListener;

import java.util.List;

/**
 * Provides customer details like number of unique customers or list of customers for a given Geo Zone for the projects added into the system.
 */
public interface ICustomersByGeoZoneQueryService extends IQueryService, IProjectListener {
    /**
     * Gets a list of customers in the given geo zone.
     *
     * @param geoZone geo zone.
     * @return list of customers
     */
    List<Integer> getCustomers(String geoZone);

    /**
     * Gets the number of customers present in a given geo zone.
     *
     * @param geoZone geo zone
     * @return number of customers
     */
    int getNumberOfCustomers(String geoZone);

    /**
     * Gets the all geo zones where the projects registered in the system are running.
     *
     * @return list of geo zones
     */
    List<String> getGeoZones();
}

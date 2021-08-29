package project.query;

import project.interfaces.IProject;
import project.interfaces.query.ICustomersByGeoZoneQueryService;

import java.util.*;

/**
 * Provides customer details like number of unique customers or list of customers for a given Geo Zone for the projects added into the system.
 */
public class CustomersByGeoZoneQueryService implements ICustomersByGeoZoneQueryService {

    private final Map<String, Set<Integer>> customerMap;

    public CustomersByGeoZoneQueryService() {
        customerMap = new HashMap<>();
    }

    @Override
    public List<Integer> getCustomers(String geoZone) {
        Set<Integer> customerList = customerMap.get(geoZone);
        if (customerList != null) {
            List<Integer> list = new ArrayList<>(customerList);
            Collections.sort(list);
            return list;
        }
        return Collections.emptyList();
    }

    @Override
    public int getNumberOfCustomers(String geoZone) {
        Set<Integer> customerList = customerMap.getOrDefault(geoZone, new HashSet<>());
        return customerList.size();
    }

    @Override
    public void projectAdded(IProject project) {
        Set<Integer> customerList = customerMap.computeIfAbsent(project.getGeoZone(), geoZone -> new HashSet<>());
        customerList.add(project.getCustomerId());
    }

    @Override
    public List<String> getGeoZones() {
        return List.copyOf(customerMap.keySet());
    }
}

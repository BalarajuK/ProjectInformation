package project.query;

import project.interfaces.IProject;
import project.interfaces.query.IQueryCustomersByGeo;
import project.listeners.IProjectListener;
import java.util.*;

public class QueryCustomersByGeoZone implements IQueryCustomersByGeo, IProjectListener {

    private final Map<String, Set<Integer>> customerMap;

    public QueryCustomersByGeoZone() {
        customerMap = new HashMap<>();
    }

    @Override
    public List<Integer> getCustomers(String geoZone) {
        Set<Integer> customerList = customerMap.get(geoZone);
        if (customerList != null) {
            return List.copyOf(customerList);
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

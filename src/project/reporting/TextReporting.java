package project.reporting;

import project.interfaces.IProjectMgr;
import project.interfaces.IProjectQueryService;
import project.interfaces.query.IBuildDurationQuery;
import project.interfaces.query.IQueryCustomersByContract;
import project.interfaces.query.IQueryCustomersByGeo;

import java.util.List;

public class TextReporting implements IProjectReporting {

    @Override
    public void display(IProjectMgr projectMgr, IProjectQueryService service) {
        System.out.println("Number of customers per contract");
        System.out.println("------------------------------------------");

        System.out.println(displayLine(20, "Contractor", "Number of customers"));

        for (int contractorId : projectMgr.getContractors()) {
            System.out.println(displayLine(25, String.valueOf(contractorId), String.valueOf(service.getNumberOfCustomers(contractorId))));
        }
        System.out.println("------------------------------------------");

    }

    @Override
    public void display(IQueryCustomersByContract service) {
        System.out.println("Number of customers per contract");
        displayAsTable(() -> {
            System.out.println(displayLine(20, "Contractor", "Number of customers"));
            for (int contractorId : service.getContractors()) {
                System.out.println(displayLine(25, String.valueOf(contractorId), String.valueOf(service.getNumberOfCustomers(contractorId))));
            }
        });
    }

    private void displayAsTable(Runnable runnable) {
        System.out.println("------------------------------------------");
        runnable.run();
        System.out.println("------------------------------------------");
        System.out.println();
        System.out.println();
    }

    @Override
    public void display(IQueryCustomersByGeo service) {
        System.out.println("Number of customers per GeoZone");
        displayAsTable(() -> {
            System.out.println(displayLine(20, "GeoZone", "Number of customers"));
            for (String geoZone : service.getGeoZones()) {
                System.out.println(displayLine(25, String.valueOf(geoZone), String.valueOf(service.getNumberOfCustomers(geoZone))));
            }
        });

        System.out.println("Customers per GeoZone");
        System.out.println("------------------------------------------");
        for (String geoZone : service.getGeoZones()) {
            List<Integer> customers = service.getCustomers(geoZone);
            if(!customers.isEmpty()){
                System.out.println("Geo Zone: "+geoZone);
                System.out.println("Customers: ");
                for (int customerId : customers) {
                    System.out.println(customerId);
                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }

    @Override
    public void display(IBuildDurationQuery service) {
        System.out.println("Average build duration per GeoZone");
        displayAsTable(() -> {
            System.out.println(displayLine(20, "GeoZone", "Average build duration( in seconds)"));
            for (String geoZone : service.getGeoZones()) {
                System.out.println(displayLine(25, String.valueOf(geoZone), String.valueOf(service.getAverageBuildDuration(geoZone))));
            }
        });
    }

    private StringBuilder displayLine(int columnGap, String col1, String col2) {
        StringBuilder report = new StringBuilder();
        report.append(col1);
        while (report.length() < columnGap) {
            report.append(' ');
        }
        report.append(col2);
        return report;
    }
}

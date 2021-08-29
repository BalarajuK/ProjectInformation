package project.reporting;


import project.interfaces.IProjectQueryService;

public class ReportSummery {
    private  static ReportSummery instance;

    private ReportSummery() {
    }

    public synchronized static ReportSummery getInstance(){
        if(instance == null){
            instance = new ReportSummery();
        }
        return instance;
    }

    public void report(IProjectQueryService projectQuery, IProjectReporting customersByContract){
        customersByContract.reportCustomersForEachGeoZone(projectQuery.getCustomersByGeoZoneService());
        customersByContract.reportAverageBuildDuration(projectQuery.getAverageBuildDurationQueryService());
        customersByContract.reportCustomerIDsForEachContranctId(projectQuery.getCustomersByContractQueryService());
    }
}

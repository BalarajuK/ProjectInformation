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

    public void report(IProjectQueryService projectQuery, IQueryReportSummaryVisitor customersByContract){
        customersByContract.visit(projectQuery);
    }

    public void reportCustomersPerGeoZone(IProjectQueryService projectQuery, IQueryReportSummaryVisitor customersByContract){
        customersByContract.visit(projectQuery.getCustomersByGeoZoneService());
    }
}

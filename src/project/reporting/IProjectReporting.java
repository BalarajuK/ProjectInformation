package project.reporting;

import project.interfaces.IProjectMgr;
import project.interfaces.IProjectQueryService;
import project.interfaces.query.IBuildDurationQuery;
import project.interfaces.query.IQueryCustomersByContract;
import project.interfaces.query.IQueryCustomersByGeo;

public interface IProjectReporting {
    void display(IProjectMgr projectMgr, IProjectQueryService service);

    void display(IQueryCustomersByContract service);

    void display(IQueryCustomersByGeo service);

    void display(IBuildDurationQuery service);
}

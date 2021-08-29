package project.impl;

import project.factory.IProjectQueryFactory;
import project.interfaces.IProject;
import project.interfaces.IProjectMgr;
import project.interfaces.IProjectQueryService;
import project.interfaces.query.IBuildDurationQuery;
import project.interfaces.query.IQueryCustomersByContract;
import project.interfaces.query.IQueryCustomersByGeo;
import project.listeners.IProjectListener;

import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private final IProjectMgr projectMgr;
    private final IProjectQueryService projectQuery;

    public ProjectService(IProjectQueryFactory factory) {
        IQueryCustomersByGeo queryCustomersByGeo = factory.createCustomersByGeo();
        IQueryCustomersByContract customersByContract = factory.createCustomersByContract();
        IBuildDurationQuery buildDurationQuery = factory.crateBuildDurationQuery();
        projectQuery = factory.createProjectQuery(queryCustomersByGeo, customersByContract, buildDurationQuery);

        List<IProjectListener> projectListenerList = new ArrayList<>();
        projectListenerList.add(queryCustomersByGeo);
        projectListenerList.add(customersByContract);
        projectListenerList.add(buildDurationQuery);
        projectMgr = createProjectMgr(projectListenerList);
    }

    private IProjectMgr createProjectMgr(List<IProjectListener> projectListenerList1) {
        final IProjectMgr projectMgr;
        projectMgr = new ProjectMgr(projectListenerList1);
        return projectMgr;
    }

    public void addProject(IProject project) {
        projectMgr.addProject(project);
    }

    public IProjectQueryService getProjectQueryService() {
        return projectQuery;
    }

    public IProjectMgr getProjectMgr(){
        return projectMgr;
    }

}

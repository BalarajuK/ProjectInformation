package project.impl;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import project.factory.DynamicProjectQueryFactory;
import project.factory.ProjectFactory;
import project.interfaces.IProject;
import project.interfaces.query.IBuildDurationQueryService;
import project.interfaces.query.ICustomersByGeoZoneQueryService;
import project.listeners.IProjectListener;

import java.util.ArrayList;
import java.util.List;

public class ProjectMgrTest extends TestCase {


    public void testProjectAdditionShouldBeNotifiedToListeners() {
        List<IProjectListener> listeners = new ArrayList<>();
        ICustomersByGeoZoneQueryService service = new DynamicProjectQueryFactory().createCustomersByGeoQueryService();
        listeners.add(service);
        ProjectMgr projectMgr = new ProjectMgr(listeners);

        projectMgr.addProject(createTestProject(2343225, 2345, "us_east", "RedTeam", "ProjectApple", 3000));
        Assert.assertEquals("Project change should have been notified ", 1, service.getNumberOfCustomers("us_east"));

        projectMgr.addProject(createTestProject(2343224, 2346, "us_east", "BlueTeam", "TestProject", 4000));
        Assert.assertEquals("Project change should have been notified ", 2, service.getNumberOfCustomers("us_east"));

    }

    private IProject createTestProject(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new ProjectFactory().createProject(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }

}
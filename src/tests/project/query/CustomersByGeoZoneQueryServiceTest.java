package project.query;

import junit.framework.TestCase;
import org.junit.Assert;
import project.factory.DynamicProjectQueryFactory;
import project.factory.ProjectFactory;
import project.interfaces.IProject;
import project.interfaces.query.ICustomersByGeoZoneQueryService;

public class CustomersByGeoZoneQueryServiceTest extends TestCase {

    public void testNumberOfCustomers() {
        ICustomersByGeoZoneQueryService service = new DynamicProjectQueryFactory().createCustomersByGeoQueryService();
        service.projectAdded(createTestProject(2343225, 2345, "us_east", "RedTeam", "ProjectApple", 3000));
        service.projectAdded(createTestProject(2343224, 2346, "us_west", "BlueTeam", "TestProject", 4000));

        Assert.assertEquals("Invalid number of customers ", 1, service.getNumberOfCustomers("us_west"));

        service.projectAdded(createTestProject(2343226, 2345, "us_west", "BlueTeam", "TestProject", 1000));

        Assert.assertEquals("Invalid number of customers ", 2, service.getNumberOfCustomers("us_west"));

    }

    public void testCustomerList() {
        ICustomersByGeoZoneQueryService service = new DynamicProjectQueryFactory().createCustomersByGeoQueryService();
        service.projectAdded(createTestProject(2343225, 2345, "us_east", "RedTeam", "ProjectApple", 3000));
        service.projectAdded(createTestProject(2343224, 2346, "us_west", "BlueTeam", "TestProject", 4000));

        Assert.assertEquals("Invalid customers ", "[2343224]", service.getCustomers("us_west").toString());

        service.projectAdded(createTestProject(2343226, 2345, "us_west", "BlueTeam", "TestProject", 1000));

        Assert.assertEquals("Invalid customers ", "[2343224, 2343226]", service.getCustomers("us_west").toString());

    }

    private IProject createTestProject(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new ProjectFactory().createProject(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }
}
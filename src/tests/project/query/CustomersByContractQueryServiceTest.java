package project.query;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import project.factory.DynamicProjectQueryFactory;
import project.factory.ProjectFactory;
import project.interfaces.IProject;
import project.interfaces.query.ICustomersByContractQueryService;

public class CustomersByContractQueryServiceTest extends TestCase {

    public void testService() {
        ICustomersByContractQueryService service = new DynamicProjectQueryFactory().createCustomersByContractQueryService();
        service.projectAdded(createTestProject(2343225, 2345, "us_east", "RedTeam", "ProjectApple", 3000));
        service.projectAdded(createTestProject(2343224, 2346, "us_west", "BlueTeam", "TestProject", 4000));

        Assert.assertEquals("Invalid number of customers ", 1, service.getNumberOfCustomers(2345));

        service.projectAdded(createTestProject(2343226, 2345, "us_west", "BlueTeam", "TestProject", 1000));

        Assert.assertEquals("Invalid number of customers ", 2, service.getNumberOfCustomers(2345));

    }

    private IProject createTestProject(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new ProjectFactory().createProject(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }

}
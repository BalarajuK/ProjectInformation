package project.impl;

import junit.framework.TestCase;
import org.junit.Assert;
import project.factory.ProjectFactory;
import project.interfaces.IProject;

public class ProjectTest extends TestCase {

    public void testProjectAdditionShouldBeNotifiedToListeners() {

        IProject project = createTestProject(2343225, 2345, "us_east", "RedTeam", "ProjectApple", 3000);
        Assert.assertEquals("Invalid project", 2343225, project.getCustomerId());
        Assert.assertEquals("Invalid project", 2345, project.getContractId());
        Assert.assertEquals("Invalid project", 3000, project.getBuildDuration());
        Assert.assertEquals("Invalid project ", "ProjectApple", project.getProjectCode());
        Assert.assertEquals("Invalid project ", "us_east", project.getGeoZone());
        Assert.assertEquals("Invalid project ", "RedTeam", project.getTeamCode());

    }

    private IProject createTestProject(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new ProjectFactory().createProject(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }

}
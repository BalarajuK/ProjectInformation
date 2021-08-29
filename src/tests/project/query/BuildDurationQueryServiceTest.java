package project.query;

import org.junit.Assert;
import org.junit.Test;
import project.factory.DynamicProjectQueryFactory;
import project.factory.ProjectFactory;
import project.interfaces.IProject;
import project.interfaces.query.IBuildDurationQueryService;


public class BuildDurationQueryServiceTest {

    @Test
    public void testDurationService() {
        IBuildDurationQueryService service = new DynamicProjectQueryFactory().crateBuildDurationQueryService();
        service.projectAdded(createTestProject(2343225, 2345, "us_east", "RedTeam", "ProjectApple", 3000));
        service.projectAdded(createTestProject(2343224, 2346, "us_west", "BlueTeam", "TestProject", 4000));

        Assert.assertEquals("Invalid average build duration ", 4000, service.getAverageBuildDuration("us_west"));

        service.projectAdded(createTestProject(2343226, 2350, "us_west", "BlueTeam", "TestProject", 1000));

        Assert.assertEquals("Invalid average build duration ", 2500, service.getAverageBuildDuration("us_west"));

    }

    private IProject createTestProject(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new ProjectFactory().createProject(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }
}
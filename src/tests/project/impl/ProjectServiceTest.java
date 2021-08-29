package project.impl;

import junit.framework.TestCase;

import project.factory.DynamicProjectQueryFactory;
import project.interfaces.IProjectQueryService;

public class ProjectServiceTest extends TestCase {
    public void testProjectService() {
        ProjectService projectService = new ProjectService(new DynamicProjectQueryFactory());
        IProjectQueryService prjService = projectService.getProjectQueryService();
        assertNotNull("ProjectQueryService can not be null", prjService);
        assertNotNull("CustomersByGeoZoneService can not be null", prjService.getCustomersByGeoZoneService());
        assertNotNull("CustomersByContractQueryService can not be null", prjService.getCustomersByContractQueryService());
        assertNotNull("AverageBuildDurationQueryService can not be null", prjService.getAverageBuildDurationQueryService());

    }

}
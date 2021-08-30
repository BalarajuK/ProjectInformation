package project;

import project.factory.DynamicProjectQueryFactory;
import project.factory.ProjectFactory;
import project.impl.ProjectService;
import project.input.FileInputData;
import project.interfaces.IProject;
import project.interfaces.IProjectQueryService;
import project.reporting.TextReporting;
import project.reporting.ReportSummery;

public class ProjectMain {

    public static void main(String[] args) {
        ProjectService projectService = new ProjectService(new DynamicProjectQueryFactory());
        ProjectFactory projectFactory = new ProjectFactory();
        for (String projectData : new FileInputData().getLines()) {
            IProject project = createProject(projectFactory, projectData);
            if (project != null) {
                projectService.addProject(project);
            }
        }
        IProjectQueryService projectQuery = projectService.getProjectQueryService();
        ReportSummery.getInstance().report(projectQuery, new TextReporting());

    }

    private static IProject createProject(ProjectFactory projectFactory, String projectData) {
        String[] projectInfo = projectData.split(",");
        if (projectInfo.length != 6) {
            return null;
        }
        try {
            int customerId = Integer.parseInt(projectInfo[0]);
            int contractorId = Integer.parseInt(projectInfo[1]);
            String geoZone = projectInfo[2];
            String teamCode = projectInfo[3];
            String projectCode = projectInfo[4];
            String durationStr = projectInfo[5];
            long duration = Long.parseLong(durationStr.substring(0, durationStr.length() - 1));
            if ("m".equals(durationStr.substring(durationStr.length() - 1))) {
                duration = duration * 60;
            } else if ("h".equals(durationStr.substring(durationStr.length() - 1))) {
                duration = duration * 60 * 60;
            }
            return projectFactory.createProject(customerId, contractorId, geoZone, teamCode, projectCode, duration);
        } catch (Exception ex) {
            System.out.println("Invalid line :" + projectData);
        }
        return null;

    }
}

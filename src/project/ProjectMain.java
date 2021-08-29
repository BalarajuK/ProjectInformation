package project;

import project.factory.DynamicProjectQueryFactory;
import project.factory.ProjectFactory;
import project.impl.ProjectService;
import project.interfaces.IProject;
import project.interfaces.IProjectQueryService;
import project.reporting.TextReporting;
import project.reporting.ReportSummery;

public class ProjectMain {

    public static void main(String[] args) {

        String input = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";

        String[] projects = input.split("\n");

        ProjectService projectService = new ProjectService(new DynamicProjectQueryFactory());
        ProjectFactory projectFactory = new ProjectFactory();
        for (String project : projects) {
            projectService.addProject(createProject(projectFactory, project));
        }

        IProjectQueryService projectQuery = projectService.getProjectQueryService();
        ReportSummery.getInstance().report(projectQuery, new TextReporting());

    }

    private static IProject createProject(ProjectFactory projectFactory, String projectData) {
        String[] projectInfo = projectData.split(",");
        int customerId = Integer.parseInt(projectInfo[0]);
        int contractorId = Integer.parseInt(projectInfo[1]);
        String geoZone = projectInfo[2];
        String teamCode = projectInfo[3];
        String projectCode = projectInfo[4];
        long duration = Long.parseLong(projectInfo[5].substring(0, projectInfo[5].length()-1));
        return projectFactory.createProject(customerId, contractorId, geoZone, teamCode, projectCode, duration);
    }
}

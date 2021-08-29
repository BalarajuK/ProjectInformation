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

        String input = getTestData();
        String[] projects = input.split("\n");

        ProjectService projectService = new ProjectService(new DynamicProjectQueryFactory());
        ProjectFactory projectFactory = new ProjectFactory();
        for (String projectData : projects) {
            projectService.addProject(createProject(projectFactory, projectData));
        }
        IProjectQueryService projectQuery = projectService.getProjectQueryService();
        ReportSummery.getInstance().report(projectQuery, new TextReporting());

    }

    private static String getTestData() {
        return "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s\n" +
                "3244332,2346,us_west,BlueTeam,ProjectBanana,2211s";
    }

    private static IProject createProject(ProjectFactory projectFactory, String projectData) {
        String[] projectInfo = projectData.split(",");
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
    }
}

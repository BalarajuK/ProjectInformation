package project.impl;

import project.interfaces.IProject;

public class Project implements IProject {

    private final int customerId;
    private final int contractId;
    private final String geoZone;
    private final String teamCode;
    private final String projectCode;
    private final long duration;

    public Project(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long duration) {
        this.customerId = customerId;
        this.contractId = contractId;
        this.geoZone = geoZone;
        this.teamCode = teamCode;
        this.projectCode = projectCode;
        this.duration = duration;
    }

    @Override
    public int getCustomerId() {
        return customerId;
    }

    @Override
    public int getContractId() {
        return contractId;
    }

    @Override
    public String getGeoZone() {
        return geoZone;
    }

    @Override
    public String getTeamCode() {
        return teamCode;
    }

    @Override
    public String getProjectCode() {
        return projectCode;
    }

    @Override
    public long getBuildDuration() {
        return duration;
    }
}

package project.interfaces.query;

import project.listeners.IProjectListener;

import java.util.List;

public interface IBuildDurationQuery extends IProjectListener {

    List<String> getGeoZones();

    long getAverageBuildDuration(String geoZone);
}

package project.interfaces.query;

import project.listeners.IProjectListener;

import java.util.List;

/**
 * Provides average build duration for a given Geo Zone for the projects added into the system.
 */
public interface IBuildDurationQueryService extends IProjectListener {

    /**
     * Gets the all geo zones where the projects are running.
     *
     * @return zeo zones
     */
    List<String> getGeoZones();

    /**
     * Gets the average build duration for the projects added into the system.
     *
     * @param geoZone geo zone
     * @return average build duration for the projects.
     */
    long getAverageBuildDuration(String geoZone);
}

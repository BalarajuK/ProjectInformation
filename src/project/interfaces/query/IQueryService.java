package project.interfaces.query;

import project.reporting.IQueryReportSummaryVisitor;

/**
 * A Query service on projects present in the system.
 */
public interface IQueryService {

    /**
     * Accepts Query report summary visitor.
     *
     * @param visitor Query report summery.
     */
    void accept(IQueryReportSummaryVisitor visitor);
}

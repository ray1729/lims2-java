/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.sanger.htgt.lims2.db;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;
import org.neo4j.graphdb.Node;

/**
 *
 * @author ray
 */
public class QCTestRunImpl implements QCTestRun {

    private Node underlyingNode;
    private static final String RUN_ID_KEY = "RunId";
    private static final String RUN_DATE_KEY = "RunDate";
    private static final String SOFTWARE_VERSION_KEY = "SoftwareVersion";
    private static final String SEQUENCING_PROJECT_KEY = "SequencingProject";
    private static final String TEMPLATE_PLATE_KEY = "TemplatePlate";

    public QCTestRunImpl(Node node) {
        underlyingNode = node;
    }

    public void setRunId(UUID runId) {
        underlyingNode.setProperty(RUN_ID_KEY, runId.toString());
    }

    public UUID getRunId() {
        return UUID.fromString((String) this.underlyingNode.getProperty(RUN_ID_KEY));
    }

    public void setRunDate(Date runDate) {
        String runDateStr = DateFormat.getDateInstance(DateFormat.SHORT).format(runDate);
        underlyingNode.setProperty(RUN_DATE_KEY, runDateStr);
    }

    public Date getRunDate() throws java.text.ParseException {
        String runDateStr = (String) underlyingNode.getProperty(RUN_DATE_KEY);
        return DateFormat.getDateInstance(DateFormat.SHORT).parse(runDateStr);
    }

    public void setSoftwareVersion(String softwareVersion) {
        underlyingNode.setProperty(SOFTWARE_VERSION_KEY, softwareVersion);
    }

    public String getSoftwareVersion() {
        return (String) underlyingNode.getProperty(SOFTWARE_VERSION_KEY);
    }

    public void setSequencingProject(String sequencingProject) {
        underlyingNode.setProperty(SEQUENCING_PROJECT_KEY, sequencingProject);
    }

    public String getSequencingProject() {
        return (String) underlyingNode.getProperty(SEQUENCING_PROJECT_KEY);
    }

    public void setTemplatePlate(String templatePlate) {
        underlyingNode.setProperty(TEMPLATE_PLATE_KEY, templatePlate);
    }

    public String getTemplatePlate() {
        return (String) underlyingNode.getProperty(TEMPLATE_PLATE_KEY);
    }
}

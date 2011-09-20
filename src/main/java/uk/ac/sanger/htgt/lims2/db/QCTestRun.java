/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.sanger.htgt.lims2.db;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author ray
 */
public interface QCTestRun {

    public void setRunId(UUID qcTestRunId);

    public UUID getRunId();

    public void setRunDate(Date runDate);

    public Date getRunDate() throws java.text.ParseException;

    public void setSoftwareVersion(String softwareVersion);

    public String getSoftwareVersion();

    public void setSequencingProject(String sequencinpProject);

    public String getSequencingProject();

    public void setTemplatePlate(String templatePlate);

    public String getTemplatePlate();
}

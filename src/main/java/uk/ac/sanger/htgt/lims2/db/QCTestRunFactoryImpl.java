/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.sanger.htgt.lims2.db;

import java.util.Date;
import java.util.UUID;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

/**
 *
 * @author ray
 */
public class QCTestRunFactoryImpl {

    private final GraphDatabaseService graphDb;
    private final Node qcTestRunFactoryNode;

    public QCTestRunFactoryImpl(GraphDatabaseService graphDb) {

        this.graphDb = graphDb;

        Relationship rel = graphDb.getReferenceNode().getSingleRelationship(
                Lims2RelationshipType.QC_RUNS, Direction.OUTGOING);

        if (rel == null) {
            qcTestRunFactoryNode = graphDb.createNode();
            graphDb.getReferenceNode().createRelationshipTo(qcTestRunFactoryNode, Lims2RelationshipType.QC_RUNS);
        } else {
            qcTestRunFactoryNode = rel.getEndNode();
        }
    }

    public QCTestRun createQCTestRun() {
        Node qcTestRunNode = graphDb.createNode();
        qcTestRunFactoryNode.createRelationshipTo(qcTestRunNode, Lims2RelationshipType.QC_RUN);
        return new QCTestRunImpl(qcTestRunNode);
    }

    public QCTestRun createQCTestRun(UUID qcTestRunId, Date runDate, String softwareVersion, String sequencingProject, String templatePlate) {
        QCTestRun qcTestRun = createQCTestRun();
        qcTestRun.setRunId(qcTestRunId);
        qcTestRun.setRunDate(runDate);
        qcTestRun.setSoftwareVersion(softwareVersion);
        qcTestRun.setSequencingProject(sequencingProject);
        qcTestRun.setTemplatePlate(templatePlate);
        return qcTestRun;
    }
}

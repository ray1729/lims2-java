/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.sanger.htgt.lims2.db;

import org.neo4j.graphdb.RelationshipType;

/**
 *
 * @author ray
 */
public enum Lims2RelationshipType implements RelationshipType {
    QC_RUNS, QC_RUN,
    QC_SEQ_READS, QC_SEQ_READ,
    QC_SYNVECS, QC_SYNVEC,
    QC_TEST_RESULT, QC_TEST_RESULT_ALIGNMENT,
    QC_ALIGNMENT_SEQ_READ, QC_ALIGNMENT_SYNVEC
}

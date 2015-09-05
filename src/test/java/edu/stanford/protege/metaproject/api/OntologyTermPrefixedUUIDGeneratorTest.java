package edu.stanford.protege.metaproject.api;

import edu.stanford.protege.metaproject.Utils;
import edu.stanford.protege.metaproject.api.impl.OntologyTermPrefixedUUIDGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public class OntologyTermPrefixedUUIDGeneratorTest {
    private static final String toStringHead = "OntologyTermPrefixedUUIDGenerator";
    private static final OntologyTermIdPrefix
            classIdPrefix = Utils.getOntologyTermIdPrefix(),
            objPropPrefix = Utils.getOntologyTermIdPrefix(),
            dataPropPrefix = Utils.getOntologyTermIdPrefix(),
            annPropPrefix = Utils.getOntologyTermIdPrefix(),
            indPrefix = Utils.getOntologyTermIdPrefix(),
            diffIndPrefix = Utils.getOntologyTermIdPrefix("customIndividualPrefix");

    private OntologyTermPrefixedUUIDGenerator gen, otherGen, diffGen;

    @Before
    public void setUp() {
        gen = Utils.getOntologyTermPrefixedUUIDGenerator(classIdPrefix, objPropPrefix, dataPropPrefix, annPropPrefix, indPrefix);
        otherGen = Utils.getOntologyTermPrefixedUUIDGenerator(classIdPrefix, objPropPrefix, dataPropPrefix, annPropPrefix, indPrefix);
        diffGen = Utils.getOntologyTermPrefixedUUIDGenerator(classIdPrefix, objPropPrefix, dataPropPrefix, annPropPrefix, diffIndPrefix);
    }

    @Test
    public void testNotNull() {
        assertThat(gen, is(not(equalTo(null))));
    }

    @Test
    public void testGetCurrentOntologyTermIdStatus() {
        assertThat(gen.getCurrentOntologyTermIdStatus(), is(Optional.empty()));
    }

    @Test
    public void testGetClassIdPrefix() {
        assertThat(gen.getClassIdPrefix(), is(classIdPrefix));
    }

    @Test
    public void testGetObjectPropertyIdPrefix() {
        assertThat(gen.getObjectPropertyIdPrefix(), is(objPropPrefix));
    }

    @Test
    public void testGetDataPropertyIdPrefix() {
        assertThat(gen.getDataPropertyIdPrefix(), is(dataPropPrefix));
    }

    @Test
    public void testGetAnnotationPropertyIdPrefix() {
        assertThat(gen.getAnnotationPropertyIdPrefix(), is(annPropPrefix));
    }

    @Test
    public void testGetIndividualIdPrefix() {
        assertThat(gen.getIndividualIdPrefix(), is(indPrefix));
    }

    @Test
    public void testGetNextClassId() {
        OntologyTermId termId = gen.getNextClassId();
        assertThat(termId, is(not(equalTo(null))));
        assertThat(termId.getPrefix(), is(classIdPrefix));
        assertThat(termId.getSuffix(), is(not(equalTo(null))));
        assertThat(termId.getSuffix(), is(not(equalTo(""))));
    }

    @Test
    public void testGetNextObjectPropertyId() {
        OntologyTermId termId = gen.getNextObjectPropertyId();
        assertThat(termId, is(not(equalTo(null))));
        assertThat(termId.getPrefix(), is(objPropPrefix));
        assertThat(termId.getSuffix(), is(not(equalTo(null))));
        assertThat(termId.getSuffix(), is(not(equalTo(""))));
    }

    @Test
    public void testGetNextDataPropertyId() {
        OntologyTermId termId = gen.getNextDataPropertyId();
        assertThat(termId, is(not(equalTo(null))));
        assertThat(termId.getPrefix(), is(dataPropPrefix));
        assertThat(termId.getSuffix(), is(not(equalTo(null))));
        assertThat(termId.getSuffix(), is(not(equalTo(""))));
    }

    @Test
    public void testGetNextAnnotationPropertyId() {
        OntologyTermId termId = gen.getNextAnnotationPropertyId();
        assertThat(termId, is(not(equalTo(null))));
        assertThat(termId.getPrefix(), is(annPropPrefix));
        assertThat(termId.getSuffix(), is(not(equalTo(null))));
        assertThat(termId.getSuffix(), is(not(equalTo(""))));
    }

    @Test
    public void testGetNextIndividualId() {
        OntologyTermId termId = gen.getNextIndividualId();
        assertThat(termId, is(not(equalTo(null))));
        assertThat(termId.getPrefix(), is(indPrefix));
        assertThat(termId.getSuffix(), is(not(equalTo(null))));
        assertThat(termId.getSuffix(), is(not(equalTo(""))));
    }

    @Test
    public void testEqualToSelf() {
        assertThat(gen, is(gen));
    }

    @Test
    public void testEquals() {
        assertThat(gen, is(otherGen));
    }

    @Test
    public void testNotEquals() {
        assertThat(gen, is(not(diffGen)));
    }

    @Test
    public void testHashCode() {
        assertThat(gen.hashCode(), is(otherGen.hashCode()));
    }

    @Test
    public void testToString() {
        assertThat(gen.toString(), startsWith(toStringHead));
    }
}
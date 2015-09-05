package edu.stanford.protege.metaproject.api.impl;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.metaproject.api.ClientConfiguration;
import edu.stanford.protege.metaproject.api.GUIRestriction;
import edu.stanford.protege.metaproject.api.Metaproject;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public final class ClientConfigurationImpl implements ClientConfiguration, Serializable {
    private static final long serialVersionUID = 9090436444643169613L;
    private final Metaproject metaproject;
    private final int synchronisationDelay;
    private final ImmutableSet<GUIRestriction> guiRestrictions;
    private final ImmutableMap<String,String> properties;

    /**
     * Constructor
     *
     * @param metaproject    Metaproject definition
     * @param synchronisationDelay  Synchronisation delay for configurations (in seconds)
     * @param guiRestrictions    Set of GUI restrictions
     * @param properties    Map of additional string properties
     */
    public ClientConfigurationImpl(Metaproject metaproject, int synchronisationDelay, Set<GUIRestriction> guiRestrictions, Map<String,String> properties) {
        this.metaproject = checkNotNull(metaproject);
        this.synchronisationDelay = checkNotNull(synchronisationDelay);

        ImmutableSet<GUIRestriction> disabledUIElementsCopy = new ImmutableSet.Builder<GUIRestriction>().addAll(checkNotNull(guiRestrictions)).build();
        this.guiRestrictions = checkNotNull(disabledUIElementsCopy);

        ImmutableMap<String,String> immutableMap = new ImmutableMap.Builder<String, String>().putAll(checkNotNull(properties)).build();
        this.properties = checkNotNull(immutableMap);
    }

    @Override
    public Metaproject getMetaproject() {
        return metaproject;
    }

    @Override
    public int getSynchronisationDelay() {
        return synchronisationDelay;
    }

    @Override
    public Set<GUIRestriction> getGUIRestrictions() {
        return guiRestrictions;
    }

    @Override
    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientConfigurationImpl that = (ClientConfigurationImpl) o;
        return Objects.equal(synchronisationDelay, that.synchronisationDelay) &&
                Objects.equal(metaproject, that.metaproject) &&
                Objects.equal(guiRestrictions, that.guiRestrictions) &&
                Objects.equal(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(metaproject, synchronisationDelay, guiRestrictions, properties);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("metaproject", metaproject)
                .add("synchronisationDelay", synchronisationDelay)
                .add("guiRestrictions", guiRestrictions)
                .add("properties", properties)
                .toString();
    }
}
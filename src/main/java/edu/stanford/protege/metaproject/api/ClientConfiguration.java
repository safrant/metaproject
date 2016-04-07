package edu.stanford.protege.metaproject.api;

/**
 * A representation of a client configuration, consisting of the value for the client-server synchronisation delay,
 * the set of UI components that are disabled for this client
 *
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public interface ClientConfiguration extends HasProperties {

    /**
     * Get the access control policy in effect for the client
     *
     * @return Metaproject
     */
    Metaproject getMetaproject();

    /**
     * Get the time (in seconds) between client-server synchronisation attempts
     *
     * @return Synchronisation delay in seconds
     */
    int getSynchronisationDelay();

}

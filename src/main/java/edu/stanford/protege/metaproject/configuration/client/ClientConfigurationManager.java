package edu.stanford.protege.metaproject.configuration.client;

import edu.stanford.protege.metaproject.configuration.ConfigurationManager;

import javax.swing.*;
import java.util.Set;

/**
 * Manager for client-side configurations
 *
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public interface ClientConfigurationManager extends ConfigurationManager {

    /**
     * Get the time (in seconds) between client-server synchronisation attempts
     *
     * @return Synchronisation delay in seconds
     */
    int getSynchronisationDelay();

    /**
     * Set the synchronisation delay time
     *
     * @param synchronisationDelay  Time in seconds
     */
    void setSynchronisationDelay(int synchronisationDelay);

    /**
     * Enable the specified UI element
     *
     * @param obj   Java swing component
     */
    void enableUIElement(JComponent obj);

    /**
     * Disable the specified UI element
     *
     * @param obj   Java swing component
     */
    void disableUIElement(JComponent obj);

    /**
     * Get the set of swing components that are disabled
     *
     * @return Set of java swing component instances
     */
    Set<JComponent> getDisabledUIElements();

}

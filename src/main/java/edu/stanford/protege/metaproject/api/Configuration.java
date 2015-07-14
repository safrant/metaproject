package edu.stanford.protege.metaproject.api;

/**
 * General manager for key-value pair configurations
 *
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public interface Configuration {

    /**
     * Get the value of a string-type property
     *
     * @param propertyName  Property name
     * @return Value of string-type property
     */
    String getStringProperty(String propertyName);

    /**
     * Get the value of an integer-type property
     *
     * @param propertyName  Property name
     * @return Value of integer-type property
     */
    int getIntegerProperty(String propertyName);

    /**
     * Get the value of a boolean-type property
     *
     * @param propertyName  Property name
     * @return Value of boolean-type property
     */
    boolean getBooleanProperty(String propertyName);

    /**
     * Set a string-type property
     *
     * @param propertyName  Property name
     * @param propertyValue Property value
     */
    void setProperty(String propertyName, String propertyValue);

    /**
     * Set an integer-type property
     *
     * @param propertyName  Property name
     * @param propertyValue Property value
     */
    void setProperty(String propertyName, int propertyValue);

    /**
     * Set a boolean-type property
     *
     * @param propertyName  Property name
     * @param propertyValue Property value
     */
    void setProperty(String propertyName, boolean propertyValue);

    /**
     * Check whether the given property has a string value
     *
     * @param propertyName  Property name
     * @return true if property has a string value, false otherwise
     */
    boolean isStringProperty(String propertyName);

    /**
     * Check whether the given property has an integer value
     *
     * @param propertyName  Property name
     * @return true if property has an integer value, false otherwise
     */
    boolean isIntegerProperty(String propertyName);

    /**
     * Check whether the given property has a boolean value
     *
     * @param propertyName  Property name
     * @return true if property has a boolean value, false otherwise
     */
    boolean isBooleanProperty(String propertyName);

    /**
     * Check whether the given property is set (with some value)
     *
     * @param propertyName  Property name
     * @return true if property has already been set, false otherwise
     */
    boolean isPropertySet(String propertyName);

}
package edu.stanford.protege.metaproject.impl;

import edu.stanford.protege.metaproject.Utils;
import edu.stanford.protege.metaproject.api.AuthenticationRegistry;
import edu.stanford.protege.metaproject.api.Host;
import edu.stanford.protege.metaproject.api.Metaproject;
import edu.stanford.protege.metaproject.api.ServerConfiguration;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public class ServerConfigurationTest {
    private static final String toStringHead = ServerConfiguration.class.getSimpleName();
    private static final Host host = Utils.getHost();
    private static final File root = Utils.getFile();
    private static final Metaproject metaproject = Utils.getMetaproject();
    private static final AuthenticationRegistry authenticationRegistry = Utils.getAuthenticationRegistry();
    private static Map<String,String> propertiesMap = Utils.getPropertyMap();

    private ServerConfiguration serverConfiguration, otherServerConfiguration, diffServerConfiguration;

    @Before
    public void setUp() {
        serverConfiguration = Utils.getServerConfiguration(host, root, metaproject, authenticationRegistry, propertiesMap);
        otherServerConfiguration = Utils.getServerConfiguration(host, root,metaproject, authenticationRegistry, propertiesMap);
        diffServerConfiguration = Utils.getServerConfiguration();
    }

    @Test
    public void testNotNull() {
        assertThat(serverConfiguration, is(not(equalTo(null))));
    }

    @Test
    public void testGetHost() {
        assertThat(serverConfiguration.getHost(), is(host));
    }

    @Test
    public void testGetPolicy() {
        assertThat(serverConfiguration.getMetaproject(), is(metaproject));
    }

    @Test
    public void testGetProperties() {
        assertThat(serverConfiguration.getProperties(), is(propertiesMap));
    }

    @Test
    public void testEqualToSelf() {
        assertThat(serverConfiguration, is(serverConfiguration));
    }

    @Test
    public void testEquals() {
        assertThat(serverConfiguration, is(otherServerConfiguration));
    }

    @Test
    public void testNotEquals() {
        assertThat(serverConfiguration, is(not(diffServerConfiguration)));
    }

    @Test
    public void testHashcode() {
        assertThat(serverConfiguration.hashCode(), is(otherServerConfiguration.hashCode()));
    }

    @Test
    public void testToString() {
        assertThat(serverConfiguration.toString(), startsWith(toStringHead));
    }
}

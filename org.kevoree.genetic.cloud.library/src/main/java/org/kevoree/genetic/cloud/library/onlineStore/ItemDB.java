package org.kevoree.genetic.cloud.library.onlineStore;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

@Library(name = "Snt-Cloud")
@ComponentType
@DictionaryType({
        @DictionaryAttribute(name = "vcpu-load", defaultValue = "0.4", optional = true),
        @DictionaryAttribute(name = "response time", defaultValue = "100", optional = true),
        @DictionaryAttribute(name = "source", defaultValue = "europe", optional = true),
        @DictionaryAttribute(name = "security", defaultValue = "1.0", optional = true)
})
@Requires({
        @RequiredPort(name="outgoingConnection", type = PortType.MESSAGE, optional = true)
})
@Provides({
        @ProvidedPort(name = "message", type = PortType.MESSAGE)
})
public class ItemDB extends AbstractComponentType {

    @Start
    public void start(){

    }

    @Stop
    public void stop(){

    }

    @Port(name = "message")
    public void messageReceived(Object o) {

    }
}

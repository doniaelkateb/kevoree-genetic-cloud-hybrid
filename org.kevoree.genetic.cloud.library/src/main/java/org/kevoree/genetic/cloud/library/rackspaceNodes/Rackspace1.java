package org.kevoree.genetic.cloud.library.rackspaceNodes;

import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;
import org.kevoree.annotation.Library;
import org.kevoree.annotation.NodeType;
import org.kevoree.library.sky.api.IaaSNode;
import org.kevoree.library.sky.api.PJavaSENode;

/**
 * Created with IntelliJ IDEA.
 * User: donia.elkateb
 * Date: 7/23/13
 * Time: 9:54 AM
 * To change this template use File | Settings | File Templates.
 */


@NodeType
@Library(name = "Snt-Cloud")
@DictionaryType({
        @DictionaryAttribute(name = "RAM", defaultValue = "512MB", optional = true),
        @DictionaryAttribute(name = "DiskSpace", defaultValue = "20GB", optional = true),
        @DictionaryAttribute(name = "vCPUs", defaultValue = "1", optional = true),
        @DictionaryAttribute(name = "Price/hour", defaultValue = "0.022", optional = true),
        @DictionaryAttribute(name = "Price/month", defaultValue = "16.06", optional = true),
        @DictionaryAttribute(name = "location", defaultValue = "1.0", optional = true),
})



public class Rackspace1 extends PJavaSENode {
}



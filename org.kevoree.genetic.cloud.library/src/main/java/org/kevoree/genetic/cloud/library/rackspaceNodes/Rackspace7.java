package org.kevoree.genetic.cloud.library.rackspaceNodes;

import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;
import org.kevoree.annotation.Library;
import org.kevoree.annotation.NodeType;
import org.kevoree.library.sky.api.KevoreeNodeRunner;
import org.kevoree.library.sky.api.nodeType.IaaSNode;
import org.kevoree.library.sky.api.nodeType.PJavaSENode;

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
        @DictionaryAttribute(name = "RAM", defaultValue = "30GB", optional = true),
        @DictionaryAttribute(name = "DiskSpace", defaultValue = "1.2TB", optional = true),
        @DictionaryAttribute(name = "vCPUs", defaultValue = "8", optional = true),
        @DictionaryAttribute(name = "Price/hour", defaultValue = "1.20", optional = true),
        @DictionaryAttribute(name = "Price/month", defaultValue = "867.60", optional = true),
        @DictionaryAttribute(name = "location", defaultValue = "US", optional = true),
})



public class Rackspace7 extends PJavaSENode {
}

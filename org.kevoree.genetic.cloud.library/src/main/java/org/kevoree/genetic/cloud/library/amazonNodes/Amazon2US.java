package org.kevoree.genetic.cloud.library.amazonNodes;

import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;
import org.kevoree.annotation.Library;
import org.kevoree.annotation.NodeType;
import org.kevoree.library.sky.api.nodeType.PJavaSENode;

/**
 * Created with IntelliJ IDEA.
 * User: donia.elkateb
 * Date: 7/23/13
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
@NodeType
@Library(name = "Snt-Cloud")
@DictionaryType({
        @DictionaryAttribute(name = "Cost/hour", defaultValue = "0.120", optional = true),
})

public class Amazon2US extends PJavaSENode {
}


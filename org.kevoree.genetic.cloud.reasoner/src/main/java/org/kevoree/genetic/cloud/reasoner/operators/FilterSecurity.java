package org.kevoree.genetic.cloud.reasoner.operators;

import org.kevoree.ContainerNode;
import org.kevoree.ContainerRoot;
import org.kevoree.genetic.cloud.reasoner.util.PropertyCachedResolver;
import org.kevoree.genetic.library.operator.MoveNodeOperator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 16/03/13
 * Time: 17:52
 */
public class FilterSecurity  {

    private PropertyCachedResolver resolver = new PropertyCachedResolver();
    private static final String level = "security level";

    protected List<Object> selectTarget(ContainerRoot root, String query) {
        List<Object> nodeList = root.selectByQuery(query);
        List<Object> selectedNodes = new ArrayList<Object>();

        for (Object n : nodeList) {
            ContainerNode node = (ContainerNode) n;

            if (resolver.getDefault(node, level).equals("B") || resolver.getDefault(node, level).equals("C") )
            {
                selectedNodes.add(node);
            }
        }
        return selectedNodes;
    }

}

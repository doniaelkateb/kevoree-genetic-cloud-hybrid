package org.kevoree.genetic.cloud.reasoner.operators;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerNode;
import org.kevoree.ContainerRoot;
import org.kevoree.TypeDefinition;
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
    private static final String AttName = "security";

    protected boolean filtersecurity(ContainerRoot root) {


        List<Object> nodeList = root.selectByQuery("nodes[{ name = *virtual* }]");
        for (Object n : nodeList) {
            ContainerNode node = (ContainerNode) n;
            System.out.println(node.getName());

            double temp = 0;
            double level = 0;

            for(ComponentInstance ci : node.getComponents())
            {
                System.out.println(ci.getName());
                level=resolver.getDefault(ci, AttName);
                System.out.println(level);
                if (temp!=level)return false ;
                temp=level;
            }
        }
        return true;
    }

}

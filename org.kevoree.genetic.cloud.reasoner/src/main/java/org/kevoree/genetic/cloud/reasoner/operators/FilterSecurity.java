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

    // The security filter returns false when there are two components having different security levels on the same VM, it returns true otherwise

    protected boolean filtersecurity(ContainerRoot root) {


        List<Object> nodeList = root.selectByQuery("nodes[{ name = *virtual* }]");
        for (Object n : nodeList) {
            ContainerNode node = (ContainerNode) n;


            double temp = 0;
            double level = 0;

            for(ComponentInstance ci : node.getComponents())
            {

                if (temp!=level)return false ;
                temp=level;
                System.out.println(ci.getName());
                level=resolver.getDefault(ci, AttName);
                System.out.println(level);


            }
        }
        return true;
    }

}

package org.kevoree.genetic.cloud.reasoner.fitness;

import com.sun.org.apache.xerces.internal.dom.ParentNode;
import org.kevoree.ContainerNode;
import org.kevoree.ContainerRoot;
import org.kevoree.genetic.cloud.reasoner.util.PropertyCachedResolver;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 26/03/13
 * Time: 18:51
 */

/* */
public class CostFitness extends AbstractSLAKevoreeFitnessFunction {

    private PropertyCachedResolver resolver = new PropertyCachedResolver();
    private static final String dictionaryAttName = "cost";

    private PropertyCachedResolver resolver1 = new PropertyCachedResolver();
    private static final String dictionaryAttName1 = "dateofstartofuse";

    @Override
    public double evaluate(ContainerRoot containerRoot) {
        Double gCost = 0.0;
        Double Cost = 0.0;
        int age = 0 ;
        for(ContainerNode loopNode : containerRoot.getNodes()){
            Cost  =  resolver.getDefault(loopNode,dictionaryAttName);
            //Get the date of start of use of the hosting node
            age  +=  resolver1.getDefault(loopNode.getHost(),dictionaryAttName1);
            if (age >=  3)
            {
            Cost = Cost - (Cost * (1.5  + 0.05 *(age-3))) /100;
            }
            gCost =  gCost +  Cost;
        }
        if(gCost == 0){
            return 0d;
        }
        return (gCost / slaModel.getMaxCost()) * 100;
    }
}

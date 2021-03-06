package org.kevoree.genetic.cloud.reasoner.fitness;

import com.sun.org.apache.xerces.internal.dom.ParentNode;
import org.kevoree.ContainerNode;
import org.kevoree.ContainerRoot;
import org.kevoree.genetic.cloud.reasoner.util.PropertyCachedResolver;
import java.util.ArrayList;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 26/03/13
 * Time: 18:51
 */
/* */
public class CostFitness extends AbstractSLAKevoreeFitnessFunction {

    private PropertyCachedResolver resolver = new PropertyCachedResolver();
    private static final String dictionaryAttName = "Price/hour";
    private PropertyCachedResolver resolver1 = new PropertyCachedResolver();
    private static final String dictionaryAttName1 = "dateofstartofuse";

    @Override
    public double evaluate(ContainerRoot containerRoot) {
        Double gCost = 0.0;
        Double Cost = 0.0;
        double age = 0 ;


        List<Object> VMNodeList = containerRoot.selectByQuery("nodes[{ name = *virtual* }]");
        for(Object loopNode : VMNodeList){

            ContainerNode virtualNode = (ContainerNode) loopNode;
            Cost  =  resolver.getDefault(virtualNode,dictionaryAttName);

            //Fonction d'amortissement: to be changed

            age = 0 + (int)(Math.random()*20);
            System.out.println(age);
            if (age >=  3)
            {
            Cost = Cost - (Cost * (1.5  + 0.05 *(age-3))) /100;
            }

            //////////////////////////////////////
            gCost =  gCost +  Cost;
           System.out.println(gCost);

        }
        if(gCost == 0){
            return 0d;
        }
        return  gCost/VMNodeList.size()* 100 ;
    }
}

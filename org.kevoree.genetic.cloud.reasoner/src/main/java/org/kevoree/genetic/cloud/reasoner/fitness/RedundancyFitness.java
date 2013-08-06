package org.kevoree.genetic.cloud.reasoner.fitness;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerNode;
import org.kevoree.ContainerRoot;
import org.kevoree.TypeDefinition;
import org.kevoree.genetic.cloud.library.onlineStore.ItemDB;
import org.kevoree.genetic.cloud.library.onlineStore.LoadBalancer;
import org.kevoree.genetic.cloud.library.onlineStore.UserDB;
import org.kevoree.genetic.cloud.reasoner.SLAModel;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: donia.elkateb
 * Date: 6/5/13
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class RedundancyFitness extends AbstractSLAKevoreeFitnessFunction{


    public double evaluate(ContainerRoot model, SLAModel SLAModel ) {

        Double redundancy = 0.0;



                       List<Object> TotalComponents  = model.selectByQuery("nodes[{ name = *}]/components[{typeDefinition.name = *}]");

                       List<Object> composants = model.selectByQuery("nodes[{ name = *}]/components[{typeDefinition.name = ItemDB}]");
                       redundancy += composants.size()/SLAModel.getRedunduncy("ItemDB");

                       List<Object> composants1 =   model.selectByQuery("nodes[{ name = *}]/components[{typeDefinition.name = LoadBalancer}]");
                       redundancy += composants1.size()/ SLAModel.getRedunduncy("LoadBalancer");

                       List<Object> composants2 = model.selectByQuery("nodes[{ name = *}]/components[{typeDefinition.name = UserDB}]");
                       redundancy += composants2.size()/ SLAModel.getRedunduncy("UserDB");


        return redundancy/TotalComponents.size() * 100 ;
    }

    @Override
    public double evaluate(ContainerRoot containerRoot) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}


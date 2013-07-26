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


    public double evaluate(ContainerRoot model) {

        Double redundancy = 0.0;
        SLAModel SLAModel = new SLAModel();
        SLAModel.putRedunduncy(ItemDB.class.getSimpleName(), 1.0);
        SLAModel.putRedunduncy(LoadBalancer.class.getSimpleName(), 1.0);
        SLAModel.putRedunduncy(UserDB.class.getSimpleName(), 1.0);


                       List<Object> composants = model.selectByQuery("nodes[*]/components[item]");
                       redundancy += composants.size()/SLAModel.getRedunduncy("ItemDB");
                       System.out.println("redundancy"+redundancy);

                       List<Object> composants1 = model.selectByQuery("nodes[*]/components[loadbalancer]");
                       redundancy += composants1.size()/ SLAModel.getRedunduncy("LoadBalancer");

                       List<Object> composants2 = model.selectByQuery("nodes[*]/components[userdb]");
                       redundancy += composants2.size()/ SLAModel.getRedunduncy("UserDB");


        return redundancy/3 * 100 ;
    }
}


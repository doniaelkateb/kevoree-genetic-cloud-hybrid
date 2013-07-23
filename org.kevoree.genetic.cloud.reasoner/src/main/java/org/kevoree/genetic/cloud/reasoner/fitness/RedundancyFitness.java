package org.kevoree.genetic.cloud.reasoner.fitness;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerNode;
import org.kevoree.ContainerRoot;
import org.kevoree.TypeDefinition;

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

    @Override
    public double evaluate(ContainerRoot model) {
        Double redundancy = 0.0;
        for (ContainerNode node : model.getNodes()) {
            if (node.getComponents().size() > 0) {
                //Look for higher security level
                for (ComponentInstance c : node.getComponents()) {
                    List<Object> composants = model.selectByQuery("nodes[*]/subNodes[virtual*]/components[c.getTypeDefinition().getName()]");
                    redundancy +=  redundancy + composants.size()/slaModel.getRedunduncy(c.getTypeDefinition().getName());
                }
            }
     }

            return redundancy * 100 ;
        }
    }


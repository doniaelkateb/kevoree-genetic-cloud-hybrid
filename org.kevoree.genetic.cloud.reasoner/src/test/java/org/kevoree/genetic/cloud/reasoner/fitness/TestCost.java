package org.kevoree.genetic.cloud.reasoner.fitness;

import org.junit.Test;
import org.kevoree.ContainerRoot;
import org.kevoree.KevoreeFactory;
import org.kevoree.genetic.cloud.reasoner.population.ExamplePopulationFactory;
import org.kevoree.impl.DefaultKevoreeFactory;
import org.kevoree.serializer.JSONModelSerializer;

import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: donia.elkateb
 * Date: 6/5/13
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCost  {

    @Test

    public static void main(String[] args) {

        ExamplePopulationFactory factory = new ExamplePopulationFactory();
        List<ContainerRoot> models = factory.createPopulation();
        ContainerRoot model = models.get(0);


        //print model to check consistency
       // JSONModelSerializer jsonModel = new JSONModelSerializer();
       // jsonModel.serialize(model,System.out);


        CostFitness fitness = new CostFitness();
        double costfitness = fitness.evaluate(model);
        System.out.println(costfitness);

}
}

package org.kevoree.genetic.cloud.reasoner.operators;

import org.kevoree.ContainerRoot;
import org.kevoree.genetic.cloud.reasoner.fitness.CostFitness;
import org.kevoree.genetic.cloud.reasoner.population.ExamplePopulationFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: donia.elkateb
 * Date: 7/31/13
 * Time: 11:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class FilterSecurityTest {

    public static void main(String[] args) {

        ExamplePopulationFactory factory = new ExamplePopulationFactory();
        List<ContainerRoot> models = factory.createPopulation();
        ContainerRoot model = models.get(0);

        //print model to check consistency
        // JSONModelSerializer jsonModel = new JSONModelSerializer();
        // jsonModel.serialize(model,System.out);

        FilterSecurity filtersecurity = new FilterSecurity();
        boolean result = filtersecurity.filtersecurity(model);
        System.out.println(result);

    }



}

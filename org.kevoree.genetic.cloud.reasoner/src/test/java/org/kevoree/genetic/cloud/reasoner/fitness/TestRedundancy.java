package org.kevoree.genetic.cloud.reasoner.fitness;
import org.junit.Test;
import org.kevoree.ContainerRoot;
import org.kevoree.KevoreeFactory;
import org.kevoree.genetic.cloud.library.onlineStore.ItemDB;
import org.kevoree.genetic.cloud.library.onlineStore.LoadBalancer;
import org.kevoree.genetic.cloud.library.onlineStore.PaymentDB;
import org.kevoree.genetic.cloud.reasoner.SLAModel;
import org.kevoree.genetic.cloud.reasoner.population.ExamplePopulationFactory;
import org.kevoree.impl.DefaultKevoreeFactory;
import org.kevoree.serializer.JSONModelSerializer;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: donia.elkateb
 * Date: 7/23/13
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestRedundancy {
    @Test
    public static void main(String[] args) {




        ExamplePopulationFactory factory = new ExamplePopulationFactory();
        KevoreeFactory kfactory = new DefaultKevoreeFactory();
        List<ContainerRoot> models = factory.createPopulation();
        ContainerRoot model = models.get(0);

        //print model to check consistency
        //JSONModelSerializer jsonModel = new JSONModelSerializer();
        //jsonModel.serialize(model,System.out);





       RedundancyFitness fitness = new RedundancyFitness();
       double redundancyfitness = fitness.evaluate(model);
       System.out.println(redundancyfitness);


    }
}

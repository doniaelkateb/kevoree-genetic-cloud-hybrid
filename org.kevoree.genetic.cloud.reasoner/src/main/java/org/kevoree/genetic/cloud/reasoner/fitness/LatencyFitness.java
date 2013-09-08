package org.kevoree.genetic.cloud.reasoner.fitness;
import org.kevoree.ComponentInstance;
import org.kevoree.ContainerRoot;
import org.kevoree.ContainerNode;
import org.kevoree.genetic.cloud.reasoner.util.PropertyCachedResolver;

import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 27/03/13
 * Time: 15:00
 */
//10 000 r/s   -> latency
//comp = TP
//US , EU = 15 = 1000 /
//comp TP compensé
//NB * TP * Coeff
/* Fitness QoS
 *
 * %TP marge 1000 - 800 = 20% etc ....
 * latency : 100ms
 *
*/
/* latency = Max(1,(current TP / currentTPMax)) * MinimalLatency */
/*  */
/*
 * a , b , c
 * A us == a + networkLatency(A) (eu - us)ms + b + c
  **/
/* latency per component =  response time - (redundunt VM number) * a + network latency
/* network latency =  (destination - source ) * b ; a,b constants */
/*  model latency latency sum of latency of all components / components number */
/*************************************************** we retain this to calculate latency*/
/*  latency/region == target      ==> SLA (ex http 120ms US)
 *  1 repliquat frontend composant : (Profiling)throughput /s , (Profiling)coef d'ammortissement de latency + (dest - src)*networkLatency
 *  1 region = replicat.region == region
 */
/***************************************************/

public class LatencyFitness extends AbstractSLAKevoreeFitnessFunction{

    private String responsetime = "response time";
    private PropertyCachedResolver resolver = new PropertyCachedResolver();

    private String localisation = "location";
    private PropertyCachedResolver resolver1 = new PropertyCachedResolver();

    public double evaluate(ContainerRoot model,  String zone )  {
         Double response_time = 0.0;
         Double coef_US = 0.001;
         Double coef_EU = 0.002;
         Double coef_AS = 0.003;
         Double networkLatency = 0.01;
         Double LatencyperComponent = 0.01;
         Double TotalLatency = 0.01;
         Double constante = 5.0;
         Double Sourcelocation = 0.0;
         Double Destinationlocation = 0.0;


         List<Object> TotalComponents  = model.selectByQuery("nodes[{ name = *}]/components[{typeDefinition.name = *}]");

        List<Object> virtualNodes = model.selectByQuery("nodes[*]");
        for (Object node : virtualNodes)
        {
        ContainerNode containernode = (ContainerNode) node;
        for (ComponentInstance co : containernode.getComponents()) {



         /* Getting response time from each component*/
         response_time = resolver.getDefault(co, responsetime);



         /* Calculating amortization function depending on the zone, response time for a given workload is different in each zone*/
         if (zone.equals("US")) response_time  =  response_time + coef_US*constante;
         if (zone.equals("EU")) response_time  =  response_time + coef_EU*constante;
         if (zone.equals("AS")) response_time  =  response_time + coef_AS*constante;


         /* Getting (dest - src) networkLatency from each component*/
             if (zone.equals("US")) Destinationlocation  =  100.0;
             if (zone.equals("EU")) Destinationlocation  =  200.0;
             if (zone.equals("AS")) Destinationlocation  =  300.0;


          /*location 1.0 ---> USA*/
          /*location 2.0 ---> EU*/
          /*location 3.0 ---> ASIA*/

         Sourcelocation = resolver1.getDefault(containernode, localisation);
         System.out.println(Sourcelocation);
         LatencyperComponent  =   response_time + (( Destinationlocation  -   Sourcelocation)   *   networkLatency) ;
         /*Latency which decreases by redunduncy/*
         /*Calculating replicata number*/
         List<Object> composants = model.selectByQuery("nodes[{ name = *}]/components[{typeDefinition.name = ItemDB}]");
         System.out.println(composants.size());
         LatencyperComponent =  LatencyperComponent/composants.size() ;
         TotalLatency  =  TotalLatency + LatencyperComponent  ;

         System.out.println(TotalLatency);
         }

        }
        return TotalLatency/TotalComponents.size();
    }


    @Override
    public double evaluate(ContainerRoot containerRoot)
    {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}


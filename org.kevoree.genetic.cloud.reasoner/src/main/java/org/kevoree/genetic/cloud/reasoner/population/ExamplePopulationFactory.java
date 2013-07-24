package org.kevoree.genetic.cloud.reasoner.population;

import org.kevoree.*;
import org.kevoree.cloner.ModelCloner;
import org.kevoree.genetic.framework.KevoreePopulationFactory;
import org.kevoree.impl.DefaultKevoreeFactory;
import org.kevoree.loader.ModelLoader;
import org.kevoree.loader.XMIModelLoader;

import java.util.ArrayList;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: donia.elkateb
 * Date: 6/5/13
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExamplePopulationFactory implements KevoreePopulationFactory {
    public List<ContainerRoot> createPopulation() {
        ArrayList<ContainerRoot> population = new ArrayList<ContainerRoot>();
        KevoreeFactory factory = new DefaultKevoreeFactory();
        ModelLoader loader = new XMIModelLoader();
        ModelCloner cloner = new ModelCloner();
        //CReate init Model
        ContainerRoot rootModel = (ContainerRoot) loader.loadModelFromStream(this.getClass().getClassLoader().getResourceAsStream("KEV-INF/lib.kev")).get(0);
        /* Fix Immutable */
        for (TypeDefinition td : rootModel.getTypeDefinitions()) {
            td.setRecursiveReadOnly();
        }
        for (DeployUnit du : rootModel.getDeployUnits()) {
            du.setRecursiveReadOnly();
        }
        for (Repository r : rootModel.getRepositories()) {
            r.setRecursiveReadOnly();
        }
        for (int i = 1; i < 6; i++) {
            ContainerNode n = factory.createContainerNode();
            n.setName("node_" + i);
            n.setTypeDefinition(rootModel.findTypeDefinitionsByID("XeonInfraNode"));
            rootModel.addNodes(n);
        }

        //parcourir nodes et ajouter VM
        int nodecounter =0;
        List<Object> VMNodeList = rootModel.selectByQuery("nodes[{ name = *node_* }]");
        for (Object obj : VMNodeList)
        {
            for (int i = 1; i < 8; i++)
            {
                ContainerNode VMNode = factory.createContainerNode();
                ContainerNode parentInfra = (ContainerNode) obj;

                VMNode.setName("virtual_" + nodecounter+i);
                VMNode.setTypeDefinition(rootModel.findTypeDefinitionsByID("Rackspace"+i));

                parentInfra.addHosts(VMNode);
                rootModel.addNodes(VMNode);
            }
            nodecounter++;
        }

        // Parcourir VM et ajouter composants  A,B,C

        //put component A in VM 01
        ContainerNode VMNodeList1 = rootModel.findNodesByID("virtual_11");
        ComponentInstance composant = factory.createComponentInstance();
        composant.setName("item");
        TypeDefinition td = rootModel.findTypeDefinitionsByID("ItemDB");
        composant.setTypeDefinition(td);
        VMNodeList1.addComponents(composant);

        //put component B in VM 02
        ContainerNode VMNodeList2 = rootModel.findNodesByID("virtual_21");
        ComponentInstance composant1 = factory.createComponentInstance();
        composant1.setName("loadbalancer");
        // How to set the type to component A
        TypeDefinition td1 = rootModel.findTypeDefinitionsByID("LoadBalancer");
        composant1.setTypeDefinition(td1);
        VMNodeList2.addComponents(composant1);


        //put component C in VM 03
        ContainerNode VMNodeList3 = rootModel.findNodesByID("virtual_31");
        ComponentInstance composant2 = factory.createComponentInstance();
        composant2.setName("userdb");
        TypeDefinition td2 = rootModel.findTypeDefinitionsByID("UserDB");
        composant2.setTypeDefinition(td2);
        VMNodeList3.addComponents(composant2);
        population.add(rootModel)   ;

        return population;

    }
}

package sample;

import api.VisFx;
import graph.VisEdge;
import graph.VisGraph;
import graph.VisNode;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Stage primaryStage = new Stage();
        VisGraph graph = new VisGraph();
        VisNode[] objects = new VisNode[25];
        for (int i = 0; i < GenerateSM.stateMachine.getQLength(); i++) {
            objects[i] = (new VisNode(i, GenerateSM.stateMachine.getQ(i)));
            graph.addNodes(new VisNode(i, GenerateSM.stateMachine.getQ(i)));
        }
        List<TransitionFunction> list = new ArrayList<TransitionFunction>();
        for (int i = 0; i < GenerateSM.stateMachine.getTFLength(); i++) {
            list.add(GenerateSM.stateMachine.getTF(i));
        }
        String[][] strings = new String[GenerateSM.stateMachine.getTFLength()][3];
        int count = 0;
        String value = "";
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            String s1 = list.get(i).VN;
            String s2 = list.get(i).Result;
            for (int j = i; j < list.size(); j++) {
                if (s1.equals(list.get(j).VN) && s2.equals(list.get(j).Result)) {
                    count++;
                    value += list.get(i).VT + ",";
                    list.remove(j);
                    j--;

                    System.out.println(i);
                }
            }
            if (count > 0) {
                strings[index][0] = s1;
                strings[index][1] = s2;
                strings[index][2] = value.substring(0, value.length() - 1);
                System.out.println(s1 + s2 + value);
                value = "";
                index++;
                i--;
                count = 0;
            }
        }
        try {
            for (int i = 0; i < strings.length; i++) {
                try {
                    for (int j = 0; j < objects.length; j++) {
                        try {
                            if (strings[i][0].equals(objects[j].getLabel()))
                                for (int q = 0; q < objects.length; q++) {
                                    System.out.println(strings[i][0].equals(objects[j].getLabel()) + " " + strings[i][1].equals(objects[q].getLabel()));
                                    if (strings[i][0].equals(objects[j].getLabel()) && strings[i][1].equals(objects[q].getLabel())) {
                                        //graph.addNodes()
                                        graph.addEdges(new VisEdge(objects[j], objects[q], "to", strings[i][2]));
                                    }

                                }
                        } catch (Exception e) {
                        }

                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
        VisFx.graphNetwork(graph, primaryStage);
        primaryStage.show();
    }
}
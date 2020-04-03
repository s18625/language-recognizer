import org.omg.PortableInterceptor.INACTIVE;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    static Perceptron perceptron1,perceptron2,perceptron3;
    static List<String> keys;
    static List<List<Integer>> listPerceptrons;
    public static void main(String[] args) {
        try {
            String path = "Data";
            Maps read = new Maps(path);
            HashMap<String,List<int[]>> mapOfLeanguages  = read.getMap();



            keys = new ArrayList<>(mapOfLeanguages.keySet());
            System.out.println(keys);


            /*
              polish = [1,0,0]
              english =[0,1,0]
              german = [0,0,1]
             */
            List<Integer> english = Arrays.asList(1,0,0);
            List<Integer> german = Arrays.asList(0,1,0);
            List<Integer> polish = Arrays.asList(0,0,1);

            listPerceptrons = new ArrayList<>();
            listPerceptrons.add(english);
            listPerceptrons.add(german);
            listPerceptrons.add(polish);


            perceptron1 = new Perceptron();
            perceptron2 = new Perceptron();
            perceptron3 = new Perceptron();


            System.out.println(perceptron1.getTetha());

            int numberOfFiles = mapOfLeanguages.get(keys.get(0)).size();


            for (int i =0; i< numberOfFiles;i++){
                for (int j=0; j<keys.size();j++){


                    int[] inVector = mapOfLeanguages.get(keys.get(j)).get(i);

                    perceptron1.yValue(inVector);
                    if (perceptron1.getY()!=listPerceptrons.get(j).get(0)){
                        perceptron1.chanegeWeightVector(inVector);
                    }



                    perceptron2.yValue(inVector);
                    if (perceptron2.getY()!=listPerceptrons.get(j).get(1)){
                        perceptron2.chanegeWeightVector(inVector);
                    }


                    perceptron3.yValue(inVector);
                    if (perceptron3.getY()!=listPerceptrons.get(j).get(2)){
                        perceptron3.chanegeWeightVector(inVector);
                    }



                }
            }
            System.out.println(perceptron1.getTetha());





            GUI gui = new GUI();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

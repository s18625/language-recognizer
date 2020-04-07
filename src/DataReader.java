import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataReader {
    private  String name;
    private List<double[]> listOfWektors = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<double[]> getListOfWektors() {
        return listOfWektors;
    }


    public DataReader(String path) throws IOException {

        File leanguege = new File(path);
        name = leanguege.getName();
        //System.out.println(name);

        File [] files = leanguege.listFiles();
        for (File fileName: files
             ) {

            double wektor[] = new double[26];
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while (( line= reader.readLine())!= null){
                line = line.toUpperCase();
                char lineChars[]= line.toCharArray();
                for(int i =0 ; i<lineChars.length;i++){
                    int charASCII = (int)lineChars[i]-65;
                    if (charASCII>=0 && charASCII <= 25 ){
                        wektor[charASCII]++;
                    }
                }
            }
             //normalization(wektor);
            listOfWektors.add(wektor);
        }


    }

    public void showVector(double[] vector){
        for (int i=0; i<vector.length;i++){
            System.out.println(i+"  "+vector[i]);
        }
    }

    public void normalization(double[] wektor){
        int suma=0;

        for (double i:wektor
             ) {
            suma+=i;
        }
        double pow2 =0;
        for (int i=0; i<wektor.length;i++){
            wektor[i] = wektor[i]/suma;
            pow2+=Math.pow(wektor[i],2);
        }
        double sqrt = Math.sqrt(pow2);
        for (int i=0; i<wektor.length;i++){
            wektor[i] = wektor[i]/sqrt;

        }
        //return wektor;
    }

}

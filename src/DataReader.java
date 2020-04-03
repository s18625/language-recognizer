import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataReader {
    private  String name;
    private List<int[]> listOfWektors = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<int[]> getListOfWektors() {
        return listOfWektors;
    }


    public DataReader(String path) throws IOException {

        File leanguege = new File(path);
        name = leanguege.getName();
        //System.out.println(name);

        File [] files = leanguege.listFiles();
        for (File fileName: files
             ) {

            int wektor[] = new int[26];
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
            listOfWektors.add(wektor);
        }


    }

    public void showVector(int[] vector){
        for (int i=0; i<vector.length;i++){
            System.out.println(i+"  "+vector[i]);
        }
    }

}

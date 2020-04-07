import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Maps {
    public HashMap<String, List<double[]>> map = new HashMap<>();

    public Maps(String path) throws IOException {
        File dircetory = new File(path);
        File[] directories = dircetory.listFiles();
        for (File dr: directories
             ) {
            DataReader dataReader= new DataReader(dr.toString());
            map.put(dataReader.getName(),dataReader.getListOfWektors());

        }

    }

    public HashMap<String, List<double[]>> getMap() {
        return map;
    }

    public void showVector(int[] vector){
        for (int i=0; i<vector.length;i++){
            System.out.println(i+"  "+vector[i]);
        }
    }

}

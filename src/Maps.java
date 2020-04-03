import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maps {
    public HashMap<String, List<int[]>>  map = new HashMap<>();

    public Maps(String path) throws IOException {
        File dircetory = new File(path);
        File[] directories = dircetory.listFiles();
        for (File dr: directories
             ) {
            DataReader dataReader= new DataReader(dr.toString());
            map.put(dataReader.getName(),dataReader.getListOfWektors());

        }

    }

    public HashMap<String, List<int[]>> getMap() {
        return map;
    }

    public void showVector(int[] vector){
        for (int i=0; i<vector.length;i++){
            System.out.println(i+"  "+vector[i]);
        }
    }

}

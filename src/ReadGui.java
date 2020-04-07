public class ReadGui {
    public double[] getGuiVector() {
        return guiVector;
    }

    private double[] guiVector;
    public ReadGui(String text){
        guiVector = new double[26];
        text= text.toUpperCase();
        for(int i=0;i<text.length();i++){
            int charASCII = (int)text.charAt(i)-65;
            if (charASCII>=0 && charASCII <= 25 ){
                guiVector[charASCII]++;
            }
        }


    }
    public void showVector(double[] vector){
        for (int i=0; i<vector.length;i++){
            System.out.println(i+"  "+vector[i]);
        }
    }

}

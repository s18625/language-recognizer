public class ReadGui {
    public int[] getGuiVector() {
        return guiVector;
    }

    private int[] guiVector;
    public ReadGui(String text){
        guiVector = new int[26];
        text= text.toUpperCase();
        for(int i=0;i<text.length();i++){
            int charASCII = (int)text.charAt(i)-65;
            if (charASCII>=0 && charASCII <= 25 ){
                guiVector[charASCII]++;
            }
        }


    }
    public void showVector(int[] vector){
        for (int i=0; i<vector.length;i++){
            System.out.println(i+"  "+vector[i]);
        }
    }

}

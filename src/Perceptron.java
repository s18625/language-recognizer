public class Perceptron {
    private  double[] weightVecot ;
    private double tetha;
    private int y=0;
    private final double alpha = 0.8;

    public double[] getWeightVecot() {
        return weightVecot;
    }


    public double getTetha() {
        return tetha;
    }

    public int getY() {
        return y;
    }

    public double getAlpha() {
        return alpha;
    }

    public Perceptron(){

        weightVecot= new double[26];
        for (int i =0; i< weightVecot.length;i++){
            weightVecot[i] = Math.random()*5*Math.pow(-1,(int)(Math.random()*2));
        }
        tetha=  Math.random()*5*Math.pow(-1,(int)(Math.random()*2));;



    }
    public void  chanegeWeightVector(double[] inVector){
        //(predicted-real)
        int diffrence;
        if(y==0){
            diffrence=1;
        }else {
            diffrence=-1;
        }

        for (int  i=0;i<weightVecot.length;i++){
            weightVecot[i]=weightVecot[i]+alpha*inVector[i]*diffrence;
        }
        tetha= tetha+alpha*(-1)*diffrence;
    }
    public void yValue(double[] inVector){
        double net =0;
        for (int i=0;i<weightVecot.length;i++){
            net += weightVecot[i]*inVector[i];
        }
        if (net>=tetha){
            y=1;
        }
        else {
            y=0;
        }
    }
    public void showVector(double[] vector){
        for (int i=0; i<vector.length;i++){
            System.out.println(i+"  "+vector[i]);
        }
    }
}

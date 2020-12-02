public class Result implements Comparable <Result>{

    private final static String REZ_FORMAT_STRING = "%10s | %10s | %10s | %8d |";

    private String trainNumber; 
    private String serviceClass; 
    private String typeOfTrain;
    private int price;

    public Result(){
    	trainNumber="";
    	serviceClass="";
        typeOfTrain="";
        price=0;
    }

    public Result(String trainNumber,String serviceClass, String typeOfTrain, int price){
        this.trainNumber=trainNumber;
        this.serviceClass=serviceClass;
        this.typeOfTrain=typeOfTrain;
        this.price=price;
    }

    public String getTrainNumber(){return trainNumber;}
    public String getServiceClass(){return serviceClass;}
    public String getTypeOfTrain(){return typeOfTrain;}
    public int getPrice(){return price;}
 
    public void setIdentificationNumber(String trainNumber){this.trainNumber = trainNumber;}
    public void setCompetitionCode(String serviceClass){this.serviceClass = serviceClass;}
    public void setDate(String typeOfTrain){this.typeOfTrain = typeOfTrain;}
    public void setWins(int price){this.price = price;}

    @Override
    public String toString(){
        return String.format(REZ_FORMAT_STRING,trainNumber,serviceClass,typeOfTrain,price);
    } 
   
    @Override
    public boolean equals (Object ob){ 
        if (ob==this) return true; 
        if (ob==null) return false;
        if (getClass()!=ob.getClass())return false;
        Result rez=(Result)ob;
        return (trainNumber.equals(rez.trainNumber) &&
        		serviceClass.equals(rez.serviceClass) && typeOfTrain.equals(rez.typeOfTrain));                 
    }

    public int hashCode(){
        return 7*trainNumber.hashCode()+
        13*serviceClass.hashCode()+
        17*typeOfTrain.hashCode()+
        19*(new Integer(price)).hashCode();
    }

    public int compareTo(Result rez){
        if (trainNumber.compareTo(rez.trainNumber) < 0) return -1;
        if ((trainNumber.compareTo(rez.trainNumber) == 0) && (serviceClass.compareTo(rez.serviceClass) < 0)) return -1;
        if ((trainNumber.compareTo(rez.trainNumber) == 0) && (serviceClass.compareTo(rez.serviceClass) == 0)&& (typeOfTrain.compareTo(rez.typeOfTrain) < 0)) return -1;
        else return 1;     
    }
}



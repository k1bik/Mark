import java.util.*;

public class CompCommandAscBallDesc implements Comparator{
    public int compare (Object ob1, Object ob2){
    	
        Result res1 = (Result) ob1;
        Result res2 = (Result) ob2;
        
        if (res1.getTrainNumber().compareTo(res2.getTrainNumber())<0) return -1;
        else if (res1.getTrainNumber().compareTo(res2.getTrainNumber())> 0) return 1;
        else if (res1.getTypeOfTrain().compareTo(res2.getTypeOfTrain())<0) return 1; 
        else if (res1.getTypeOfTrain().compareTo(res2.getTypeOfTrain())>0) return 0;
        else return -1;       
    }   
}
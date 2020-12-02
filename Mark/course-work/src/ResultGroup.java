import java.util.*;

public class ResultGroup {
	
    private final static String GROUP_FORMAT_STRING ="Результаты соревнований: %-s, %-5d строк";
    
    private String name; 
    private List <Result> results; 
    
    public ResultGroup() {
        name=""; 
        results = new ArrayList <Result>();
    }

    public ResultGroup(String name){
        this.name=name; 
        results = new ArrayList <Result>();
    }

    public ResultGroup(String name, List list){
        this.name=name; 
        results = new ArrayList <Result>(list); 
    }

    public void setName(String name)  {this.name = name;}
    public void setResults (List <Result> results) {this.results = results;}

    public String getName(){return name;}
    
    public List <Result> getResults(){
        return results;
    }
    
    public String toString(){
        return String.format(GROUP_FORMAT_STRING,name,getResultNum());  
    }
    
    public boolean addResult(Result res){
       
        if (getResult(res)!=null) 
            return false; 
        if (results.add(res)) return true;
        else return false;
    }
   
    public boolean delResult(Result res){
        if (results.remove(res)) return true;
        else return false;
    }
    
    public boolean deleteBetween(int g1, int g2){ 
        return results.removeAll(betweenPrice(g1,g2).results);
    } 
   
    public boolean updateResultPrice(Result res){
        Result r = getResult(res);
        if (r!=null) {
            r.setWins(res.getPrice()); return true;
        }
        return false;
    }
    
    public Result getResult (Result res){
        for (Result r : results)
            if (r.equals(res)) return r; 
        return null; 
    } 

    public int getResultNum(){   
        return results.size();
    }    

    public ResultGroup filterTypeOfTrain(String filter){ 
        ResultGroup group = new ResultGroup (name+": результаты для команд на \"" + filter +"\"");
        for (Result res : results)
            if (res.getServiceClass().startsWith(filter))group.addResult(res);
        return group;
    }
   
    public int trainNumber(){
        int n=results.size();
        if (n==0) return 0;
        Set <String> trainNsumber = new TreeSet <String>();
        for (Result res:results)
        	trainNsumber.add(res.getTrainNumber()); 
        return trainNsumber.size();
    }
    
    public ResultGroup betweenPrice(int g1, int g2){
    	ResultGroup group = new ResultGroup (
    	String.format("%s: результаты, у которых число голов в диапазоне от %5d до %5d", name,g1,g2));  
    	Iterator <Result> iter=results.iterator();
    	while (iter.hasNext()){
    		Result res=iter.next(); 
    	    if ((res.getPrice()>=g1)&&(res.getPrice()<=g2)) group.addResult(res);
    	}   
    	return group;
    }

    public List <TotalRecord> totalMaxPriceOfTicket(){
    	int n = results.size();
        if (n == 0) return null;
        Set <String> commandsS = new TreeSet(); 
        for (Result res:results)
            commandsS.add(res.getServiceClass());
        List <String> commandsL= new ArrayList(commandsS);
        int m = commandsL.size(); 
        String com;
        List <TotalRecord> totRecList = new ArrayList <TotalRecord>();
        for (int i=0; i<m; i++){
        	int maxPrice = 0;
            com = commandsL.get(i);
            for (Result res: results){
                if (com.equals(res.getServiceClass()))
                	if (res.getPrice() > maxPrice || maxPrice == 0) {
                		maxPrice = res.getPrice();
                	}
            }   
            totRecList.add(new TotalRecord(com, maxPrice));		 
        }
        return totRecList; 
    }

    public ResultGroup sort(){ 
        ResultGroup group = new ResultGroup (name, results);
        Collections.sort(group.results);
        return group;
    } 

    public ResultGroup sort(Comparator comp){ 
        ResultGroup group = new ResultGroup (name, results);
        Collections.sort(group.results, comp);
        return group;
    }
} 

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class ResultTableModel extends AbstractTableModel{
    List <Result> results;
    public ResultTableModel(List <Result> results) {
        super();
        this.results = results;
    }

    @Override
    public int getRowCount() {
        return results.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
            return results.get(r).getTrainNumber();
            case 1:
            return results.get(r).getServiceClass();
            case 2:
            return results.get(r).getTypeOfTrain();
            case 3:
            return results.get(r).getPrice();
            default:
            return "";
        }
    }

    @Override
    public String getColumnName(int c) {
        String name = "";
        switch (c) {
            case 0:
            name = "Номер поезда";
            break;
            case 1:
            name = "Тип вагона";
            break;
            case 2:
            name = "Класс обслуживания";
            break;
            case 3:
            name = "Цена билета";
            break;
        }
        return name;
    }
}
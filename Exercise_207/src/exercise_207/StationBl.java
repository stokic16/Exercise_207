

package exercise_207;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

/**
 * @author Kilian Stöckler
 */
public class StationBl extends AbstractTableModel{

    private String[] names = {"Place","Sea Level","Temperature","rel. Humidity"};
    private ArrayList<WeatherStation> stations = new ArrayList<>();
    
    
    public void addStation(WeatherStation w){
        stations.add(w);
        fireTableRowsInserted(stations.size(), stations.size());
        this.sort();
    }
    
    public void removeStation(int idx){
        stations.remove(idx);
        fireTableRowsDeleted(idx, idx);
    }
    public void removeStation(int[] idx){
        for(int i=0;i<idx.length;i++){
            stations.remove(idx[i]);
            fireTableRowsDeleted(idx[i],idx[i]);
        }
    }
    
    public void sort(){
        Collections.sort(stations,new SortByName());
        fireTableRowsUpdated(0, stations.size()-1);
    }
    
    @Override
    public int getRowCount() {
        return stations.size();
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    @Override
    public String getColumnName(int column) {
        return names[column];
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return stations.get(rowIndex);
    }

}

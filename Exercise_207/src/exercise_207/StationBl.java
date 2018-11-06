package exercise_207;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

/**
 * @author Kilian Stöckler
 */
public class StationBl extends AbstractTableModel {

    private String[] names = {"Place", "Sea Level", "Temperature", "rel. Humidity"};
    private ArrayList<WeatherStation> stations = new ArrayList<>();

    public void addStation(WeatherStation w) throws Exception {
        if (w.getTemperature() >= -35 && w.getTemperature() <= 45) {
            throw new Exception("Temperature must be between -35° and +45°!");
        }
        if (w.getHumidity() >= 0 && w.getHumidity() <= 100) {
            throw new Exception("Humidity must be between 0% and 100%!");
        }
        stations.add(w);
        fireTableRowsInserted(stations.size(), stations.size());
        this.sort();
    }

    public void removeStation(int[] idx) {
        for (int i = 0; i <= idx.length - 1; i++) {
            stations.remove(idx[i]);
            fireTableRowsDeleted(idx[i], idx[i]);
        }
    }

    public void set(int idx, double t) {
        stations.get(idx).setTemperature(t);
        fireTableDataChanged();
    }

    public void set(int idx, int t) {
        stations.get(idx).setHumidity(t);
        fireTableDataChanged();
    }

    public void sort() {
        Collections.sort(stations, new SortByName());
        fireTableRowsUpdated(0, stations.size() - 1);
    }

    public void save(File f) throws Exception {
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (WeatherStation station : stations) {
            oos.writeObject(oos);
        }
        oos.flush();
        oos.close();
        fos.flush();
        fos.close();
    }
    
    public void load(File f)throws Exception{
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object input = null;
        try{
            while((input=ois.readObject())!=null){
                if(input instanceof WeatherStation){
                    stations.add((WeatherStation) input);
                }
            }
            fireTableRowsUpdated(0, stations.size()-1);
        }catch(IOException e){
            
        }
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

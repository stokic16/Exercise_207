

package exercise_207;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * @author Kilian Stöckler
 */
public class CellRenderer implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        WeatherStation station = null;
        if(value instanceof WeatherStation){
            station = (WeatherStation) value;
        }
        JLabel label = new JLabel();
        label.setOpaque(true);
        double temp = station.getTemperature();
        int hum = station.getHumidity();
        if(temp>25 && hum<20){
            label.setBackground(Color.yellow);
        }
        if(temp<0&&hum<30){
            label.setBackground(Color.blue);
        }
        if(temp>=0&&temp<=25&&hum>50){
            label.setBackground(Color.GREEN);
        }
        switch(column){
            case 0: label.setText(station.getPlace());break;
            case 1: label.setText(station.getSeaLevel()+"m");break;
            case 2: label.setText(String.format("%.2f°", station.getTemperature()));break;
            case 3: label.setText(""+station.getHumidity()+"%");break;
            default: label.setText("error");
        }
        return label;
    }

}

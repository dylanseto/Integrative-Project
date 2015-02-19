
package Main;

import javafx.scene.chart.*;

/**
 *
 * @author Ahmad El-Baher
 */
public class ChartSection extends LineChart<Number, Number>
{
    public ChartSection()
    {
        super(new NumberAxis(), new NumberAxis());
        getData().add(new XYChart.Series());
    }
    
    public void changeLabels(String chartTitle, String xAxisLabel, String yAxisLabel)
    {
        setTitle(chartTitle);
        getXAxis().setLabel(xAxisLabel);
        getYAxis().setLabel(yAxisLabel);
    }
    
    public void clearData()
    {
        getData().get(Constants.ZERO).getData().clear();
    }
    
    public void addDataPoint(double x, double y)
    {
        getData().get(Constants.ZERO).getData().add(new Data(x, y));
    }

}
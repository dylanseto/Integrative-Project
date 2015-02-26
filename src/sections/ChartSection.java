
package sections;

import Main.Constants;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseEvent;


public class ChartSection extends LineChart<Number, Number>
{
    public ChartSection()
    {
        super(new NumberAxis(), new NumberAxis());
        getData().add(new XYChart.Series());
        setCursor(Cursor.CROSSHAIR);
    }
    
    public void setLabels(String chartTitle, String xAxisLabel, String yAxisLabel)
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
    	addDataPoint(x, y, false);
    }
    public void addDataPoint(double x, double y, boolean hover)
    {
    	XYChart.Data<Number, Number> data = new Data<Number, Number>(x, y);
    	
    	if(hover)
    	{
    		data.setNode(new HoverDetector());
    	}
    	
        getData().get(Constants.ZERO).getData().add(data);
    }
    private class HoverDetector extends StackPane
    {
    	HoverDetector()
    	{	
    		setOnMouseEntered(new EventHandler<MouseEvent>() {
    	        @Override public void handle(MouseEvent mouseEvent) {
    	          System.out.println("mouse over"); //hover over
    	          setCursor(Cursor.NONE);
    	          toFront();
    	        }
    	      });
    		setOnMouseExited(new EventHandler<MouseEvent>() {
    	        @Override public void handle(MouseEvent mouseEvent) {
    	          System.out.println("mouse exit"); //hovers away
    	          setCursor(Cursor.CROSSHAIR);
    	          toFront();
    	        }
    	      });
    	}
    }

}

package sections;

import Main.Constants;
import Main.MainWindow;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class ChartSection extends LineChart<Number, Number>
{
    public ChartSection()
    {
        super(new NumberAxis(), new NumberAxis());
        this.setLegendVisible(false);
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
                //made a change to constructor of HoverDetector
    		data.setNode(new HoverDetector(x, y));
    	}
    	
        getData().get(Constants.ZERO).getData().add(data);
    }
    private class HoverDetector extends StackPane
    {
        //made a change to constructor here
    	HoverDetector(final double data_x, final double data_y)
    	{	
    		setPrefSize(15, 15);
    		setOnMouseEntered(new EventHandler<MouseEvent>() {
    	        @Override public void handle(MouseEvent mouseEvent) {
    	          //System.out.println("mouse over "); //hover over
                  
                    if(MainWindow.getUserInterface() == Constants.UserInterface.SPORTS_BIKE)
                    {
                        MainWindow.getAnimSection().drawNewBikeFrame(data_x, data_y);
                    }
                    else if(MainWindow.getUserInterface() == Constants.UserInterface.NEWTON_LAW)
                    {
                    	Label label = new Label("X: " + data_x + "s\ny: " + Constants.FORMATTER.format(data_y) + "m/s");
                    	label.setMinSize(Label.USE_PREF_SIZE*Constants.FIVE, Label.USE_PREF_SIZE*Constants.FIVE);
                    	getChildren().add(label);
                    }
                    else if(MainWindow.getUserInterface() == Constants.UserInterface.PROJ_MOTION)
                    {
                    	Label label = new Label("X: " + data_x + "s\nY: " + Constants.FORMATTER.format(data_y) + "m");
                    	label.setMinSize(Label.USE_PREF_SIZE*Constants.FIVE, Label.USE_PREF_SIZE*Constants.FIVE);
                    	getChildren().add(label);
                    }
                  
    	          setCursor(Cursor.NONE);
    	          toFront();
    	        }
    	      });
    		setOnMouseExited(new EventHandler<MouseEvent>() {
    	        @Override public void handle(MouseEvent mouseEvent) {
    	          //System.out.println("mouse exit"); //hovers away
                  
                    if(MainWindow.getUserInterface() == Constants.UserInterface.SPORTS_BIKE)
                    {
                        MainWindow.getAnimSection().drawNewBikeFrame();
                    }
                    getChildren().clear();
                  
    	          setCursor(Cursor.CROSSHAIR);
    	          toFront();
    	        }
    	      });
    	}
    }

}
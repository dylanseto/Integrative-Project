package Main;

import sections.AnimationSection;
import sections.ChartSection;
import sections.MainMenuSection;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sections.GUIControlSection;

public class MainWindow extends Application
{
	private static Constants.UserInterface userInterface;
	private static SplitPane topSplitPane;
	private static SplitPane buttomSplitPane;
        private static AnimationSection animSection;
        private static ChartSection chartSection;
	private static MainMenuSection mainMenuSection;
        private static GUIControlSection guiControlSection;
	
	public static void main(String[] args) 
	{
		launch(args); 
	}
	
	public void start(Stage primaryStage)
	{
		VBox mainWindow = new VBox();
		topSplitPane = new SplitPane();
		buttomSplitPane = new SplitPane();
		mainMenuSection = new MainMenuSection();
		userInterface = Constants.UserInterface.NO_CHOICE;
		
		topSplitPane.setOrientation(Orientation.HORIZONTAL);
		topSplitPane.setPrefSize(600, 300);
		
		buttomSplitPane.setOrientation(Orientation.HORIZONTAL);
		buttomSplitPane.setPrefSize(600, 300);

		ChartSection s = new ChartSection();
		s.setLabels("lol", "x", "y");
		s.addDataPoint(10, 100, true);
		s.addDataPoint(20, 120, true);
		s.addDataPoint(30, 110, true);
		buttomSplitPane.getItems().add(s);
		
                mainWindow.getChildren().add(topSplitPane);
		mainWindow.getChildren().add(buttomSplitPane);
		
		primaryStage.setScene(new Scene(new Group(mainWindow), 599, 590));
		primaryStage.show();
	}
	
	public static Constants.UserInterface getUserInterface()
	{
		return userInterface;
	}
	public static void setUserInterface(Constants.UserInterface ui)
	{
		userInterface = ui;
	}

	public static SplitPane getTopSplitPane() 
        {
		return topSplitPane;
	}

	public static SplitPane getButtomSplitPane() 
        {
		return buttomSplitPane;
	}
        
        public static AnimationSection getAnimSection() 
        {
		return animSection;
	}
        
        public static ChartSection getChartSection()
        {
            return chartSection;
        }

	public static MainMenuSection getMainMenuSection() 
        {
		return mainMenuSection;
	}
        
        public static GUIControlSection getGUIControlSection()
        {
            return guiControlSection;
        }
}

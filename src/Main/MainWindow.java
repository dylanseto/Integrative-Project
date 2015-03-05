package Main;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sections.AnimationSection;
import sections.ChartSection;
import sections.GUIControlSection;
import sections.MainMenuSection;
import sections.TableSection;

public class MainWindow extends Application
{
	private static Constants.UserInterface userInterface;
	private static SplitPane topSplitPane;
	private static SplitPane bottomSplitPane;
    private static AnimationSection animSection;
    private static ChartSection chartSection;
    private static TableSection tableSection;
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
		bottomSplitPane = new SplitPane();
                
                topSplitPane.setOrientation(Orientation.HORIZONTAL);
		topSplitPane.setPrefSize(600, 300);
                
                bottomSplitPane.setOrientation(Orientation.HORIZONTAL);
		bottomSplitPane.setPrefSize(600, 300);
       
		mainMenuSection = new MainMenuSection();
                animSection = new AnimationSection();
                animSection.setWidth(topSplitPane.getPrefWidth()/Constants.TWO);
                animSection.setHeight(topSplitPane.getPrefHeight()/Constants.TWO);
                tableSection = new TableSection(topSplitPane.getPrefWidth()/Constants.TWO, topSplitPane.getPrefHeight()/Constants.TWO);
                chartSection = new ChartSection();
                

                guiControlSection = new GUIControlSection();
		userInterface = Constants.UserInterface.NO_CHOICE;
                
                
                topSplitPane.getItems().add(animSection);
                topSplitPane.getItems().add(chartSection);
               
                bottomSplitPane.getItems().add(mainMenuSection);
                bottomSplitPane.getItems().add(guiControlSection);

        mainWindow.getChildren().addAll(topSplitPane, bottomSplitPane);
		
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
		return bottomSplitPane;
	}

        public static AnimationSection getAnimSection() 
        {
            return animSection;
        }

        public static ChartSection getChartSection()
        {
            return chartSection;
        }

        public static TableSection getTableSection()
        {
            return tableSection;
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

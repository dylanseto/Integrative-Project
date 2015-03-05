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

                switch(userInterface)
                {
                    case NO_CHOICE:
                        break;
                        
                    case NEWTON_LAW:
                        topSplitPane.getItems().remove(Constants.ONE);
                        topSplitPane.getItems().add(chartSection);
                        chartSection.setLabels(Constants.NEWTON_GRAPH_LABELS[Constants.GRAPH_TITLE_INDEX], 
                                               Constants.NEWTON_GRAPH_LABELS[Constants.GRAPH_Y_AXIS_INDEX], 
                                               Constants.NEWTON_GRAPH_LABELS[Constants.GRAPH_X_AXIS_INDEX]);
                        guiControlSection.showNewtonLawControls();
                        animSection.drawNewtonFrame(); //change this later
                        break;
                        
                    case PROJ_MOTION:
                        topSplitPane.getItems().remove(Constants.ONE);
                        topSplitPane.getItems().add(chartSection);
                        chartSection.setLabels(Constants.PROJ_MOT_GRAPH_LABELS[Constants.GRAPH_TITLE_INDEX], 
                                               Constants.PROJ_MOT_GRAPH_LABELS[Constants.GRAPH_Y_AXIS_INDEX], 
                                               Constants.PROJ_MOT_GRAPH_LABELS[Constants.GRAPH_X_AXIS_INDEX]);
                        guiControlSection.showProjMotControls();
                        break;
                    
                        /*
                    case OPTICS:
                        topSplitPane.getItems().remove(Constants.ONE);
                        topSplitPane.getItems().add(tableSection);
                        tableSection.setColumnLabels(Constants.IMAGE_LABEL_TEXT, STYLESHEET_MODENA, STYLESHEET_MODENA);
                        guiControlSection.showProjMotControls();
                        break;
                                */
                        //add the rest of the things here.
                }
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

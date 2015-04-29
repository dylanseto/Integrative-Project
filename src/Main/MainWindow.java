package Main;


import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
                animSection.setHeight(topSplitPane.getPrefHeight());
                tableSection = new TableSection(topSplitPane.getPrefWidth()/Constants.TWO, topSplitPane.getPrefHeight());
                chartSection = new ChartSection();
                chartSection.setVisible(false);
                tableSection.setVisible(false);

                guiControlSection = new GUIControlSection();
		userInterface = Constants.UserInterface.NO_CHOICE;
                
                
                topSplitPane.getItems().add(animSection);
                topSplitPane.getItems().add(chartSection);
                
               
                bottomSplitPane.getItems().add(mainMenuSection);
                bottomSplitPane.getItems().add(guiControlSection);

        mainWindow.getChildren().addAll(topSplitPane, bottomSplitPane);
		

                Scene scene = new Scene(new Group(mainWindow), 599, 590);
                
                Font.loadFont(this.getClass().getResourceAsStream("/res/PressStart2P.ttf"), 12);
                Font.loadFont(this.getClass().getResourceAsStream("/res/bigmacca.ttf"), 12);
               scene.getStylesheets().add(this.getClass().getResource("/res/buttonComboBoxstyle.css").toExternalForm());
              guiControlSection.getStylesheets().add(this.getClass().getResource("/res/guiControlSectionStyle.css").toExternalForm());
              tableSection.getStylesheets().add(this.getClass().getResource("/res/tableSectionStyle.css").toExternalForm());
               
		primaryStage.setScene(scene);
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
                        guiControlSection.getChildren().clear();
                        animSection.getGraphicsContext2D().clearRect(Constants.ZERO, Constants.ZERO, animSection.getWidth(), animSection.getHeight());
                        animSection.stop();
                        tableSection.clearRows();
                        if(topSplitPane.getItems().get(Constants.ONE) instanceof ChartSection)
                        {
                            chartSection.setVisible(false);
                            chartSection.clearData();
                        }
                        else
                        {
                            tableSection.setVisible(false);
                            tableSection.clearRows();
                        }
                        break;
                        
                    case NEWTON_LAW:
                    case PROJ_MOTION:
                    case SPORTS_BIKE:
                    case INF_GEOM_SERIES:
                        if(!(topSplitPane.getItems().get(Constants.ONE) instanceof ChartSection))
                        {
                           topSplitPane.getItems().remove(Constants.ONE);
                           topSplitPane.getItems().add(chartSection);
                        }
                        
                        if(!chartSection.isVisible())
                        {
                            chartSection.setVisible(true);
                        }
                        
                        switch(userInterface)
                        {
                            case NEWTON_LAW:
                                chartSection.setLabels(Constants.NEWTON_GRAPH_LABELS[Constants.GRAPH_TITLE_INDEX], 
                                               Constants.NEWTON_GRAPH_LABELS[Constants.GRAPH_X_AXIS_INDEX], 
                                               Constants.NEWTON_GRAPH_LABELS[Constants.GRAPH_Y_AXIS_INDEX]);
                                guiControlSection.showNewtonLawControls();
                                animSection.drawNewtonFrame(); 
                                break;
                            
                            case PROJ_MOTION:
                                chartSection.setLabels(Constants.PROJ_MOT_GRAPH_LABELS[Constants.GRAPH_TITLE_INDEX], 
                                               Constants.PROJ_MOT_GRAPH_LABELS[Constants.GRAPH_Y_AXIS_INDEX], 
                                               Constants.PROJ_MOT_GRAPH_LABELS[Constants.GRAPH_X_AXIS_INDEX]);
                                guiControlSection.showProjMotControls();
                                break;
                                
                            case SPORTS_BIKE:
                                chartSection.setLabels(Constants.NEW_BIKE_GRAPH_LABELS[Constants.GRAPH_TITLE_INDEX], 
                                               Constants.NEW_BIKE_GRAPH_LABELS[Constants.GRAPH_Y_AXIS_INDEX], 
                                               Constants.NEW_BIKE_GRAPH_LABELS[Constants.GRAPH_X_AXIS_INDEX]);
                                guiControlSection.showNewBikeControls();
                                break;
                                
                            case INF_GEOM_SERIES:
                                chartSection.setLabels(Constants.INF_GEOM_GRAPH_LABELS[Constants.GRAPH_TITLE_INDEX], 
                                               Constants.INF_GEOM_GRAPH_LABELS[Constants.GRAPH_Y_AXIS_INDEX], 
                                               Constants.INF_GEOM_GRAPH_LABELS[Constants.GRAPH_X_AXIS_INDEX]);
                                guiControlSection.showInfSeriesControls();
                                break;
                                
                            default:
                                break;
                        }
                        break;
                        
                    case OPTICS:
                    case THIN_FILM:
                        if(!(topSplitPane.getItems().get(Constants.ONE) instanceof TableSection))
                        {
                            topSplitPane.getItems().remove(Constants.ONE);
                            topSplitPane.getItems().add(tableSection);
                        }
                        
                        if(!tableSection.isVisible())
                        {
                            tableSection.clearRows();
                            tableSection.setVisible(true);
                        }
                        
                        switch(userInterface)
                        {
                            case OPTICS:
                                tableSection.setColumnLabels(Constants.IMAGE_LABEL_TEXT, Constants.EMPTY_STRING, Constants.EMPTY_STRING);
                                tableSection.addLeftValue(Constants.IMG_DIST_LABEL_TEXT);
                                tableSection.addLeftValue(Constants.IMG_HEIGHT_LABEL_TEXT);
                                tableSection.addLeftValue(Constants.MAGNIFICATION_LABEL_TEXT);
                                tableSection.addLeftValue(Constants.REAL_OR_VIRT_LABEL_TEXT);
                                animSection.drawOpticsFrame();
                                guiControlSection.showOpticsControls();
                                break;
                                
                            case THIN_FILM:
                                tableSection.setColumnLabels(Constants.WAVE_LENGTHS_LABEL_TEXT, Constants.ENHANCED_LABEL_TEXT, Constants.DESTROYED_LABEL_TEXT); 
                                guiControlSection.showThinFilmControls();
                                break;
                                
                            default:
                                break;
                        }
                    break;
                        
                    default:
                        break;
                }
                
                guiControlSection.setVisible(userInterface != Constants.UserInterface.NO_CHOICE);
	}

	public static SplitPane getTopSplitPane() 
        {
		return topSplitPane;
	}

	public static SplitPane getBottomSplitPane() 
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

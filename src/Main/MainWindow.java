package Main;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application
{
	private static Constants.UserInterface userInterface;
	private static SplitPane topSplitPane;
	private static SplitPane buttomSplitPane;
	private static MainMenu mainMenu;
	
	public static void main(String[] args) 
	{
		launch(args); 
	}
	
	public void start(Stage primaryStage)
	{
		VBox mainWindow = new VBox();
		topSplitPane = new SplitPane();
		buttomSplitPane = new SplitPane();
		mainMenu = new MainMenu();
		userInterface = Constants.UserInterface.NO_CHOICE;
		
		topSplitPane.setOrientation(Orientation.HORIZONTAL);
		topSplitPane.setPrefSize(600, 300);
		
		buttomSplitPane.setOrientation(Orientation.HORIZONTAL);
		buttomSplitPane.setPrefSize(600, 300);
		
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

	public static SplitPane getTopSplitPane() {
		return topSplitPane;
	}

	public static SplitPane getButtomSplitPane() {
		return buttomSplitPane;
	}

	public static MainMenu getMainMenu() {
		return mainMenu;
	}
}

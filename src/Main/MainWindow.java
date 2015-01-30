package Main;

import javafx.application.Application;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

public class MainWindow extends Application
{
	private SplitPane topSplitPane;
	private SplitPane buttomSplitPane;
	private MainMenu mainMenu;
	
	public static void main(String[] args) 
	{
		launch(args); 
	}
	
	public void start(Stage primaryStage)
	{
		topSplitPane = new SplitPane();
		buttomSplitPane = new SplitPane();
		mainMenu = new MainMenu();
	}

}

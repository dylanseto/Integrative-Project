package Main;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class MainMenu extends VBox
{
	ComboBox<String> mainOptionBox;
	
	public MainMenu() 
	{
		mainOptionBox = new ComboBox<String>();
	}

}
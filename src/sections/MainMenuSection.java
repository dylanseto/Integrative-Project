package sections;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class MainMenuSection extends VBox
{
	private ComboBox<String> mainOptionBox;
	
	public MainMenuSection() 
	{
		mainOptionBox = new ComboBox<String>();
	}

}

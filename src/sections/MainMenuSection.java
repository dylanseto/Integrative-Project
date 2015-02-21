package sections;

import Main.Constants;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author cstuser
 */
public class MainMenuSection extends VBox implements EventHandler<ActionEvent>
{
	private final ComboBox mainOptionBox;
	private final ObservableList<String> mainOptionsList;
        
        private final Button subChoiceOneButton;
        private final Button subChoiceTwoButton;
        private final Button startButton;
        private final Button pauseButton;
        private final Button resetButton;
        private final Button helpButton;
        private final Button doneButton;
        private final Button continueButton;
        
        
	public MainMenuSection() 
	{
            mainOptionsList = FXCollections.observableArrayList(Constants.OPTION_MECHANICS, Constants.OPTION_WAVES, Constants.OPTION_CALCULUS, Constants.OPTION_EXIT);
            mainOptionBox = new ComboBox(mainOptionsList);
            mainOptionBox.setOnAction(this);
            
            getChildren().add(mainOptionBox);
            //initialize all buttons, add "this" to the buttons for action event
            this.subChoiceOneButton = new Button("temp name");
            this.subChoiceTwoButton = new Button("temp name");
            this.startButton = new Button("Start");
            this.pauseButton = new Button("Pause");
            this.resetButton = new Button("Reset");
            this.helpButton = new Button("Help");
            this.doneButton = new Button("Done");
            this.continueButton = new Button("Continue");
            
	}

        public void handle(ActionEvent event) 
        {
            //add all handling here
            //For the combobox handling, show add the subchoice buttons with their appropriate texts, then remove combobox and add subchoice buttons
            //for the subChoiceOneButton and subChoiceTwoButton, change the value of the MainWindow's userInterface var
            //depending on the button's text, then remove sub choice buttons and add main menu buttons
            //when you click done, remove the main menu buttons and add combobox
            //when you click help, a JOptionPane-like message pops up and shows approproate text depending on userInterface
            
            if(event.getSource() == mainOptionBox)
            {
                //this is an example of how to handle a combo box event in our case specifically
                if(((String)(mainOptionBox.getSelectionModel().getSelectedItem())).equals(Constants.OPTION_MECHANICS))
                {
                    
                }
            }
        }
        
        private void showComboBoxMenu()
        {
            getChildren().clear();
            getChildren().add(mainOptionBox);
        }
        
        private void showSubMenu(String subChoiceOneText, String subChoiceTwoText)
        {
            getChildren().clear();
            subChoiceOneButton.setText(subChoiceOneText);
            subChoiceOneButton.setText(subChoiceTwoText);
            getChildren().add(subChoiceOneButton);
            getChildren().add(subChoiceTwoButton);
        }
        
        private void showMainMenu()
        {
            getChildren().clear();
            getChildren().add(startButton);
            getChildren().add(pauseButton);
            getChildren().add(resetButton);
            getChildren().add(helpButton);
            getChildren().add(doneButton);
            getChildren().add(continueButton);
        }


}

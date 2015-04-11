package sections;

import java.net.URISyntaxException;

import javax.print.DocFlavor.URL;

import Main.Constants;
import Main.MainWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author cstuser
 */
public class MainMenuSection extends VBox implements EventHandler<ActionEvent>
{
	private ComboBox mainOptionBox;
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

            this.subChoiceOneButton = new Button();
            this.subChoiceTwoButton = new Button();
            this.startButton = new Button(Constants.START_BUTTON);
            this.pauseButton = new Button(Constants.PAUSE_BUTTON);
            this.resetButton = new Button(Constants.RESET_BUTTON);
            this.helpButton = new Button(Constants.HELP_BUTTON);
            this.doneButton = new Button(Constants.DONE_BUTTON);
            this.continueButton = new Button(Constants.CONTINUE_BUTTON);
            
            mainOptionBox.setOnAction(this);
            subChoiceOneButton.setOnAction(this);
            subChoiceTwoButton.setOnAction(this);
            startButton.setOnAction(this);
            pauseButton.setOnAction(this);
            resetButton.setOnAction(this);
            helpButton.setOnAction(this);
            doneButton.setOnAction(this);
            continueButton.setOnAction(this);
            
            showComboBoxMenu();
            
	}

        public void handle(ActionEvent event) 
        {
            //when you click help, a JOptionPane-like message pops up and shows approproate text depending on userInterface
            
            if(event.getSource() == mainOptionBox)
            {
                if(((String)(mainOptionBox.getSelectionModel().getSelectedItem())).equalsIgnoreCase(Constants.OPTION_MECHANICS))
                {
                    showSubMenu(Constants.OPTION_NEWTON, Constants.OPTION_PROJ_MOT);
                }
                else if(((String)(mainOptionBox.getSelectionModel().getSelectedItem())).equalsIgnoreCase(Constants.OPTION_WAVES))
                {
                    showSubMenu(Constants.OPTION_OPTICS, Constants.OPTION_THIN_FILM);
                }
                else if(((String)(mainOptionBox.getSelectionModel().getSelectedItem())).equalsIgnoreCase(Constants.OPTION_CALCULUS))
                {
                    showSubMenu(Constants.OPTION_NEW_BIKE, Constants.OPTION_INF_GEOM);
                }
                else if(((String)(mainOptionBox.getSelectionModel().getSelectedItem())).equalsIgnoreCase(Constants.OPTION_EXIT))
                {
                    getChildren().add(new Label(Constants.CONFIRM_EXIT_MSG));
                    showSubMenu(Constants.OPTION_YES, Constants.OPTION_NO);
                }
                
                mainOptionBox = new ComboBox(mainOptionsList);
                mainOptionBox.setOnAction(this);
            }
            else if(event.getSource() == subChoiceOneButton)
            {
                if(subChoiceOneButton.getText().equalsIgnoreCase(Constants.OPTION_NEWTON))
                {
                    MainWindow.setUserInterface(Constants.UserInterface.NEWTON_LAW);
                    MainWindow.getAnimSection().drawNewtonFrame();
                }
                else if(subChoiceOneButton.getText().equalsIgnoreCase(Constants.OPTION_OPTICS))
                {
                    MainWindow.setUserInterface(Constants.UserInterface.OPTICS);
                }
                else if(subChoiceOneButton.getText().equalsIgnoreCase(Constants.OPTION_NEW_BIKE))
                {
                    MainWindow.setUserInterface(Constants.UserInterface.SPORTS_BIKE);
                }
                else if(subChoiceOneButton.getText().equalsIgnoreCase(Constants.OPTION_YES))
                {
                    System.exit(Constants.ZERO);
                }
                
                if(!subChoiceOneButton.getText().equalsIgnoreCase(Constants.OPTION_YES))
                {
                   showMainMenu(); 
                }
            }
            else if(event.getSource() == subChoiceTwoButton)
            {
                if(subChoiceTwoButton.getText().equalsIgnoreCase(Constants.OPTION_PROJ_MOT))
                {
                    MainWindow.setUserInterface(Constants.UserInterface.PROJ_MOTION);
                   // URL u = getClass().getResource("src/res/testCannon.png");
                    final String dir = System.getProperty("user.dir");
                    Image img = new Image("file:/" + dir + "/src/res/testCannon.png");
                    Image img2 = new Image("file:/" + dir + "/src/res/testCannonStand.png");
                    MainWindow.getAnimSection().getGraphicsContext2D().drawImage(img2, 43, 200);
                    MainWindow.getAnimSection().getGraphicsContext2D().drawImage(img, 20, 200);
                    
                    //new Image("src/res/testCannon.png");
                   
                    //final String dir = System.getProperty("user.dir");
                    System.out.println("current dir = " + dir);
                    //MainWindow.getAnimSection().getGraphicsContext2D().fillText("HIIIIII", 20, 20);
                }
                else if(subChoiceTwoButton.getText().equalsIgnoreCase(Constants.OPTION_THIN_FILM))
                {
                    MainWindow.setUserInterface(Constants.UserInterface.THIN_FILM);
                }
                else if(subChoiceTwoButton.getText().equalsIgnoreCase(Constants.OPTION_INF_GEOM))
                {
                    MainWindow.setUserInterface(Constants.UserInterface.INF_GEOM_SERIES);
                }
                else if(subChoiceTwoButton.getText().equalsIgnoreCase(Constants.OPTION_NO))
                {
                    showComboBoxMenu();
                }
                
                if(!subChoiceTwoButton.getText().equalsIgnoreCase(Constants.OPTION_NO))
                {
                   showMainMenu(); 
                }
            }
            else if(event.getSource() == startButton || event.getSource() == continueButton)
            {
                if(MainWindow.getGUIControlSection().getValues())
                {
                    MainWindow.getAnimSection().start();
                }
            }
            else if(event.getSource() == pauseButton)
            {
                MainWindow.getAnimSection().stop();
            }
            else if(event.getSource() == resetButton)
            {
                MainWindow.getAnimSection().reset();
            }
            else if(event.getSource() == helpButton)
            {
                
            }
            else if(event.getSource() == doneButton)
            {
                MainWindow.setUserInterface(Constants.UserInterface.NO_CHOICE);
                showComboBoxMenu();
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
            subChoiceTwoButton.setText(subChoiceTwoText);
            getChildren().addAll(subChoiceOneButton, subChoiceTwoButton);
        }
        
        private void showMainMenu()
        {
            getChildren().clear();
            getChildren().addAll(startButton, pauseButton, resetButton, helpButton, doneButton, continueButton);
        }


}

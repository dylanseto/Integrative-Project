package sections;

import Main.Constants;
import Main.MainWindow;
import calculations.Variables;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;

public class GUIControlSection extends VBox implements EventHandler<ActionEvent>
{
	private final Label enterValuesLabel = new Label("Enter Values---------------");
	
	private final FlowPane forceFlowPane = new FlowPane();
	private final Label forceLabel = new Label("Force (N): ");
	private final TextField forceTextField = new TextField()
	{
		public void replaceText(int start, int end, String text) 
		{
			if (text.matches("^[0-9\\.]*$")) {
	            super.replaceText(start, end, text);
	        }
		}
	};
	
	private final FlowPane massFlowPane = new FlowPane();
	private final Label massLabel = new Label("Mass (kg): ");
	private final TextField massTextField = new TextField(){
		public void replaceText(int start, int end, String text) 
		{
			if (text.matches("^[0-9\\.]*$")) {
	            super.replaceText(start, end, text);
	        }
		}
	};
	
	private final FlowPane initVelFLowPane = new FlowPane();
	private final Label initVelLabel = new Label("Initial Velocity: ");
	private final TextField initVelTextField = new TextField(){
		public void replaceText(int start, int end, String text) 
		{
			if (text.matches("^[0-9\\.]*$")) {
	            super.replaceText(start, end, text);
	        }
		}
	};
	
	private final FlowPane projectileFlowPane = new FlowPane();
	private final ObservableList<String> projectileList = Constants.PROJECTILE_TYPE_LIST;
	private final ComboBox<String> projectileOptionBox = new ComboBox<String>(projectileList);

    
	private final FlowPane gravityFlowPane = new FlowPane();
	private final ObservableList<String> GravityList = Constants.GRAVITY_TYPE_LIST;
	private final ComboBox<String> gravityOptionBox = new ComboBox<String>(GravityList);
	
	private final FlowPane angleFLowPane = new FlowPane();
	private final Label angleLabel = new Label("Angle: ");
	private final TextField angleTextField = new TextField(){
		public void replaceText(int start, int end, String text) 
		{
			if (text.matches("^[0-9\\.]*$")) {
	            super.replaceText(start, end, text);
	        }
		}
	};
	
	private final FlowPane objectHeightFLowPane = new FlowPane();
	private final Label objectHeightLabel = new Label("Object Height: ");
	private final TextField objectHeightTextField = new TextField(){
		public void replaceText(int start, int end, String text) 
		{
			if (text.matches("^[0-9\\.]*$")) {
	            super.replaceText(start, end, text);
	        }
		}
	};
	
	private final FlowPane objectDistanceFLowPane = new FlowPane();
	private final Label objectDistanceLabel = new Label("Object Distance: ");
	private final TextField objectDistanceTextField = new TextField();
	
	private final FlowPane focalDistFLowPane = new FlowPane();
	private final Label focalDistLabel = new Label("Focal Length: ");
	private final TextField focalDistTextField = new TextField(){
		public void replaceText(int start, int end, String text) 
		{
			if (text.matches("^[0-9\\.]*$")) {
	            super.replaceText(start, end, text);
	        }
		}
	};
	
	private final FlowPane materialFlowPane = new FlowPane();
	private final ObservableList<String> materialList = Constants.MATERIAL_TYPE_LIST;
	private final ComboBox<String> materialOptionBox = new ComboBox<String>(materialList);
	
	private final Label indexRefMatLabel = new Label(Constants.INDEX_REF_MAT_LABEL_TEXT);
	
	private final FlowPane thicknessFLowPane = new FlowPane();
	private final Label thicknessLabel = new Label("Thickness: ");
	private final TextField thicknessTextField = new TextField(){
		public void replaceText(int start, int end, String text) 
		{
			if (text.matches("^[0-9\\.]*$")) {
	            super.replaceText(start, end, text);
	        }
		}
	};
	
	private final FlowPane costBikeFLowPane = new FlowPane();
	private final Label costBikeLabel = new Label("Bike Cost: ");
	private final TextField costBikeTextField = new TextField(){
		public void replaceText(int start, int end, String text) 
		{
			if (text.matches("^[0-9\\.]*$")) {
	            super.replaceText(start, end, text);
	        }
		}
	};
	
	private final FlowPane costSetUpFLowPane = new FlowPane();
	private final Label costSetUpLabel = new Label("Setup Cost: ");
	private final TextField costSetUpTextField = new TextField(){
		public void replaceText(int start, int end, String text) 
		{
			if (text.matches("^[0-9\\.]*$")) {
	            super.replaceText(start, end, text);
	        }
		}
	};
	
	private final FlowPane indexRefFilmFLowPane = new FlowPane();
	private final Label indexRefFilmLabel = new Label("Index Of Refraction Of Film: ");
	private final TextField indexRefFilmTextField = new TextField(){
		public void replaceText(int start, int end, String text) 
		{
			if (text.matches("^[0-9\\.]*$")) {
	            super.replaceText(start, end, text);
	        }
		}
	};
	
	private final FlowPane lenslFlowPane = new FlowPane();
	private final ObservableList<String> lensList = Constants.LENS_TYPE_LIST;
	private final ComboBox<String> lensOptionBox = new ComboBox<String>(lensList);
	private final Label lensLabel = new Label("Lens Type: ");
	
	private final FlowPane coffiecientFLowPane = new FlowPane();
	private final Label coefficientLabel = new Label("Coefficient: ");
	private final TextField coefficientTextField = new TextField(){
		public void replaceText(int start, int end, String text) 
		{
			if (text.matches("^[0-9\\.]*$")) {
	            super.replaceText(start, end, text);
	        }
		}
	};
	
	private final FlowPane baseFLowPane = new FlowPane();
	private final Label baseLabel = new Label("Base: ");
	private final TextField baseTextField = new TextField(){
		public void replaceText(int start, int end, String text) 
		{
			if (text.matches("^[0-9\\.]*$")) {
	            super.replaceText(start, end, text);
	        }
		}
	};
	
	private final FlowPane exponentFLowPane = new FlowPane();
	private final Label exponentLabel = new Label("Exponent: ");
	private final TextField exponentTextField = new TextField(){
		public void replaceText(int start, int end, String text) 
		{
			if (text.matches("^[0-9\\.]*$")) {
	            super.replaceText(start, end, text);
	        }
		}
	};
	
	private final Label infSumEquationLabel = new Label();
	private final Label partSumEquationLabel = new Label();
	
	/**
         * Constructor
         */
	public GUIControlSection()
	{
		this.massFlowPane.getChildren().addAll(massLabel, massTextField);
		this.forceFlowPane.getChildren().addAll(forceLabel, forceTextField);
		
		this.projectileFlowPane.getChildren().add(projectileOptionBox);
		this.gravityFlowPane.getChildren().add(gravityOptionBox);
		this.angleFLowPane.getChildren().addAll(angleLabel, angleTextField);
		this.initVelFLowPane.getChildren().addAll(initVelLabel, initVelTextField);
		
		this.objectHeightFLowPane.getChildren().addAll(objectHeightLabel, objectHeightTextField);
		this.objectDistanceFLowPane.getChildren().addAll(objectDistanceLabel, objectDistanceTextField);
		this.focalDistFLowPane.getChildren().addAll(focalDistLabel, focalDistTextField);
		this.lenslFlowPane.getChildren().addAll(lensLabel, lensOptionBox);
		
		this.materialFlowPane.getChildren().add(materialOptionBox);
		this.thicknessFLowPane.getChildren().addAll(thicknessLabel, thicknessTextField);
		this.indexRefFilmFLowPane.getChildren().addAll(indexRefFilmLabel, indexRefFilmTextField);
		
		this.costBikeFLowPane.getChildren().addAll(costBikeLabel, costBikeTextField);
		this.costSetUpFLowPane.getChildren().addAll(costSetUpLabel, costSetUpTextField);
		
		this.coffiecientFLowPane.getChildren().addAll(coefficientLabel, coefficientTextField);
		this.baseFLowPane.getChildren().addAll(baseLabel, baseTextField);
		this.exponentFLowPane.getChildren().addAll(exponentLabel, exponentTextField);
                
                massTextField.setOnAction(this);
                forceTextField.setOnAction(this);
                
                projectileOptionBox.setOnAction(this);
                gravityOptionBox.setOnAction(this);
                angleTextField.setOnAction(this);
                initVelTextField.setOnAction(this);
                
                objectHeightTextField.setOnAction(this);
                objectDistanceTextField.setOnAction(this);
                focalDistTextField.setOnAction(this);
                lensOptionBox.setOnAction(this);
                
                materialOptionBox.setOnAction(this);
                thicknessTextField.setOnAction(this);
		indexRefFilmTextField.setOnAction(this);
                
                costBikeTextField.setOnAction(this);
                costSetUpTextField.setOnAction(this);
                
                coefficientTextField.setOnAction(this);
                baseTextField.setOnAction(this);
                exponentTextField.setOnAction(this);
                
	}
	public void showNewtonLawControls()
	{
		this.getChildren().clear();
		this.getChildren().addAll(enterValuesLabel, massFlowPane, forceFlowPane);
		
	}
	
	public void showProjMotControls()
	{
		this.getChildren().clear();
		this.getChildren().addAll(enterValuesLabel, projectileFlowPane, gravityFlowPane, angleFLowPane, initVelFLowPane);
	}
	
	public void showOpticsControls()
	{
		this.getChildren().clear();
		this.getChildren().addAll(enterValuesLabel, objectHeightFLowPane, objectDistanceFLowPane, focalDistFLowPane, lenslFlowPane);
	}
	
	public void showThinFilmControls()
	{
		this.getChildren().clear();
		this.getChildren().addAll(enterValuesLabel, materialFlowPane, indexRefMatLabel, thicknessFLowPane, indexRefFilmFLowPane);
	}
	
	public void showNewBikeControls()
	{
		this.getChildren().clear();
		this.getChildren().addAll(enterValuesLabel, costBikeFLowPane, costSetUpFLowPane);
	}
	
	public void showInfSeriesControls()
	{
		this.getChildren().clear();
		this.getChildren().addAll(enterValuesLabel, coffiecientFLowPane,baseFLowPane,exponentFLowPane,infSumEquationLabel,partSumEquationLabel);
	}
        
        public boolean getValues()
        {
            boolean disableSection = true;
            switch(MainWindow.getUserInterface())
            {
                
                case NEWTON_LAW:
                    if(massTextField.getText().isEmpty()
                            || forceTextField.getText().isEmpty())
                    {
                        disableSection = false;
                    }
                    Variables.setMass(Double.valueOf(massTextField.getText()));
                    Variables.setForce(Double.valueOf(forceTextField.getText()));
                    break;
                    
                case PROJ_MOTION:
                	/*if(massTextField.getText().isEmpty()
                            || forceTextField.getText().isEmpty())
                    {
                        disableSection = false;
                    }*/
                	//Variables.
                	break;
                    
                case OPTICS:
                    if(((String)(lensOptionBox.getSelectionModel().getSelectedItem())) == null
                            || objectHeightTextField.getText().isEmpty()
                            || objectDistanceTextField.getText().isEmpty()
                            || focalDistTextField.getText().isEmpty())
                    {
                        disableSection = false;
                    }
                    Variables.setLensType(((String)(lensOptionBox.getSelectionModel().getSelectedItem())));
                    Variables.setObjHeight(Double.valueOf(objectHeightTextField.getText()));
                    Variables.setObjDistance(Double.valueOf(objectDistanceTextField.getText()));
                    Variables.setFocalPoint(((Variables.getLensType().equalsIgnoreCase("diverging"))
                                            ? -Double.valueOf(focalDistTextField.getText())
                                            : Double.valueOf(focalDistTextField.getText())));
                    MainWindow.getAnimSection().drawOpticsFrame();
                    break;
                    
                case THIN_FILM:
                    if(((String)(materialOptionBox.getSelectionModel().getSelectedItem())) == null
                            || thicknessTextField.getText().isEmpty()
                            || indexRefFilmTextField.getText().isEmpty())
                    {
                        disableSection = false;
                    }
                    Variables.setThickness(Double.valueOf(thicknessTextField.getText()));
                    Variables.setIndexRefFilm(Double.valueOf(indexRefFilmTextField.getText()));
                    MainWindow.getAnimSection().drawThinFlimFrame();
                    break;
                    
                case SPORTS_BIKE:
                    if(costBikeTextField.getText().isEmpty()
                            || costSetUpTextField.getText().isEmpty())
                    {
                        disableSection = false;
                    }
                    MainWindow.getChartSection().clearData();
                    Variables.setCostMake(Double.valueOf(costBikeTextField.getText()));
                    Variables.setCostSetUp(Double.valueOf(costSetUpTextField.getText()));
                    break;
                    
                default:
                    disableSection = false;
                    break;
            }
            setDisable(disableSection);
            return disableSection;
        }

	@Override
	public void handle(ActionEvent event) 
	{

            //handling each individual component
            if(event.getSource() == materialOptionBox)
            {
                Variables.setMaterialType(((String)(materialOptionBox.getSelectionModel().getSelectedItem())));
                MainWindow.getAnimSection().drawThinFlimFrame();
                if(Variables.getMaterialType().equalsIgnoreCase("water"))
                {
                    indexRefMatLabel.setText(Constants.INDEX_REF_MAT_LABEL_TEXT + Constants.INDEX_REF_WATER);
                    Variables.setIndexRefMaterial(Constants.INDEX_REF_WATER);
                }
                else if(Variables.getMaterialType().equalsIgnoreCase("glycerin"))
                {
                    indexRefMatLabel.setText(Constants.INDEX_REF_MAT_LABEL_TEXT + Constants.INDEX_REF_GLYCERIN);
                    Variables.setIndexRefMaterial(Constants.INDEX_REF_GLYCERIN);
                }
                else if(Variables.getMaterialType().equalsIgnoreCase("oil"))
                {
                    indexRefMatLabel.setText(Constants.INDEX_REF_MAT_LABEL_TEXT + Constants.INDEX_REF_OIL);
                    Variables.setIndexRefMaterial(Constants.INDEX_REF_OIL);
                }
                else if(Variables.getMaterialType().equalsIgnoreCase("zircon"))
                {
                    indexRefMatLabel.setText(Constants.INDEX_REF_MAT_LABEL_TEXT + Constants.INDEX_REF_ZIRCON);
                    Variables.setIndexRefMaterial(Constants.INDEX_REF_ZIRCON);
                }
                else if(Variables.getMaterialType().equalsIgnoreCase("diamond"))
                {
                    indexRefMatLabel.setText(Constants.INDEX_REF_MAT_LABEL_TEXT + Constants.INDEX_REF_DIAMOND);
                    Variables.setIndexRefMaterial(Constants.INDEX_REF_DIAMOND);
                }
                else if(Variables.getMaterialType().equalsIgnoreCase("pyrex"))
                {
                    indexRefMatLabel.setText(Constants.INDEX_REF_MAT_LABEL_TEXT + Constants.INDEX_REF_PYREX);
                    Variables.setIndexRefMaterial(Constants.INDEX_REF_PYREX);
                }

            }
            else if(event.getSource() == thicknessTextField)//note: user has to press enter to make this work
            {
                Variables.setThickness(Double.valueOf(thicknessTextField.getText()));
            }
            else if(event.getSource() == indexRefFilmTextField)
            {
                Variables.setIndexRefFilm(Double.valueOf(indexRefFilmTextField.getText()));
            }
            else if(event.getSource() == this.forceTextField)
            {
            	Variables.setForce(Double.valueOf(forceTextField.getText()));
            }
            else if(event.getSource() == this.massTextField)
            {
            	Variables.setMass(Double.valueOf(massTextField.getText()));
            }
            else if(event.getSource() == objectHeightTextField)
            {
                Variables.setObjHeight(Double.valueOf(objectHeightTextField.getText()));
            }
            else if(event.getSource() == objectDistanceTextField)
            {
                Variables.setObjDistance(Double.valueOf(objectDistanceTextField.getText()));
            }
            else if(event.getSource() == focalDistTextField)
            {
                Variables.setFocalPoint(Double.valueOf(focalDistTextField.getText()));
            }
            else if(event.getSource() == lensOptionBox)
            {
                Variables.setLensType(((String)(lensOptionBox.getSelectionModel().getSelectedItem())));
                //MainWindow.getAnimSection().drawOpticsFrame();
            }
            else if(event.getSource() == costBikeTextField)
            {
                Variables.setCostMake(Double.valueOf(costBikeTextField.getText()));
            }
            else if(event.getSource() == costSetUpTextField)
            {
                Variables.setCostSetUp(Double.valueOf(costSetUpTextField.getText()));
            }
            else if(event.getSource() == angleTextField)
            {
            	Variables.setAngle(Double.valueOf(angleTextField.getText()));
            	
            	MainWindow.getAnimSection().getGraphicsContext2D().clearRect(0, 0, 1000, 1000);
            	final String dir = System.getProperty("user.dir");
                Image img = new Image("file:/" + dir + "/src/res/Cannon.png");
                Image img2 = new Image("file:/" + dir + "/src/res/CannonStand2.png");
                
                
                MainWindow.getAnimSection().getGraphicsContext2D().save();
                Rotate r = new Rotate(-Variables.getAngle(), 11 + img.getWidth() / 2, 200 + img.getHeight() / 2);
                MainWindow.getAnimSection().getGraphicsContext2D().setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
                MainWindow.getAnimSection().getGraphicsContext2D().drawImage(img, 11, 200);
                MainWindow.getAnimSection().getGraphicsContext2D().restore();
                
                MainWindow.getAnimSection().getGraphicsContext2D().drawImage(img2, 10, 200);
            }
	}
}

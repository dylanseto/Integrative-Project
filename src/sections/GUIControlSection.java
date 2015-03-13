package sections;

import Main.Constants;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

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
	
	private final Label indexRefMatLabel = new Label("Index Of Refraction Of Material: ");
	
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
	private final Label coffiecientLabel = new Label("Coefficient: ");
	private final TextField coffiecientTextField = new TextField(){
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
	
	/*
	 * COnstructor
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
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
		
		this.coffiecientFLowPane.getChildren().addAll(coffiecientLabel, coffiecientTextField);
		this.baseFLowPane.getChildren().addAll(baseLabel, baseTextField);
		this.exponentFLowPane.getChildren().addAll(exponentLabel, exponentTextField);
		
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
		this.getChildren().addAll(materialFlowPane, indexRefMatLabel, thicknessFLowPane, indexRefFilmFLowPane);
	}
	
	public void showNewBikeControls()
	{
		this.getChildren().clear();
		this.getChildren().addAll(costBikeFLowPane, costSetUpFLowPane);
	}
	
	public void showInfSeriesControls()
	{
		this.getChildren().clear();
		this.getChildren().addAll(coffiecientFLowPane,baseFLowPane,exponentFLowPane,infSumEquationLabel,partSumEquationLabel);
	}

	@Override
	public void handle(ActionEvent arg0) 
	{	
	}
}

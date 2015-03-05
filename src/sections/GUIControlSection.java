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
	private final Label enterValuesLabel = new Label("Enter Value:");
	
	private final FlowPane forceFlowPane = new FlowPane();
	private final Label forceLabel = new Label("Force (N): ");
	private final TextField forceTextField = new TextField();
	
	private final FlowPane massFlowPane = new FlowPane();
	private final Label massLabel = new Label("Mass (kg): ");
	private final TextField massTextField = new TextField();
	
	private final FlowPane initVelFLowPane = new FlowPane();
	private final Label initVelLabel = new Label("Initial Velocity: ");
	private final TextField initVelTextField = new TextField();
	
	private final FlowPane projectileFlowPane = new FlowPane();
	private final ObservableList<String> projectileList = Constants.PROJECTILE_TYPE_LIST;
	private final ComboBox<String> projectileOptionBox = new ComboBox(projectileList);

    
	private final FlowPane gravityFlowPane = new FlowPane();
	private final ObservableList<String> GravityList = Constants.GRAVITY_TYPE_LIST;
	private final ComboBox<String> gravityOptionBox = new ComboBox(GravityList);
	
	private final FlowPane angleFLowPane = new FlowPane();
	private final Label angleLabel = new Label("Angle: ");
	private final TextField angleTextField = new TextField();
	
	private final FlowPane objectHeightFLowPane = new FlowPane();
	private final Label objectHeightLabel = new Label("Object Height: ");
	private final TextField objectHeightTextField = new TextField();
	
	private final FlowPane objectDistanceFLowPane = new FlowPane();
	private final Label objectDistanceLabel = new Label("Object Distance: ");
	private final TextField objectDistanceTextField = new TextField();
	
	private final FlowPane focalDistFLowPane = new FlowPane();
	private final Label focalDistLabel = new Label("Focal Length: ");
	private final TextField focalDistTextField = new TextField();
	
	private final FlowPane materialFlowPane = new FlowPane();
	private final ComboBox materialOptionBox = new ComboBox();
	//private final ObservableList<String> materialList = new ObservableList<String>();
	
	private final Label indexRefMatLabel = new Label();
	
	private final FlowPane thicknessFLowPane = new FlowPane();
	private final Label thicknessLabel = new Label("Thickness: ");
	private final TextField thicknessTextField = new TextField();
	
	private final FlowPane costBikeFLowPane = new FlowPane();
	private final Label costBikeLabel = new Label("Bike Cost: ");
	private final TextField costBikeTextField = new TextField();
	
	private final FlowPane costSetUpFLowPane = new FlowPane();
	private final Label costSetUpLabel = new Label("Setup Cost: ");
	private final TextField costSetUpTextField = new TextField();
	
	private final FlowPane indexRefFilmFLowPane = new FlowPane();
	private final Label indexRefFilmLabel = new Label("Index Of Refraction: ");
	private final TextField indexRefFilmTextField = new TextField();
	
	private final FlowPane lenslFlowPane = new FlowPane();
	private final ComboBox lensOptionBox = new ComboBox();
	private final Label lensLabel = new Label("Lens Type: ");
	//private final ObservableList<String> lensList = new ObservableList<String>();
	
	private final FlowPane coffiecientFLowPane = new FlowPane();
	private final Label coffiecientLabel = new Label("Coefficient: ");
	private final TextField coffiecientTextField = new TextField();
	
	private final FlowPane baseFLowPane = new FlowPane();
	private final Label baseLabel = new Label("Base: ");
	private final TextField baseTextField = new TextField();
	
	private final FlowPane exponentFLowPane = new FlowPane();
	private final Label exponentLabel = new Label("Exponent: ");
	private final TextField exponentTextField = new TextField();
	
	private final Label infSumEquationLabel = new Label();
	private final Label partSumEquationLabel = new Label();
	
	public GUIControlSection()
	{
		
	}
	
	public void showNewtonLawControls()
	{
		massFlowPane.getChildren().addAll(massLabel, massTextField);
		forceFlowPane.getChildren().addAll(forceLabel, forceTextField);
		this.getChildren().addAll(massFlowPane, forceFlowPane);
		
	}
	
	public void showProjMotControls()
	{
		this.projectileFlowPane.getChildren().add(projectileOptionBox);
		this.gravityFlowPane.getChildren().add(gravityOptionBox);
		this.getChildren().addAll(projectileFlowPane, gravityFlowPane);
	}
	
	public void showOpticsControls()
	{
		
	}
	
	public void showThinLensControls()
	{
		
	}
	
	public void showNewBikeControls()
	{
		
	}
	
	public void showInfSeriesControls()
	{
		
	}

	@Override
	public void handle(ActionEvent arg0) {
		
	}
}

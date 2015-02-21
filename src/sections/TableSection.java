

package sections;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class TableSection extends TableView
{
    private final TableColumn colTitle;
    private final TableColumn colRightValue;
    private final TableColumn colLeftValue;
    
    private final ObservableList<TableEntry> dataList = FXCollections.observableArrayList();
      
    public TableSection()
    {
        this("", "", ""); //GOTTA MAKE THESE CONSTANTS!!
    }
    public TableSection(String titleLabel, String rightValueLabel, String leftValueLabel)
    {
        setPrefSize(302, 300); //GOTTA MAKE THESE CONSTANTS!!
        colTitle = new TableColumn();
        colTitle.setPrefWidth(300);
        
        colRightValue = new TableColumn();
        colRightValue.setPrefWidth(150); //GOTTA MAKE THESE CONSTANTS!!
        colRightValue.setCellValueFactory(
              new PropertyValueFactory<TableEntry,String>("rightValue"));
        
        colLeftValue = new TableColumn();
        colLeftValue.setPrefWidth(150); //GOTTA MAKE THESE CONSTANTS!!
        colLeftValue.setCellValueFactory(
                new PropertyValueFactory<TableEntry,String>("leftValue"));

        setColumnLabels(titleLabel, rightValueLabel, leftValueLabel);
        setItems(dataList);
        colTitle.getColumns().addAll(colRightValue, colLeftValue);
        getColumns().add(colTitle);

    }

    public void setColumnLabels(String titleLabel, String rightValueLabel, String leftValueLabel)
    {
        colTitle.setText(titleLabel);
        colRightValue.setText(rightValueLabel);
        colLeftValue.setText(leftValueLabel);
    }
    
    public void clearRows()
    {
        dataList.clear();
    }
    
    public void addRow(double rightValue, double leftValue)
    {
        addRow(String.valueOf(rightValue), String.valueOf(leftValue));
    }
    
    public void addRow(String rightValue, String leftValue)
    {
        dataList.add(new TableEntry(rightValue, leftValue));
    }
    
    public void addRightValue(String rightValue)
    {
        dataList.add(new TableEntry(rightValue));
    }
    
    public void setLeftValue(int index, double leftValue)
    {
        setLeftValue(index, String.valueOf(leftValue));
    }
    
    public void setLeftValue(int index, String leftValue)
    {
        if(index >= 0 && index < dataList.size())//GOTTA MAKE THESE CONSTANTS!!
        {
            dataList.get(index).setLeftValue(leftValue);
        }
    }
    
    protected class TableEntry
    {
          private final SimpleStringProperty rightValue;
          private final SimpleStringProperty leftValue;

          TableEntry(String rightValue)
          {
              this(rightValue, null);
          }
          
          TableEntry(String rightValue, String leftValue)
          {
              this.rightValue = new SimpleStringProperty(rightValue);
              this.leftValue  = new SimpleStringProperty(leftValue);
          }

          public String getRightValue() 
          {
              return rightValue.get();
          }

          public String getLeftValue() 
          {
              return leftValue.get();
          }
          
          public void setRightValue(String strRightValue)
          {
              rightValue.set(strRightValue);
          }
          
          public void setLeftValue(String strLeftValue)
          {
              leftValue.set(strLeftValue);
          }
    }
}


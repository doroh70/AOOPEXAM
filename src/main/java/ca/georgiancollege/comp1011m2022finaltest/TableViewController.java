package ca.georgiancollege.comp1011m2022finaltest;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {
    @FXML
    private Label saleLabel;

    @FXML
    private Label msrpLabel;

    @FXML
    private Label savingsLabel;

    @FXML
    private Label rowsInTableLabel;

    @FXML
    private TableView<Customer> tableView;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> firstNameColumn;

    @FXML
    private TableColumn<Customer, String> lastNameColumn;

    @FXML
    private TableColumn<Customer, String> phoneColumn;

    @FXML
    private TableColumn<Customer, String> totalPurchaseColumn;

    @FXML
    private ListView<Product> purchaseListView;

    @FXML
    private ImageView imageView;

    @FXML
    private void top10Customers()
    {
        System.out.println("called method top10Customers()");
    }

    @FXML
    private void customersSavedOver5()
    {
        System.out.println("called method customersSavedOver5()");
    }

    @FXML
    private void loadAllCustomers()
    {
        System.out.println("called method loadAllCustomers");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        APIManager instance = APIManager.Instance();
        ArrayList<Customer> customers = instance.parseJsonFile();

        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        totalPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("TotalPurchases"));

        //add your data to the table here.
        tableView.getItems().addAll(customers);
        rowsInTableLabel.setText("Rows in Table: "+tableView.getItems().size());

        /**Adding Listener to tableView Object*/
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldMovieSelected, newMovieSelected) ->{
            Customer selected = newMovieSelected;
            purchaseListView.getItems().clear();
            purchaseListView.getItems().addAll(selected.getProducts());
            //System.out.println(selected.getProducts());

            /*Add labels that display the sum of the regular prices (msrpLabel) for all purchases, the sum of the sale
            prices (saleLabel) and the total savings for that customer (savingsLabel).
                    The savings should be calculated by subtracting the total sale price from the total regular price.*/

            msrpLabel.setText(String.format("Sum of Regular Price is: $%.2f", getSumOfRegularPrice(newMovieSelected.getProducts())));
            saleLabel.setText(String.format("Sum of Sale Price is: $%.2f", getSumOfSalePrice(newMovieSelected.getProducts())));
            savingsLabel.setText(String.format("Total Savings for Customer is: $%.2f", getSumOfRegularPrice(newMovieSelected.getProducts()) - getSumOfSalePrice(newMovieSelected.getProducts())));
        });

    }

    public double getSumOfRegularPrice(Product[] products){
        double sum = 0;
        for(Product p: products){
            sum +=p.getRegularPrice();
        }
        return sum;
    }

    public double getSumOfSalePrice(Product[] products){
        double sum = 0;
        for(Product p: products){
            sum +=p.getSalePrice();
        }
        return sum;
    }
}

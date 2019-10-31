package finalproject;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleGroup;



public class FXMLDocumentController {

    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private TextField subtotaldisplay;
    
     @FXML
    private RadioButton radio_white;

    @FXML
    private RadioButton radio_wheat;

    @FXML
    private CheckBox check_cheese;

    @FXML
    private CheckBox check_butter;

    @FXML
    private CheckBox check_blue;

    @FXML
    private CheckBox check_ras;

    @FXML
    private CheckBox check_peach;

    @FXML
    private RadioButton radio_none;

    @FXML
    private RadioButton radio_coff;

    @FXML
    private RadioButton radio_cappu;

    @FXML
    private RadioButton radio_cafe;

    
    @FXML
    private TextField totaldisplay;

    @FXML
    private TextField taxdisplay;
    double nbagel = 0;
    double ntopping;
    double ncoffee;
    double total_price = 0;
    double subtotal = 0;
    double tax = 0;
    double white_bagel = 0;
    double wheat_bagel = 0;
    double coffee = 1.25;
    double cappu = 2.25;
    double cafe_au = 1.50;
    String Coffee = "";
    String topping ="";
    String Bagel = "";

    @FXML
    void Print_File(ActionEvent event) throws IOException {
        
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
              new FileOutputStream("filename.txt"), "utf-8"))) {
            
                writer.write("..........SHERIDAN BAGEL STORE...........");
                writer.newLine();
                
                writer.write("   ITEM                       AMOUNT");
                writer.newLine();
                writer.write("   "+Bagel+"                  "+nbagel);                
                if(radio_coff.isSelected()| radio_cafe.isSelected() | radio_cappu.isSelected() ){
                writer.newLine();    
                writer.write("   "+Coffee+"           "+ncoffee);
                }
                writer.newLine();
                writer.write("  "+topping+"             "+ntopping);
                writer.newLine();
                writer.write("   "+"Subtotal"+"                     "+subtotal);
                writer.newLine();
                writer.write("   "+"Tax"+"                          "+tax);
                writer.newLine();
                writer.write("   "+"Total"+"                        "+total_price);
    }
    }
    @FXML
    void Print_Receipt(ActionEvent event) {

    }

    @FXML
    void blueberrycheck(ActionEvent event) {
        ntopping += 0.75;
       subtotal += 0.75;
       topping += " Blueberry";

    }

    @FXML
    void buttercheck(ActionEvent event) {
        ntopping += 0.25;
        subtotal += 0.25;
        topping += " Butter";
        
    }

    @FXML
    void calculatetotalbtn(ActionEvent event) {
        String subdisplay =  Double.toString(subtotal); 
        subtotaldisplay.setText("$"+subdisplay);
        tax = subtotal * 0.013; 
        total_price  = subtotal + tax;
        String taxe = Double.toString(tax); 
        String totdisplay = Double.toString(total_price); 
        totaldisplay.setText("$"+totdisplay);
        taxdisplay.setText("$"+taxe);
        
    }

    @FXML
    void checkras(ActionEvent event) {
        ntopping += 0.75;
        subtotal += 0.75;
        topping += " Rasberry";
    }

    @FXML
    void cheesecheck(ActionEvent event) {
        ntopping += 0.50;
        subtotal += 0.50;
        topping += " Cheese";
    }

    @FXML
    void exitbutton(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void peachcheck(ActionEvent event) {
        ntopping += 0.75;
        subtotal += 0.75;
        topping += " Peach";

    }

    @FXML
    void radioCappucino(ActionEvent event) {
        ncoffee += 2.25;
        subtotal += 2.25;
        Coffee += "Cappucino";

    }

    @FXML
    void radiocafeau(ActionEvent event) {
        ncoffee += 1.50;
        subtotal += 1.50;
        Coffee += "Cafe au Lait";

    }

    @FXML
    void radiocoffee(ActionEvent event) {
        ncoffee += 1.00;
        subtotal += 1.25;
        Coffee += "Regular Coffee     ";
    }

    @FXML
    void radiowhite(ActionEvent event) {
        nbagel += 1.25;
        subtotal += 1.25;
        Bagel += "White Bagel";
        if(radio_white.isSelected() | radio_wheat.isSelected()){
            radio_cafe.setDisable(false);
        }
        else{
            radio_cafe.setDisable(false);
            radio_coff.setDisable(false);
            radio_cappu.setDisable(false);
            
        }
        
        

    }

    @FXML
    void radiowholewheat(ActionEvent event) {
        nbagel += 1.50;
        subtotal += 1.50;
        Bagel += "Wheat Bagel";    
    }

    @FXML
    void resetbtn(ActionEvent event) {
        if(radio_cafe.isSelected() | radio_cappu.isSelected() | radio_coff.isSelected() 
                | radio_none.isSelected() | radio_cafe.isSelected() | radio_wheat.isSelected() 
                | radio_white.isSelected() | check_blue.isSelected() )
        {
            ToggleGroup radioGroup = new ToggleGroup();
            ToggleGroup coffeeGroup = new ToggleGroup();
            
            radio_cafe.setToggleGroup(coffeeGroup);
            radio_cappu.setToggleGroup(coffeeGroup);
            radio_coff.setToggleGroup(coffeeGroup);
            
            radio_none.setToggleGroup(radioGroup);
            radio_cafe.setToggleGroup(radioGroup);
            radio_wheat.setToggleGroup(radioGroup);
            radio_none.setToggleGroup(radioGroup);
            radio_white.setToggleGroup(radioGroup);
            
            check_blue.setSelected(false);
            check_butter.setSelected(false);
            check_cheese.setSelected(false);
            check_peach.setSelected(false);
            check_ras.setSelected(false);
            
            radioGroup.selectToggle(null);
            coffeeGroup.selectToggle(null);
            
            subtotaldisplay.setText(" ");
            taxdisplay.setText(" ");
            totaldisplay.setText(" ");
            


        }
        
        
    }
    
    
    

    

}

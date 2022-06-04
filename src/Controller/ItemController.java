package Controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.Fruit;
import sample.Main;
import sample.MyListerner;

import java.awt.event.ActionEvent;

public class ItemController {

    @FXML
    private ImageView img;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;
    @FXML
    private void  click(MouseEvent mouseEvent){
        myListerner.onClickListerner(fruit);
    }
    private Fruit fruit;
    private MyListerner myListerner;


    public  void setData(Fruit fruit,MyListerner myListerner){
        this.fruit=fruit;
        this.myListerner=myListerner;
        nameLabel.setText(fruit.getName());
        priceLabel.setText(Main.CURRENCY+fruit.getPrice());
        Image image=new Image(getClass().getResourceAsStream(fruit.getImgscr()));
        img.setImage(image);
    }
}

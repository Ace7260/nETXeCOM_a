package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import model.Fruit;
import sample.Main;
import sample.MyListerner;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StoreController implements Initializable{

    @FXML
    private VBox chosenFruitCard;

    @FXML
    private Label fruitNameLabel;

    @FXML
    private Label fruitPriceLabel;

    @FXML
    private ImageView fruitimg;
    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
private List<Fruit> fruits=new ArrayList<Fruit>();

private MyListerner myListerner;
    public List<Fruit> getData() {
        List<Fruit> fruits=new ArrayList<Fruit>();
        Fruit fruit;
            fruit=new Fruit();
            fruit.setName("Kiwi");
            fruit.setPrice(2.99);
            fruit.setImgscr("/images/kiwi.png");
            fruit.setColor("6A7324");
            fruits.add(fruit);

            fruit=new Fruit();
            fruit.setName("Coconut");
            fruit.setPrice(3.99);
            fruit.setImgscr("/images/coconut.png");
            fruit.setColor("A77458");
            fruits.add(fruit);

            fruit=new Fruit();
            fruit.setName("Peach");
            fruit.setPrice(1.50);
            fruit.setImgscr("/images/peach.png");
            fruit.setColor("F16C31");
            fruits.add(fruit);

            fruit=new Fruit();
            fruit.setName("Grapes");
            fruit.setPrice(8.99);
            fruit.setImgscr("/images/grapes.png");
            fruit.setColor("291D36");
            fruits.add(fruit);

            fruit=new Fruit();
            fruit.setName("watermelon");
            fruit.setPrice(4.99);
            fruit.setImgscr("/images/watermelon.png");
            fruit.setColor("22371D");
            fruits.add(fruit);

            fruit=new Fruit();
            fruit.setName("Orange");
            fruit.setPrice(2.99);
            fruit.setImgscr("/images/orange.png");
            fruit.setColor("FB5D03");
            fruits.add(fruit);

            fruit=new Fruit();
            fruit.setName("StrawBerry");
            fruit.setPrice(2.99);
            fruit.setImgscr("/images/strawberry.png");
            fruit.setColor("FB5D03");
            fruits.add(fruit);

            fruit=new Fruit();
            fruit.setName("Mango");
            fruit.setPrice(0.99);
            fruit.setImgscr("/images/mango.png");
            fruit.setColor("FFB605");
            fruits.add(fruit);

            fruit=new Fruit();
            fruit.setName("Cherry");
            fruit.setPrice(0.99);
            fruit.setImgscr("/images/cherry.png");
            fruit.setColor("80080C");
            fruits.add(fruit);

            fruit=new Fruit();
            fruit.setName("Banana");
            fruit.setPrice(1.99);
            fruit.setImgscr("/images/banana.png");
            fruit.setColor("E7C00F");
            fruits.add(fruit);

        return fruits;
    }
private void setChosenFruitCard(Fruit fruit){
        fruitNameLabel.setText(fruit.getName());
        fruitPriceLabel.setText(Main.CURRENCY + fruit.getPrice());
        Image image=new Image(getClass().getResourceAsStream(fruit.getImgscr()));
        fruitimg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color:#"+fruit.getColor()+";\n" +
                "-fx-background-radius:30;");
}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fruits.addAll(getData());
        if(fruits.size()>0){
            setChosenFruitCard(fruits.get(0));
            myListerner=new MyListerner() {
                @Override
                public void onClickListerner(Fruit fruit) {
                    setChosenFruitCard(fruit);
                }
            };
        }
        int column=0;
        int row=1;
        try {
        for (int i = 0; i < fruits.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));


            AnchorPane anchorPane = fxmlLoader.load();

            ItemController itemController = fxmlLoader.getController();
            itemController.setData(fruits.get(i),myListerner);
            if(column==3){
                column=0;
                row++;
            }
            grid.add(anchorPane,column++,row);//child,colum,row
            //set grid width
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
            //set grid height
            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_COMPUTED_SIZE);


            GridPane.setMargin(anchorPane,new Insets(10,10,10,10));
        }  } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


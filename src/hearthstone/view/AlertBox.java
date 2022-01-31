package hearthstone.view;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

    public static void display(String title, String message) {
    	Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setHeight(120);

        if(message.length()>=40){
            window.setWidth(850);
            window.setX(550);
        }

        else{
            window.setX(700);
            window.setWidth(500);
        }


        window.setY(460);
        window.initStyle(StageStyle.UNDECORATED);
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Okay");
        label.setFont(Font.font("Showcard Gothic", FontWeight.BOLD, 20));

        closeButton.setStyle("-fx-background-color: black; -fx-text-fill: gold; ;-fx-border-color: Gold ; -fx-border-width: 3px ; -fx-border-radius: 12; -fx-background-radius: 15");


        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        label.setAlignment(Pos.CENTER);
        closeButton.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        scene.setFill(Color.RED);
        window.setScene(scene);
        window.showAndWait();
    }


}

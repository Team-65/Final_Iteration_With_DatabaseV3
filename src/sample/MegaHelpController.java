package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.io.InputStream;

/**
 * Created by peternolan on 5/1/17.
 */
public class MegaHelpController {
    @FXML ImageView searchView,
            reviseView,
            correctView,
            supervisorView,
            newView;

    /**
     * Initializes search help screen.
     */
    public void initialize(){

        try {
            InputStream resource = ScreenUtil.class.getClassLoader().getResourceAsStream("resources/SearchUI.png");
            searchView.setImage(new javafx.scene.image.Image(resource, 500.0, 0.0, true, true));
        }
        catch(NullPointerException nullPoint){
            InputStream resource = ScreenUtil.class.getClassLoader().getResourceAsStream("labels/imageUnavailable.jpg");
            searchView.setImage(new javafx.scene.image.Image(resource, 100.0, 0.0, true, true));
            System.out.println("Image Was Not Found");
        }
        try {
            InputStream resource = ScreenUtil.class.getClassLoader().getResourceAsStream("resources/SearchUI.png");
            reviseView.setImage(new javafx.scene.image.Image(resource, 500.0, 0.0, true, true));
        }
        catch(NullPointerException nullPoint){
            InputStream resource = ScreenUtil.class.getClassLoader().getResourceAsStream("labels/imageUnavailable.jpg");
            reviseView.setImage(new javafx.scene.image.Image(resource, 100.0, 0.0, true, true));
            System.out.println("Image Was Not Found");
        }
        try {
            InputStream resource = ScreenUtil.class.getClassLoader().getResourceAsStream("resources/SearchUI.png");
            correctView.setImage(new javafx.scene.image.Image(resource, 500.0, 0.0, true, true));
        }
        catch(NullPointerException nullPoint){
            InputStream resource = ScreenUtil.class.getClassLoader().getResourceAsStream("labels/imageUnavailable.jpg");
            correctView.setImage(new javafx.scene.image.Image(resource, 100.0, 0.0, true, true));
            System.out.println("Image Was Not Found");
        }
        try {
            InputStream resource = ScreenUtil.class.getClassLoader().getResourceAsStream("resources/SearchUI.png");
            supervisorView.setImage(new javafx.scene.image.Image(resource, 500.0, 0.0, true, true));
        }
        catch(NullPointerException nullPoint){
            InputStream resource = ScreenUtil.class.getClassLoader().getResourceAsStream("labels/imageUnavailable.jpg");
            supervisorView.setImage(new javafx.scene.image.Image(resource, 100.0, 0.0, true, true));
            System.out.println("Image Was Not Found");
        }
        try {
            InputStream resource = ScreenUtil.class.getClassLoader().getResourceAsStream("resources/SearchUI.png");
            newView.setImage(new javafx.scene.image.Image(resource, 500.0, 0.0, true, true));
        }
        catch(NullPointerException nullPoint){
            InputStream resource = ScreenUtil.class.getClassLoader().getResourceAsStream("labels/imageUnavailable.jpg");
            newView.setImage(new javafx.scene.image.Image(resource, 100.0, 0.0, true, true));
            System.out.println("Image Was Not Found");
        }
    }


}

package com.upb.agripos;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductTableView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppJavaFX extends Application {

    @Override
    public void start(Stage stage) {
        ProductDAO dao = new ProductDAO();
        ProductService service = new ProductService(dao);
        ProductController controller = new ProductController(service);

        stage.setScene(new Scene(
                new ProductTableView(controller), 800, 500
        ));
        stage.setTitle("Agri-POS - Week 13 TableView & Lambda");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

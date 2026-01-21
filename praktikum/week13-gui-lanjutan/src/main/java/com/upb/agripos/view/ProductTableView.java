package com.upb.agripos.view;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.model.Product;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public class ProductTableView extends VBox {

    private TableView<Product> table;
    private ObservableList<Product> data;
    private ProductController controller;

    public ProductTableView(ProductController controller) {
        this.controller = controller;
        initUI();
        loadData();
    }

    private void initUI() {
        table = new TableView<>();
        data = FXCollections.observableArrayList();

        TableColumn<Product, String> colCode = new TableColumn<>("Kode");
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));

        TableColumn<Product, String> colName = new TableColumn<>("Nama");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> colPrice = new TableColumn<>("Harga");
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> colStock = new TableColumn<>("Stok");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        table.getColumns().addAll(colCode, colName, colPrice, colStock);
        table.setItems(data);

        Button btnAdd = new Button("Tambah Produk");
        Button btnDelete = new Button("Hapus Produk");
        Button btnReload = new Button("Reload Data");

        // ➕ Tambah (dummy sesuai praktikum)
        btnAdd.setOnAction(e -> {
            Product p = new Product(
                    "P" + System.currentTimeMillis(),
                    "Produk Baru",
                    25000,
                    10
            );
            controller.add(p);
            loadData();
        });

        // 🗑️ Hapus
        btnDelete.setOnAction(e -> {
            Product selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                controller.delete(selected.getCode());
                loadData();
            }
        });

        // 🔄 Reload
        btnReload.setOnAction(e -> loadData());

        HBox buttonBar = new HBox(10, btnAdd, btnDelete, btnReload);

        setPadding(new Insets(10));
        setSpacing(10);
        getChildren().addAll(table, buttonBar);
    }

    private void loadData() {
        data.clear();
        data.addAll(controller.load());
    }
}

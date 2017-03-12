package com.oberthur.fsi.tools;

import java.io.IOException;

import com.oberthur.fsi.tools.STDGenerator.view.STDGeneratorController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane mainLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("STD Generator");
		
		initMainLayout();
		
		showApplication();
	}
	
	private void initMainLayout() {
		try {
			// Load Main Layout from FXML file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/MainLayout.fxml"));
			mainLayout = (BorderPane) loader.load();
			
			// Show the scene containing the Main Layout.
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void showApplication() {
		try {
			// Load STD Generator application.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("STDGenerator/view/STDGenerator.fxml"));
			AnchorPane stdGenerator = (AnchorPane) loader.load();
			// Give the controller access to the main application.
			STDGeneratorController stdController = loader.getController();
			stdController.setMainApplication(this);
			
			// List of all application.
			Tab[] tabs = new Tab[1];
			
			tabs[0] = new Tab("STD Generator");	
			tabs[0].setContent(stdGenerator);
			
			// Set tabs in the center of Main layout.
			TabPane tabPane = new TabPane(tabs);
			tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
			mainLayout.setCenter(tabPane);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

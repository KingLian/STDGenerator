package com.oberthur.fsi.tools.STDGenerator.view;

import java.io.File;

import com.oberthur.fsi.tools.Main;
import com.oberthur.fsi.tools.STDGenerator.model.FolderList;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.stage.DirectoryChooser;

public class STDGeneratorController {
	
	@FXML
	private TextField projectFolder;
	
	@FXML
	private ComboBox<String> srcFolder;
	
	@FXML
	private ComboBox<String> xmlFile;
	
	@FXML
	private CheckBox autoparagraph;
	
	private FolderList folderList = new FolderList();
	private FolderList xmlList = new FolderList();
	
	// Reference to the Main application.
	private Main main;
	
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public STDGeneratorController() {
		
	}
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
	@FXML
	private void initialize() {
		
	}
	
	/**
     * Is called by the main application to give a reference back to itself.
     * @param main
     */
	public void setMainApplication(Main main) {
		this.main = main;
	}
	
	@FXML
	private void generateSTD() {
		// Check project directory
		String path = projectFolder.getText();
		String src = srcFolder.getSelectionModel().getSelectedItem();
		String xml = xmlFile.getSelectionModel().getSelectedItem();
		
		if (path != null && src != null && xml != null) {
			// Generate STD Document
//			if (this.autoparagraph.isSelected()) {
//				stdGenerator.main(path + "/" + xml, path + "/" + src, "-autoparagraph");
//			} else {
//				stdGenerator.main(path + "/" + xml, path + "/" + src);
//			}
			
		} else {
			// Error
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Ooops, there was an error!");
			alert.setContentText("Project Folder, Source Folder, or XML File is not yet selected!");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void chooseProjectFolder() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File selectedDirectory = directoryChooser.showDialog(main.getPrimaryStage());
		
		if (selectedDirectory != null) { 
			projectFolder.setText(selectedDirectory.getAbsolutePath());
			
			setFolderList(projectFolder.getText());
			setXMLList(projectFolder.getText());
		}
	}
	
	private void setFolderList(String path) {
		folderList.getFolderList(path);
		srcFolder.setItems(folderList.getList());
		for (String folder : folderList.getList()) {
			if (folder.equalsIgnoreCase("src")) {
				srcFolder.getSelectionModel().select(folder);
			}
		}
	}
	
	private void setXMLList(String path) {
		xmlList.getFileList(path, ".xml");
		xmlFile.setItems(xmlList.getList());
		if (xmlList.getList().size() > 0) {
			xmlFile.getSelectionModel().select(0);
		}
	}
	
}

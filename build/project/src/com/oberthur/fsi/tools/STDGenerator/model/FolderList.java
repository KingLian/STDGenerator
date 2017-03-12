package com.oberthur.fsi.tools.STDGenerator.model;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FolderList {
	
	private ObservableList<String> list = FXCollections.observableArrayList();
	
	public ObservableList<String> getFolderList(String path) {
		list.clear();
		File[] files = new File(path).listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				list.add(file.getName());
			}
		}
		return list;
	}
	
	public ObservableList<String> getFileList(String path) {
		list.clear();
		File[] files = new File(path).listFiles();
		for (File file : files) {
			if (file.isFile()) {
				list.add(file.getName());
			}
		}
		return list;
	}
	
	public ObservableList<String> getFileList(String path, String fileFormat) {
		list.clear();
		File[] files = new File(path).listFiles();
		for (File file : files) {
			if (file.isFile()) {
				if (file.getName().toLowerCase().endsWith(fileFormat.toLowerCase())) {
					list.add(file.getName());
				}
			}
		}
		return list;
	}
	
	public void clear() {
		list.clear();
	}
	
	public ObservableList<String> getList() {
		return list;
	}

}

package com.av.fantasy.model;

import com.av.fantasy.dao.PlayerImporter;

public class ImportPlayers {


	public static void main(String[] args){
		System.out.println("Uploading Players");
		PlayerImporter.importPlayers();
		System.out.println("UploadFinished");
	}
		
	


}

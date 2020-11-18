package com.hussain.service;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInitialize {
	@PostConstruct
	public void initialize() {
		try {
			FileInputStream serviceAccount = new FileInputStream("./springbootwebappdemo-firebase-adminsdk-k5d9k-e6a93b4c72.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://springbootwebappdemo.firebaseio.com").build();
			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("*******************Error Occurred******************");
			System.out.println("*******************Error Occurred******************");
			System.out.println("*******************Error Occurred******************");
			System.out.println("*******************Error Occurred******************");
			System.out.println("*******************Error Occurred******************");
		}
	}
}

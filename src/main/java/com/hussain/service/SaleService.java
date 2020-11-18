package com.hussain.service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.hussain.model.Sale;

@Service
public class SaleService {

	public static final String COL_NAME = "Sale";

	public String saveSaleDetails(Sale sale) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(sale.getBillNo())
				.set(sale);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public Sale getSaleDetails(String billNo) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(billNo);

		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		Sale sale = null;
		sale = document.toObject(Sale.class);
		return sale;
	}

	public String updateSaleDetails(Sale sale) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(sale.getBillNo())
				.set(sale);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public String deleteSale(String billNo) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(billNo).delete();
		return "Document with Bill No " + billNo + " has been deleted";
	}

	public ArrayList<Sale> getSalesLike(Sale sale) throws Exception {
		Firestore db = FirestoreClient.getFirestore();
		ArrayList<Sale> sales = new ArrayList<>();
		double diff=0.0001;
		CollectionReference salesRef = db.collection(COL_NAME);
		// [START fs_chained_query]
		// [START firestore_query_filter_compound_multi_eq]
		Query chainedQuery = null;
		if (sale.getCustomerName() != null && !sale.getCustomerName().equals("0"))
			chainedQuery = salesRef.whereEqualTo("customerName", sale.getCustomerName());
		if (sale.getBillNo() == null && !sale.getBillNo().equals("0"))
			chainedQuery = salesRef.whereEqualTo("billNo", sale.getBillNo());
		if (java.lang.Math.abs(sale.getAmount()+1)>diff)
			chainedQuery = salesRef.whereEqualTo("amount", sale.getAmount());
		ApiFuture<QuerySnapshot> querySnapshot;
		if (chainedQuery != null) {
			querySnapshot = chainedQuery.get();
			for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
				sales.add(document.toObject(Sale.class));
			}
		}
		return sales;
	}

}

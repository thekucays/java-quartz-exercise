package com.luki.exercises.tutordam.batches;

public interface BatchInterface {
	
	/*
	 * ini cuman sebuah interface dummy, dimana semua file batch akan mengimplementasikan method ini
	 * .. implementasi dari doBatch bisa beda2 tiap batch.. 
	 * .. tapi semua batch di-force buat ada method ini makanya dibuatlah interface
	 */
	
	public void doBatch();
}

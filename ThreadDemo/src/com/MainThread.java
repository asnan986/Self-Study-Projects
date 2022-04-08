package com;

public class MainThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		  A a= new A(); B b = new B(); 
		  //Thread t = new Thread(a); a.start();
		  
		  try{Thread.sleep(1000);} catch(Exception exception)
		  {exception.printStackTrace();} b.start(); a.show();
		 

		/*
		 * Runnable r = ()-> { for(int i=0;i<=4;i++) { try{Thread.sleep(1000);}
		 * catch(Exception exception) {exception.printStackTrace();}
		 * System.out.println("hai"); } };
		 */

		/*
		 * new Thread(() -> { for (int i = 0; i <= 4; i++) { try { Thread.sleep(1000); }
		 * catch (Exception exception) { exception.printStackTrace(); }
		 * System.out.println("hai"); } }).start();
		 * 
		 * try { Thread.sleep(500); } catch (Exception exception) {
		 * exception.printStackTrace(); }
		 * 
		 * new Thread(() -> { for (int i = 0; i <= 4; i++) { try { Thread.sleep(1000); }
		 * catch (Exception exception) { exception.printStackTrace(); }
		 * System.out.println("hello"); } }).start();
		 */
	}

}


  class A implements Runnable{
  
  @Override public void run() { for(int i=0;i<=4;i++) {
  try{Thread.sleep(1000);} catch(Exception exception)
  {exception.printStackTrace();} System.out.println("hai"); } }
  
  public void show() { System.out.println("show hai"); }
  
  
  }
  
  class B extends Thread{
  
  @Override public void run() { for(int i=0;i<=4;i++) {
  try{Thread.sleep(1000);} catch(Exception exception)
  {exception.printStackTrace();} System.out.println("hello"); } }
  
  }
 
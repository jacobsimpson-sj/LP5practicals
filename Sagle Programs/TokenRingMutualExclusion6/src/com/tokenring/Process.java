package com.tokenring;
 public class Process extends Thread {
 private int id;
 private Process nextProcess;
 private boolean hasToken;
 private boolean inCriticalSection;
 public Process(int id) {
 this.id = id;
 this.hasToken = false;
 this.inCriticalSection = false;
 }
 public void setNextProcess(Process nextProcess) {
 this.nextProcess = nextProcess;
 }
 public void setToken(boolean hasToken) {
 this.hasToken = hasToken;
 }
 @Override
 public void run() {
 while (true) {
 if (hasToken) {
 enterCriticalSection();
 passToken();
 }
 try {
 Thread.sleep(1000); // Simulate processing time
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 }
 }
 private void enterCriticalSection() {
 inCriticalSection = true;
 System.out.println("Process " + id + " is in the critical section.");
 try {
 Thread.sleep(2000); // Simulate critical section work
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 inCriticalSection = false;
 System.out.println("Process " + id + " exited the critical section.");
 }
 private void passToken() {
 hasToken = false;
 nextProcess.setToken(true);
 System.out.println("Process " + id + " passed the token to Process " + nextProcess.id);
 }
 }
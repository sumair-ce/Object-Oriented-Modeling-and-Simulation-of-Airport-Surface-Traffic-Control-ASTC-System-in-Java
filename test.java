package airportSimulation;

public class test {

	public static void main(String[] args) {
		
		TaskEngine taskEngine1 = new TaskEngine();
        TaskEngine taskEngine2 = new TaskEngine();

        Thread thread1 = new Thread(() -> taskEngine1.dispatchTask());
        Thread thread2 = new Thread(() -> taskEngine2.dispatchsametask());

        taskEngine1.collectData();
        taskEngine1.mySort();
        taskEngine1.addtime();
        taskEngine1.seperatetasks();

        thread1.start();
        thread2.start();
	
	}
}

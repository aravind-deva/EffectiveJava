/**
 * 
 */
package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author abrahmad
 *
 */
public class ConcurrencyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService exec=Executors.newSingleThreadExecutor();
		
		Future<String> result=exec.submit(new Callable<String>(){
			@Override
			public String call(){
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "Aravind";
			}
		});
		exec.shutdown();
		if(result.isDone()){
			try {
				System.out.println(result.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Who is first");
		//if(result.isDone()){
			try {
				System.out.println(result.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
	}

}

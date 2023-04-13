package com.diwakarsharma.advanceJava1.thread;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.diwakarsharma.advanceJava1.CSVData.data.Tshirt;
import com.diwakarsharma.advanceJava1.inputData.SearchInput;
import com.diwakarsharma.advanceJava1.outputData.Output;
import com.diwakarsharma.advanceJava1.outputData.SearchOutput;

public class Refresh {
    public void refreshOutput(SearchInput searchIp) {
        try (WatchService service = FileSystems.getDefault().newWatchService()) {
            Map<WatchKey, Path> keyMap = new HashMap<>();
            Path path = Paths.get("C:\\Users\\Asus\\Desktop\\Product_searching_system_in_java\\Product_searching_system_in_java\\advanceJava1\\src\\main\\java\\com\\diwakarsharma\\advanceJava1\\CSVData\\CSVFiles");
            keyMap.put(path.register(service,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY),
                    path);

            WatchKey watchKey;
            do {
                watchKey = service.take();
                Path eventDir = keyMap.get(watchKey);

                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    Path eventPath = (Path) event.context();
                    
                    //give updated output on change in directory
                    ArrayList<Tshirt>matchedTShirts = SearchOutput.getMatchingTshirts(searchIp);
                    Output output = new Output();
                    output.displayOutput(matchedTShirts);
                }
            } while (watchKey.reset());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

//-------------------------------------using thread-------------------------------------------------------
//package com.diwakarsharma.advanceJava1.thread;
//
//import java.nio.file.FileSystems;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardWatchEventKinds;
//import java.nio.file.WatchEvent;
//import java.nio.file.WatchKey;
//import java.nio.file.WatchService;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import com.diwakarsharma.advanceJava1.CSVData.data.Tshirt;
//import com.diwakarsharma.advanceJava1.inputData.SearchInput;
//import com.diwakarsharma.advanceJava1.outputData.Output;
//import com.diwakarsharma.advanceJava1.outputData.SearchOutput;
//
//public class Refresh extends Thread{
//	private SearchInput searchIp;
//    public void refreshOutput(SearchInput searchIp) {
//    	this.searchIp = searchIp;
//    	Refresh thread = new Refresh();
//    	thread.start(); // we can not use searchIp parameter in start as an argument
//    }
//    
//    	
//    	public void run() {
//	        try (WatchService service = FileSystems.getDefault().newWatchService()) {
//	            Map<WatchKey, Path> keyMap = new HashMap<>();
//	            Path path = Paths.get("C:\\Users\\diwakarsharma\\Desktop\\java\\advanceJava1\\src\\main\\java\\com\\diwakarsharma\\advanceJava1\\CSVData\\CSVFiles");
//	            keyMap.put(path.register(service,
//	                    StandardWatchEventKinds.ENTRY_CREATE,
//	                    StandardWatchEventKinds.ENTRY_DELETE,
//	                    StandardWatchEventKinds.ENTRY_MODIFY),
//	                    path);
//	
//	            WatchKey watchKey;
//	            do {
//	                watchKey = service.take();
//	                Path eventDir = keyMap.get(watchKey);
//	
//	                for (WatchEvent<?> event : watchKey.pollEvents()) {
//	                    WatchEvent.Kind<?> kind = event.kind();
//	                    Path evenPath = (Path) event.context();
//	                    
//	                    //give updated output on change in directory
//	                    ArrayList<Tshirt>matchedTShirts = SearchOutput.getMatchingTshirts(this.searchIp);
//	                    Output output = new Output();
//	                    output.displayOutput(matchedTShirts);
//	                }
//	            } while (watchKey.reset());
//	        } catch (Exception e) {
//	            System.out.println(e);
//	        }
//
//    }
//        
//}
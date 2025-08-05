/*
You have a Database that stores unix timestamps as keys, and a list of filenames that were saved at that timestamp.
All of the filenames are unique.

You can interact with the Database ONLY using its two methods:

int CountFilenames(int start_time, int end_time);  // Counts filenames in timerange, inclusive of endpoints.
List<String> GetFilenames(int timestamp);  // Gets all filenames at a timestamp

The data from this Database was copied into another one, but one filename did not make it!
Your job is to find the missing filename. See test case at bottom of file.
*/

import java.io.*;
import java.util.*;

public class Main {
    // DO NOT EDIT Database class code!
    // Assume Database class methods are constant time when estimating time complexity.
    class Database {
        public TreeMap<Integer, List<String>> data = new TreeMap<Integer, List<String>>();

        public List<String> getFilenames(int timestamp) {
          if (!data.containsKey(timestamp)) {
            return Collections.emptyList();
          }
          return data.get(Integer.valueOf(timestamp));
        }

        // Counts filenames in timerange, inclusive of endpoints.
        public int countFilenames(int start, int end) {
            int count = 0;
            for (int i = start; i <= end; i++) {
                if (data.containsKey(i)) count += data.get(Integer.valueOf(i)).size();
            }
            return count;
        }
    };
    
    public static int linearFind(Database db, Database dbCopy, int startTime, int endTime){
        int timestamp = -1 ;
        
        for(int i=startTime; i<=endTime; i++){
            ///System.out.println("timestamp: "+i+", count: "+db.countFilenames(i, i)+" vs " +dbCopy.countFilenames(i, i));
            if(db.countFilenames(i, i) != dbCopy.countFilenames(i, i)){
                timestamp = i;
                break;
            }
        }
        return timestamp;
    }
    
    public static int binarySearch(Database db, Database dbCopy, int startTime, int endTime){
        int time = (endTime + startTime) / 2;
            
        if(db.countFilenames(time, time) != dbCopy.countFilenames(time, time)){
            return startTime;
        }
         
        int left = binarySearch(db, dbCopy, startTime, time);
        if(left >= 0){
            return left;
        }
        
        int right = binarySearch(db, dbCopy, time, endTime);
        if(right >= 0){
            return right;
        }
        
        
        return -1;
    }
    
    public static int binarySearch2(Database db, Database dbCopy, int startTime, int endTime){
        if (startTime == endTime) return startTime;
        
        int middle = (endTime + startTime) / 2;
            
        if(db.countFilenames(startTime, middle) != dbCopy.countFilenames(startTime, middle)){
            return binarySearch(db, dbCopy, startTime, middle);
        }
        
        if(db.countFilenames(middle + 1, endTime) != dbCopy.countFilenames(middle + 1, endTime)){
            return binarySearch(db, dbCopy, middle + 1, endTime);
        }
        
        return -1;
    }
    
    public static void binarySearch3(Database db, Database dbCopy, int startTime, int endTime, Set<Integer> timestamps){
        if (startTime == endTime) {
            timestamps.add(startTime);
            return;
        };
        
        int middle = (endTime + startTime) / 2;
            
        if(db.countFilenames(startTime, middle) != dbCopy.countFilenames(startTime, middle)){
            binarySearch3(db, dbCopy, startTime, middle, timestamps);
        }
        
        if(db.countFilenames(middle + 1, endTime) != dbCopy.countFilenames(middle + 1, endTime)){
            binarySearch3(db, dbCopy, middle + 1, endTime, timestamps);
        }
    }

    // Returns the missing filename in the interval [startTime, endTime].
    public static String FindMissingFilename(Database db, Database dbCopy, int startTime, int endTime) {
      // TODO: Fill me out.
        // for i= starttime to endtime
        // binary search 
        int timestamp = binarySearch2(db, dbCopy, startTime, endTime);
        System.out.println("timestamp: "+timestamp);
        
        List<String>  dbFilenames = db.getFilenames(timestamp); //N
        Set<String>  dbCopyFilenames = new HashSet<String>(dbCopy.getFilenames(timestamp));//N-1
        for(String filename: dbFilenames){ //N
            if(!dbCopyFilenames.contains(filename)){ // 1
                return filename;
            }
        } // N(N-1)
        return null;
    }
    
    /* Now any number of filenames may be missing in the interval [startTime, endTime].
   Create a new method FindAllMissingFilenames which returns them all. */
    public static List<String> findAllMissingFilenames(Database db, Database dbCopy, int startTime, int endTime) {
        Set<Integer> timestamps = new HashSet<Integer>();
        
        binarySearch3(db, dbCopy, startTime, endTime, timestamps);
        System.out.println("timestamps: "+timestamps);
        
        List<String> missingFiles = new ArrayList();
        for (int timestamp: timestamps) {
            List<String>  dbFilenames = db.getFilenames(timestamp); //N
            Set<String>  dbCopyFilenames = new HashSet<String>(dbCopy.getFilenames(timestamp));//N-1
            for(String filename: dbFilenames){ //N
                if(!dbCopyFilenames.contains(filename)){ // 1
                    missingFiles.add(filename);
                }
            } // N(N-1)    
        }
        
        return missingFiles;
    }

    public static void main(String[] args) {
      Main solution = new Main();
      solution.test();
      solution.test2();
    }

    public void test() {
      Database db = new Database();
      db.data.put(2, Arrays.asList("file1", "file2"));
      db.data.put(4, Arrays.asList("file3"));
      db.data.put(5, Arrays.asList("file4", "file5", "file6"));
      db.data.put(6, Arrays.asList("file7", "file8", "file9", "file10"));
      db.data.put(7, Arrays.asList("file11"));
      db.data.put(10, Arrays.asList("file12"));

      Database db_copy = new Database();
      db_copy.data.put(2, Arrays.asList("file1", "file2"));
      db_copy.data.put(4, Arrays.asList("file3"));
      db_copy.data.put(5, Arrays.asList("file4", "file5", "file6"));
      db_copy.data.put(6, Arrays.asList("file7", "file8", "file9", "file10"));
      db_copy.data.put(7, Collections.emptyList());
      db_copy.data.put(10, Arrays.asList("file12"));

      // Should print "file11"
      System.out.println(FindMissingFilename(db, db_copy, 2, 10)); // 2-6, 7-10
    }
    
    public void test2() {
    Database db = new Database();
          db.data.put(2, Arrays.asList("file1", "file2"));
          db.data.put(4, Arrays.asList("file3"));
          db.data.put(5, Arrays.asList("file4", "file5", "file6"));
          db.data.put(6, Arrays.asList("file7", "file8", "file9", "file10"));
          db.data.put(7, Arrays.asList("file11"));
          db.data.put(10, Arrays.asList("file12", "file13"));

      Database db_copy = new Database();
      db_copy.data.put(2, Arrays.asList("file1"));
      db_copy.data.put(4, Arrays.asList("file3"));
      db_copy.data.put(5, Arrays.asList("file4", "file5", "file6"));
      db_copy.data.put(6, Arrays.asList("file7", "file8", "file9", "file10"));
      db_copy.data.put(7, Collections.emptyList());
      db_copy.data.put(10, Arrays.asList("file12"));

      // Should print [ "file2", "file11" ] (in any order)
      System.out.println(findAllMissingFilenames(db, db_copy, 2, 10));
}
}

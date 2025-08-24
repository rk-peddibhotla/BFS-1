// Time Complexity : O(E+V) 
// Space Complexity : O(E+V) 
// Approach:
/*We treat the courses as nodes in a directed graph and prerequisites as directed edges (from → to).
    Compute in-degrees (number of prerequisites) for each course.
    Put all courses with 0 in-degree (no prerequisites) into a queue.
    Process the queue:
        Remove a course from the queue.
        Reduce the in-degree of its dependent courses.
        If any dependent course’s in-degree becomes 0, add it to the queue.
    Count how many courses are processed.
    If count == numCourses, it means we can finish all courses (graph is acyclic). Otherwise, a cycle exists and we cannot finish.
    
    
    */


import java.util.*;
public class CourseSchedule {
    public boolean solve(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
        }
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        for(int[] prerequisite : prerequisites){
            int to = prerequisite[0];
            int from = prerequisite[1];
            indegrees[to]++;

            if(!hmap.containsKey(from)){
                hmap.put(from,  new ArrayList<>());
            }
            hmap.get(from).add(to); 
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                count++;
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> edges = hmap.get(curr);
            if(edges == null){
                continue;
            }
            for(int e: edges){
                indegrees[e] --;
                if(indegrees[e] == 0){
                    q.add(e);
                    count++;
                }
            }

        }

        return count == numCourses;




    }

    public static void main(String[]args){
        CourseSchedule ob = new CourseSchedule();
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        System.out.println(ob.solve(numCourses1, prerequisites1));
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1,0},{0,1}};
        System.out.println(ob.solve(numCourses2, prerequisites2));


    }
    
}

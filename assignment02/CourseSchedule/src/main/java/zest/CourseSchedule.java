package zest;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Checks for preconditions
        if (numCourses>64 || numCourses<1) throw new IllegalArgumentException("NumCourses has to be between 1 and 64");
        if (prerequisites.length > 64) throw new IllegalArgumentException("Prerequisite length has to be between 0 and 64");
        for (int i = 0; i<prerequisites.length; i++) {
            if (prerequisites[i].length != 2 || prerequisites[i][0] > numCourses-1 || prerequisites[i][0]<0 || prerequisites[i][1] > numCourses-1 || prerequisites[i][1]<0 ) throw new IllegalArgumentException("Prerequisite elements have to be pairs with each entry being atleast 0 and at the most numCourses -1");
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] visited = new int[numCourses];

        // Check for cycles
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (hasCycle(graph, visited, i)) {
                    return false;
                }
            }
        }

        return true; 
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] visited, int course) {
        if (visited[course] == 1) {
            return true;
        }
        if (visited[course] == 2) {
            return false;
        }

        visited[course] = 1;

        for (int adjCourse : graph.get(course)) {
            if (hasCycle(graph, visited, adjCourse)) {
                return true;
            }
        }

        visited[course] = 2;
        return false;
    }
}

package zest;

public class Main {
    public static void main(String[] args) {
        CourseSchedule scheduler = new CourseSchedule();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}, {0, 1}};
        boolean canFinish1 = scheduler.canFinish(numCourses1, prerequisites1);
        System.out.println("Can all courses be finished (Example 1)? " + canFinish1);

        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 1}, {3, 2}};
        boolean canFinish2 = scheduler.canFinish(numCourses2, prerequisites2);
        System.out.println("Can all courses be finished (Example 2)? " + canFinish2);

    }
}

## Problem: CourseSchedule

# Description

In a university, a student needs to complete certain courses to finish their degree. Some courses have prerequisites that must be taken before taking the course. You are given the total number of courses and a list of prerequisite pairs. Write a function to determine if the student can finish all courses such that all prerequisites are taken before a course is attempted.
Prerequisites are represented as a list of pairs. Each pair [a, b] indicates a one-way requirement from b to a — you must finish course b before starting course a.
 The challenge is to check if the entire course plan can be completed without encountering any cyclical prerequisite conditions.

Inputs:

**numCourses (int): The total number of courses the student needs to complete

**prerequisites (int[][]): An array of prerequisite pairs where each pair [i, j] indicates that course i must be taken after course j (i and j must be less than numCourses-1)


Output:

**boolean: Return true if the student can finish all courses. Otherwise, return false.


Constraints:

**numCourses cannot be null and must be at least 1 and no more than 64.
**The length of the prerequisites array can range from 0 to 64, allowing for an empty list of prerequisites.
**Prerequisite pairs are not necessarily unique, and one course can be a prerequisite for multiple courses.



#Example

**Input: numCourses = 2, prerequisites = [[1, 0], [0, 1]]

**Output:  false
Explanation: There are 2 courses to take. For [1, 0], to take course 1, the student must complete course 0 first, and to take course 0, the student must complete course 1 first, which is impossible.



## Problem: Merge Intervals

# Description

The goal of this problem is to merge all overlapping intervals from a list of intervals. Each interval is represented as a pair of integers indicating the start and end time. If any two intervals overlap, they should be merged into a single interval that spans from the earliest start time of the overlapping intervals to the latest end time.

Inputs:

**List of int[][] intervals, where each sub-array contains two integers [startTime, endTime].


Output:

**List of int[][], representing the merged intervals, sorted by start times.

Behavior:

**The function should handle an empty list of intervals and return an empty list.

**The function should merge any overlapping intervals and return a minimal list of intervals.

**Overlapping intervals are defined where one interval's start time is less than or equal to another's end time.

#Example

**Input: intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]

**Output:  [[1, 6], [8, 10], [15, 18]]

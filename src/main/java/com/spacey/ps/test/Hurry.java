package com.spacey.ps.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Hurry {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int t = Integer.parseInt(line[1]);
		int[][] task = new int[n][2];
		for (int i_task = 0; i_task < n; i_task++) {
			String[] arr_task = br.readLine().split(" ");
			for (int j_task = 0; j_task < arr_task.length; j_task++) {
				task[i_task][j_task] = Integer.parseInt(arr_task[j_task]);
			}
		}

		int out_ = solve(n, t, task);
		System.out.println(out_);

		wr.close();
		br.close();
	}

	/**
	 * 
	 * 3 16 2 8 4 5 5 1
	 * 
	 * @param n
	 * @param t
	 * @param task
	 * @return
	 */
	static int solve(int n, int t, int[][] task) {
		// Write your code here
		List<Task> tasks = new ArrayList<>();
		for (int i = 0; i < task.length; i++) {
			tasks.add(new Task(task[i][0], task[i][1]));
		}
		Map<List<Task>, Integer> output = new HashMap<>();
		findTaskTime(tasks, new ArrayList<>(), output);
		int maxTime = 0;
		int maxTask = 0;
		Entry<List<Task>, Integer> copy = null;
		for (Entry<List<Task>, Integer> e : output.entrySet()) {
			if (e.getValue() <= t && e.getValue() > maxTime) {
				copy = e;
				maxTime = e.getValue();
				maxTask = e.getKey().size();
			}
		}
		System.out.println(copy);
		return maxTask;
	}

	private static void findTaskTime(List<Task> tasks, List<Task> validTasks, Map<List<Task>, Integer> timeMaps) {
		if (tasks.size() == 0) {
			timeMaps.put(validTasks, calculateTotalTime(validTasks));
			return;
		}

		List<Task> tasksCopy = new ArrayList<>(tasks);
		Task currTask = tasksCopy.remove(0);
		
		findTaskTime(tasksCopy, validTasks, timeMaps);

		List<Task> validTasksWithCurrent = new ArrayList<>(validTasks);
		validTasksWithCurrent.add(currTask);
		findTaskTime(tasksCopy, validTasksWithCurrent, timeMaps);
	}

	static int calculateTotalTime(List<Task> tasks) {
		int sum = 0;
		int t2 = 0;
		for (Task t : tasks) {
			t2 = t.getPosition();
			sum += t.getWorkUnit();
		}
		return sum + (t2 * 2);
	}

	static class Task {
		int position;
		int workUnit;

		public Task(int position, int workUnit) {
			this.position = position;
			this.workUnit = workUnit;
		}

		public int getPosition() {
			return position;
		}


		public int getWorkUnit() {
			return workUnit;
		}

		@Override
		public String toString() {
			return "[" + position + ", " + workUnit + "]";
		}

	}
}

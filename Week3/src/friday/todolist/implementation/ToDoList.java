package friday.todolist.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import friday.todolist.tasks.Task;

public class ToDoList {
	private PriorityQueue<Task> tasks;
	private int remainingTime;

	public ToDoList(int remainingTime) {
		this.remainingTime = remainingTime;
		tasks = new PriorityQueue<>(new TaskComparator());
	}

	public void addTask(Task task) {
		tasks.offer(task);
	}

	private void reorderElements() {
		List<Task> backUp = new ArrayList<>();
		for (Task task : tasks) {
			backUp.add(task);
		}
		tasks.clear();
		for (Task task : backUp) {
			tasks.add(task);
		}
	}

	public void markFinished(Task t) {
		t.setTimeNeeded(0);
		t.setFinished(true);
		t.setPriority(0);
		reorderElements();
		System.out.println(t + " finished");
	}

	public void markCancelled(Task t) {
		tasks.remove(t);
		System.out.println(t + " canceled");
	}

	public boolean canFinish() {
		return remainingTime > getTimeNeeded();
	}

	public Task top() {
		System.out.print("Higher priority task ==> ");
		return tasks.peek();
	}

	public float getTimeNeeded() {
		float sum = 0;
		for (Task task : tasks) {
			sum += task.getTimeNeeded();
		}
		System.out
				.print("Time needed in order to finished all tasks in the list: ");
		return sum;
	}

	public boolean changePriority(Task task, int priority) {
		if (priority < 1 || priority > 10) {
			System.err
					.println("Invalid priority value!Priority should be in the range 1-10");
			return false;
		}
		task.setPriority(priority);
		reorderElements();
		return true;

	}

	@Override
	public String toString() {
		PriorityQueue<Task> set = new PriorityQueue<>(tasks);
		System.out.println("\nYour tasks in the list");
		String str = "=====================================================\n";
		while (!set.isEmpty()) {
			str += set.poll() + "\n";

		}
		str += "=====================================================";
		return str;
	}
}

package ru.netology.inherit;

public class Epic extends Task {
    protected Task[] subtasks = new Task[0];

    public Epic(int id, Task[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public Task[] getSubtasks(){
        return subtasks;
    }
}

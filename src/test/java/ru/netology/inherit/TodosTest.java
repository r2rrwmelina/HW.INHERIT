package ru.netology.inherit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям и купить хлеб");
    String[] subtasks = {"молоко", "яйца", "хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );
    Todos todos = new Todos();

    @BeforeEach
    public void set() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTask() {

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTasks() {

        Task[] expected = {};
        Task[] actual = todos.search("Buy some tea");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAMatchWithFewTasks() {

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }
}

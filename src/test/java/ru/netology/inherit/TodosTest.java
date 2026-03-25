package ru.netology.inherit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
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
    public void shouldFindAMatchWithSimpleTask() {

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAMatchWithSimpleTask() {

        Task[] expected = {};
        Task[] actual = todos.search("Позвонить друзьям");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAMatchWithEpic() {

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAMatchWithEpic() {

        Task[] expected = {};
        Task[] actual = todos.search("Огурцы");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAMatchWithMeeting() {

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение НетоБанка");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAMatchWithMeeting() {

        Task[] expected = {};
        Task[] actual = todos.search("Во вторник после обеда");

        Assertions.assertArrayEquals(expected, actual);
    }
}

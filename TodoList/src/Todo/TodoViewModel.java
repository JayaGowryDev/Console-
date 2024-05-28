package Todo;

import java.util.List;

import Model.Todo;
import Model.TodoRepository;

public class TodoViewModel {
    private TodoView todoView;
    private TodoRepository todoRepository;

    public TodoViewModel(TodoView todoView, TodoRepository todoRepository) {
        this.todoView = todoView;
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllItems() {
        return todoRepository.getAllItems();
    }
    public void addItem(String description) {
        todoRepository.addItem(new Todo(0, description, false));
    }

    public void updateItem(int id, String description, boolean isCompleted) {
        todoRepository.updateItem(new Todo(id, description, isCompleted));
    }

    public boolean deleteItem(int id) {
       return todoRepository.deleteItem(id);
    }

}

package Model;

import java.util.List;

public interface TodoRepository {
    List<Todo> getAllItems();
    Todo getItem(int id);
    void addItem(Todo item);
    void updateItem(Todo item);
    boolean deleteItem(int id);
    
} 

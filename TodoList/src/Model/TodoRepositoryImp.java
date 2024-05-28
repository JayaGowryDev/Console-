package Model;

import java.util.ArrayList;
import java.util.List;

public class TodoRepositoryImp implements TodoRepository{
    private List<Todo> items =new ArrayList<>();
    private int id=1;

    public List<Todo> getAllItems(){
        return items;
    }
    public Todo getItem(int id){
        for (Todo item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    public void addItem(Todo item){
        item.setId(id++);
        items.add(item);
    }
    public void updateItem(Todo item) {
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == item.getId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            items.set(index, item);
        }
    }
    public boolean deleteItem(int val) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == val) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }
}

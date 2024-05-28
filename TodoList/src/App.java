import Model.TodoRepository;
import Model.TodoRepositoryImp;
import Todo.TodoView;
import Todo.TodoViewModel;

public class App {
    public static void main(String[] args) throws Exception {
        TodoRepository todoRepository = new TodoRepositoryImp();
        TodoViewModel todoViewModel = new TodoViewModel(null, todoRepository);
        TodoView todoView = new TodoView(todoViewModel);

        // Set the viewModel in the viewModel (to avoid circular dependency)
        todoViewModel = new TodoViewModel(todoView, todoRepository);

        // Update the viewModel in the view
        todoView = new TodoView(todoViewModel);

        // Start the application
        todoView.showMenu();
    }
}

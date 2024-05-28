package Todo;

import java.util.List;
import java.util.Scanner;

import Model.Todo;

public class TodoView {
    private TodoViewModel todoViewModel;
    private Scanner scan;

    public TodoView(TodoViewModel todoViewModel) {
        this.todoViewModel = todoViewModel;
        this.scan = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("---------     ToDo List Menu    ----------------");
            System.out.println("1. View all items");
            System.out.println("2. Add new item");
            System.out.println("3. Update item");
            System.out.println("4. Delete item");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    viewAllItems();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    private void viewAllItems() {
        List<Todo> items = todoViewModel.getAllItems();
        if (items.size() == 0) {
            System.out.println("Todo List is Empty Please Try to add");
        } else {
            System.out.println("ToDo Items:");
            for (Todo item : items) {
                System.out.println(
                        item.getId() + ". " + item.getDescription() + " [Completed: " + item.getIsCompleted() + "]");
            }
        }
    }

    private void addItem() {
        scan.nextLine();
        System.out.print("Enter description: ");

        String description = scan.nextLine();
        todoViewModel.addItem(description);
        System.out.println("Item added successfully.");

    }

    private void updateItem() {

        System.out.print("Enter item ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter new description: ");
        String description = scan.nextLine();
        System.out.print("Is completed? (true/false): ");
        boolean isCompleted = Boolean.parseBoolean(scan.nextLine());
        todoViewModel.updateItem(id, description, isCompleted);
        System.out.println("Item updated successfully.");

    }

    private void deleteItem() {

        System.out.print("Enter item ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        boolean isDeleted = todoViewModel.deleteItem(id);
        if (isDeleted) {
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Item with ID " + id + " not found.");
        }

    }
}
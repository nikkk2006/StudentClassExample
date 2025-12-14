import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ArrayList<Student> listOfStudents = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Меню управления студентами ===");
            System.out.println("1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Отображение всех студентов");
            System.out.println("4. Среднее значение всех оценок");
            System.out.println("5. Отображение конкретного студента");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1: {
                    System.out.print("Введите количество студентов для добавления: ");
                    int count = scanner.nextInt();
                    scanner.nextLine();

                    for(int i = 0; i < count; i++) {
                        System.out.println("\n=== Добавление студента #" + (i + 1) + " ===");
                        Student student = new Student();

                        System.out.print("Введите имя студента: ");
                        student.setName(scanner.nextLine());

                        System.out.print("Введите возраст студента: ");
                        student.setAge(scanner.nextInt());

                        System.out.print("Введите оценку студента: ");
                        student.setGrade(scanner.nextInt());
                        scanner.nextLine(); // очистка буфера

                        listOfStudents.add(student);
                        System.out.println("Студент добавлен!");
                    }
                    break;
                }

                case 2: {
                    if (listOfStudents.isEmpty()) {
                        System.out.println("Список студентов пуст!");
                        break;
                    }

                    System.out.println("\n=== Удаление студента ===");
                    System.out.println("Список студентов:");
                    for (int i = 0; i < listOfStudents.size(); i++) {
                        System.out.println((i + 1) + ". " + listOfStudents.get(i).getName());
                    }

                    System.out.print("Введите номер студента для удаления: ");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (index >= 0 && index < listOfStudents.size()) {
                        String removedName = listOfStudents.get(index).getName();
                        listOfStudents.remove(index);
                        System.out.println("Студент " + removedName + " удален!");
                    } else {
                        System.out.println("Неверный номер студента!");
                    }
                    break;
                }

                case 3: {
                    if (listOfStudents.isEmpty()) {
                        System.out.println("Список студентов пуст!");
                        break;
                    }

                    System.out.println("\n=== Список всех студентов ===");
                    System.out.println("Всего студентов: " + listOfStudents.size());
                    System.out.println("----------------------------------------");
                    for (int i = 0; i < listOfStudents.size(); i++) {
                        Student student = listOfStudents.get(i);
                        System.out.println((i + 1) + ". Имя: " + student.getName() +
                                ", Возраст: " + student.getAge() +
                                ", Оценка: " + student.getGrade());
                    }
                    break;
                }

                case 4: {
                    if (listOfStudents.isEmpty()) {
                        System.out.println("Список студентов пуст!");
                        break;
                    }

                    double sum = 0;
                    for (Student student : listOfStudents) {
                        sum += student.getGrade();
                    }
                    double average = sum / listOfStudents.size();
                    System.out.printf("Средняя оценка всех студентов: %.2f\n", average);
                    break;
                }

                case 5: {
                    if (listOfStudents.isEmpty()) {
                        System.out.println("Список студентов пуст!");
                        break;
                    }

                    System.out.println("\n=== Поиск студента ===");
                    System.out.println("1. Поиск по номеру");
                    System.out.println("2. Поиск по имени");
                    System.out.print("Выберите способ поиска: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (searchChoice == 1) {
                        System.out.print("Введите номер студента: ");
                        int index = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (index >= 0 && index < listOfStudents.size()) {
                            Student student = listOfStudents.get(index);
                            System.out.println("\nИнформация о студенте:");
                            System.out.println("Имя: " + student.getName());
                            System.out.println("Возраст: " + student.getAge());
                            System.out.println("Оценка: " + student.getGrade());
                        } else {
                            System.out.println("Студент с таким номером не найден!");
                        }
                    } else if (searchChoice == 2) {
                        System.out.print("Введите имя студента: ");
                        String name = scanner.nextLine();

                        boolean found = false;
                        for (int i = 0; i < listOfStudents.size(); i++) {
                            if (listOfStudents.get(i).getName().equalsIgnoreCase(name)) {
                                Student student = listOfStudents.get(i);
                                System.out.println("\nИнформация о студенте:");
                                System.out.println("Номер в списке: " + (i + 1));
                                System.out.println("Имя: " + student.getName());
                                System.out.println("Возраст: " + student.getAge());
                                System.out.println("Оценка: " + student.getGrade());
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Студент с именем '" + name + "' не найден!");
                        }
                    } else {
                        System.out.println("Неверный выбор!");
                    }
                    break;
                }

                case 0: {
                    System.out.println("Выход из программы...");
                    break;
                }

                default: {
                    System.out.println("Неверный выбор! Попробуйте снова.");
                    break;
                }
            }

        } while(choice != 0);

        scanner.close();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество фигур (N): ");
        int n = scanner.nextInt();

        Shape[] shapes = new Shape[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nВвод данных для фигуры #" + (i + 1) + ":");
            System.out.print("Тип ('C' - Круг, 'R' - Прямоугольник): ");
            char type = scanner.next().toUpperCase().charAt(0);

            switch (type) {
                case 'C':
                    System.out.print("Введите радиус: ");
                    double radius = scanner.nextDouble();
                    shapes[i] = new Circle(radius);
                    break;
                case 'R':
                    System.out.print("Введите ширину: ");
                    double width = scanner.nextDouble();
                    System.out.print("Введите высоту: ");
                    double height = scanner.nextDouble();
                    shapes[i] = new Rectangle(width, height);
                    break;
                default:
                    System.out.println("Неизвестный тип. Создана пустая фигура-заглушка.");
                    shapes[i] = new Shape(type);
                    break;
            }
        }
        System.out.println("\n--- РЕЗУЛЬТАТЫ РАСЧЕТОВ ---");

        Shape maxShape = null;

        for (Shape shape : shapes) {
            double currentArea = shape.area(); // Полиморфный вызов метода area()

            System.out.printf("Тип фигуры: %c | Площадь: %.2f\n", shape.getType(), currentArea);

            // Логика поиска фигуры с максимальной площадью
            if (maxShape == null || currentArea > maxShape.area()) {
                maxShape = shape;
            }
        }
        
        if (maxShape != null) {
            System.out.println("\n-------------------------------------------");
            System.out.printf("Фигура с максимальной площадью: %c (Площадь: %.2f)\n",
                    maxShape.getType(), maxShape.area());
        }

        scanner.close();
    }
}
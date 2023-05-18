package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Lesson> list = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso?");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char type = sc.next().charAt(0);
            clearBuffer(sc);

            System.out.print("Título: ");
            String titulo = sc.nextLine();

            if (type == 'c' || type == 'C') {
                System.out.print("URL do vídeo:");
                String url = sc.nextLine();

                System.out.print("Duração em segundos: ");
                int segundos = sc.nextInt();
                clearBuffer(sc);

                list.add(new Video(titulo, url, segundos));
                System.out.println();

            } else if (type == 't' || type == 'T') {
                System.out.print("Descrição: ");
                String descricao = sc.nextLine();

                System.out.print("Quantidade de questões: ");
                int questionCount = sc.nextInt();
                System.out.println();
                list.add(new Task(titulo, descricao, questionCount));
                clearBuffer(sc);
            }
        }
        int sum = 0;
        for (Lesson lesson : list) {
            sum += lesson.duration();
        }
        System.out.println("DURAÇÃO TOTAL DO CURSO: " + sum + " Segundos");
        sc.close();
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}

package exercicio1.application;

import exercicio1.entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        String path = sc.next();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Set<LogEntry> set = new HashSet<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(" ");
                String userName = fields[0];
                LocalDateTime accessMoment =  LocalDateTime.ofInstant(Instant.parse(fields[1]), ZoneId.systemDefault());

                set.add(new LogEntry(userName, accessMoment));

                line = br.readLine();
            }

            // PRINTING SET CONTENT
            /*
            for (User u : set) {
                System.out.println(u);
            }
            */

            System.out.println("Total users: " + set.size());
        }
        catch (IOException | DateTimeException e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
}

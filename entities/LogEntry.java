package exercicio1.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class LogEntry {
    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm");

    private String userName;
    private LocalDateTime dateMoment;

    public LogEntry(String name, LocalDateTime date) {
        this.userName = name;
        this.dateMoment = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getDateMoment() {
        return dateMoment;
    }

    public void setDateMoment(LocalDateTime dateMoment) {
        this.dateMoment = dateMoment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry user = (LogEntry) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public String toString() {
        return getUserName() + " " + getDateMoment().format(DTF);
    }
}

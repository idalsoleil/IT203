package WakeUp;

import java.util.Scanner;
import java.time.LocalTime;

public class Monday extends Weekday {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n====================================");
        System.out.println("Welcome to Alarm Clock!");
        System.out.println("====================================");
        
        boolean continueSettingAlarm = true;
        while (continueSettingAlarm) {
            System.out.print("\nEnter the time for the alarm (HH:MM): ");
            String time = scan.nextLine();
        
            Monday monday = new Monday();
            monday.setAlarm(time);
            monday.showAlarm();
            
            System.out.print("\nDo you want to set another alarm? (yes/no): ");
            String response = scan.nextLine();
            
            if (!response.equalsIgnoreCase("yes")) {
                continueSettingAlarm = false;
                System.out.println("\nThank you for using Alarm Clock. Goodbye!");
            }
        }
    }

    private String alarmTime;
    
    @Override
    public void setAlarm(String time) {
        this.alarmTime = time;
    }
    
    @Override
    public void showAlarm() {
        LocalTime alarm = LocalTime.parse(alarmTime);
        LocalTime now = LocalTime.now();
        
        if (alarm.isAfter(now)) {
            System.out.println("I'll wake you up later!");
        } else {
            System.out.println("Alarm is set for tomorrow!");
        }
    }
}

interface Alarm {
    void setAlarm(String time);
    void showAlarm();
}

abstract class Weekday implements Alarm {}
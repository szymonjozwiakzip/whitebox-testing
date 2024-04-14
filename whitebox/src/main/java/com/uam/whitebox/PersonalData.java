package com.uam.whitebox;

import java.util.ArrayList;
import java.util.List;

public class PersonalData {

    private String name;
    private String surname;
    private String pesel;
    private String emailAddress;
    private String phoneNumber;
    private String bankAccountNumber;


    public boolean validateName (String name) {
        final String regex = "[a-zA-ZółśćńźąężŁÓŚĆŃĄĘŻŹ]{1,20}";
        return name.matches(regex);
    }

    public boolean validateSurname (String surname) {
        final String regex = "[a-zA-ZółśćńźąężŁÓŚĆŃĄĘŻŹ -]{1,60}";
        return surname.matches(regex);
    }

    public boolean validatePesel (String pesel) {

        final String regex = "[0-9]{11}";

        if (!pesel.matches(regex))
            return false;

        String tmp = pesel.substring(2, 4);
        if (parseMonth(Integer.parseInt(tmp))==0)
            return false;

        if (!checkDay(pesel.substring(4,6), pesel.substring(2, 4)))
            return false;

        if (!checkControl(pesel))
            return false;

        return true;
    }

    public boolean validatePhoneNumber (String phoneNumber) {
        final String regex = "[0-9]{9}";
        if (!phoneNumber.matches(regex))
            return false;
        return true;
    }



    private int parseMonth(int month) {
        //Code review - discussion
        //83062113611
        //13220203470
        for (int i=0; i<=4; i++) {
            if (month - i*20 > 0 && month - i*20 <= 12 && month > 0)
                return month;
        }
        return 0;
    }

    public boolean checkDay(String days, String months) {
        //RubberDuck method
        //83062113611
        int day = Integer.parseInt(days);
        int month = Integer.parseInt(months);
        month = parseMonth(month);

        if (day < 1 || day > 31)
            return false;

        if (month == 2 && day > 29)
            return false;

        if (day == 31 && (month == 4 || month == 6 || month == 9 || month == 11))
            return false;

        return true;
    }

    private boolean checkControl(String pesel) {
        List<Character> chars = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i<pesel.length(); i++) {
            chars.add(pesel.charAt(i));
        }

        for (int i = 0; i<pesel.length(); i++) {
            digits.add(Integer.valueOf(chars.get(i).toString()));
        }

        int sum = 1 * digits.get(0);
        sum+= 3 * digits.get(1);
        sum+= 7 * digits.get(2);
        sum+= 9 * digits.get(3);
        sum+= 1 * digits.get(4);
        sum+= 3 * digits.get(5);
        sum+= 7 * digits.get(6);
        sum+= 9 * digits.get(7);
        sum+= 1 * digits.get(8);
        sum+= 3 * digits.get(9);
        sum %= 10;
        sum = 10-sum;
        sum %= 10;
        if (sum == digits.get(10))
            return true;

        return false;
    }

}

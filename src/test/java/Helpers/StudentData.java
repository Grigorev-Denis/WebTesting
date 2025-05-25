package Helpers;

import lombok.*;
import pages.StudentRegistrationFormPage;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentData {
    private String firstName = "Иван";
    private String lastName = "Петров";
    private String firstAndLastName = firstName +" "+ lastName;
    private String email = "nameexample@mail.com";
    private String mobileNum = "9997773409";
    private String gender = "Male";
    private String dateOfBirth = "10 May,2005";
    private String Subject = "Maths";
    private String hobbies = "Sports, Reading, Music";
    private String picture = "photo.jpg";
    private String currentAddress = "Kursk";
    private String state = "Haryana";
    private String city = "Panipat";
    private String stateCity = state +" "+ city;

    public List<String> dataList = List.of(firstAndLastName, email, gender, mobileNum, dateOfBirth, Subject, hobbies,
            picture, currentAddress, stateCity);

}

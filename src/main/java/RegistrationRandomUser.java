import page_object.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationRandomUser {

    public static void registrationUser(String name, String email, String password) {
        RegistrationPage registrationPage = open(RegistrationPage.URL, RegistrationPage.class);
        registrationPage.registrationUser(name, email, password);
    }
}

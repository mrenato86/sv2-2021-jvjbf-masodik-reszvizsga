package filemanipulation;

public class User {

    private String userName;
    private int yearOfBirth;
    private String emailAddress;

    public User(String userName, int yearOfBirth, String emailAddress) {
        this.userName = userName;
        this.yearOfBirth = yearOfBirth;
        this.emailAddress = emailAddress;
    }

    public boolean isEmailAndUserNameMatches() {
        int indexOfAt = emailAddress.indexOf('@');
        return userName.equalsIgnoreCase(emailAddress.substring(0, indexOfAt));
    }

    public String getUserName() {
        return userName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

}

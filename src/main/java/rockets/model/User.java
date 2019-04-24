package rockets.model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.Validate.notBlank;

public class User extends Entity {
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        notBlank(firstName, "first name cannot be null or empty");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        notBlank(lastName, "last name cannot be null or empty");
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        notBlank(email, "email cannot be null or empty");
        isEmailFormat(email);
        this.email = email;
    }

    public void isEmailFormat(String email){
        // 邮箱验证规则
        String regEx = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        if(!rs){
            throw new IllegalArgumentException("It is not a email of right format");
        }
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        notBlank(password, "password cannot be null or empty"); //add this notBlank to correct
        passwordIsAtLeast6(password);
        passwordHasDigitAndUpperCaseCharAndLowCaseChar(password);
        this.password = password;
    }

    public boolean passwordIsAtLeast6(String password){
        char[] chars = password.toCharArray();
        if(chars.length<6){
            throw new IllegalArgumentException("password should be at least 6");
        }
        return true;
    }

    public boolean passwordHasDigitAndUpperCaseCharAndLowCaseChar(String password){
        int nc = 0;
        int nlu = 0;
        int nll = 0;
        char[] chars = password.toCharArray();
        for(char c: chars){
            if(Character.isDigit(c))
                nc++;
            if(Character.isUpperCase(c))
                nlu++;
            if(Character.isLowerCase(c))
                nll++;
        }
        if(nc==0 || nlu==0 || nll==0)
            throw new IllegalArgumentException("password should contain at least one digit one lowerCase character and one uppercase character");
        return true;
    }

    // match the given password against user's password and return the result
    public boolean isPasswordMatch(String password) {
        return this.password.equals(password.trim());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

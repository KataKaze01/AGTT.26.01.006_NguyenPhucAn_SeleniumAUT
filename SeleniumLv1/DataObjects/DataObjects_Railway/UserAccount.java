package DataObjects_Railway;

import lombok.Getter;

@Getter
public class UserAccount {
    private final String usernameAccount;
    private final String passwordAccount;
    private final String pidAccount;

    public UserAccount(String usernameAccount, String passwordAccount, String pidAccount){
        this.usernameAccount = usernameAccount;
        this.passwordAccount = passwordAccount;
        this.pidAccount = pidAccount;
    }
}

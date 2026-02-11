package DataObjects_Railway;

public class UserAccount {
    private String usernameAccount;
    private String passwordAccount;
    private String resetPasswordAccount;
    private String pidAccount;

    public UserAccount(String usernameAccount, String passwordAccount, String resetPasswordAccount, String pidAccount) {
        this.usernameAccount = usernameAccount;
        this.passwordAccount = passwordAccount;
        this.resetPasswordAccount = resetPasswordAccount;
        this.pidAccount = pidAccount;
    }

    public String getUsernameAccount() {
        return usernameAccount;
    }

    public String getPasswordAccount() {
        return passwordAccount;
    }

    public String getResetPasswordAccount(){ return resetPasswordAccount; }

    public String getPidAccount() {
        return pidAccount;
    }
}
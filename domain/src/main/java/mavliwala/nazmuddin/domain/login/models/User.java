package mavliwala.nazmuddin.domain.login.models;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class User {

    private final Long id;
    private final String mobile;
    private final String email;
    private final String name;
    private final String password;
    private final String referralCode;

    public User(Long id, String mobile, String email, String name, String password, String referralCode) {
        this.id = id;
        this.mobile = mobile;
        this.email = email;
        this.name = name;
        this.password = password;
        this.referralCode = referralCode;
    }

    public Long getId() {
        return id;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public static class UserBuilder {

        private Long id;
        private String mobile;
        private String email;
        private String name;
        private String password;
        private String referralCode;

        public UserBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setReferralCode(String referralCode) {
            this.referralCode = referralCode;
            return this;
        }

        public User createUser() {
            return new User(id, mobile, email, name, password, referralCode);
        }
    }
}

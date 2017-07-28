package mavliwala.nazmuddin.zoloassignment.register.models;

/**
 * Created by nazmuddinmavliwala on 29/07/17.
 */

public class UserVO {

    private final Long id;
    private final String mobile;
    private final String email;
    private final String name;
    private final String password;
    private final String referralCode;

    public UserVO(Long id, String mobile, String email, String name, String password, String referralCode) {
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

    public static class UserVOBuilder {

        private Long id;
        private String mobile;
        private String email;
        private String name;
        private String password;
        private String referralCode;

        public UserVOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public UserVOBuilder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public UserVOBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserVOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserVOBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserVOBuilder setReferralCode(String referralCode) {
            this.referralCode = referralCode;
            return this;
        }

        public UserVO createUserVO() {
            return new UserVO(id, mobile, email, name, password, referralCode);
        }
    }
}

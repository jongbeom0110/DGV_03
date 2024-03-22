package DGV;

public class TMember {
    String      tId;
    String      tPw;
    String      tName;
    String      tBirth;
    String      tPhone;

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettPw() {
        return tPw;
    }

    public void settPw(String tPw) {
        this.tPw = tPw;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettBirth() {
        return tBirth;
    }

    public void settBirth(String tBirth) {
        this.tBirth = tBirth;
    }

    public String gettPhone() {
        return tPhone;
    }

    public void settPhone(String tPhone) {
        this.tPhone = tPhone;
    }

    @Override
    public String toString() {
        return "TMember{" +
                "tId='" + tId + '\'' +
                ", tPw='" + tPw + '\'' +
                ", tName='" + tName + '\'' +
                ", tBirth='" + tBirth + '\'' +
                ", tPhone='" + tPhone + '\'' +
                '}';
    }
}

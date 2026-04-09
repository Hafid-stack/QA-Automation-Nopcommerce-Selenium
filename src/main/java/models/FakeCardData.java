package models;

public class FakeCardData {
    private String cardFullName;
    private String cvcNumber;
    private String expirationMonth;
    private String expirationYear;
    private String cardNumber;


    public FakeCardData(String cardFullName, String cvcNumber, String expirationMonth, String expirationYear, String cardNumber) {
        this.cardFullName = cardFullName;
        this.cvcNumber = cvcNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.cardNumber = cardNumber;
    }

    public String getCardFullName() {
        return cardFullName;
    }

    public void setCardFullName(String cardFullName) {
        this.cardFullName = cardFullName;
    }

    public String getCvcNumber() {
        return cvcNumber;
    }

    public void setCvcNumber(String cvcNumber) {
        this.cvcNumber = cvcNumber;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}

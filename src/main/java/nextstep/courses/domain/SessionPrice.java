package nextstep.courses.domain;

public class SessionPrice {
    private static final int MINIMUM_SESSION_PRICE = 0;

    private final int price;

    public SessionPrice(int price) {
        if(price < MINIMUM_SESSION_PRICE) {
            throw new IllegalArgumentException("강의 최소 수강료는 " + MINIMUM_SESSION_PRICE + "원입니다: " + price);
        }
        this.price = price;
    }
}
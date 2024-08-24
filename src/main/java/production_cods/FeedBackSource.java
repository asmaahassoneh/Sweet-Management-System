package production_cods;
public class FeedBackSource {
    public  boolean positiveFeedBack(String pos)
    {
        return pos.equals("Excellent")||pos.equals("good")||pos.equals("Medium");
    }
    public  boolean negativeFeedBack(String neg)

    {
        return neg.equals("poor")||neg.equals("very bad");
    }
}

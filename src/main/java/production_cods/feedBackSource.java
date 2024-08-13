package production_cods;
public class feedBackSource {
    public  boolean PositiveFeedBack(String pos)
    {
        if(pos.equals("Excellent")||pos.equals("good")||pos.equals("Medium"))
        {
            return  true;
        }
        else
        {
            return false;
        }
    }
    public  boolean negativeFeedBack(String neg)

    {
        if(neg.equals("poor")||neg.equals("very bad"))
        {
            return  true;
        }
        else
        {
            return false;
        }
    }
}

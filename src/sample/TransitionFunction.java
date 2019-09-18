package sample;


public class TransitionFunction
{
    String VN="";
    String VT="";
    String Result;

    TransitionFunction(String VN,String VT,String result) {
        this.VN=VN;
        this.VT=VT;
        this.Result=result;
    }
    @Override
    public String toString()
    {
        return ("b("+VN+","+VT+")="+Result);
    }
}

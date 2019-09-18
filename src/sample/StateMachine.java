package sample;


import java.util.ArrayList;
import java.util.List;

public class StateMachine
{
    private List<String> Q=new ArrayList<String>();
    private List<String> V=new ArrayList<String>();
    private List<TransitionFunction> transition_functions=new ArrayList<TransitionFunction>();
    private String q0="";
    private List<String> F=new ArrayList<String>();

    public String getQ(int index)
    {
        return Q.get(index);
    }
    public String getV(int index)
    {
        return V.get(index);
    }
    public String getTransactionFunction(int index)
    {
        return transition_functions.get(index).toString();
    }
    public TransitionFunction getTF(int index){return  transition_functions.get(index);}
    public String getF(int index)
    {
        return F.get(index);
    }
    public String getQ0()
    {
        return q0;
    }
    public void setQ0(String s)
    {
        q0 = s;
    }
    public void setQ(String value)
    {
        Q.add(value);
    }
    public void setV(String value)
    {
        V.add(value);
    }
    public void setF(String value)
    {
        F.add(value);
    }
    public void setTransactionFunction(String VN,String VT, String Result) {
        transition_functions.add(new TransitionFunction(VN,VT,Result));
    }
    public int getQLength()
    {
        return Q.size();
    }
    public int getFLength()
    {
        return F.size();
    }
    public int getVLength()
    {
        return V.size();
    }
    public int getTFLength()
    {
        return transition_functions.size();
    }
}

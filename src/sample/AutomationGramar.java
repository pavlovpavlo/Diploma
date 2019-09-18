package sample;

import java.util.ArrayList;
import java.util.List;

public class AutomationGramar
{
    private List<String> VT=new ArrayList<String>();
    private List<String> VN=new ArrayList<String>();
    private List<String> P=new ArrayList<String>();
    private String S;
    public List<String> Steps=new ArrayList<String>();

    public String getVN(int index)
    {
        return VN.get(index);
    }
    public String getVT(int index)
    {
        return VT.get(index);
    }
    public String getP(int index)
    {
        return P.get(index);
    }
    public String getS()
    {
        return S;
    }

    public String getSteps(int i) {
        return Steps.get(i);
    }

    public void setS(String s)
    {
        S = s;
    }
    public void setVT(String value)
    {
        VT.add(value);
    }
    public void setVN(String value)
    {
        VN.add(value);
    }
    public void setP(String value)
    {
        P.add(value);
    }
    public int getIndex(String string) {return P.indexOf(string);}
    public void RemoveP(String value)
    {
        P.remove(value);
    }
    public int getPLength()
    {
        return P.size();
    }
    public int getStepLength()
    {
        return Steps.size();
    }
    public int getVNLength()
    {
        return VN.size();
    }
    public int getVTLength()
    {
        return VT.size();
    }
}

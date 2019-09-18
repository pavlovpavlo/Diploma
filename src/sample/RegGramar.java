package sample;

import java.util.ArrayList;
import java.util.List;

public class RegGramar
{
    private List<String> VT=new ArrayList<String>();
    private List<String> VN=new ArrayList<String>();
    private List<String> P=new ArrayList<String>();
    private String S;

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
    public int getPLength()
    {
        return P.size();
    }
    public int getVNLength()
    {
        return VN.size();
    }
    public int getVTLength()
    {
        return VT.size();
    }
    public boolean IsTerminal(String value) {
        for (String symbol:VT)
            if(symbol.equals(value))
                return true;
    return false;
    }
    public boolean IsNotTerminal(String value) {
        for (String symbol:VN)
            if(symbol.equals(value))
                return true;
        return false;
    }
}

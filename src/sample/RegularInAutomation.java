package sample;

import java.util.ArrayList;
import java.util.List;

import static sample.Controller.regGramar;

public class RegularInAutomation
{
    String[] S=new String[]{"S","Q","W","E","R","T","Y","U","I","O","P","L","K","J","H","G","F","D","A","M","N","B","C","X","Z"
            ,"S0","Q0","W0","E0","R0","T0","Y0","U0","I0","O0","P0","L0","K0","J0","H0","G0","F0","D0","A0","M0","N0","B0","C0","X0","Z0"};
    int index=1;
    List<String> list;
    static AutomationGramar automationGramar= new AutomationGramar();
    public void Step_One()
    {
        automationGramar=new AutomationGramar();
        automationGramar.Steps.add("ПЕРЕТВОРЕННЯ РЕГУЛЯРНОЇ ГРАМАТИКИ В АВТОМАТНУ:");
       for(int i = 0; i< regGramar.getVNLength(); i++)
       {
         automationGramar.setVN(regGramar.getVN(i));
       }
        for(int i = 0; i< regGramar.getVTLength(); i++)
        {
            automationGramar.setVT(regGramar.getVT(i));
        }
        automationGramar.setS(regGramar.getS());
    }
    public void Step_Two()
    {
        automationGramar.Steps.add("КРОК 2:");
        for(int i=0;i<regGramar.getPLength();i++)
        {

             list= new ArrayList<String>();
            String value=regGramar.getP(i).substring(2);
            System.out.println(value);
            String first=String.valueOf(regGramar.getP(i).charAt(0));
           final int length=value.length();
            if(!(value.length()==0)&&regGramar.IsTerminal(Character.toString(value.charAt(0))))
            {
                if(value.length()>1)
                {
                    value = firstTerminal(value);
                    index++;
                    if(value.length()>2)
                    {
                        for (int x = 0; x < length-2; x++)
                        {
                            value = firstNotTerminal(value);
                            index++;
                        }
                        automationGramar.Steps.add("Перенесення правила "+first+"="+value+" до множини правил автоматної граматики");
                        automationGramar.setP(first + "=" + value);
                        for(String s:list)
                        {
                            automationGramar.Steps.add("Перенесення правила "+s+" до множини правил автоматної граматики");
                            automationGramar.setP(s);
                        }
                    }
                    else
                    {
                        automationGramar.Steps.add("Перенесення правила "+first+"="+value+" до множини правил автоматної граматики");
                        automationGramar.setP(first+"="+value);
                    }
                }
                else
                {
                    automationGramar.Steps.add("Перенесення правила "+first+"="+value+" до множини правил автоматної граматики");
                    automationGramar.setP(first+"="+value);
                }
            }
            else
                if(!(value.length()==0)&&regGramar.IsNotTerminal(Character.toString(value.charAt(0))))
            {
                if(value.length()>2)
                {
                    for (int z = 0; z < length-2; z++)
                    {
                        value = firstNotTerminal(value);
                        index++;
                    }
                    automationGramar.Steps.add("Перенесення правила "+first+"="+value+" до множини правил автоматної граматики");
                    automationGramar.setP(first + "=" + value);
                    for(String string:list)
                    {
                        automationGramar.setP(string);
                        automationGramar.Steps.add("Перенесення правила "+string+" до множини правил автоматної граматики");
                    }
                }
                else
                {
                    automationGramar.setP(first+"="+value);
                    automationGramar.Steps.add("Перенесення правила "+first+"="+value+" до множини правил автоматної граматики");
                }
            }
            else
                {
                    automationGramar.Steps.add("Перенесення правила "+first+"="+value+" до множини правил автоматної граматики");
                    automationGramar.setP(first+"="+value);
                }
        }
    }
    public String firstTerminal(String value)
    {
        if(!regGramar.IsNotTerminal(S[index])&&!regGramar.IsTerminal(S[index]))
        {
            list.add(S[index]+"="+value.substring(0,1));
            automationGramar.setVN(S[index]);
            automationGramar.Steps.add("Заміна правила "+ value+" на правило "+S[index]+value.substring(1));
            return S[index]+value.substring(1);
        }
        else
        {
            index++;
            return firstTerminal(value);
        }
    }
    public String firstNotTerminal(String value)
    {
        if(!regGramar.IsNotTerminal(S[index])&&!regGramar.IsTerminal(S[index]))
        {
            list.add(S[index]+"="+value.substring(0,S[index-1].length()+1));
            automationGramar.setVN(S[index]);
            automationGramar.Steps.add("Заміна правила "+ value+" на правило "+S[index]+value.substring(S[index-1].length()+1));
            return S[index]+value.substring(S[index-1].length()+1);
        }
        else
        {
            index++;
            return firstNotTerminal(value);
        }
    }
    public void Step_Three()
    {
       Three_Step();
        /*for(String s:automationGramar.Steps)System.out.println(s);
        automationGramar.setS(regGramar.getS());
       for (int i=0;i<automationGramar.getPLength();i++) System.out.println(automationGramar.getP(i));*/

    }

    public boolean Three_Step()
    {
        automationGramar.Steps.add("КРОК 3:");
        boolean value=false;
        int i=0;
       while(i<automationGramar.getPLength())
        {
            System.out.println("tyt");
         if(automationGramar.getP(i).length()<4&&automationGramar.getP(i).length()>2)
         {
             String  rule= automationGramar.getP(i);
             String symbol=Character.toString(rule.charAt(2));
             if(regGramar.IsNotTerminal(Character.toString(automationGramar.getP(i).charAt(2)))&&!Character.toString(rule.charAt(0)).equals(symbol))
             {
                 System.out.println("tyt");
                 value=true;
                for(int j=0;j<automationGramar.getPLength();j++)
                {
                    System.out.println("tyt");
                  if(Character.toString(automationGramar.getP(j).charAt(0)).equals(symbol))
                  {
                      String s=automationGramar.getP(j);
                      automationGramar.setP(rule.substring(0,2)+automationGramar.getP(j).substring(2));
                      automationGramar.Steps.add("Заміна правила "+ rule +" на правило "+(rule.substring(0,2)+automationGramar.getP(j).substring(2)));
                      automationGramar.Steps.add("Видалення правила "+rule);
                      automationGramar.RemoveP(rule);
                      //automationGramar.Steps.add("Видалення правила "+s);
                      //automationGramar.RemoveP(s);
                      i=-1;
                      j=automationGramar.getIndex(s);
                  }
                }
             }

         }
         else
         if(automationGramar.getP(i).length()==2)
         {
             System.out.println("tyt");
             value=true;
             String  rule= automationGramar.getP(i);
             String symbol=Character.toString(rule.charAt(0));
             if(!Character.toString(automationGramar.getP(i).charAt(0)).equals(automationGramar.getS()))
             for(int j=0;j<automationGramar.getPLength();j++)
             {
                 if(!automationGramar.getP(j).equals(rule)&&Character.toString(automationGramar.getP(j).charAt(2)).equals(symbol) )
                 { System.out.println("tyt");
                     String s=automationGramar.getP(j);
                     automationGramar.setP(s.substring(0,2)+s.charAt(s.length()-1));
                     automationGramar.Steps.add("Заміна правила "+ s +" на правило "+s.substring(0,2)+s.charAt(s.length()-1));
                     automationGramar.Steps.add("Видалення правила "+rule);
                     automationGramar.RemoveP(rule);
                     //automationGramar.Steps.add("Видалення правила "+s);
                     //automationGramar.RemoveP(s);
                     i=-1;
                     j=automationGramar.getIndex(s);
                 }
             }
         }
         i++;
        }
        return value;
    }
}

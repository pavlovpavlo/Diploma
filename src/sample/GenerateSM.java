package sample;


import static sample.Controller.regGramar;

public class GenerateSM
{
    public static StateMachine stateMachine=new StateMachine();
    AutomationGramar automationGramar= RegularInAutomation.automationGramar;
    public void Step_One()
    {
        stateMachine = new StateMachine();

        automationGramar.Steps.add("ПЕРЕТВОРЕННЯ АВТОМАТНОЇ ГРАМАТИКИ В СКІНЧЕННИЙ АВТОМАТ:");
        automationGramar.Steps.add("КРОК 1:");
        stateMachine.setQ("H");
       for(int i=0;i<automationGramar.getVNLength();i++)
       {
           stateMachine.setQ(automationGramar.getVN(i));
       }
    }
    public void Step_Two()
    {
        for(int i=0;i<automationGramar.getVTLength();i++)
        {
            stateMachine.setV(automationGramar.getVT(i));
        }
    }
    public void Step_Three()
    {
        automationGramar.Steps.add("КРОК 3:");
        for(int i=0;i<automationGramar.getPLength();i++)
        {
            String value=automationGramar.getP(i);
           if(value.length()>3)
           {
               automationGramar.Steps.add("Додавання правила переходу "+"( "+Character.toString(value.charAt(2))+","+Character.toString(value.charAt(3))+")="+Character.toString(value.charAt(0)));
               stateMachine.setTransactionFunction(Character.toString(value.charAt(2)),Character.toString(value.charAt(3)),Character.toString(value.charAt(0)));
           }
           if(value.length()<4&& value.length()>2&& !regGramar.IsNotTerminal(Character.toString(value.charAt(2))))
            {
                automationGramar.Steps.add("Додавання правила переходу "+"( "+"H"+","+Character.toString(value.charAt(2))+")="+Character.toString(value.charAt(0)));
                stateMachine.setTransactionFunction("H",Character.toString(value.charAt(2)),Character.toString(value.charAt(0)));
            }

        }
        for (int j=0;j<stateMachine.getTFLength();j++) System.out.println(stateMachine.getTransactionFunction(j));
    }
    public void Step_Four()
    {
        stateMachine.setF(automationGramar.getS());
    }
    public void Step_Five()
    {
        stateMachine.setQ0("H");
    }
}

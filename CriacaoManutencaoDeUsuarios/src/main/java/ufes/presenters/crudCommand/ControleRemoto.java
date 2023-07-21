package ufes.presenters.crudCommand;

public class ControleRemoto {
    private ICrudCommand command;
    
    public void setCommand(ICrudCommand command){
        this.command = command;
    }
    
    public void pressionarBotao(){
        this.command.execute();
    }
}

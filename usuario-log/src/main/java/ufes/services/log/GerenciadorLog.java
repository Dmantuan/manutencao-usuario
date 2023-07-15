package ufes.services.log;

import ufes.models.Log;

public class GerenciadorLog {
    public static void salvarLog(ILog tipoLog, Log log ){
        tipoLog.salvarLog(log);
    }
}

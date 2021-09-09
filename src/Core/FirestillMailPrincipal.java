/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Comunicacion.ClienteSMTP;
import Comunicacion.MailVerificationThread;
import Interfaces.IEmailEventListener;
import Utils.ComandoFirestill;
import java.util.List;
import Utils.Email;



public class FirestillMailPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MailVerificationThread mail = new MailVerificationThread();
        
        mail.setEmailEventListener(new IEmailEventListener() {
            @Override
            public void onReceiveEmailEvent(List<Email> emails) {
                
//                ClienteSMTP mensajero= new ClienteSMTP();
//                mensajero.enviarMensaje("nath.1475369@gmail.com", "mensaje de prueba dentro si recibio");
                
                
                ComandoFirestill comandoFirestill= new ComandoFirestill();
                for (Email email : emails) {
//                    NegocioEmpleado negocioEmpleado= new NegocioEmpleado();
//                    if(negocioEmpleado.obtenerEmpleado(email.getFrom())!=null){
//                        comandoFirestill.ejecutarComando(email.getFrom(), email.getSubject());
//                    }
                    
                    comandoFirestill.ejecutarComando(email.getFrom(), email.getSubject());
                }
                
                
            }
        });
        
        Thread thread = new Thread(mail);
        thread.setName("Mail Verification Thread");
        thread.start();
    }
    
}

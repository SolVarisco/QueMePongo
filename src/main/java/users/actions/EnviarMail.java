package users.actions;

import services.AlertaMetoerologica;
import users.User;

public class EnviarMail implements Action{
  private MailSender mailSender;

  public EnviarMail(MailSender mailSender) {
    this.mailSender = mailSender;
  }

  @Override
  public void ejecutar(User user, AlertaMetoerologica alerta) {
    mailSender.send(user.getMail(), armarMail(alerta));
  }

  private String armarMail(AlertaMetoerologica alerta) {
    return "Buenos dias! Desde el equipo de Que Me Pongo queremos informarle que hoy hay "
        + alerta.toString();
  }
}

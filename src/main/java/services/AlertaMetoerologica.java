package services;

public enum AlertaMetoerologica {
  GRANIZO () {
    public String mensaje() {
      return "Esta granizando, evite salir en auto";
    }
  },
  LLUVIA() {
    public String mensaje() {
      return "Esta lloviendo, si va a salir, hagalo con paraguas";
    }
  };

  public abstract String mensaje();
}

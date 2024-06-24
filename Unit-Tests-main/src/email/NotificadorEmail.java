package email;

public class NotificadorEmail {
    private EmailCliente emailCliente;

    public NotificadorEmail(EmailCliente emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void notificar(String direccion, String mensaje) {
        // Lógica para enviar una notificación por correo
        emailCliente.enviarCorreo(direccion, mensaje);
    }

    // Método adicional para demostrar más funcionalidad si es necesario
    public void notificarAAdministradores(String mensaje) {
        emailCliente.enviarCorreo("admin1@example.com", mensaje);
        emailCliente.enviarCorreo("admin2@example.com", mensaje);
    }
}


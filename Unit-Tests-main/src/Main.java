import email.EmailCliente;
import email.NotificadorEmail;
import email.SmtpEmailCliente;

public class Main {

        public static void main(String[] args) {
            // Crear instancia de EmailCliente concreto (ej. SmtpEmailCliente)
            EmailCliente emailCliente = new SmtpEmailCliente();

            // Instanciar NotificadorEmail con la implementación concreta de EmailCliente
            NotificadorEmail notificador = new NotificadorEmail(emailCliente);

            // Ejemplo de uso: notificar a un usuario específico
            String direccionDestino = "sebas@gmail.com";
            String mensaje = "Hola, esta es una prueba.";

            notificador.notificar(direccionDestino, mensaje);

            // Ejemplo adicional: notificar a administradores
            String mensajeAdmin = "Este es un mensaje para los admin.";
            notificador.notificarAAdministradores(mensajeAdmin);
        }
    }
package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import email.EmailCliente;
import email.NotificadorEmail;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class NotificadorEmailTest {

    @Mock
    private EmailCliente emailClienteMock;

    @Test
    public void testNotificar() {
        // Arrange
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);

        // Act
        notificador.notificar("Sebas@gmail.com", "Hola Mundo");

        // Assert
        verify(emailClienteMock).enviarCorreo("Sebas@gmail.com", "Hola Mundo");
    }

    @Test
    public void testNotificarConDireccionVacia() {
        // Arrange
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);

        // Act
        notificador.notificar("", "Mensaje");

        // Assert
        verify(emailClienteMock, never()).enviarCorreo(anyString(), anyString());
    }

    @Test
    public void testNotificarConMensajeNulo() {
        // Arrange
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);

        // Act
        notificador.notificar("sebas@gmail.com", null);


    }


    @Test
    public void testNotificarConMensajeVacio() {
        // Arrange
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);

        // Act
        notificador.notificar("ejemplo@test.com", "");

        // Assert
        verify(emailClienteMock).enviarCorreo("ejemplo@test.com", "");
    }
}

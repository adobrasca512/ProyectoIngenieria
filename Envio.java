package ProyectoIngenieria;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Envio {
	private Comprascliente compras;
	String productos;
	double precios;
	String mensaje;
	private Accesos_Clientes datos;
	private Date date;
    private String correo;
	public Envio(String mensaje,String correo) {
		super();
		this.date = new Date();
		this.mensaje = mensaje;
		this.productos = productos;
		this.precios = precios;
		this.datos = new Accesos_Clientes(null, null, null, null, null, 0, 0, null);
		this.compras = new Comprascliente(null, null, null, 0, 0, null, null);
        this.correo=correo;
	}

	public void enviarMail() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		// Origen
		final String fromEmail = "juicedeliciosa@gmail.com";
		final String password = "contrasenia123";
		// destino
		String toEmail = this.correo;

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		try {

			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(toEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			compras.getCarrito();
			compras.getCarritoprecio();

			msg.setSubject("Mensaje de Facturacion de Juice Delicio S.A");

			for (int i = 0; i < compras.getCarrito().size() && i < compras.getCarritoprecio().size(); i++) {
				mensaje += "" + compras.enviomensaje(0) + "\n";
			}

			mensaje += "\n\n Gracias por seleccionarnos!";
			msg.setText(mensaje);
			Transport.send(msg);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("El correo introducido no es valido.");
		}

	}
}

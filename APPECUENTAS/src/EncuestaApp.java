import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncuestaApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelCards;

    public EncuestaApp() {
        setTitle("Aplicación de Encuesta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        panelCards = new JPanel(cardLayout);

        // Pantalla selección de encuesta
        JPanel panelSeleccion = new JPanel();
        JLabel lblSeleccion = new JLabel("Selecciona una encuesta:");
        JButton btnEncuesta1 = new JButton("Encuesta 1");
        JButton btnEncuesta2 = new JButton("Encuesta 2");

        btnEncuesta1.addActionListener(e -> mostrarEncuesta("Encuesta 1"));
        btnEncuesta2.addActionListener(e -> mostrarEncuesta("Encuesta 2"));

        panelSeleccion.add(lblSeleccion);
        panelSeleccion.add(btnEncuesta1);
        panelSeleccion.add(btnEncuesta2);

        // Añadir panel de selección al panel de tarjetas
        panelCards.add(panelSeleccion, "Seleccion");

        // Añadir el panel de tarjetas a la ventana principal
        add(panelCards);
    }

    private void mostrarEncuesta(String encuesta) {
        // Panel para la encuesta
        JPanel panelEncuesta = new JPanel();
        panelEncuesta.setLayout(new BoxLayout(panelEncuesta, BoxLayout.Y_AXIS));

        JLabel lblPregunta1 = new JLabel("¿Cuál es tu deporte favorito?");
        JTextField txtRespuesta1 = new JTextField(20);
        JLabel lblPregunta2 = new JLabel("¿Cuál es tu videojuego favorito");
        JTextField txtRespuesta2 = new JTextField(20);

        JButton btnEnviar = new JButton("Enviar Respuestas");
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String respuesta1 = txtRespuesta1.getText();
                String respuesta2 = txtRespuesta2.getText();
                JOptionPane.showMessageDialog(null,
                        "Gracias por participar en " + encuesta + "!\n" +
                                "Tus respuestas:\n" +
                                "1. " + respuesta1 + "\n" +
                                "2. " + respuesta2);
                cardLayout.show(panelCards, "Seleccion");
            }
        });

        panelEncuesta.add(lblPregunta1);
        panelEncuesta.add(txtRespuesta1);
        panelEncuesta.add(lblPregunta2);
        panelEncuesta.add(txtRespuesta2);
        panelEncuesta.add(btnEnviar);

        // Añadir el panel de encuesta al panel de tarjetas
        panelCards.add(panelEncuesta, "Encuesta");
        cardLayout.show(panelCards, "Encuesta");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EncuestaApp app = new EncuestaApp();
            app.setVisible(true);
        });
    }
}

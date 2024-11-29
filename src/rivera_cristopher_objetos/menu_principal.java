/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rivera_cristopher_objetos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author river
 */
public class menu_principal {
    private static String[] usuarios = new String[100];
    private static String[] contraseñas = new String[100];
    private static int contadorUsuarios = 0;
    
    private static String[] nombresRanking = new String[100];
    private static int[] victoriasRanking = new int[100];
    private static int contadorRanking = 0;

    // Constructor del juego (ya lo tienes)
    public menu_principal() {
         // Código de tu juego
    }

    // Clase del Menú Principal
    public static class MenuPrincipal {
        public MenuPrincipal() {
            JFrame menuVentana = new JFrame("Menú Principal");
            menuVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menuVentana.setSize(300, 300);
            menuVentana.setLayout(null);

            // Botn Jugar X-0
            JButton botonJugar = new JButton("Jugar X-0");
            botonJugar.setBounds(80, 20, 140, 30);
            botonJugar.addActionListener(e -> {
                menuVentana.dispose(); 
                new juego(); 
            });
            menuVentana.add(botonJugar);

            // Boton Ranking
            JButton botonRanking = new JButton("Ranking");
            botonRanking.setBounds(80, 60, 140, 30);
            botonRanking.addActionListener(e -> JOptionPane.showMessageDialog(menuVentana, "Ranking seleccionado"));
            menuVentana.add(botonRanking);

            // Botón Cerrar Sesión
            JButton botonCerrarSesion = new JButton("Cerrar Sesión");
            botonCerrarSesion.setBounds(80, 100, 140, 30);
            botonCerrarSesion.addActionListener(e -> {
                menuVentana.dispose(); // Cierra el menú principal
                new InicioSesion(); // Vuelve a la ventana de inicio de sesión
            });
            menuVentana.add(botonCerrarSesion);

            // Botón Salir
            JButton botonSalir = new JButton("Salir");
            botonSalir.setBounds(80, 140, 140, 30);
            botonSalir.addActionListener(e -> System.exit(0));
            menuVentana.add(botonSalir);

            menuVentana.setLocationRelativeTo(null);
            menuVentana.setVisible(true);
        }
    }

    // Clase de Inicio de Sesión
    public static class InicioSesion {
        private JFrame ventanaInicio;

        public InicioSesion() {
            ventanaInicio = new JFrame("Iniciar Sesión");
            ventanaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventanaInicio.setSize(300, 250);
            ventanaInicio.setLayout(null);

            JLabel etiquetaUsuario = new JLabel("Usuario:");
            etiquetaUsuario.setBounds(30, 30, 80, 30);
            ventanaInicio.add(etiquetaUsuario);

            JTextField campoUsuario = new JTextField();
            campoUsuario.setBounds(110, 30, 150, 30);
            ventanaInicio.add(campoUsuario);

            JLabel etiquetaContraseña = new JLabel("Contraseña:");
            etiquetaContraseña.setBounds(30, 70, 80, 30);
            ventanaInicio.add(etiquetaContraseña);

            JPasswordField campoContraseña = new JPasswordField();
            campoContraseña.setBounds(110, 70, 150, 30);
            ventanaInicio.add(campoContraseña);

            JButton botonIniciarSesion = new JButton("Iniciar Sesión");
            botonIniciarSesion.setBounds(30, 120, 120, 30);
            botonIniciarSesion.addActionListener(e -> {
                String usuario = campoUsuario.getText();
                String contraseña = new String(campoContraseña.getPassword());

                if (validarUsuario(usuario, contraseña)) {
                    ventanaInicio.dispose();
                    new MenuPrincipal();
                } else {
                    JOptionPane.showMessageDialog(ventanaInicio, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            ventanaInicio.add(botonIniciarSesion);

            // Botón Crear Cuenta
            JButton botonCrearCuenta = new JButton("Crear Cuenta");
            botonCrearCuenta.setBounds(160, 120, 120, 30);
            botonCrearCuenta.addActionListener(e -> {
                ventanaInicio.dispose();
                new CrearCuenta(); // Abre la ventana de registro
            });
            ventanaInicio.add(botonCrearCuenta);

            ventanaInicio.setLocationRelativeTo(null);
            ventanaInicio.setVisible(true);
        }

        private boolean validarUsuario(String usuario, String contraseña) {
            for (int i = 0; i < contadorUsuarios; i++) {
                if (usuarios[i].equals(usuario) && contraseñas[i].equals(contraseña)) {
                    return true;
                }
            }
            return false;
        }
    }

    // Clase para Crear Cuenta
    public static class CrearCuenta {
    private JFrame ventanaCrearCuenta;

    public CrearCuenta() {
        ventanaCrearCuenta = new JFrame("Crear Cuenta");
        ventanaCrearCuenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaCrearCuenta.setSize(300, 300);
        ventanaCrearCuenta.setLayout(null);

        JLabel etiquetaUsuario = new JLabel("Nuevo Usuario:");
        etiquetaUsuario.setBounds(30, 30, 100, 30);
        ventanaCrearCuenta.add(etiquetaUsuario);

        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(140, 30, 120, 30);
        ventanaCrearCuenta.add(campoUsuario);

        JLabel etiquetaContraseña = new JLabel("Nueva Contraseña:");
        etiquetaContraseña.setBounds(30, 70, 120, 30);
        ventanaCrearCuenta.add(etiquetaContraseña);

        JPasswordField campoContraseña = new JPasswordField();
        campoContraseña.setBounds(140, 70, 120, 30);
        ventanaCrearCuenta.add(campoContraseña);

        JLabel etiquetaConfirmar = new JLabel("Confirmar Contraseña:");
        etiquetaConfirmar.setBounds(30, 110, 140, 30);
        ventanaCrearCuenta.add(etiquetaConfirmar);

        JPasswordField campoConfirmar = new JPasswordField();
        campoConfirmar.setBounds(140, 110, 120, 30);
        ventanaCrearCuenta.add(campoConfirmar);

        JButton botonRegistrar = new JButton("Registrar");
        botonRegistrar.setBounds(80, 160, 120, 30);
        botonRegistrar.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String contraseña = new String(campoContraseña.getPassword());
            String confirmar = new String(campoConfirmar.getPassword());

            if (usuario.isEmpty() || contraseña.isEmpty() || confirmar.isEmpty()) {
                JOptionPane.showMessageDialog(ventanaCrearCuenta, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!contraseña.equals(confirmar)) {
                JOptionPane.showMessageDialog(ventanaCrearCuenta, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (usuarioYaExiste(usuario)) {
                JOptionPane.showMessageDialog(ventanaCrearCuenta, "El usuario ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                registrarUsuario(usuario, contraseña);
                JOptionPane.showMessageDialog(ventanaCrearCuenta, "Cuenta creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                ventanaCrearCuenta.dispose();
                new InicioSesion(); // Regresa a la ventana de inicio de sesión
            }
        });
        ventanaCrearCuenta.add(botonRegistrar);

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(80, 200, 120, 30);
        botonCancelar.addActionListener(e -> {
            ventanaCrearCuenta.dispose();
            new InicioSesion(); // Regresa a la ventana de inicio de sesión
        });
        ventanaCrearCuenta.add(botonCancelar);

        ventanaCrearCuenta.setLocationRelativeTo(null);
        ventanaCrearCuenta.setVisible(true);
    }

    private boolean usuarioYaExiste(String usuario) {
        // Verifica si el usuario ya está registrado
        for (int i = 0; i < contadorUsuarios; i++) {
            if (usuarios[i].equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    private void registrarUsuario(String usuario, String contraseña) {
        // Agrega el nuevo usuario a las listas de usuarios y contraseñas
        usuarios[contadorUsuarios] = usuario;
        contraseñas[contadorUsuarios] = contraseña;
        contadorUsuarios++; // Incrementa el contador de usuarios registrados
    }
}
    public static void main(String[] args) {
        new InicioSesion(); // Inicio del programa
    }
    
    public static class Ranking {
        public static void registrarVictoria(String jugador) {
            int index = buscarJugadorEnRanking(jugador);
            if (index == -1) { // Si no está en el ranking, agregarlo
                nombresRanking[contadorRanking] = jugador;
                victoriasRanking[contadorRanking] = 1;
                contadorRanking++;
            } else { // Si ya está, incrementar las victorias
                victoriasRanking[index]++;
            }
        }

        public static void mostrarRanking(JFrame parent) {
            // Ordenar el ranking usando un algoritmo básico como burbuja
            for (int i = 0; i < contadorRanking - 1; i++) {
                for (int j = 0; j < contadorRanking - i - 1; j++) {
                    if (victoriasRanking[j] < victoriasRanking[j + 1]) {
                        // Intercambiar victorias
                        int tempVictorias = victoriasRanking[j];
                        victoriasRanking[j] = victoriasRanking[j + 1];
                        victoriasRanking[j + 1] = tempVictorias;

                        // Intercambiar nombres
                        String tempNombre = nombresRanking[j];
                        nombresRanking[j] = nombresRanking[j + 1];
                        nombresRanking[j + 1] = tempNombre;
                    }
                }
            }

            // Crear el mensaje del ranking
            StringBuilder mensaje = new StringBuilder("Ranking de Jugadores:\n\n");
            for (int i = 0; i < contadorRanking; i++) {
                mensaje.append((i + 1)).append(". ").append(nombresRanking[i]).append(": ").append(victoriasRanking[i]).append(" victorias\n");
            }

            JOptionPane.showMessageDialog(parent, mensaje.toString(), "Ranking", JOptionPane.INFORMATION_MESSAGE);
        }

        private static int buscarJugadorEnRanking(String jugador) {
            for (int i = 0; i < contadorRanking; i++) {
                if (nombresRanking[i].equals(jugador)) {
                    return i;
                }
            }
            return -1; // No encontrado
        }
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Clase Vehiculo
class Vehiculo {
    private String placa;
    private String modelo;
    private String color;

    // Constructor
    public Vehiculo(String placa, String modelo, String color) {
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
    }

    // Métodos get y set
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

// Subclase Motocicleta
class Motocicleta extends Vehiculo {
    private String tipoMoto;

    // Constructor
    public Motocicleta(String placa, String modelo, String color, String tipoMoto) {
        super(placa, modelo, color);
        this.tipoMoto = tipoMoto;
    }

    // Métodos get y set
    public String getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(String tipoMoto) {
        this.tipoMoto = tipoMoto;
    }
}

public class Main {
    // Método para conectar a la base de datos MySQL
    public static Connection connectToDatabase() {
        Connection connection = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar a la base de datos
            String url = "jdbc:mysql://localhost:3306/nombre_base_de_datos";
            String user = "usuario";
            String password = "contraseña";
            connection = DriverManager.getConnection(url, user, password);

            System.out.println("Conexión a la base de datos establecida con éxito.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

        return connection;
    }

    public static void main(String[] args) {
        // Crear una instancia de Motocicleta
        Motocicleta moto = new Motocicleta("ABC123", "Yamaha", "Rojo", "Deportiva");

        // Conectar a la base de datos
        Connection connection = connectToDatabase();

        // Lógica adicional para usar la base de datos aquí

        // Cerrar la conexión a la base de datos
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión a la base de datos cerrada con éxito.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
        }
    }
}

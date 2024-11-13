import java.util.Random;
import java.util.Scanner;

public class StarWarsGame {

    // Constantes del juego
    static final int BOARD_SIZE = 10;
    static final int MAX_LIVES = 3;
    static final int NUM_ENEMIES = 5;
    static final int NUM_WALLS = 5;
    static final int NUM_POTIONS = 5;

    // Símbolos utilizados en el juego
    static final char EMPTY_CELL = 'L';
    static final char WALL = 'M';
    static final char YODA = 'Y';
    static final char VADER = 'V';
    static final char DARTH_MAUL = 'D';
    static final char R2D2 = 'R';
    static final char FINAL_CELL = 'F';
    static final char POTION = 'P';

    // Variables de los jugadores
    static String player1Name = "Yoda";
    static String player2Name = "Darth Vader";
    static char player1Symbol = YODA;
    static char player2Symbol = VADER;

    static int player1X, player1Y;
    static int player2X, player2Y;
    static int player1Lives = MAX_LIVES;
    static int player2Lives = MAX_LIVES;

    static boolean player1HasPotion = false;
    static boolean player2HasPotion = false;

    // Tableros de los jugadores
    static char[][] board1 = new char[BOARD_SIZE][BOARD_SIZE];
    static char[][] board2 = new char[BOARD_SIZE][BOARD_SIZE];

    // Enemigos de cada jugador
    static char player1Enemy = DARTH_MAUL;
    static char player2Enemy = R2D2;

    // Objetos para entrada y generación aleatoria
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        // Inicializar los tableros
        initializeBoard(board1, player1Symbol, player1Enemy);
        initializeBoard(board2, player2Symbol, player2Enemy);

        boolean gameOver = false;

        while (!gameOver) {
            // Turno del jugador 1
            System.out.println("\nTablero de " + player1Name + ":");
            printBoard(board1);
            playerMove(player1Name, board1, player1Symbol, player1Enemy);
            if (checkWin(player1X, player1Y)) {
                System.out.println("¡" + player1Name + " ha llegado a la casilla final y gana el juego!");
                break;
            }
            if (player1Lives <= 0) {
                System.out.println(player1Name + " ha perdido todas sus vidas. ¡" + player2Name + " gana el juego!");
                break;
            }

            // Turno del jugador 2
            System.out.println("\nTablero de " + player2Name + ":");
            printBoard(board2);
            playerMove(player2Name, board2, player2Symbol, player2Enemy);
            if (checkWin(player2X, player2Y)) {
                System.out.println("¡" + player2Name + " ha llegado a la casilla final y gana el juego!");
                break;
            }
            if (player2Lives <= 0) {
                System.out.println(player2Name + " ha perdido todas sus vidas. ¡" + player1Name + " gana el juego!");
                break;
            }
        }
    }

    static void initializeBoard(char[][] board, char playerSymbol, char enemySymbol) {
        // Rellenar el tablero con celdas vacías
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }

        // Colocar la casilla final
        board[BOARD_SIZE - 1][BOARD_SIZE - 1] = FINAL_CELL;

        // Colocar al jugador en una posición aleatoria
        int x, y;
        do {
            x = random.nextInt(BOARD_SIZE);
            y = random.nextInt(BOARD_SIZE);
        } while (board[x][y] != EMPTY_CELL);

        board[x][y] = playerSymbol;

        // Guardar la posición inicial del jugador
        if (playerSymbol == player1Symbol) {
            player1X = x;
            player1Y = y;
        } else {
            player2X = x;
            player2Y = y;
        }

        // Colocar enemigos
        for (int i = 0; i < NUM_ENEMIES; i++) {
            int ex, ey;
            do {
                ex = random.nextInt(BOARD_SIZE);
                ey = random.nextInt(BOARD_SIZE);
            } while (board[ex][ey] != EMPTY_CELL);
            board[ex][ey] = enemySymbol;
        }

        // Colocar muros
        for (int i = 0; i < NUM_WALLS; i++) {
            int wx, wy;
            do {
                wx = random.nextInt(BOARD_SIZE);
                wy = random.nextInt(BOARD_SIZE);
            } while (board[wx][wy] != EMPTY_CELL);
            board[wx][wy] = WALL;
        }

        // Colocar pócimas
        placePotions(board);
    }

    static void placePotions(char[][] board) {
        for (int i = 0; i < NUM_POTIONS; i++) {
            int px, py;
            do {
                px = random.nextInt(BOARD_SIZE);
                py = random.nextInt(BOARD_SIZE);
            } while (board[px][py] != EMPTY_CELL);
            board[px][py] = POTION;
        }
    }

    static void printBoard(char[][] board) {
        System.out.print("  ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void playerMove(String playerName, char[][] board, char playerSymbol, char enemySymbol) {
        int playerX = (playerSymbol == player1Symbol) ? player1X : player2X;
        int playerY = (playerSymbol == player1Symbol) ? player1Y : player2Y;
        int playerLives = (playerSymbol == player1Symbol) ? player1Lives : player2Lives;
        boolean playerHasPotion = (playerSymbol == player1Symbol) ? player1HasPotion : player2HasPotion;

        System.out.println("\nTurno de " + playerName + ". Vidas: " + playerLives);

        // Opción de teletransportarse si el jugador tiene una pócima
        if (playerHasPotion) {
            System.out.println("Tienes una pócima. Puedes teletransportarte a cualquier casilla libre ('L'). ¿Deseas usarla? (S/N):");
            String usePotion = scanner.nextLine().toUpperCase().trim();
            if (usePotion.equals("S")) {
                teleportPlayer(board, playerSymbol);
                if (playerSymbol == player1Symbol) {
                    player1HasPotion = false;
                } else {
                    player2HasPotion = false;
                }
                return;
            }
        }

        System.out.println("Ingresa tu movimiento (Número de casillas 1-3 y dirección [W,A,S,D,Q,E,Z,C]):");
        String input = scanner.nextLine().toUpperCase().trim();

        if (input.length() < 2) {
            System.out.println("Entrada inválida. Intenta de nuevo.");
            return;
        }

        int steps;
        try {
            steps = Integer.parseInt(input.substring(0, 1));
            if (steps < 1 || steps > 3) {
                System.out.println("Número de casillas inválido. Debe ser entre 1 y 3.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. El primer carácter debe ser un número (1-3).");
            return;
        }

        char direction = input.charAt(1);
        int dx = 0, dy = 0;

        switch (direction) {
            case 'W': dx = -1; break; // Arriba
            case 'S': dx = 1; break; // Abajo
            case 'A': dy = -1; break; // Izquierda
            case 'D': dy = 1; break; // Derecha
            case 'Q': dx = -1; dy = -1; break; // Diagonal arriba-izquierda
            case 'E': dx = -1; dy = 1; break; // Diagonal arriba-derecha
            case 'Z': dx = 1; dy = -1; break; // Diagonal abajo-izquierda
            case 'C': dx = 1; dy = 1; break; // Diagonal abajo-derecha
            default:
                System.out.println("Dirección inválida. Usa W,A,S,D,Q,E,Z,C.");
                return;
        }

        for (int i = 0; i < steps; i++) {
            int newX = (playerX + dx + BOARD_SIZE) % BOARD_SIZE;
            int newY = (playerY + dy + BOARD_SIZE) % BOARD_SIZE;

            char cell = board[newX][newY];

            if (cell == WALL) {
                System.out.println("Te has encontrado con un muro y no puedes avanzar más en esta dirección.");
                break;
            } else {
                board[playerX][playerY] = EMPTY_CELL;
                playerX = newX;
                playerY = newY;

                if (cell == enemySymbol) {
                    playerLives--;
                    System.out.println("¡Has encontrado un enemigo! Pierdes una vida. Vidas restantes: " + playerLives);
                } else if (cell == FINAL_CELL) {
                    board[playerX][playerY] = playerSymbol;
                    System.out.println("¡Has llegado a la casilla final!");
                    updateGlobalPlayerPosition(playerSymbol, playerX, playerY, playerLives, playerHasPotion);
                    return;
                } else if (cell == POTION) {
                    System.out.println("¡Has encontrado una pócima! Puedes teletransportarte en el próximo turno.");
                    playerHasPotion = true;
                }

                board[playerX][playerY] = playerSymbol;
            }
        }

        updateGlobalPlayerPosition(playerSymbol, playerX, playerY, playerLives, playerHasPotion);
    }

    static void teleportPlayer(char[][] board, char playerSymbol) {
        System.out.println("Ingresa las coordenadas de la casilla libre (L) a la que deseas teletransportarte:");
        int newX = scanner.nextInt();
        int newY = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        if (newX >= 0 && newX < BOARD_SIZE && newY >= 0 && newY < BOARD_SIZE && board[newX][newY] == EMPTY_CELL) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (board[i][j] == playerSymbol) {
                        board[i][j] = EMPTY_CELL;
                    }
                }
            }
            board[newX][newY] = playerSymbol;
            System.out.println("¡Te has teletransportado a la casilla [" + newX + "][" + newY + "]!");
        } else {
            System.out.println("Casilla inválida. Debes elegir una casilla libre (L) dentro del tablero.");
        }
    }

    static void updateGlobalPlayerPosition(char playerSymbol, int x, int y, int lives, boolean hasPotion) {
        if (playerSymbol == player1Symbol) {
            player1X = x;
            player1Y = y;
            player1Lives = lives;
            player1HasPotion = hasPotion;
        } else {
            player2X = x;
            player2Y = y;
            player2Lives = lives;
            player2HasPotion = hasPotion;
        }
    }

    static boolean checkWin(int x, int y) {
        return x == BOARD_SIZE - 1 && y == BOARD_SIZE - 1;
    }
}


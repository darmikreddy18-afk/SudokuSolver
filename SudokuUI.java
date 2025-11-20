import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuUI {

    
    private static final int[][] initialGrid = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    private static int[][] grid = new int[9][9];

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sudoku Solver");
        frame.setSize(600, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(9, 9));
        JTextField[][] cells = new JTextField[9][9];

        
        resetGrid();

       
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new JTextField();
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setFont(new Font("Arial", Font.BOLD, 20));

                if (grid[i][j] != 0) {
                    cells[i][j].setText(String.valueOf(grid[i][j]));
                    cells[i][j].setEditable(false);
                    cells[i][j].setBackground(Color.LIGHT_GRAY);
                }

                panel.add(cells[i][j]);
            }
        }

        
        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
          
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        String text = cells[i][j].getText();
                        grid[i][j] = text.isEmpty() ? 0 : Integer.parseInt(text);
                    }
                }

                if (sudokucode.sudosolver(grid)) {
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            cells[i][j].setText(String.valueOf(grid[i][j]));
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame,
                        "Invalid puzzle! No solution exists.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGrid();
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (grid[i][j] != 0) {
                            cells[i][j].setText(String.valueOf(grid[i][j]));
                            cells[i][j].setEditable(false);
                            cells[i][j].setBackground(Color.LIGHT_GRAY);
                        } else {
                            cells[i][j].setText("");
                            cells[i][j].setEditable(true);
                            cells[i][j].setBackground(Color.WHITE);
                        }
                    }
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(solveButton);
        buttonPanel.add(resetButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    
    private static void resetGrid() {
        for (int i = 0; i < 9; i++) {
            System.arraycopy(initialGrid[i], 0, grid[i], 0, 9);
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlepanel = new JPanel();
    JPanel buttonpanel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean pemain1;


    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        titlepanel.setLayout(new BorderLayout());
        titlepanel.setBounds(10,10,700,100);

        buttonpanel.setLayout(new GridLayout(3,3));
        buttonpanel.setBackground(new Color(150,150,150));

        for (int i=0; i<9; i++){
            buttons[i] = new JButton();
            buttonpanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlepanel.add(textfield);
        frame.add(titlepanel,BorderLayout.NORTH);
        frame.add(buttonpanel);

        gilran();
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        for (int i=0; i<9; i++){
            if (e.getSource()==buttons[i]) {
                if (pemain1){
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("S");
                        pemain1 = false;
                        textfield.setText("O Turn");
                        check();
                    }
                }
                else {
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        pemain1 = true;
                        textfield.setText("S Turn");
                        check();
                    }
                }
            }
        }
    }

    public void gilran(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        if (random.nextInt(2)==0){
            pemain1 = true;
            textfield.setText("S turn");
        }
        else {
            pemain1 = false;
            textfield.setText("O turn");
        }
    }

    public void check(){
        //p1
        if (    (buttons[0].getText()=="S") &&
                (buttons[1].getText()=="S") &&
                (buttons[2].getText()=="S")   ){
            xWins(0,1,2);
        }
        if (    (buttons[3].getText()=="S") &&
                (buttons[4].getText()=="S") &&
                (buttons[5].getText()=="S")   ){
            xWins(3,4,5);
        }
        if (    (buttons[6].getText()=="S") &&
                (buttons[7].getText()=="S") &&
                (buttons[8].getText()=="S")   ){
            xWins(6,7,8);
        }
        if (    (buttons[0].getText()=="S") &&
                (buttons[3].getText()=="S") &&
                (buttons[6].getText()=="S")   ){
            xWins(0,3,6);
        }
        if (    (buttons[1].getText()=="S") &&
                (buttons[4].getText()=="S") &&
                (buttons[7].getText()=="S")   ){
            xWins(1,4,7);
        }
        if (    (buttons[2].getText()=="S") &&
                (buttons[5].getText()=="S") &&
                (buttons[8].getText()=="S")   ){
            xWins(2,5,8);
        }
        if (    (buttons[0].getText()=="S") &&
                (buttons[4].getText()=="S") &&
                (buttons[8].getText()=="S")   ){
            xWins(0,4,8);
        }
        if (    (buttons[2].getText()=="S") &&
                (buttons[4].getText()=="S") &&
                (buttons[6].getText()=="S")   ){
            xWins(2,4,6);
        }

        //p2
        if (    (buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")   ){
            oWins(0,1,2);
        }
        if (    (buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")   ){
            oWins(3,4,5);
        }
        if (    (buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")   ){
            oWins(6,7,8);
        }
        if (    (buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")   ){
            oWins(0,3,6);
        }
        if (    (buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")   ){
            oWins(1,4,7);
        }
        if (    (buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")   ){
            oWins(2,5,8);
        }
        if (    (buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O")   ){
            oWins(0,4,8);
        }
        if (    (buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O")   ){
            oWins(2,4,6);
        }

    }
    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.yellow);
        buttons[b].setBackground(Color.YELLOW);
        buttons[c].setBackground(Color.yellow);

        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("S Win!!!");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.pink);
        buttons[b].setBackground(Color.pink);
        buttons[c].setBackground(Color.pink);

        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O Win!!!");

    }
}

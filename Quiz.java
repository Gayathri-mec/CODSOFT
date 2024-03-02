package codsoft;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Quiz implements ActionListener{
    String [] question={"which company created java?",
                        "which year was java created?",
                        "what java originally called?",
                         "who is credited with creating java "
                       } ;
    String [][] choice={
                    {"sun Microsystem","starbucks","microsoft","Alphabet"},
                     {"1989","1996","1972","1942"},
                    {"apple","latte","Oka","Koffing"},
                    {"streve jobs","bill gates","james gosiling","mark"}

                };
    char[] answers={
            'A','B','C','C'
    };

    char guess;
    char answer;
    int index;
    int correct_guess=0;
    int total_qusetion= question.length;
    int result;
    int seconds=10;
    JFrame frame=new JFrame();
    JTextField textField=new JTextField();
    JTextArea textArea=new JTextArea();
    JButton buttonA= new JButton();
    JButton buttonB= new JButton();
    JButton buttonC= new JButton();
    JButton buttonD= new JButton();
    JLabel ans_lableA=new JLabel();
    JLabel ans_lableB=new JLabel();
    JLabel ans_lableC=new JLabel();
    JLabel ans_lableD=new JLabel();
    JLabel time_lable=new JLabel();
    JLabel seconds_left=new JLabel();
    JTextField number=new JTextField();
    JTextField percentage=new JTextField();

    Timer timer=new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         seconds--;
         seconds_left.setText(String.valueOf(seconds));
         if(seconds<=0){
             displayAnswer();
         }

        }
    });

    public Quiz(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0,0,650,50);
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(0,50,650,50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25,25,25));
        textArea.setForeground(new Color(25,255,0));
        textArea.setFont(new Font("Mv boli",Font.BOLD,25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
        textArea.setText("textarea");

        buttonA.setBounds(0, 100,100,100);
        buttonA.setFont(new Font("Mv boli",Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 200,100,100);
        buttonB.setFont(new Font("Mv boli",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 300,100,100);
        buttonC.setFont(new Font("Mv boli",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 400,100,100);
        buttonD.setFont(new Font("Mv boli",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        ans_lableA.setBounds(125,100,500,100);
        ans_lableA.setBackground(new Color(50,50,50));
        ans_lableA.setForeground(new Color(25,255,0));
        ans_lableA.setFont(new Font("Mv boli",Font.BOLD,35));
        ans_lableA.setText("testing lable A");

        ans_lableB.setBounds(125,200,500,100);
        ans_lableB.setBackground(new Color(50,50,50));
        ans_lableB.setForeground(new Color(25,255,0));
        ans_lableB.setFont(new Font("Mv boli",Font.BOLD,35));
        ans_lableB.setText("testing lable B");

        ans_lableC.setBounds(125,300,500,100);
        ans_lableC.setBackground(new Color(50,50,50));
        ans_lableC.setForeground(new Color(25,255,0));
        ans_lableC.setFont(new Font("Mv boli",Font.BOLD,35));
        ans_lableC.setText("testing lable C");

        ans_lableD.setBounds(125,400,500,100);
        ans_lableD.setBackground(new Color(50,50,50));
        ans_lableD.setForeground(new Color(25,255,0));
        ans_lableD.setFont(new Font("Mv boli",Font.BOLD,35));
        ans_lableD.setText("testing lable D");

        seconds_left.setBounds(535,510,100,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(255,0,0));
        seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_lable.setBounds(535,475,100,25);
        time_lable.setBackground(new Color(50,50,50));
        time_lable.setForeground(new Color(255,0,0));
        time_lable.setFont(new Font("Mv boli",Font.PLAIN,20));
        time_lable.setHorizontalAlignment(JTextField.CENTER);
        time_lable.setText("timer>:D");

        number.setBounds(225,225,200,100);
        number.setBackground(new Color(25,25,25));
        number.setForeground(new Color(25,255,0));
        number.setFont(new Font("Ink Free",Font.BOLD,50));
        number.setBorder(BorderFactory.createBevelBorder(1));
        number.setHorizontalAlignment(JTextField.CENTER);
        number.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("Ink Free",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);


        frame.add(time_lable);
        frame.add(seconds_left);
        frame.add(textField);
        frame.add(textArea);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(ans_lableA);
        frame.add(ans_lableB);
        frame.add(ans_lableC);
        frame.add(ans_lableD);


        frame.setVisible(true);

        nextQuestion();
    }
    public void nextQuestion(){
            if(index>=total_qusetion){
                result();
            }
            else{
                textField.setText("question"+(index+1));
                textArea.setText(question[index]);
                ans_lableA.setText(choice[index][0]);
                ans_lableB.setText(choice[index][1]);
                ans_lableC.setText(choice[index][2]);
                ans_lableD.setText(choice[index][3]);
                timer.start();
            }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
               buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource()==buttonA){
            answer='A';
           if( answer==answers[index]){
               correct_guess++;
           }
        }
        if(e.getSource()==buttonB){
            answer='B';
            if( answer==answers[index]){
                correct_guess++;
            }
        }
        if(e.getSource()==buttonC){
            answer='C';
            if( answer==answers[index]){
                correct_guess++;
            }
        }
        if(e.getSource()==buttonD){
            answer='D';
            if( answer==answers[index]){
                correct_guess++;
            }
        }
        displayAnswer();
    }
    public void displayAnswer(){
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index]!='A'){
            ans_lableA.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='B'){
            ans_lableB.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='C'){
            ans_lableC.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='D'){
            ans_lableD.setForeground(new Color(255,0,0));
        }

        Timer pause=new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ans_lableA.setForeground(new Color(25,255,0));
                ans_lableB.setForeground(new Color(25,255,0));
                ans_lableC.setForeground(new Color(25,255,0));
                ans_lableD.setForeground(new Color(25,255,0));

                answer=' ';
                seconds=10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();

            }
        });
        pause.setRepeats(false);
            pause.start();

    }
    public void result(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result= (int)((correct_guess/(double)total_qusetion)*100);


        textField.setText("Results");
        textArea.setText("");
        ans_lableA.setText("");
        ans_lableB.setText("");
        ans_lableC.setText("");
        ans_lableD.setText("");
       
        number.setText("("+correct_guess+"/"+total_qusetion+")");
        percentage.setText(result+"%");
        
        frame.add(percentage);
        frame.add(number);

    }
    public static void main(String[] args) {
        Quiz quiz=new Quiz();
    }
}
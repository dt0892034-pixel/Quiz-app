package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    // ===================== DATA =====================
    String questions[][] = new String[51][5];
    String answers[][]   = new String[51][2];
    String userAnswers[] = new String[51];

    // ===================== UI COMPONENTS =====================
    JLabel qno, question, timerLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup group;
    JButton next, submit, help;

    // ===================== STATE =====================
    int timer  = 15;
    int count  = 0;
    int score  = 0;
    String name;

    // Swing Timer (correct way — no Thread.sleep in paint!)
    javax.swing.Timer swingTimer;

    // ===================== CONSTRUCTOR =====================
    Quiz(String name) {
        this.name = name;

        setTitle("Java Quiz App");
        setSize(1500, 900);
        setLocation(60, 0);
        setUndecorated(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        loadQuestions();
        loadAnswers();
        setupUI();
        startTimer();
        start(count);

        setVisible(true);
    }

    // ===================== QUESTIONS =====================
    void loadQuestions() {
        questions[0][0] = "Number of primitive data types in Java are?";
        questions[0][1] = "6";
        questions[0][2] = "7";
        questions[0][3] = "8";
        questions[0][4] = "9";

        questions[1][0] = "What is the size of float and double in Java?";
        questions[1][1] = "32 and 64";
        questions[1][2] = "32 and 32";
        questions[1][3] = "64 and 64";
        questions[1][4] = "64 and 32";

        questions[2][0] = "Automatic type conversion is possible in which case?";
        questions[2][1] = "Byte to int";
        questions[2][2] = "Int to Long";
        questions[2][3] = "Long to int";
        questions[2][4] = "Short to int";

        questions[3][0] = "When an array is passed to a method, what does the method receive?";
        questions[3][1] = "The reference of the array";
        questions[3][2] = "A copy of the array";
        questions[3][3] = "Length of the array";
        questions[3][4] = "Copy of first element";

        questions[4][0] = "Arrays in Java are?";
        questions[4][1] = "Object References";
        questions[4][2] = "Objects";
        questions[4][3] = "Primitive data type";
        questions[4][4] = "None";

        questions[5][0] = "When is the object created with new keyword?";
        questions[5][1] = "At run time";
        questions[5][2] = "At compile time";
        questions[5][3] = "Depends on the code";
        questions[5][4] = "None";

        questions[6][0] = "Identify the correct definition of a package.";
        questions[6][1] = "A package is a collection of editing tools";
        questions[6][2] = "A package is a collection of Classes";
        questions[6][3] = "A package is a collection of Classes and interfaces";
        questions[6][4] = "A package is a collection of interfaces";

        questions[7][0] = "compareTo() returns?";
        questions[7][1] = "True";
        questions[7][2] = "False";
        questions[7][3] = "An int value";
        questions[7][4] = "None";

        questions[8][0] = "To which package does the String class belong?";
        questions[8][1] = "java.lang";
        questions[8][2] = "java.awt";
        questions[8][3] = "java.applet";
        questions[8][4] = "java.String";

        questions[9][0] = "Total constructors the String class has?";
        questions[9][1] = "3";
        questions[9][2] = "7";
        questions[9][3] = "13";
        questions[9][4] = "20";

        questions[10][0] = "Which keyword is used to inherit a class in Java?";
        questions[10][1] = "implements";
        questions[10][2] = "extends";
        questions[10][3] = "inherit";
        questions[10][4] = "super";

        questions[11][0] = "Which method is the entry point of a Java program?";
        questions[11][1] = "start()";
        questions[11][2] = "run()";
        questions[11][3] = "main()";
        questions[11][4] = "init()";

        questions[12][0] = "Which package is imported automatically in Java?";
        questions[12][1] = "java.util";
        questions[12][2] = "java.lang";
        questions[12][3] = "java.awt";
        questions[12][4] = "java.io";

        questions[13][0] = "Which operator is used for comparison?";
        questions[13][1] = "=";
        questions[13][2] = "==";
       questions[13][3] = "!=";
        questions[13][4] = "&&";

        questions[14][0] = "Which loop executes at least once?";
        questions[14][1] = "for";
        questions[14][2] = "while";
        questions[14][3] = "do while";
        questions[14][4] = "foreach";

        questions[15][0] = "Which keyword is used to create an object?";
        questions[15][1] = "class";
        questions[15][2] = "new";
        questions[15][3] = "this";
        questions[15][4] = "super";

        questions[16][0] = "Which of these is NOT a Java keyword?";
        questions[16][1] = "static";
        questions[16][2] = "Boolean";
        questions[16][3] = "public";
        questions[16][4] = "class";

        questions[17][0] = "Which keyword is used to stop a loop?";
        questions[17][1] = "exit";
        questions[17][2] = "break";
        questions[17][3] = "stop";
        questions[17][4] = "continue";

        questions[18][0] = "Which exception occurs when dividing by zero?";
        questions[18][1] = "IOException";
        questions[18][2] = "ArithmeticException";
        questions[18][3] = "NullPointerException";
        questions[18][4] = "ArrayIndexOutOfBoundsException";

        questions[19][0] = "Which collection stores unique elements?";
        questions[19][1] = "List";
        questions[19][2] = "Set";
        questions[19][3] = "ArrayList";
        questions[19][4] = "Vector";

        questions[20][0] = "Which keyword is used to define a constant in Java?";
        questions[20][1] = "const";
        questions[20][2] = "final";
        questions[20][3] = "static";
        questions[20][4] = "fixed";

        questions[21][0] = "Which method is used to print output in Java?";
        questions[21][1] = "System.out.println()";
        questions[21][2] = "print()";
        questions[21][3] = "echo()";
        questions[21][4] = "display()";

        questions[22][0] = "Which data type is used to store true or false?";
        questions[22][1] = "int";
        questions[22][2] = "boolean";
        questions[22][3] = "char";
        questions[22][4] = "String";

        questions[23][0] = "Which symbol is used for single line comments?";
        questions[23][1] = "//";
        questions[23][2] = "/*";
        questions[23][3] = "#";
        questions[23][4] = "<!--";

        questions[24][0] = "Which loop is best when the number of iterations is known?";
        questions[24][1] = "while";
        questions[24][2] = "for";
        questions[24][3] = "do while";
        questions[24][4] = "switch";

        questions[25][0] = "Which keyword is used to implement interfaces?";
        questions[25][1] = "implements";
        questions[25][2] = "extends";
        questions[25][3] = "inherit";
        questions[25][4] = "interface";

        questions[26][0] = "Which class is used to take keyboard input?";
        questions[26][1] = "Scanner";
        questions[26][2] = "Input";
        questions[26][3] = "Reader";
        questions[26][4] = "Buffer";

        questions[27][0] = "Which package contains the Scanner class?";
        questions[27][1] = "java.util";
        questions[27][2] = "java.io";
        questions[27][3] = "java.lang";
        questions[27][4] = "java.awt";

        questions[28][0] = "Which keyword is used to handle exceptions?";
        questions[28][1] = "catch";
        questions[28][2] = "try";
        questions[28][3] = "throw";
        questions[28][4] = "throws";

        questions[29][0] = "Which keyword is used to exit a method?";
        questions[29][1] = "break";
        questions[29][2] = "return";
        questions[29][3] = "continue";
        questions[29][4] = "exit";

        questions[30][0] = "Which keyword is used to define a class in Java?";
        questions[30][1] = "define";
        questions[30][2] = "class";
        questions[30][3] = "object";
        questions[30][4] = "new";

        questions[31][0] = "Which operator is used for logical AND?";
        questions[31][1] = "&";

        questions[31][2] = "&&";
        questions[31][3] = "||";
        questions[31][4] = "!";

        questions[32][0] = "Which method is used to compare two Strings?";
        questions[32][1] = "compare()";
        questions[32][2] = "equals()";
        questions[32][3] = "match()";
        questions[32][4] = "same()";

        questions[33][0] = "Which access modifier allows access everywhere?";
        questions[33][1] = "private";
        questions[33][2] = "protected";
        questions[33][3] = "public";
        questions[33][4] = "default";

        questions[34][0] = "Which keyword refers to the current object?";
        questions[34][1] = "this";
        questions[34][2] = "super";
        questions[34][3] = "self";
        questions[34][4] = "current";

        questions[35][0] = "Which class is the parent of all Java classes?";
        questions[35][1] = "Main";
        questions[35][2] = "Object";
        questions[35][3] = "Class";
        questions[35][4] = "Parent";

        questions[36][0] = "Which keyword is used to inherit a class?";
        questions[36][1] = "implements";
        questions[36][2] = "extends";
        questions[36][3] = "inherit";
        questions[36][4] = "using";

        questions[37][0] = "Which of these is NOT a loop in Java?";
        questions[37][1] = "for";
        questions[37][2] = "repeat";
        questions[37][3] = "while";
        questions[37][4] = "do while";

        questions[38][0] = "Which exception occurs when an array index is invalid?";
        questions[38][1] = "IOException";
        questions[38][2] = "ArithmeticException";
        questions[38][3] = "ArrayIndexOutOfBoundsException";
        questions[38][4] = "NullPointerException";

        questions[39][0] = "Which package contains ArrayList?";
        questions[39][1] = "java.util";
        questions[39][2] = "java.lang";
        questions[39][3] = "java.io";
        questions[39][4] = "java.awt";

        questions[40][0] = "Which keyword is used to create an interface?";
        questions[40][1] = "class";
        questions[40][2] = "interface";
        questions[40][3] = "extends";
        questions[40][4] = "implements";

        questions[41][0] = "Which method is used to find the length of a String?";
        questions[41][1] = "size()";
        questions[41][2] = "length()";
        questions[41][3] = "count()";
        questions[41][4] = "getLength()";

        questions[42][0] = "Which symbol is used to end a statement in Java?";
        questions[42][1] = ".";
        questions[42][2] = ";";
        questions[42][3] = ":";
        questions[42][4] = ",";

        questions[43][0] = "Which keyword is used to call a superclass constructor?";
        questions[43][1] = "this";
        questions[43][2] = "super";
        questions[43][3] = "extends";
        questions[43][4] = "parent";

        questions[44][0] = "Which keyword is used to prevent method overriding?";
        questions[44][1] = "final";
        questions[44][2] = "static";
        questions[44][3] = "private";
        questions[44][4] = "protected";

        questions[45][0] = "Which collection allows duplicate elements?";
        questions[45][1] = "Set";
        questions[45][2] = "HashSet";
        questions[45][3] = "List";
        questions[45][4] = "TreeSet";

        questions[46][0] = "Which method converts a String to an integer?";
        questions[46][1] = "Integer.parseInt()";
        questions[46][2] = "Integer.value()";
        questions[46][3] = "String.toInt()";
        questions[46][4] = "parseInteger()";

        questions[47][0] = "Which keyword is used to throw an exception?";
        questions[47][1] = "throw";
        questions[47][2] = "throws";
        questions[47][3] = "try";
        questions[47][4] = "catch";

        questions[48][0] = "Which loop is used to iterate over arrays and collections?";
        questions[48][1] = "while";
        questions[48][2] = "for-each";
        questions[48][3] = "do while";
        questions[48][4] = "switch";

        questions[49][0] = "Which company originally developed Java?";
        questions[49][1] = "Microsoft";
        questions[49][2] = "Sun Microsystems";
        questions[49][3] = "Google";
        questions[49][4] = "Apple";

        questions[50][0] = "Which method is called automatically when a Java program starts?";
        questions[50][1] = "run()";
        questions[50][2] = "start()";
        questions[50][3] = "main()";
        questions[50][4] = "init()";
    }

    // ===================== ANSWERS =====================
    void loadAnswers() {
        answers[0][1]  = "8";
        answers[1][1]  = "32 and 64";
        answers[2][1]  = "Byte to int";
        answers[3][1]  = "The reference of the array";
        answers[4][1]  = "Objects";
        answers[5][1]  = "At run time";
        answers[6][1]  = "A package is a collection of Classes and interfaces";
        answers[7][1]  = "An int value";
        answers[8][1]  = "java.lang";
        answers[9][1]  = "13";
        answers[10][1] = "extends";
        answers[11][1] = "main()";
        answers[12][1] = "java.lang";
        answers[13][1] = "==";
        answers[14][1] = "do while";
        answers[15][1] = "new";
        answers[16][1] = "Boolean";
        answers[17][1] = "break";
        answers[18][1] = "ArithmeticException";
        answers[19][1] = "Set";
        answers[20][1] = "final";
        answers[21][1] = "System.out.println()";
        answers[22][1] = "boolean";
        answers[23][1] = "//";
        answers[24][1] = "for";
        answers[25][1] = "implements";
        answers[26][1] = "Scanner";
        answers[27][1] = "java.util";
        answers[28][1] = "try";
        answers[29][1] = "return";
        answers[30][1] = "class";
        answers[31][1] = "&&";
        answers[32][1] = "equals()";
        answers[33][1] = "public";
        answers[34][1] = "this";
        answers[35][1] = "Object";
        answers[36][1] = "extends";
        answers[37][1] = "repeat";
        answers[38][1] = "ArrayIndexOutOfBoundsException";
        answers[39][1] = "java.util";
        answers[40][1] = "interface";
        answers[41][1] = "length()";
        answers[42][1] = ";";
        answers[43][1] = "super";
        answers[44][1] = "final";
        answers[45][1] = "List";
        answers[46][1] = "Integer.parseInt()";
        answers[47][1] = "throw";
        answers[48][1] = "for-each";
        answers[49][1] = "Sun Microsystems";
        answers[50][1] = "main()";
    }

    // ===================== UI SETUP =====================
    void setupUI() {
        // Top image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ICONS.png"));
        JLabel img = new JLabel(i1);
        img.setBounds(0, 0, 1450, 450);
        add(img);

        // Question number label
        qno = new JLabel();
        qno.setBounds(150, 450, 80, 30);
        qno.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        add(qno);

        // Question text label
        question = new JLabel();
        question.setBounds(200, 450, 1000, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(question);

        // Timer label (FIX: use JLabel instead of painting on Graphics)
        timerLabel = new JLabel("Time left - 15 seconds");
        timerLabel.setBounds(1100, 480, 350, 35);
        timerLabel.setFont(new Font("Dialog", Font.BOLD, 25));
        timerLabel.setForeground(Color.RED);
        add(timerLabel);

        // Radio buttons
        opt1 = new JRadioButton();
        opt1.setBounds(180, 500, 800, 35);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 22));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(180, 550, 800, 35);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 22));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(180, 600, 800, 35);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 22));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(180, 650, 800, 35);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 22));
        add(opt4);

        // Button group
        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        // Next button
        JButton next = new JButton("Next");
        next.setBounds(1300, 750, 100, 35);
        next.setBackground(new Color(22, 99, 54));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        this.next = next;

        // Submit button
        JButton submit = new JButton("Submit");
        submit.setBounds(1150, 750, 100, 35);
        submit.setBackground(new Color(255, 215, 0));
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);
        this.submit = submit;

        // Help button
        JButton help = new JButton("Help");
        help.setBounds(980, 750, 100, 35);
        help.setBackground(new Color(22, 99, 54));
        help.setForeground(Color.WHITE);
        help.addActionListener(this);
        add(help);
        this.help = help;
    }

    // ===================== TIMER (FIX: use Swing Timer) =====================
    void startTimer() {
        timer = 15;
        swingTimer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer--;
                if (timer > 0) {
                    timerLabel.setText("Time left - " + timer + " seconds");
                } else {
                    timerLabel.setText("Time up!!");
                    swingTimer.stop();
                    saveAnswerAndMoveNext();
                }
            }
        });
        swingTimer.start();
    }

    // ===================== SAVE ANSWER AND MOVE TO NEXT QUESTION =====================
    void saveAnswerAndMoveNext() {
        if (group.getSelection() == null) {
            userAnswers[count] = "";
        } else {
            userAnswers[count] = group.getSelection().getActionCommand();
        }

        if (count == 50) {
            doSubmit();
        } else {
            count++;
            start(count);
            timer = 15;
            swingTimer.restart();
        }
    }

    // ===================== START QUESTION =====================
    public void start(int count) {
        qno.setText((count + 1) + ".");
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt1.setEnabled(true);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt2.setEnabled(true);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt3.setEnabled(true);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        opt4.setEnabled(true);

        group.clearSelection();
        help.setEnabled(true);
        timerLabel.setText("Time left - 15 seconds");
        timerLabel.setForeground(Color.RED);

        if (count == 50) {
            next.setEnabled(false);
            submit.setEnabled(true);
        } else {
            next.setEnabled(true);
            submit.setEnabled(false);
        }
    }

    // ===================== CALCULATE SCORE AND SHOW RESULT =====================
    void doSubmit() {
        swingTimer.stop();

        score = 0;
        for (int i = 0; i < 51; i++) {
            if (userAnswers[i] != null && userAnswers[i].equals(answers[i][1])) {
                score++;
            }
        }

        setVisible(false);
        new Score(name, score);
    }

    // ===================== ACTION LISTENER =====================
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            // Save current answer
            if (group.getSelection() == null) {
                userAnswers[count] = "";
            } else {
                userAnswers[count] = group.getSelection().getActionCommand();
            }

            // Move to next question
            if (count < 50) {
                count++;
                start(count);
                timer = 15;
                swingTimer.restart();
            }

        } else if (e.getSource() == help) {
            // 50-50 lifeline logic
            String correct = answers[count][1];
            int correctOpt = 0;
            if (correct.equals(questions[count][1])) correctOpt = 1;
            else if (correct.equals(questions[count][2])) correctOpt = 2;
            else if (correct.equals(questions[count][3])) correctOpt = 3;
            else if (correct.equals(questions[count][4])) correctOpt = 4;

            // Disable two wrong options
            int disabled = 0;
            if (correctOpt != 1 && disabled < 2) { opt1.setEnabled(false); disabled++; }
            if (correctOpt != 2 && disabled < 2) { opt2.setEnabled(false); disabled++; }
            if (correctOpt != 3 && disabled < 2) { opt3.setEnabled(false); disabled++; }
            if (correctOpt != 4 && disabled < 2) { opt4.setEnabled(false); disabled++; }

            help.setEnabled(false);

        } else if (e.getSource() == submit) {
            // Save answer for last question
            if (group.getSelection() == null) {
                userAnswers[count] = "";
            } else {
                userAnswers[count] = group.getSelection().getActionCommand();
            }

            // Final submission
            doSubmit();
        }
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Quiz("User"));
    }
}
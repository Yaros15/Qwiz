import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final String ANSWER_PROPERTY = "Ответить";
    private static final String NEXT_PROPERTY = "Следующий";
    private static final String NEW_GAME_PROPERTY = "Новая игра";
    private static final String DESCRIPTION = "Отгадайте имена 10 персонажей из Гарри Поттера";
    private static final String CORRECTLY = "Правильно";
    private static final String WRONG = "Неправильно";
    private static final String RESULT_TEMPLATE = "Ваш результат: %d из %d";
    private JLabel label;
    private JTextField textField;
    private JButton buttonAnswer, buttonNext, buttonNewGame;
    private Task riddle;
    private String question, answer;
    private int rand, correctly, total;

    public MainWindow() {
        super("Harry_Potter");
        this.setBounds(100, 100, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void go() {
        label = new JLabel(DESCRIPTION);
        textField = new JTextField("", 10);
        buttonAnswer = new JButton(ANSWER_PROPERTY);
        buttonNext = new JButton(NEXT_PROPERTY);
        buttonNewGame = new JButton(NEW_GAME_PROPERTY);
        buttonAnswer.setVisible(false);
        buttonNext.setVisible(false);
        setLayout(new GridLayout(5, 1, 2, 2));

        add(label);
        add(textField);
        add(buttonAnswer);
        add(buttonNext);
        add(buttonNewGame);
        buttonAnswer.addActionListener(e -> {
            if (answer.equalsIgnoreCase(textField.getText())) {
                correctly++;
                label.setText(CORRECTLY);
            } else {
                label.setText(WRONG);
            }
            total++;
            buttonAnswer.setVisible(false);
            buttonNext.setVisible(true);
        });
        buttonNext.addActionListener(e -> {
            if (total < 10) {
                rand = (int) (Math.random() * riddle.getRiddle().size());
                question = riddle.getRiddle().get(rand).getQuestion();
                answer = riddle.getRiddle().get(rand).getAnswer();
                riddle.removeRiddle(rand);
                label.setText(question);
                textField.setText(null);
                buttonAnswer.setVisible(true);
                buttonNext.setVisible(false);
            } else {
                buttonAnswer.setVisible(false);
                buttonNext.setVisible(false);
                buttonNewGame.setVisible(true);
                String result = String.format(RESULT_TEMPLATE,correctly, total);
                textField.setText(result);
                label.setText(DESCRIPTION);
            }
        });
        buttonNewGame.addActionListener(e -> {
            riddle = new Task();
            buttonNewGame.setVisible(false);
            rand = (int) (Math.random() * riddle.getRiddle().size());
            question = riddle.getRiddle().get(rand).getQuestion();
            answer = riddle.getRiddle().get(rand).getAnswer();
            riddle.removeRiddle(rand);
            label.setText(question);
            buttonAnswer.setVisible(true);
            textField.setText(null);
            correctly = 0;
            total = 0;
        });
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow b = new MainWindow();
        b.go();
    }
}

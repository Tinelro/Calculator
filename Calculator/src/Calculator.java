import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextLayout;

public class Calculator extends Frame {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image i = toolkit.getImage("logo_Java.png");

        TextLayout tl = new TextLayout("AWT Calculator", new Font("Georgia",
                Font.BOLD | Font.ITALIC, 20), g2.getFontRenderContext());
        tl.draw(g2, 20, 50);

        g2.drawImage(i, 30, 70, 150, 150, this);
        g2.drawImage(i, 520, 70, 150, 150, this);
    }

    public static void main(String[] args) {

        Calculator f = new Calculator();

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        GridBagLayout gridBagLayout = new GridBagLayout();
        f.setLayout(gridBagLayout);

        GridBagConstraints c = new GridBagConstraints();

        Label l1 = new Label("First number:");
        c.gridx = 0;
        c.gridy = 4;
        f.add(l1, c);

        Label l2 = new Label("Operation:");
        c.gridx = 1;
        c.gridy = 4;
        f.add(l2, c);

        Label l3 = new Label("Second number:");
        c.gridx = 2;
        c.gridy = 4;
        f.add(l3, c);

        TextField f1 = new TextField(12);
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(10, 10, 10, 10);
        f.add(f1, c);

        Choice op = new Choice();
        c.gridx = 1;
        c.gridy = 5;
        op.add("");
        op.add("+");
        op.add("-");
        op.add("*");
        op.add("/");
        f.add(op, c);

        TextField f2 = new TextField(12);
        c.gridx = 2;
        c.gridy = 5;
        f.add(f2, c);


        Button button = new Button("CALCULATE");
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 5;
        c.fill = GridBagConstraints.BOTH;
        f.add(button, c);


        TextField f3 = new TextField("Welcome to Java AWT calculator!", 10);
        c.gridx = 0;
        c.gridy = 9;
        f.add(f3, c);

        button.addActionListener(e -> {
            try {
                Double.parseDouble(f1.getText());
                Double.parseDouble(f2.getText());
            } catch (NumberFormatException exc) {
                f3.setText("You must insert two numbers!");
            }

            if (op.getSelectedItem().equals("")) {
                f3.setText("Choose an operation!");
            }

            if (op.getSelectedItem().equals("+")) {
                f3.setText(String.valueOf(Double.parseDouble(f1.getText()) + Double.parseDouble(f2.getText())));
            }

            if (op.getSelectedItem().equals("-")) {
                f3.setText(String.valueOf(Double.parseDouble(f1.getText()) - Double.parseDouble(f2.getText())));
            }

            if (op.getSelectedItem().equals("*")) {
                f3.setText(String.valueOf(Double.parseDouble(f1.getText()) * Double.parseDouble(f2.getText())));
            }

            if (op.getSelectedItem().equals("/")) {
                if ((Double.parseDouble(f2.getText())) != 0) {
                    f3.setText(String.valueOf(Double.parseDouble(f1.getText()) / Double.parseDouble(f2.getText())));
                } else {
                    f3.setText("Division by zero not allowed!");
                }
            }

        });


        f.setSize(700, 300);
        f.setVisible(true);

    }

}

package palindrome;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Palindrome
{
    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();
    final JTextField field = new JTextField();
    private final JButton test = new JButton("Test this word");
    private final JLabel label = new JLabel();

    private final JMenuBar bar = new JMenuBar();
    private final JMenu fileMenu = new JMenu("File");
    private final JMenu aboutMenu = new JMenu("About");
    private final JMenuItem exit = new JMenuItem("Exit");
    private final JMenuItem cs2420 = new JMenuItem("CS 2420");

    private final Stack<Character> stack = new Stack<Character>();
    private final Queue<Character> queue = new ListQueue<Character>();
    private boolean isPalindrome = false;
    private boolean awesome = false;
    private String fieldText = "";

    public void init()
    {
        field.setColumns(20);
        frame.setLocation(400, 300);
        frame.setSize(400, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Palindrome Tester");
        frame.setResizable(false);
        panel.setLayout(new FlowLayout());

        fileMenu.add(exit);
        bar.add(fileMenu);

        aboutMenu.add(cs2420);
        bar.add(aboutMenu);

        panel.add(field);
        panel.add(test);
        panel.add(label, BorderLayout.SOUTH);
        frame.add(panel);

        frame.setJMenuBar(bar);
        frame.setVisible(true);

        addActions();
    }

    protected void testForPalindrome(String text)
    {
        fieldText = text;
        fieldText = fieldText.toLowerCase().replaceAll(" ", "").replaceAll("\\W", "");
        if (fieldText.equals("starwars"))
        {
            awesome = true;
        }
        char[] palindrome = fieldText.toCharArray();
        for (int i = 0; i < palindrome.length; i++)
        {
            char palindromeChar = palindrome[i];
            stack.push(palindromeChar);
            queue.enqueue(palindromeChar);
        }

        isPalindrome = isTextPalindrome();
    }

    private boolean isTextPalindrome()
    {
        for (int i = 0; i < stack.size(); i++)
        {
            if (stack.pop() != queue.dequeue())
            {
                return false;
            }
        }
        return true;
    }

    void displayResults()
    {
        String text = field.getText();
        if (isPalindrome)
        {
            label.setText("\"" + text + "\"" + " is a palindrome!");
        }
        else if (awesome)
        {
            label.setText("Why, that's the greatest thing ever!");
        }
        else
        {
            label.setText("\"" + text + "\"" + " is NOT a palindrome!");
        }
        resetFields();
    }

    void resetFields()
    {
        awesome = false;
        field.setText("");
        field.requestFocus();
        stack.clear();
        queue.clear();
    }

    private void addActions()
    {
        exit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        cs2420.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                showImage();
            }
        });
        test.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                testForPalindrome(field.getText());
                displayResults();
            }
        });
        field.addKeyListener(new KeyListener()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_ENTER)
                {
                    testForPalindrome(field.getText());
                    displayResults();
                }
                if (keyCode == KeyEvent.VK_ESCAPE)
                {
                    System.exit(0);
                }
            }

            @Override
            public void keyTyped(KeyEvent e)
            {
                // unused
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                // unused
            }
        });
    }

    protected void showImage()
    {
        Icon icon = new ImageIcon(getClass().getResource("/images/slcc.png"));
        JOptionPane.showMessageDialog(null, "Palindrome Assignment\nTrevyn Mace", "CS 2420", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public boolean isPalindrome()
    {
        return isPalindrome;
    }

    public void setPalindrome(boolean isPalindrome)
    {
        this.isPalindrome = isPalindrome;
    }
}
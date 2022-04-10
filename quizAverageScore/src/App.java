import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

//to add my gui later
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App extends JFrame implements ActionListener  {
//global Variables listed as they appear
    static ArrayList<Integer> scores=new ArrayList<>();
    static int total;
    static int score;
    static char[] letterGrade = {'A', 'B', 'C', 'D', 'F'};
//swing declarations
    JFrame f;
    JTextField resultTF, scoresTF, gradeTF;
    JButton[] btn = new JButton[5];
    JButton addBtn, avgBtn, resetBtn, exitBtn;
    Font myFont = new Font("Ink Free",Font.BOLD,18);
    JPanel panel;
    
    App(){
        //Frame specification
        f = new JFrame("Average Exam Score");//must initialize frame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit from app
        f.setTitle("Average Exam Score");//set text of label
        f.setSize(540, 550); //sets (x-dimension y-dimension)
        f.setLayout(null); 
        f.getContentPane().setBackground(Color.black);
        f.setForeground(Color.white);

        // TextField Initialization
        resultTF = new JTextField();
        gradeTF = new JTextField();
        gradeTF.setBounds(220,100,50,50);
        gradeTF.setFont(myFont);
        gradeTF.setEditable(true);
        
        scoresTF = new JTextField();
        scoresTF.setBounds(50,200,400,50);
        scoresTF.setFont(myFont);
        scoresTF.setEditable(false);
        
        resultTF.setBounds(50,300,400,100);
        resultTF.setFont(myFont);
        resultTF.setEditable(false);
        //btn Initialization
        addBtn = new JButton("Add Score");
        avgBtn = new JButton("Average");
        resetBtn = new JButton("Reset");
        exitBtn = new JButton("Exit");
        //btn dimensions/position
        addBtn.setBounds(50,430,100,50);
		avgBtn.setBounds(150,430,100,50);
		resetBtn.setBounds(250,430,100,50);
        exitBtn.setBounds(350,430,100,50);
        btn[0] = addBtn;
        btn[1] = avgBtn;
        btn[2] = resetBtn;
        btn[3] = exitBtn;
        //I could not bare to write for each 
        //btn so i for looped it!
        for(int i=0; i<4; i++) {
            btn[i].addActionListener(this);
            btn[i].setFont(myFont);
            btn[i].setFocusable(false);
        }
        //added to frame
        f.add(resultTF);
        f.add(scoresTF);
        f.add(gradeTF);
        f.add(addBtn);
        f.add(avgBtn);
        f.add(resetBtn);
        f.add(exitBtn);
        f.setVisible(true); //makes f visible default hidden
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
            App myApp = new App();
        // a forloop to obtain user input for the ArrayList
        // Integer score;
        boolean valid = true;
        do{
        for(int i =1; i<=10; i++){
            System.out.println("Enter your final 10 test scores or 999 to exit:\n ");
            String scoreString= scan.nextLine();
            try {
            Integer score= Integer.parseInt(scoreString);
            if (score == 999){
            break;    
            }else{valid = true;}
            scores.add(score);  
    
            }catch (Exception e) {
            System.out.println("Please enter a valid Integer: ");
            scores.add(score);  
        } 
    }        
    }while(valid==false);
          //for loop to obtain total from the ArrayList
          for(int s=0; s<scores.size();s++){
             total+=scores.get(s); 
          }
          //Testing for average score
         Integer avgScore =total/10;
         System.out.println("\nYour average score will be: \n\n" + avgScore + "%, due to the scores of:\n\n" + scores);
         //logic of the grading system  
         if(avgScore >=90 && avgScore <= 100){
             System.out.print("\nYou Have earned an:\n\n " + letterGrade[0]);
         }else if(avgScore >=89){
              System.out.print("\nYou Have earned a:\n\n " + letterGrade[1]);
          }else if(avgScore >=70){
              System.out.print("\nYou Have earned a:\n\n "  + letterGrade[2]);
          }else if(avgScore >=60||avgScore ==69){
              System.out.print("\nYou Have earned a:\n\n " + letterGrade[3]);
          }else if(avgScore <= 59){
              System.out.print("\nYou Have earned a:\n\n " + letterGrade[4]);
          }else{
              System.out.println("Please Enter Valid Scores ");
          }
        //   System.out.println(scores);
        scan.close(); //prevent leakage   
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //   if(e.getSource() ) {
            //     System.out.println();
        }
      }



        
  



  
  


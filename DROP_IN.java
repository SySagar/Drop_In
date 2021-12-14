import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
public class DROP_IN extends JFrame 
{
    int i=1;
    int counter;
    int k=3;
    int start=0;  
    int color_val=0;
    int color_code=0;
    Graphics gh;
    int c=0,down=50;
    boolean play;
    Timer timer;
    public DROP_IN()
    {
        setTitle("DROP IN");        
        setSize(1100,700);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton b =new JButton("O");
        add(b);
        b.setVisible(true);
        b.setBounds(540,400,50,50);
        
        JPanel p= new JPanel();
        p.setBounds(0,0,1100,700);
        p.setBackground(Color.black);
        p.setVisible(true);
        add(p);
        
        b.addMouseListener(mouseHandler);
        b.addActionListener(al);
        timer = new Timer(0,al);
    
    }
        public ActionListener al= new ActionListener()        
        {
            public void actionPerformed(ActionEvent e)
            {
               timer.start();

                if(down<270)
               {Dot(down);  
               down++;
               
               try{
                   Thread.sleep(k);
                }
                catch(Exception er){};
                
                if(counter>2*i)
                {
                    if(k>1)
                    k--;
                    i++;
                    }

            }
            else
            {
                if(color_val==color_code)
                 {gh.setColor(Color.red);
                 gh.drawString("GOT IT !!!",150,500);
                 String w="";
                 counter++;
                 w=w+counter;
                 gh.setColor(Color.black);
                 gh.fillRect(222,325,50,100);   
                 gh.setColor(Color.red);
                 gh.drawString(w,230,350);
                 
                }
                else
                {
                    
                 gh.setColor(Color.red);
                 gh.drawString("MISSED !!!",880,500);
                 counter--;
                 String w="";               
                 w=w+counter;
                 gh.setColor(Color.black);
                 gh.fillRect(222,325,50,100);   
                 gh.setColor(Color.red);
                 gh.drawString(w,230,350);
                 
                 if(counter<=0)
                 {play=false;
                 JFrame f= new JFrame();  
                 Font font=new Font(Font.SERIF,Font.BOLD,25);
                 JDialog jd = new JDialog(f , "Warning!", true);
                 JLabel la =new JLabel("Game Over!" ); 
                 la.setBounds(40,20,160, 100); 
                 la.setFont(font);
                 jd.add(la);       
                 jd.setLayout(null);    
                 jd.setSize(250,200);    
 
                 Toolkit tool=Toolkit.getDefaultToolkit();
                 Dimension di=tool.getScreenSize();
                 int xcor=(di.width-jd.getWidth())/2;
                 int ycor=(di.height-jd.getHeight())/2;
                 jd.setLocation(xcor,ycor);
                 
                 jd.setVisible(true); 
                 
                }
                 
                }
                 
                 try{
                 Thread.sleep(550);}
                 catch(Exception e1){};
                 
                 gh.setColor(Color.black);
                 gh.fillRect(840,450,200,60);   
                 gh.setColor(Color.black);
                 gh.fillRect(100,450,200,100);   
                 gh.setColor(Color.black);
                 gh.fillOval(550,269,50,50);
                 if(play)
               down=0;
               else
               timer.stop();
         int q=5;      
        while(q>3)
        {q=(int)(Math.random()*10);
        if(q==0)
        color_code=1;
        if(q==1)
        color_code=2;
        if(q==2)
        color_code=3;
        if(q==3)
        color_code=4;}
            }
            
            
            }
        };
    
    
    public void rotator(int c)
    {
        if(c==1)
        {
        gh.setColor(Color.yellow);
        gh.fillRect(400,400,50,50);

        gh.setColor(Color.green);
        gh.fillRect(550,320,50,50);
        
        gh.setColor(Color.blue);
        gh.fillRect(700,400,50,50);
        
        gh.setColor(Color.red);
        gh.fillRect(550,530,50,50);
    }
        if(c==2)
        {
        gh.setColor(Color.green);
        gh.fillRect(400,400,50,50);

        gh.setColor(Color.blue);
        gh.fillRect(550,320,50,50);
        
        gh.setColor(Color.red);
        gh.fillRect(700,400,50,50);
        
        gh.setColor(Color.yellow);
        gh.fillRect(550,530,50,50);
        
        }
        if(c==3)
        {
        gh.setColor(Color.blue);
        gh.fillRect(400,400,50,50);

        gh.setColor(Color.red);
        gh.fillRect(550,320,50,50);
        
        gh.setColor(Color.yellow);
        gh.fillRect(700,400,50,50);
        
        gh.setColor(Color.green);
        gh.fillRect(550,530,50,50);
        }
        if(c==4)
        {
        gh.setColor(Color.red);
        gh.fillRect(400,400,50,50);

        gh.setColor(Color.yellow);
        gh.fillRect(550,320,50,50);
        
        gh.setColor(Color.green);
        gh.fillRect(700,400,50,50);
        
        gh.setColor(Color.blue);
        gh.fillRect(550,530,50,50);
        }
        
        if(c==1)
        color_val=1; 
         if(c==2)
        color_val=2; 
         if(c==3)
        color_val=3; 
         if(c==4)
        color_val=4; 
        
    }
    
    public void Dot(int x)
    {
        gh.setColor(Color.black);
        gh.fillOval(550,x-1,50,50);
        
        
        if(color_code==1)
        gh.setColor(Color.green);
        gh.fillOval(550,x,50,50);
        if(color_code==2)
        gh.setColor(Color.blue);
        gh.fillOval(550,x,50,50);
        if(color_code==3)
        gh.setColor(Color.red);
        gh.fillOval(550,x,50,50);
        if(color_code==4)
        gh.setColor(Color.yellow);
        gh.fillOval(550,x,50,50);
        
    }
    
    public MouseListener mouseHandler=new MouseAdapter()
        {
            public void mouseExited(MouseEvent m)
            {   
                play=false;
                counter=0;
            }
            
            public void mousePressed(MouseEvent m)
            {   
                play=true;
                c++; 
                if(c==5)
                c=1;
                rotator(c);
                
                if(start==0)
                {
                    int q=(int)(Math.random()*10);
        if(q<=2)
        color_code=1;
        if(q>2 && q<=5)
        color_code=2;
        if(q>5 && q<=7)
        color_code=3;
        if(q>7 && q<=9)
        color_code=4;
                }
                
                start++;
            }

        };

    public void paint(Graphics g)
    {   super.paint(g);
        
        Font f=new Font("",Font.ITALIC,46);
        g.setFont(f);
        g.setColor(Color.green);
        g.drawString("DROP IN",70,150);
        f=new Font("",Font.ITALIC,30);
        g.setColor(Color.white);
        g.setFont(f);
        g.drawString("SCORE - ",90,350);
        g.setColor(Color.red);
        g.drawString("0",230,350);
        gh=g.create();
        
    }

   
    
}
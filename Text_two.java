//package cmy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class TransJFrame{
    private JFrame frame = new JFrame("翻译小程序1.0");
    private JTextArea input1 = new JTextArea(4,10);
    private JTextArea input2 = new JTextArea(4,10);
    private JLabel tip = new JLabel("请输入你想要翻译的内容");
    private JPanel pan =new JPanel();
    private JButton but1 = new JButton("翻译");//定义四个按钮
    private JButton but2 = new JButton("清除");
    private JButton but3 = new JButton("添加");
    private JButton but4 = new JButton("中->英");
    private boolean langFlag = false;       //英->中 ==true  中->英 ==false
    private Text_one mytrans = new Text_one();
    public TransJFrame() {
        jieMian();
        kuaiJiejian();//设置快捷键
        frame.setLayout(null);
        but1.addActionListener(new ActionListener() {//翻译的监听
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==but1){
                    input2.setText(null);   //显示前先清空
                    getInput();
                }
            }
        });
        but2.addActionListener(new ActionListener() {//清除界面的监听
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==but2){
                    input1.setText(null);
                    input2.setText(null);
                }
            }
        });
        but3.addActionListener(new ActionListener() {//添加的监听
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==but3){
                    getAdd();
                }
            }
        });
        but4.addActionListener(new ActionListener() {//模式选择的监听
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==but4){
                    if("中->英".equals(but4.getText())) {
                        but4.setText("英->中");
                        langFlag = true;
                    }else {
                        but4.setText("中->英");
                        langFlag = false;
                    }
                    but4.repaint();
                }
            }
        });
        frame.addWindowListener(new WindowAdapter() {//窗口的监听
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        tip.setBounds(100,5,200,20);
        input1.setBounds(90,30,200,100);
        pan.setBounds(0,140,1000,40);
        input2.setBounds(90,190,200,100);
        frame.add(tip);
        frame.add(input1);
        frame.add(pan);
        frame.add(input2);
        frame.setVisible(true);
    }
    public void jieMian(){
        //Container cont = frame.getContentPane();
        Icon i=new ImageIcon("图片1.jpg");
        JLabel lb = new JLabel(i);
        lb.setBounds(0, 0,i.getIconWidth(),i.getIconHeight());
        //创建背景
        this.frame.getLayeredPane().add(lb, new Integer (Integer.MIN_VALUE));
        JPanel pl= (JPanel) this.frame.getContentPane();
        pl.setOpaque(false);
        pan.setOpaque(false);
        pan.setLayout(new FlowLayout());

        pan.add(but1);
        pan.add(but2);
        pan.add(but3);
        pan.add(but4);
        frame.setSize(i.getIconWidth(),i.getIconHeight()); // 设置成图片大小

    }
    public String setorgetText(){//得到输入的要翻译的东西
        if(input1.getText()!=null){
            return input1.getText();
        }else{
            return "wrong!";
        }
    }
    public void getInput(){//得到输入的要翻译的东西
        String str = this.setorgetText();//得到输入的要翻译的东西
        if(str=="wrong!"){
            System.out.println("请输入您要查询的东西");
        }else{
            input2.setText(mytrans.trans(str,langFlag));//将结果输入到TextArea对象input2中
        }
    }
    public void getAdd(){//得到输入的要翻译的东西
        String str = this.setorgetText();//得到输入的要翻译的东西
        if(str=="wrong!"){
            System.out.println("请输入您想要添加到字典东西");
        }else{
            input2.setText(mytrans.dictionAdd(str,langFlag));//将结果输入到TextArea对象input2中
        }
    }
    public void kuaiJiejian(){//给各个操作加一个快捷键
        but1.setMnemonic(java.awt.event.KeyEvent.VK_F);
        but2.setMnemonic(java.awt.event.KeyEvent.VK_D);
        but3.setMnemonic(java.awt.event.KeyEvent.VK_T);
    }

}
public class Text_two {
    public static void main(String[] args) {
        //使按钮跟操作系统的一样，增加美观性
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        TransJFrame j= new TransJFrame();
    }

}

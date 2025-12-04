/*     */ package com.schnurritv.sexmod.gui;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.SystemColor;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextPane;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ import net.minecraftforge.fml.common.FMLCommonHandler;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PornWarningWindow
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*     */   static PornWarningWindow frame;
/*     */   
/*     */   public static void launch() {
/*  34 */     EventQueue.invokeLater(() -> {
/*     */           try {
/*     */             frame = new PornWarningWindow();
/*     */             frame.setVisible(true);
/*     */             frame.requestFocus();
/*  39 */           } catch (Exception e) {
/*     */             e.printStackTrace();
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean wait = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public PornWarningWindow() throws InterruptedException {
/*  52 */     setResizable(false);
/*  53 */     setBounds(100, 100, 600, 260);
/*  54 */     this.contentPane = new JPanel();
/*  55 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  56 */     this.contentPane.setLayout(new BorderLayout(0, 0));
/*  57 */     setContentPane(this.contentPane);
/*     */     
/*  59 */     JPanel title = new JPanel();
/*  60 */     this.contentPane.add(title, "North");
/*     */     
/*  62 */     JTextPane titleText = new JTextPane();
/*  63 */     titleText.setFont(new Font("Tahoma", 0, 16));
/*  64 */     titleText.setBackground(SystemColor.control);
/*  65 */     titleText.setText("Adult content warning!");
/*  66 */     title.add(titleText);
/*     */ 
/*     */     
/*  69 */     JPanel buttons = new JPanel();
/*  70 */     this.contentPane.add(buttons, "South");
/*     */     
/*  72 */     JCheckBox dontAskAgain = new JCheckBox("don't ask again");
/*  73 */     buttons.add(dontAskAgain);
/*     */     
/*  75 */     JButton okay = new JButton("I'm at least 18 years old!");
/*  76 */     okay.addActionListener(e -> {
/*     */           wait = false;
/*     */           
/*     */           if (dontAskAgain.isSelected()) {
/*     */             System.out.println("ok i wont ask again");
/*     */             
/*     */             File dir = new File("sexmod");
/*     */             
/*     */             dir.mkdir();
/*     */             File save = new File("sexmod/dontAskAgain");
/*     */             try {
/*     */               save.createNewFile();
/*  88 */             } catch (IOException ioException) {
/*     */               ioException.printStackTrace();
/*     */             } 
/*     */           } 
/*     */           
/*     */           frame.dispose();
/*     */         });
/*     */     
/*  96 */     buttons.add(okay);
/*     */     
/*  98 */     JButton delete = new JButton("I'm below the age of 18!");
/*  99 */     delete.addActionListener(e -> {
/*     */           wait = false;
/*     */           
/*     */           System.out.println("MINOR!!! WHEOO WOOO WHEEE WHOOO WHEEE WHOO");
/*     */           
/*     */           File sexmodFolder = new File("sexmod");
/*     */           
/*     */           try {
/*     */             FileUtils.deleteDirectory(sexmodFolder);
/* 108 */           } catch (IOException ioException) {
/*     */             ioException.printStackTrace();
/*     */           } 
/*     */           
/*     */           File f = new File("mods/youCanJustDeleteMe.bat");
/*     */           
/*     */           try {
/*     */             FileWriter fw = new FileWriter(f);
/*     */             
/*     */             fw.write("@echo off\n");
/*     */             
/*     */             fw.write("TIMEOUT /T 5\n");
/*     */             
/*     */             fw.write("DEL \"mods\\*sexmod*.jar\"\n");
/*     */             fw.write("exit 0");
/*     */             fw.close();
/*     */             Runtime.getRuntime().exec("cmd /c start " + f.getPath());
/* 125 */           } catch (IOException ioException) {
/*     */             ioException.printStackTrace();
/*     */           } 
/*     */           
/*     */           FMLCommonHandler.instance().exitJava(0, true);
/*     */         });
/*     */     
/* 132 */     buttons.add(delete);
/*     */     
/* 134 */     JPanel text = new JPanel();
/* 135 */     this.contentPane.add(text, "Center");
/* 136 */     text.setLayout(new BoxLayout(text, 0));
/*     */     
/* 138 */     JTextPane blabla = new JTextPane();
/* 139 */     blabla.setContentType("text/html");
/* 140 */     blabla.setBackground(SystemColor.control);
/* 141 */     blabla.setEditable(false);
/* 142 */     blabla.setText("<html><center><p style='font-family: Tahoma'>This version of Minecraft has been modified, so that it contains pornographic content. By continuing the launch of the game, you are at the risk of being exposed to it. If you are below the age of 18 and/or just don't want that to happen,<br> hit the 'I'm below the age of 18!' button. Then the pornographic content will be removed of your System, the Game will be closed and by restarting Minecraft, you can play your session of Minecraft in peace</p></center></html> ");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     text.add(blabla);
/*     */   }
/*     */ }


/* Location:              C:\Users\User\AppData\Roaming\.minecraft\versions\hjjhj\mods\SchnurriTVs Sexmod-1.3.2.jar!\com\schnurritv\sexmod\gui\PornWarningWindow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
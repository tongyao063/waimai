package cn.edu.zucc.waimaizhushou.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import cn.edu.zucc.waimaizhushou.ui.Frmriderlogin;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.waimaizhushou.WaiMaiUtil;
import cn.edu.zucc.waimaizhushou.model.Beanuserd;
import cn.edu.zucc.waimaizhushou.util.BaseException;


public class FrmLogin extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnLogin = new JButton("�û���½");
	private JButton btnCancel = new JButton("�˳�");
	private JButton btnRegister = new JButton("�û�ע��");
	
	private JLabel labelUser = new JLabel("�û�id��");
	private JLabel labelPwd = new JLabel("���룺");
	private JTextField edtUserId = new JTextField(20);
	private JPasswordField edtPwd = new JPasswordField(20);

	
	public FrmLogin(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnRegister);
		toolBar.add(btnLogin);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelUser);
		workPane.add(edtUserId);
		workPane.add(labelPwd);
		workPane.add(edtPwd);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(320, 140);
		// ��Ļ������ʾ
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();

		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);
		this.btnRegister.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnLogin) {
			int p =Integer.parseInt(this.edtUserId.getText());
			int userid=p;
			String pwd=new String(this.edtPwd.getPassword());
			try {
				Beanuserd.currentLoginuser= WaiMaiUtil.useriManager.login(userid, pwd);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.setVisible(false);
			
		} else if (e.getSource() == this.btnCancel) {
			System.exit(0);
		}  else if (e.getSource() == this.btnRegister) {
			FrmRegister adm=new FrmRegister(this,"�û�ע��",true);
			adm.setVisible(true);
		} 
	}

}

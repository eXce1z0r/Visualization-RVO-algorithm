package Visualization;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class App 
{

	public static void main(String[] args) 
	{
		Thread paintThread;		
		AppWindow window = new AppWindow();		
		AppPanel pane = new AppPanel();
		
		window.getContentPane().setLayout(new GridBagLayout());
		
		GridBagConstraints properties = new GridBagConstraints();
		properties.fill = GridBagConstraints.BOTH;//���������� ��������� ������������� ���������� ���������� ������������ ������ ��� �����) �������, ���� ������� ���������� ������ �������� ����������� ��� ���� �����
		properties.gridx = GridBagConstraints.RELATIVE;//����� ������� ���� ����� ������� ������
		properties.gridy = 1;//����� ������ ���� ����� ������� ������
		properties.gridwidth = 1;//���������� ���������� ����� �� �����������, ���������� ����������� �����������
		properties.gridheight = GridBagConstraints.REMAINDER;//���������� ���������� ����� �� ���������, ���������� ����������� �����������
		properties.anchor = GridBagConstraints.CENTER;//���� anchor ������ ������������ ���������� ������ ����������� ��� ���� ������������. �� ���������� � ������, ����� ������� ���������� ������ �������� ����������� ��� ���� �����
		properties.weightx = 1.0;//���������� ��������� ��������� �������� ����������, ������� �� ��������� ������������ ��� ��������
		properties.weighty = 1.0;//���������� ��������� ��������� �������� ����������, ������� �� ��������� ������������ ��� �����
		properties.ipadx = 0;//��������� �� ������� ������� ���������� ���������� ��������� � �������� �� �����������
		properties.ipady = 0;//��������� �� ������� ������� ���������� ���������� ��������� � �������� �� ���������
		properties.insets = new Insets(10, 10, 10, 10);//��������� ������ ��� ���������� ������� �� ����� ���������� ��� �������
		
		window.getContentPane().add(pane, properties);
		
		paintThread = new Thread(pane);
		paintThread.start();
		

	}

}

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
		properties.fill = GridBagConstraints.BOTH;//определ€ет стратегию распределени€ компоненту свободного пространства €чейки или €чеек) таблицы, если размеры компонента меньше размеров выделенного дл€ него места
		properties.gridx = GridBagConstraints.RELATIVE;//номер столбца куда будет помещен объект
		properties.gridy = 1;//номер строки куда будет помещен объект
		properties.gridwidth = 1;//определ€ет количество €чеек по горизонтали, занимаемых добавл€емым компонентом
		properties.gridheight = GridBagConstraints.REMAINDER;//определ€ет количество €чеек по вертикали, занимаемых добавл€емым компонентом
		properties.anchor = GridBagConstraints.CENTER;//ѕоле anchor задает выравнивание компонента внутри отведенного дл€ него пространства. ќн включаетс€ в работу, когда размеры компонента меньше размеров выделенного дл€ него места
		properties.weightx = 1.0;//определ€ет стратегию изменени€ размеров компонента, отвеча€ за выделение пространства дл€ столбцов
		properties.weighty = 1.0;//определ€ет стратегию изменени€ размеров компонента, отвеча€ за выделение пространства дл€ строк
		properties.ipadx = 0;//указывает на сколько размеры компонента необходимо увеличить в пиксел€х по горизонтали
		properties.ipady = 0;//указывает на сколько размеры компонента необходимо увеличить в пиксел€х по вертикали
		properties.insets = new Insets(10, 10, 10, 10);//позвол€ет задать дл€ компонента отступы от краев выделенной ему области
		
		window.getContentPane().add(pane, properties);
		
		paintThread = new Thread(pane);
		paintThread.start();
		

	}

}

package just.ca.UI;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import just.ca.Dao.MemberDao;
import just.ca.Dao.MemberDaoImpl;
import just.ca.einity.Member;

public class PreviewFrame extends JFrame{
	String[] columnNames;
	String[][] tableValues;
	int length=0;
	public PreviewFrame(){
		this.setTitle("预览");
		this.setSize(900,500);
		this.setLocationRelativeTo(null);
		this.add(createContentPanel());
		this.setResizable(false);
	}
	private Component createContentPanel() {
		MemberDao dao=new MemberDaoImpl();
		List<Member> members=new ArrayList<Member>();
		try {
			members=dao.findAll();
			for(Member member:members){
				++length;
			}
			columnNames=new String[]{"学号","姓名"," 性别","专业","手机号","QQ号","签到次数"};
			tableValues=new String[length][7];
			int i=0;
			for(Member member:members){
				tableValues[i][0]=member.getNumber()+"";
				tableValues[i][1]=member.getName();
				tableValues[i][2]=member.getSex();
				tableValues[i][3]=member.getProfession();
				tableValues[i][4]=member.getPhone();
				tableValues[i][5]=member.getQqnumber();
				tableValues[i++][6]=member.getTimes()+"";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JTable table=new JTable(tableValues,columnNames);
		JScrollPane panel = new JScrollPane(table);
		panel.setBorder(new TitledBorder("协会成员数据"));
		return panel;
	}
}

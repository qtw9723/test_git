package emp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;


public class EmpViewEvt extends MouseAdapter {
	private EmpView ev;
	
	public EmpViewEvt(EmpView ev) {
		this.ev = ev;
		
		setEmpno();
	}
	
	public void setEmpno() {
		EmpDAO eDAO = EmpDAO.getInstance();
		
		try {
			List<String> empno = eDAO.selecEmpno(); 
			for(String setEmpno : empno) {
				ev.getDlmJlEmpno().addElement(setEmpno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getSource() == ev.getJlEmpno()) {
			EmpInfoView eiv = new EmpInfoView();
			selectEmpno(eiv);
		}
	}

	
	public void selectEmpno(EmpInfoView eiv) {
		EmpDAO eDAO = EmpDAO.getInstance();
		String empno = ev.getJlEmpno().getSelectedValue();
			
		EmpVO eVO = new EmpVO();

		try {
				eVO = eDAO.selectOneEmpInfo(empno);
				eiv.getJtfEmpno().setText(eVO.getEmpno());
				eiv.getJtfEname().setText(eVO.getEname());
				eiv.getJtfHiredate().setText(eVO.getHiredate());
				eiv.getJtfJob().setText(eVO.getJob());
				eiv.getJtfSal().setText(eVO.getSal());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	
}

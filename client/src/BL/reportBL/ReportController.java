package BL.reportBL;

import java.rmi.RemoteException;
import java.util.Date;

import BLService.reportBLService.ReportBLService;
import vo.report.KeyForSearchReport;
import vo.report.ManageProgressReportVO;
import vo.report.ManageStateReportVO;
import vo.report.SaleReportVO;

/**
 * 对各种报表进行管理的controller
 * @author lzb
 *
 */
public class ReportController implements ReportBLService{

	ReportList reportList = new ReportList();
	
	@Override
	public SaleReportVO getSaleReport(KeyForSearchReport key)  throws RemoteException  {
		// TODO Auto-generated method stub
		return this.reportList.getSaleReport(key);
	}

	@Override
	public boolean ExportReport(SaleReportVO toBeExport, String path) throws RemoteException   {
		// TODO Auto-generated method stub
		return this.reportList.ExportReport(toBeExport, path);
	}

	@Override
	public ManageStateReportVO getManageState(Date begin ,Date end)  throws RemoteException  {
		// TODO Auto-generated method stub
		return this.reportList.getManageState(begin,end);
	}

	@Override
	public boolean ExportReport(ManageStateReportVO toBeExport, String path) throws RemoteException   {
		// TODO Auto-generated method stub
		return this.ExportReport(toBeExport, path);
	}

	@Override
	public ManageProgressReportVO getManageProgress(KeyForSearchReport key)  throws RemoteException  {
		// TODO Auto-generated method stub
		return this.reportList.getManageProgress(key);
	}

	@Override
	public boolean ExportReport(ManageProgressReportVO toBeExport, String path)  throws RemoteException  {
		// TODO Auto-generated method stub
		return this.ExportReport(toBeExport, path);
	}

	
	
	
	
	
}

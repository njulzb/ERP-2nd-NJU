package BLService.reportBLService;

import java.rmi.RemoteException;
import java.util.Date;

import vo.report.KeyForSearchReport;
import vo.report.ManageProgressReportVO;
import vo.report.ManageStateReportVO;
import vo.report.SaleReportVO;

public interface ReportBLService {

	public SaleReportVO getSaleReport(KeyForSearchReport key)  throws RemoteException  ;
	public boolean ExportReport(SaleReportVO toBeExport,String path)  throws RemoteException  ;

	public ManageStateReportVO getManageState(Date begin ,Date end)  throws RemoteException  ;
	public boolean ExportReport(ManageStateReportVO toBeExport,String path)  throws RemoteException  ;

	public ManageProgressReportVO getManageProgress(KeyForSearchReport key)  throws RemoteException  ;
	public boolean ExportReport(ManageProgressReportVO toBeExport,String path)  throws RemoteException  ;

	
}

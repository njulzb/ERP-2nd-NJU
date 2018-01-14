package BL.reportBL.Stub;

import java.util.Date;

import BLService.reportBLService.ReportBLService;
import vo.report.KeyForSearchReport;
import vo.report.ManageProgressReportVO;
import vo.report.ManageStateReportVO;
import vo.report.SaleReportVO;

public class ReportBLServiceStub implements ReportBLService {

	@Override
	public SaleReportVO getSaleReport(KeyForSearchReport key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ExportReport(SaleReportVO toBeExport, String path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ManageStateReportVO getManageState(Date begin ,Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ExportReport(ManageStateReportVO toBeExport, String path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ManageProgressReportVO getManageProgress(KeyForSearchReport key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ExportReport(ManageProgressReportVO toBeExport, String path) {
		// TODO Auto-generated method stub
		return false;
	}

}

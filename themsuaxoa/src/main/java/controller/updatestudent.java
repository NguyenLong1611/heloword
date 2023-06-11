package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SINH_VIENDAOimpl;
import entities.SINH_VIEN;

/**
 * Servlet implementation class updatestudent
 */
@WebServlet("/updatestudent")
public class updatestudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updatestudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msv = request.getParameter("MSV");
		SINH_VIEN sv = new SINH_VIENDAOimpl().findStudentById(msv);
		request.setAttribute("sv", sv);
		request.getRequestDispatcher("updatestudent.jsp").forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String msv = request.getParameter("MSV");
		String ho_ten = request.getParameter("HO_TEN");
		String ngay_sinh = request.getParameter("NGAY_SINH");
		String dia_chi = request.getParameter("DIA_CHI");
		String ma_lop = request.getParameter("MA_LOP");
		String gioi_tinh = request.getParameter("gender");
		Date dt = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {

			dt = sdf.parse(ngay_sinh);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SINH_VIEN sinhvien = new SINH_VIEN();
		sinhvien.setMSV(msv);
		sinhvien.setHO_TEN(ho_ten);
		sinhvien.setNGAY_SINH(new java.sql.Date(dt.getTime()));
		sinhvien.setDIA_CHI(dia_chi);
		sinhvien.setMA_LOP(ma_lop);
		sinhvien.setGIOI_TINH(Boolean.parseBoolean(gioi_tinh));
		Boolean check = new SINH_VIENDAOimpl().updateSINH_VIEN(sinhvien);
		if (check) {
			response.sendRedirect("Student");
		} else {
			response.sendError(500);
		}
	}

}

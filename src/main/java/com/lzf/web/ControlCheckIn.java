/**
 * 
 */
package com.lzf.web;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.lzf.entity.Room;
import com.lzf.service.IServiceCheckIn;
import com.lzf.util.AipOpticalCharacterRecognition;

/**
 * @author MJCoder
 *
 */
@Controller
@RequestMapping("checkin")
public class ControlCheckIn {

	@Autowired
	private IServiceCheckIn serviceCheckIn;

	/**
	 * 
	 */
	public ControlCheckIn() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "aipOcrIdCard", method = RequestMethod.POST)
	private Object aipOcrIdCard(MultipartFile file, HttpServletRequest request) {
		// String path = request.getParameter("path");
		try {
			String path = request.getServletContext().getRealPath("upload"); // uploads文件夹位置
			String fileName = file.getOriginalFilename(); // 原始名称
			File dir = new File(path, fileName);// 新文件名
			if (!dir.exists()) { // 如果目标文件所在的目录不存在，则创建父目录
				dir.mkdirs();
			}
			System.out.println(dir.getAbsolutePath());
			file.transferTo(dir); // 将内存中的数据写入磁盘

			JSONObject resp = AipOpticalCharacterRecognition.aipOcrIdCard(dir.getAbsolutePath());
			String imageStatus = resp.getString("image_status");
			if ("normal".equals(imageStatus)) {
				JSONObject temp = resp.getJSONObject("words_result");
				String name = temp.getJSONObject("姓名").getString("words");
				String identity = temp.getJSONObject("公民身份号码").getString("words");
				List<Room> rooms = serviceCheckIn.select(name, identity);
				request.setAttribute("user", name);
				request.setAttribute("rooms", rooms);
			} else if ("reversed_side".equals(imageStatus)) {
				request.setAttribute("errorMsg", "未摆正身份证");
			} else if ("non_idcard".equals(imageStatus)) {
				request.setAttribute("errorMsg", "上传的图片中不包含身份证");
			} else if ("blurred".equals(imageStatus)) {
				request.setAttribute("errorMsg", "身份证模糊");
			} else if ("over_exposure".equals(imageStatus)) {
				request.setAttribute("errorMsg", "身份证关键字段反光或过曝");
			} else if ("unknown".equals(imageStatus)) {
				request.setAttribute("errorMsg", "该身份证无法识别，请重新上传。(未知状态)");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("errorMsg", "该身份证无法识别，请重新上传。(异常状态)");
		}
		return "jsp/checkin";
	}

}

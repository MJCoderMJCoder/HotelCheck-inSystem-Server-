/**
 * 
 */
package com.lzf.util;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

/**
 * @author MJCoder
 * 
 *         AipOcr是Optical Character Recognition的Java客户端，为使用Optical Character
 *         Recognition的开发人员提供了一系列的交互方法。初始化完成后建议单例使用,避免重复获取access_token。
 */
public final class AipOpticalCharacterRecognition {
	// 设置APPID/AK/SK
	private static final String APP_ID = "11133618";
	private static final String API_KEY = "cXx3nfnZGVZESp1FKiLEan9x";
	private static final String SECRET_KEY = "QD30CiV2fyCnkFCpLmFICy0nkjtTk4zH";
	private static AipOcr client;

	private static AipOcr getAipOcrInstance() {
		if (client == null) {
			// 初始化一个AipOcr
			client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
			// 可选：设置网络连接参数
			client.setConnectionTimeoutInMillis(2000);
			client.setSocketTimeoutInMillis(60000);

			// 可选：设置代理服务器地址, http和socket二选一，或者均不设置
			// client.setHttpProxy("proxy_host", proxy_port); // 设置http代理
			// client.setSocketProxy("proxy_host", proxy_port); // 设置socket代理

			// 可选：设置log4j日志输出格式，若不设置，则使用默认配置
			// 也可以直接通过jvm启动参数设置此环境变量
			// System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
		}
		return client;
	}

	/**
	 * 用户向服务请求识别身份证，身份证识别包括正面和背面。
	 * 
	 * @param client
	 */
	public static JSONObject aipOcrIdCard(String path) {
		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();
		// 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:true：检测朝向；false：不检测朝向。
		options.put("detect_direction", "true");
		// 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，默认不开启，即：false。可选值:true-开启；false-不开启
		options.put("detect_risk", "false");

		String idCardSide = "front"; // front：身份证含照片的一面；back：身份证带国徽的一面

		/**
		 * 参数path为本地图片路径
		 * 
		 * image_status normal-识别正常; reversed_side-未摆正身份证 ; non_idcard-上传的图片中不包含身份证;
		 * blurred-身份证模糊 ; over_exposure-身份证关键字段反光或过曝 ; unknown-未知状态;
		 */

		JSONObject res = getAipOcrInstance().idcard(path, idCardSide, options);
		// System.out.println("响应内容：\n" + res.toString(2));
		return res;

		// 参数为本地图片二进制数组
		// byte[] file = readImageFile(image);
		// res = client.idcard(file, idCardSide, options);
		// System.out.println(res.toString(2));

	}

}

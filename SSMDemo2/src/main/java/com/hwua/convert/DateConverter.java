package com.hwua.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * @ClassName: DateConverter
 * @Description:TODO(自定义转换器)
 * @author: maple
 * @date: 2018年11月20日 下午4:10:09
 * 
 * @Copyright: 2018 www.hwua.com Inc. All rights reserved.
 *             注意：本内容仅限于海文科信息技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class DateConverter implements Converter<String, Date> {

	public Date convert(String source) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			java.util.Date sd = simpleDateFormat.parse(source);
			// 将util.Date转换为sql.Date
			return sd;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}

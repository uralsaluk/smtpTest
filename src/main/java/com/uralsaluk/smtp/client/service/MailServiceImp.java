package com.uralsaluk.smtp.client.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.uralsaluk.smtp.client.config.YAMLConfig;

@Service
public class MailServiceImp  implements MailService{


	@Autowired
	YAMLConfig yamlConfig;
	
	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public void sendmail() throws MessagingException, IOException {


		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		SimpleDateFormat formatForDocument = new SimpleDateFormat("yyyy-MM-dd--HH:mm:ss");
			
			String mailTemp="<html>"+
					"<p>   reactı siktim öldü </p>" + 					
					"</html>";
		
		//	String[] mailAddressTo= {"ural.saluk@gratis.com"};
			
		String[] mailAddressTo= yamlConfig.getMailAddressTo();
			
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper;
		
			
			
			   //yamlConfig.getMailAddressTo();     //{"ural.saluk@gratis.com"};  // 
		
			helper = new MimeMessageHelper(message, true); // true indicates
			helper.setFrom("uralsaluk@gmail.comm");
			helper.setTo(mailAddressTo);
			helper.setSubject("javatestsmtp");
			
			File file = new File("C:\\Users\\ural.saluk\\Desktop\\Ural Docs\\Dict-Source Workspace\\uralsaluk-smtp-client\\uralsaluk-smtp-client\\src\\main\\resources\\images\\instagram2x.png");
			
			
			FileInputStream fileInputStream = null;
		      byte[] bFile = new byte[(int) file.length()];
		     
		      
		        //convert file into array of bytes
		         fileInputStream = new FileInputStream(file);
		         fileInputStream.read(bFile);
		         fileInputStream.close();
		         for (int i = 0; i < bFile.length; i++)
		         {
		            System.out.print((char) bFile[i]);
		         }
		      
		   
		         ByteArrayOutputStream baos = new ByteArrayOutputStream(bFile.length);
		         baos.write(bFile, 0, bFile.length);

				   
		     	
				helper.setText(htmlTemp,true);
				
	InputStreamSource attachmentBefore =new ByteArrayResource(bFile);
			
			
		
	
	
				
				
				helper.addAttachment("instagram2x.png", attachmentBefore);
				
				
			// true indicates html
			// continue using helper object for more functionalities like adding attachments, etc.  
					
			javaMailSender.send(message);
			
		
	}
	
	private static final String htmlTemp = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
			"\r\n" + 
			"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\r\n" + 
			"<head>\r\n" + 
			"<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\r\n" + 
			"<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\r\n" + 
			"<meta content=\"width=device-width\" name=\"viewport\"/>\r\n" + 
			"<!--[if !mso]><!-->\r\n" + 
			"<meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\"/>\r\n" + 
			"<!--<![endif]-->\r\n" + 
			"<title></title>\r\n" + 
			"<!--[if !mso]><!-->\r\n" + 
			"<!--<![endif]-->\r\n" + 
			"<style type=\"text/css\">\r\n" + 
			"		body {\r\n" + 
			"			margin: 0;\r\n" + 
			"			padding: 0;\r\n" + 
			"		}\r\n" + 
			"\r\n" + 
			"		table,\r\n" + 
			"		td,\r\n" + 
			"		tr {\r\n" + 
			"			vertical-align: top;\r\n" + 
			"			border-collapse: collapse;\r\n" + 
			"		}\r\n" + 
			"\r\n" + 
			"		* {\r\n" + 
			"			line-height: inherit;\r\n" + 
			"		}\r\n" + 
			"\r\n" + 
			"		a[x-apple-data-detectors=true] {\r\n" + 
			"			color: inherit !important;\r\n" + 
			"			text-decoration: none !important;\r\n" + 
			"		}\r\n" + 
			"	</style>\r\n" + 
			"<style id=\"media-query\" type=\"text/css\">\r\n" + 
			"		@media (max-width: 620px) {\r\n" + 
			"\r\n" + 
			"			.block-grid,\r\n" + 
			"			.col {\r\n" + 
			"				min-width: 320px !important;\r\n" + 
			"				max-width: 100% !important;\r\n" + 
			"				display: block !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.block-grid {\r\n" + 
			"				width: 100% !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.col {\r\n" + 
			"				width: 100% !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.col_cont {\r\n" + 
			"				margin: 0 auto;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			img.fullwidth,\r\n" + 
			"			img.fullwidthOnMobile {\r\n" + 
			"				width: 100% !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.no-stack .col {\r\n" + 
			"				min-width: 0 !important;\r\n" + 
			"				display: table-cell !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.no-stack.two-up .col {\r\n" + 
			"				width: 50% !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.no-stack .col.num2 {\r\n" + 
			"				width: 16.6% !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.no-stack .col.num3 {\r\n" + 
			"				width: 25% !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.no-stack .col.num4 {\r\n" + 
			"				width: 33% !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.no-stack .col.num5 {\r\n" + 
			"				width: 41.6% !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.no-stack .col.num6 {\r\n" + 
			"				width: 50% !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.no-stack .col.num7 {\r\n" + 
			"				width: 58.3% !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.no-stack .col.num8 {\r\n" + 
			"				width: 66.6% !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.no-stack .col.num9 {\r\n" + 
			"				width: 75% !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.no-stack .col.num10 {\r\n" + 
			"				width: 83.3% !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.video-block {\r\n" + 
			"				max-width: none !important;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.mobile_hide {\r\n" + 
			"				min-height: 0px;\r\n" + 
			"				max-height: 0px;\r\n" + 
			"				max-width: 0px;\r\n" + 
			"				display: none;\r\n" + 
			"				overflow: hidden;\r\n" + 
			"				font-size: 0px;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.desktop_hide {\r\n" + 
			"				display: block !important;\r\n" + 
			"				max-height: none !important;\r\n" + 
			"			}\r\n" + 
			"		}\r\n" + 
			"	</style>\r\n" + 
			"<style id=\"icon-media-query\" type=\"text/css\">\r\n" + 
			"		@media (max-width: 620px) {\r\n" + 
			"			.icons-inner {\r\n" + 
			"				text-align: center;\r\n" + 
			"			}\r\n" + 
			"\r\n" + 
			"			.icons-inner td {\r\n" + 
			"				margin: 0 auto;\r\n" + 
			"			}\r\n" + 
			"		}\r\n" + 
			"	</style>\r\n" + 
			"</head>\r\n" + 
			"<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #FFFFFF;\">\r\n" + 
			"<!--[if IE]><div class=\"ie-browser\"><![endif]-->\r\n" + 
			"<table bgcolor=\"#FFFFFF\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF; width: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
			"<tbody>\r\n" + 
			"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
			"<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\r\n" + 
			"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#FFFFFF\"><![endif]-->\r\n" + 
			"<div style=\"background-color:#132437;\">\r\n" + 
			"<div class=\"block-grid\" style=\"min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;\">\r\n" + 
			"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;background-image:url('images/blue-glow_3.jpg');background-position:center top;background-repeat:no-repeat\">\r\n" + 
			"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:#132437;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\r\n" + 
			"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\r\n" + 
			"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
			"<div class=\"col_cont\" style=\"width:100% !important;\">\r\n" + 
			"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
			"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
			"<!--<![endif]-->\r\n" + 
			"<div align=\"center\" class=\"img-container center fixedwidth fullwidthOnMobile\" style=\"padding-right: 0px;padding-left: 0px;\">\r\n" + 
			"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img align=\"center\" border=\"0\" class=\"center fixedwidth fullwidthOnMobile\" src=\"images/top-rounded.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 600px; max-width: 100%; display: block;\" width=\"600\"/>\r\n" + 
			"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
			"</div>\r\n" + 
			"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
			"</div>\r\n" + 
			"<!--<![endif]-->\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<div style=\"background-color:#132437;\">\r\n" + 
			"<div class=\"block-grid\" style=\"min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #ffffff;\">\r\n" + 
			"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#ffffff;\">\r\n" + 
			"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:#132437;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#ffffff\"><![endif]-->\r\n" + 
			"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#ffffff;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:10px;\"><![endif]-->\r\n" + 
			"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
			"<div class=\"col_cont\" style=\"width:100% !important;\">\r\n" + 
			"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
			"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:10px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
			"<!--<![endif]-->\r\n" + 
			"<div align=\"center\" class=\"img-container center autowidth\" style=\"padding-right: 20px;padding-left: 20px;\">\r\n" + 
			"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 20px;padding-left: 20px;\" align=\"center\"><![endif]-->\r\n" + 
			"<div style=\"font-size:1px;line-height:5px\"> </div><img align=\"center\" border=\"0\" class=\"center autowidth\" src=\"https://cdn.armut.com/UserPics/tr:w-325,h-325/263bdcf0-3ba6-41ce-96c9-092016749454.jpeg\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 541px; max-width: 100%; display: block;\" width=\"541\"/>\r\n" + 
			"<div style=\"font-size:1px;line-height:5px\"> </div>\r\n" + 
			"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
			"</div>\r\n" + 
			"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
			"</div>\r\n" + 
			"<!--<![endif]-->\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<div style=\"background-image:url('images/orange-gradient-wide.png');background-position:top left;background-repeat:no-repeat;background-color:#ff7d14;\">\r\n" + 
			"<div class=\"block-grid\" style=\"min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #ffffff;\">\r\n" + 
			"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#ffffff;\">\r\n" + 
			"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-image:url('images/orange-gradient-wide.png');background-position:top left;background-repeat:no-repeat;background-color:#ff7d14;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:#ffffff\"><![endif]-->\r\n" + 
			"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:#ffffff;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\r\n" + 
			"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
			"<div class=\"col_cont\" style=\"width:100% !important;\">\r\n" + 
			"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
			"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
			"<!--<![endif]-->\r\n" + 
			"<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\r\n" + 
			"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
			"<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-left: 0px; padding-right: 0px; padding-top: 25px; text-align: center; width: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
			"<h1 style=\"color:#555555;direction:ltr;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-size:36px;font-weight:normal;letter-spacing:normal;line-height:120%;text-align:center;margin-top:0;margin-bottom:0;\"><strong>Merhaba Ural</strong></h1>\r\n" + 
			"</td>\r\n" + 
			"</tr>\r\n" + 
			"</table>\r\n" + 
			"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 15px; padding-left: 15px; padding-top: 20px; padding-bottom: 20px; font-family: Arial, sans-serif\"><![endif]-->\r\n" + 
			"<div style=\"color:#737487;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.8;padding-top:20px;padding-right:15px;padding-bottom:20px;padding-left:15px;\">\r\n" + 
			"<div class=\"txtTinyMce-wrapper\" style=\"font-size: 14px; line-height: 1.8; color: #737487; font-family: Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 25px;\">\r\n" + 
			"<p style=\"margin: 0; font-size: 18px; line-height: 1.8; word-break: break-word; text-align: center; mso-line-height-alt: 32px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 18px;\">En kısa sürede dönüş yapacağım </span></p>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
			"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
			"</div>\r\n" + 
			"<!--<![endif]-->\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<div style=\"background-color:#ff7d14;\">\r\n" + 
			"<div class=\"block-grid\" style=\"min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;\">\r\n" + 
			"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
			"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:#ff7d14;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\r\n" + 
			"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:0px;\"><![endif]-->\r\n" + 
			"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
			"<div class=\"col_cont\" style=\"width:100% !important;\">\r\n" + 
			"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
			"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
			"<!--<![endif]-->\r\n" + 
			"<div align=\"center\" class=\"img-container center fixedwidth fullwidthOnMobile\" style=\"padding-right: 0px;padding-left: 0px;\">\r\n" + 
			"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img align=\"center\" border=\"0\" class=\"center fixedwidth fullwidthOnMobile\" src=\"images/bottom-rounded.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 600px; max-width: 100%; display: block;\" width=\"600\"/>\r\n" + 
			"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
			"</div>\r\n" + 
			"<table cellpadding=\"0\" cellspacing=\"0\" class=\"social_icons\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\r\n" + 
			"<tbody>\r\n" + 
			"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
			"<td style=\"word-break: break-word; vertical-align: top; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\r\n" + 
			"<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"social_table\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;\" valign=\"top\">\r\n" + 
			"<tbody>\r\n" + 
			"<tr align=\"center\" style=\"vertical-align: top; display: inline-block; text-align: center;\" valign=\"top\">\r\n" + 
			"<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;\" valign=\"top\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img alt=\"Facebook\" height=\"32\" src=\"images/facebook2x.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;\" title=\"Facebook\" width=\"32\"/></a></td>\r\n" + 
			"<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;\" valign=\"top\"><a href=\"https://twitter.com/\" target=\"_blank\"><img alt=\"Twitter\" height=\"32\" src=\"images/twitter2x.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;\" title=\"Twitter\" width=\"32\"/></a></td>\r\n" + 
			"<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;\" valign=\"top\"><a href=\"https://instagram.com/\" target=\"_blank\"><img alt=\"Instagram\" height=\"32\" src=\"https://www.freepnglogos.com/uploads/logo-ig-png/logo-ig-png-instagram-logo-camel-productions-website-25.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;\" title=\"Instagram\" width=\"32\"/></a></td>\r\n" + 
			"<td style=\"word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;\" valign=\"top\"><a href=\"https://www.linkedin.com/\" target=\"_blank\"><img alt=\"LinkedIn\" height=\"32\" src=\"images/linkedin2x.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;\" title=\"LinkedIn\" width=\"32\"/></a></td>\r\n" + 
			"</tr>\r\n" + 
			"</tbody>\r\n" + 
			"</table>\r\n" + 
			"</td>\r\n" + 
			"</tr>\r\n" + 
			"</tbody>\r\n" + 
			"</table>\r\n" + 
			"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 5px; padding-left: 5px; padding-top: 30px; padding-bottom: 5px; font-family: Arial, sans-serif\"><![endif]-->\r\n" + 
			"<div style=\"color:#262b30;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.2;padding-top:30px;padding-right:5px;padding-bottom:5px;padding-left:5px;\">\r\n" + 
			"<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.2; font-size: 12px; font-family: Arial, Helvetica Neue, Helvetica, sans-serif; color: #262b30; mso-line-height-alt: 14px;\">\r\n" + 
			"<p style=\"margin: 0; font-size: 12px; line-height: 1.2; word-break: break-word; text-align: center; mso-line-height-alt: 14px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 12px;\">© 2020 <span id=\"c85ff154-05a5-4313-ba84-b656931665e4\" style=\"\">@gizemsavruk</span></span></p>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
			"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 5px; padding-bottom: 35px; font-family: Arial, sans-serif\"><![endif]-->\r\n" + 
			"<div style=\"color:#262b30;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;line-height:1.2;padding-top:5px;padding-right:10px;padding-bottom:35px;padding-left:10px;\">\r\n" + 
			"<div class=\"txtTinyMce-wrapper\" style=\"line-height: 1.2; font-size: 12px; font-family: Arial, Helvetica Neue, Helvetica, sans-serif; color: #262b30; mso-line-height-alt: 14px;\">\r\n" + 
			"<p style=\"margin: 0; font-size: 12px; line-height: 1.2; word-break: break-word; text-align: center; mso-line-height-alt: 14px; margin-top: 0; margin-bottom: 0;\"><span style=\"font-size: 12px;\">Mail almak istemiyorsanız, lütfen <a href=\"asdasd.com\" rel=\"noopener\" style=\"text-decoration: underline; color: #262b30;\" target=\"_blank\" title=\"er\">buraya </a>tıklayınız..</span></p>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
			"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
			"</div>\r\n" + 
			"<!--<![endif]-->\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<div style=\"background-color:transparent;\">\r\n" + 
			"<div class=\"block-grid\" style=\"min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;\">\r\n" + 
			"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
			"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\r\n" + 
			"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\r\n" + 
			"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
			"<div class=\"col_cont\" style=\"width:100% !important;\">\r\n" + 
			"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
			"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
			"<!--<![endif]-->\r\n" + 
			"<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" valign=\"top\" width=\"100%\">\r\n" + 
			"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
			"<td align=\"center\" style=\"word-break: break-word; vertical-align: top; padding-top: 5px; padding-right: 0px; padding-bottom: 5px; padding-left: 0px; text-align: center;\" valign=\"top\">\r\n" + 
			"<!--[if vml]><table align=\"left\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\"><![endif]-->\r\n" + 
			"<!--[if !vml]><!-->\r\n" + 
			"\r\n" + 
			"</td>\r\n" + 
			"</tr>\r\n" + 
			"</table>\r\n" + 
			"<!--[if (!mso)&(!IE)]><!-->\r\n" + 
			"</div>\r\n" + 
			"<!--<![endif]-->\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
			"</td>\r\n" + 
			"</tr>\r\n" + 
			"</tbody>\r\n" + 
			"</table>\r\n" + 
			"<!--[if (IE)]></div><![endif]-->\r\n" + 
			"</body>\r\n" + 
			"</html>";
}

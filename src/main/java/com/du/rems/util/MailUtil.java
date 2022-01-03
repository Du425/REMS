//package com.du.rems.util;
//
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import javax.xml.crypto.Data;
//import java.io.File;
//import java.io.IOException;
//import java.util.Date;
//import java.util.Map;
//
//@Component
//public class MailUtil {
//
//    @Resource
//    private JavaMailSenderImpl javaMailSender;
//
//    public boolean sendMailCode(String code, String receiver) throws MessagingException{
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setFrom("15929993389@163.com");
//
//        message.setTo(receiver);
//        //邮件主题
//        message.setSubject("REMS");
//        //邮件正文
//        message.setText(new Date()+"\n" + "您好！欢迎登陆REMS收支管理系统，本次登录验证码是：");
//        javaMailSender.send(message);
//        return true;
//
//    }
//
//    /**
//     *
//     * @param sender
//     * @param receiver
//     * @param map
//     * @param file
//     * @return
//     * @throws MessagingException
//     * @throws IOException
//     */
//    public Boolean sendMail(String sender, String receiver, Map<String,String> map, MultipartFile file) throws MessagingException,IOException{
//
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"utf-8");
//        mimeMessageHelper.setFrom(sender);
//        mimeMessageHelper.setTo(receiver);
//        getParam(mimeMessageHelper,map,file);
//        javaMailSender.send(mimeMessage);
//        return true;
//
//    }
//
//    public void getParam(MimeMessageHelper helper, Map<String,String> map, MultipartFile file) throws MessagingException, IOException{
//        helper.setSubject(map.get("subject"));
//        if (map.get("text") != null){
//            helper.setText(map.get("text"),true);
//        }
//        if (map.get("attachment") != null && map.get("fileBirth") != null){
//            helper.addAttachment(map.get("attachment"), new File(map.get("fileBirth")));
//        }else {
//            helper.addAttachment(file.getOriginalFilename(),file);
//        }
//    }
//
//}

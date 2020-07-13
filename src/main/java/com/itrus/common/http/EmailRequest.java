package com.itrus.common.http;

import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.itrus.common.exception.EmailException;
import com.itrus.common.params.ByteParams;
import com.itrus.common.params.EmailParams;
import com.itrus.common.utils.ByteFileUtil;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 邮件发送工具类
 *
 * @author wgx52
 */
@Data
@Component
@Slf4j
public class EmailRequest implements Serializable {

    @Resource(name = "taskExecutor")
    private TaskExecutor taskExecutor; //sping 2.0最新线程池功能

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public EmailRequest() {
        super();
    }

    /**
     * 同步发送邮件,适用不带附件同步返回发送成功失败
     *
     * @param email
     * @throws EmailException
     * @throws MessagingException
     */
    public void send(EmailParams email) throws EmailException {
        log.info("开始发送。。。。。。。。。。。。。。。。。。。。。。。");
        //加认证机制
        JavaMailSenderImpl mailSender = email.getMailSender();
        Properties javaMailProperties = mailSender.getJavaMailProperties();
        Object object = javaMailProperties.get("mail.smtp.auth");
        if (object == null) {
            //设置默认的，可以自定义参数
            javaMailProperties.put("mail.smtp.auth", true);
            javaMailProperties.put("mail.smtp.starttls.enable", true);
            javaMailProperties.put("mail.smtp.timeout", 20000);
            mailSender.setJavaMailProperties(javaMailProperties);
        }
        System.getProperties().setProperty("mail.mime.splitlongparameters", "false");
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message;
        try {
            message = new MimeMessageHelper(mimeMessage, true, "UTF-8");// 防止出现中文乱码，
            message.setFrom(mailSender.getUsername());// 设置发送方地址
            message.setTo(email.getEmail());// 设置接收方的email地址
            message.setSubject(email.getSuject());// 设置邮件主题
            message.setText(email.getContent(), email.getHtml());
            //附件不能是文件夹只能是带后缀的文件，不适合太大，不然会导致发送邮件时间过长 建议不超过 1M
            if (email.getFile() != null) {//文件流附件防止附件名称中文乱码
                message.addAttachment(MimeUtility.encodeText(email.getFile().getName(), "gb2312", "B"), email.getFile());
            }
            if (email.getByteParams() != null) {//文件流附件防止附件名称中文乱码
                File file = new File(email.getByteParams().getFileName());
                ByteFileUtil.copyByteToFile(email.getByteParams().getBytes(), file);
                message.addAttachment(MimeUtility.encodeText(email.getByteParams().getFileName(), "gb2312", "B"), file);
            }
            for (File file : email.getListFile()) {//文件流附件防止附件名称中文乱码
                message.addAttachment(MimeUtility.encodeText(file.getName(), "gb2312", "B"), file);
            }
            for (ByteParams byteParams : email.getBytes()) {//byte[]附件防止附件名称中文乱码
                File file = new File(byteParams.getFileName());
                ByteFileUtil.copyByteToFile(byteParams.getBytes(), file);
                message.addAttachment(MimeUtility.encodeText(byteParams.getFileName(), "gb2312", "B"), file);
            }
            mailSender.send(mimeMessage);
            log.info("发送成功。。。。。。。。。。。。。。。。。。。。。。。");
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new EmailException(e);
        }
    }

    /**
     * 异步发送邮件 适用附件发送
     *
     * @param email
     */
    public void sendMailByAsynchronousMode(final EmailParams email) {

        taskExecutor.execute(new Runnable() {
            public void run() {
                try {
                    send(email);
                } catch (Exception e) {
                    log.info("----------------发送邮件异常，异常原因：-------------------------");
                    log.error(e.getMessage());
                }
            }
        });
    }

    /**
     * 使用方法
     *
     * @param args
     * @throws MessagingException
     * @throws EmailException
     */
    public static void main(String[] args) throws EmailException {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setUsername("wen_guoxing@itrus.com.cn");
        mailSender.setPassword("***");
        mailSender.setPort(587);
        mailSender.setHost("mail.itrus.com.cn");
        String[] toEmail = new String[]{"wen_guoxing@itrus.com.cn"};
        EmailParams emailParams = new EmailParams(toEmail, "test", "温温测试", true, mailSender);
        EmailRequest emailUtil = new EmailRequest();
        emailUtil.send(emailParams);

        System.out.println("发送完成");
    }
}

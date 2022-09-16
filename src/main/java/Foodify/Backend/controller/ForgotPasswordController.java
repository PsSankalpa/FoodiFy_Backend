package Foodify.Backend.controller;
import Foodify.Backend.exception.Registered_Customer_Exception;
import Foodify.Backend.model.Registered_Customer;
import Foodify.Backend.service.Registered_Customer_Sev;
import com.sun.mail.imap.Utility;
import net.bytebuddy.utility.RandomString;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.Console;
import java.io.UnsupportedEncodingException;

@Controller
public class ForgotPasswordController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Registered_Customer_Sev RegCusSev;

    @GetMapping("/Foodify/forgot_password")
    public String showForgotPasswordForm(){
        return "forgot_password_form";
    }

    @RequestMapping(value="/Foodify/forgot_password", method = RequestMethod.POST)
    public String processForgotPassword(HttpServletRequest request, Model model) {
        String token = RandomString.make(30);
        String email = request.getParameter("email");
        try{
            RegCusSev.updateResetPasswordToken(token,email);
            String resetPasswordLink = ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).build().toUriString() + "/Foodify/reset_password?token=" + token;
            sendEmail(email, resetPasswordLink);
            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
        } catch (Registered_Customer_Exception e) {
            model.addAttribute("error", e.getMessage());
        } catch (MessagingException e) {
            model.addAttribute("error", "Error while sending email");
        } catch (UnsupportedEncodingException e) {
            model.addAttribute("error", "Error while sending email");
        }

        return "forgot_password_form";
    }

    public void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom("contact@shopme.com", "Foodify Support");
            helper.setTo(recipientEmail);

            String subject = "Here's the link to reset your password";

            String content = "<p>Hello,</p>"
                    + "<p>You have requested to reset your password.</p>"
                    + "<p>Click the link below to change your password:</p>"
                    + "<p><a href=\"" + link + "\">Change my password</a></p>"
                    + "<br>"
                    + "<p>Ignore this email if you do remember your password, "
                    + "or you have not made the request.</p>";

            helper.setSubject(subject);

            helper.setText(content, true);

            mailSender.send(message);
        }


    @GetMapping("/Foodify/reset_password")
    public String showResetPasswordForm(@Param(value="token") String token, Model model) {

        Registered_Customer RegCus = RegCusSev.getByResetPasswordToken(token);
        model.addAttribute("token", token);

        if(RegCus == null) {
            model.addAttribute("message", "Invalid Token");
            return "message";
        }

        return "reset_password_form";
}

    @PostMapping("/Foodify/reset_password")
    public String processResetPassword(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        Registered_Customer RegCus = RegCusSev.getByResetPasswordToken(token);
        model.addAttribute("title","Reset Your Password");

        if (RegCus == null){
            model.addAttribute("message", "Invalid Token");
            return "message";
        } else {
            RegCusSev.updatePassword(RegCus, password);
            model.addAttribute("message", "You have successfully changed your password.");
        }

        return "Success";
    }
}

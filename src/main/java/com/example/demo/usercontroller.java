package com.example.demo;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class usercontroller {
	
	@Autowired
	Userdao dao;
	
	@Autowired
	Facultydao fdao;
	
	@Autowired
    private PasswordResetService passwordResetService;
	
	@Autowired
    private GrievanceRepository grievanceRepository;
	
	@Autowired
	ManagementDao mdao;
	
	
	
	
	@GetMapping("/test")
	@ResponseBody
	public String tester() {
		return "testing successfull";
	}
	
	@GetMapping("/welcome")
	public String fun10() {
		return "welcome.jsp";
	}
	
	@GetMapping("/userreg")
	public String fun1() {
		return "userregistrastion.jsp";
	}
	
	@PostMapping("/save")  
	public String fun2(Model m, @ModelAttribute("u") User u, HttpServletRequest request) {
		dao.insert(u);
		//m.addAttribute("command", u);
		//StringBuffer stringBufferName = new StringBuffer(u.getFirst_name());
		System.out.println(u.getFirst_name());
		//System.out.println(stringBufferName);
		 m.addAttribute("firstName", u.getFirst_name());
			m.addAttribute("lastName", u.getLast_name());
			m.addAttribute("studentId", u.getStudent_id());
			m.addAttribute("year", u.getYear());
			m.addAttribute("branch", u.getBranch());
			m.addAttribute("email", u.getEmail());



			request.getSession().setAttribute("firstName", u.getFirst_name());
			request.getSession().setAttribute("lastName", u.getLast_name());
			request.getSession().setAttribute("studentId", u.getStudent_id());
			request.getSession().setAttribute("year", u.getYear());
			request.getSession().setAttribute("branch", u.getBranch());
			request.getSession().setAttribute("email", u.getEmail());





		return "redirect:/user";
	}
	
	@GetMapping("/userlog")
	public String fun3() {
		return "userlogin.jsp";
	}
	
	@PostMapping("/loggingin")
	public String login2(Model m, @ModelAttribute("pf") User pf, HttpServletRequest request, RedirectAttributes redirectAttributes) {
			if(dao.validateLogin(pf)) {
				 User u = dao.getDetailsById(pf);
				 //m.addAttribute("command", u);
				 //StringBuffer stringBufferName = new StringBuffer(u.getFirst_name());
				 System.out.println(u.getFirst_name());
				// System.out.println(stringBufferName);
				 m.addAttribute("firstName", u.getFirst_name());
					m.addAttribute("lastName", u.getLast_name());
					m.addAttribute("studentid", u.getStudent_id());
					m.addAttribute("year", u.getYear());
					m.addAttribute("branch", u.getBranch());
					m.addAttribute("email", u.getEmail());
					redirectAttributes.addAttribute("studentId", u.getStudent_id());



					request.getSession().setAttribute("firstName", u.getFirst_name());
					request.getSession().setAttribute("lastName", u.getLast_name());
					request.getSession().setAttribute("studentId", u.getStudent_id());
					request.getSession().setAttribute("year", u.getYear());
					request.getSession().setAttribute("branch", u.getBranch());
					request.getSession().setAttribute("email", u.getEmail());

				 return "redirect:/user";
			}
			else {
				return "userlogin.jsp";
			}
	}
	
	@GetMapping("/facultylog")
	public String fun4() {
		return "facultylogin.jsp";
	}
	
	@PostMapping("/loggedin")
	public String login1(Model m, @ModelAttribute("pf") Faculty pf, HttpServletRequest request) {
			if(fdao.validateLogin(pf)) {
				 Faculty f = fdao.getDetailsById(pf);
				 //m.addAttribute("command", u);
				 //StringBuffer stringBufferName = new StringBuffer(u.getFirst_name());
				 System.out.println(f.getId());
				// System.out.println(stringBufferName);
				 m.addAttribute("facultyName", f.getUsername());
				 request.getSession().setAttribute("facultyName", f.getUsername());

				 
				 return "redirect:/faculty";
			}
			else {
				return "facultylogin.jsp";
			}
	}
	
	@GetMapping("/user")
	public String userPage(Model m, @RequestParam(name = "studentId", defaultValue = "0") Long studentId) {
	    if (studentId != 0) {
	        System.out.println(studentId);
	        m.addAttribute("studentId", studentId);
	    }
	    return "user.jsp";
	}

	
	@GetMapping("/faculty")
	public String facultyPage() {
	    return "faculty.jsp";
	}

	
	@PostMapping("/forgotpassword")
	public String forgotPassword(@RequestParam(name = "email", required = false) String email) {
	    if (email == null) {
	        // Handle cases where 'email' is missing (e.g., display an error message).
	    	return "redirect:/forgot";
	    } else {
	        User user = dao.findByEmail(email);
	        if (user != null) {
	            passwordResetService.createPasswordResetToken(user);
	            // Password reset process continues...
	            return "redirect:/resetpass/{token}";
	        } else {
	            // Handle cases where the user doesn't exist.
	        	return "redirect:/userlog";
	        }
	    }
	}
	
	@GetMapping("/forgot")
	public String fun8() {
		return "forgot.jsp";
	}


	@GetMapping("/resetpass/{token}")
	public String showResetPasswordForm(@PathVariable String token, Model model) {
	    boolean validToken = passwordResetService.isTokenValid(token);
	    if (validToken) {
	        model.addAttribute("token", token);
	        return "redirect:/reset/" + token;
	    } else {
	        return "redirect:/invalid"; // Display an error page
	    }
	}
	
	@GetMapping("/reset/{token}")
	public String fun7(@PathVariable String token, Model model) {
		model.addAttribute("token", token);
		return "reset-password-form.jsp";
	}
	
	@GetMapping("/invalid")
	public String fun6() {
		return "invalid.jsp";
	}
    
    @PostMapping("/resetpass")
    @ResponseBody
    public String resetPassword(@RequestParam("token") String token, @RequestParam("newPassword") String newPassword) {
        boolean success = passwordResetService.resetPassword(token, newPassword);
        if (success) {
            return "password-reset-success"; // Display a success page
        } else {
            return "password-reset-failure"; // Display an error page
        }
    }
    
    @GetMapping("/checkInternet")
    @ResponseBody
    public String checkInternet() {
        try {
            // Attempt to connect to a reliable website
            InetAddress.getByName("www.google.com").isReachable(5000); // Replace with a reliable website
            return "Internet is connected.";
        } catch (IOException e) {
            return "Internet is not connected.";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Retrieve the current session (if it exists)

        if (session != null) {
            session.invalidate(); // Invalidate the session to log the user out
        }

        // Redirect to the login page or any other appropriate page
        return "redirect:/welcome"; // Change the URL as needed
    }
    
    @GetMapping("/logout1")
    public String logout1(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Retrieve the current session (if it exists)
        System.out.println(session);
        if (session != null) {
            session.invalidate(); // Invalidate the session to log the user out
        }

        // Redirect to the login page or any other appropriate page
        return "redirect:/welcome"; // Change the URL as needed
    }
    
    @GetMapping("/submitgrievance")
	public String fun9() {
		return "submitgrievance.jsp";
	}
    
//
//    @GetMapping("/grievance")
//    public String showGrievanceForm(Model model) {
//        model.addAttribute("grievance", new Grievance());
//        return "grievance-form";
//    }

    @PostMapping("/grievance")
    public String submitGrievance(Model m ,@ModelAttribute Grievance grievance, @RequestParam("file") MultipartFile file) {
        // Handle file upload and save it to the grievance object's image property
        try {
            grievance.setImage(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        m.addAttribute("var", grievance);
        grievanceRepository.save(grievance);
        return "redirect:/user";
    }
    
    
    @GetMapping("/grievance/image/{id}")
    @ResponseBody
    public void showImage(@PathVariable("id") Long id, HttpServletResponse response) throws IOException
 {
        Grievance grievance = grievanceRepository.findById(id).orElse(null);
        if (grievance != null) 
{
            byte[] imageData = grievance.getImage();
            if (imageData != null)
 {
                response.setContentType("image/jpeg"); // Adjust content type based on your image type
                response.getOutputStream().write(imageData);
                
            }
        }
    }


    @GetMapping("/your-url-path")
    public String handleGetRequest(Model model) {
        // You can perform actions such as loading data, setting attributes for the view, and returning a view name.
        
        // For example, load some data and add it to the model for rendering in the view.
         // Replace with your actual data retrieval logic.
        
        // Return the name of the view (HTML or JSP template) to render the response.
        return "your-view-name"; // Replace with the name of your view template.
    }
    
    
    @GetMapping("/grievancesr")
    public String listGrievances(@RequestParam("id") String studentId, Model model) {
        try {
            Long studentIdValue = Long.parseLong(studentId); // Parse the String to Long

            List<Grievance> grievances = grievanceRepository.findByIdnum(studentIdValue);

            if (!grievances.isEmpty()) {
                model.addAttribute("grievances", grievances);
            } else {
                // Handle the case where no matching grievance is found.
            }
        } catch (NumberFormatException e) {
            // Handle the case where the "studentId" parameter is not a valid Long.
            // You can redirect to an error page or return an error response.
            return "errorPage"; // Create an error page.
        }

        return "grievanceshis";
    }


    @GetMapping("/idnum")
    public String fun30(Model model) {
        // You can initialize the "id" model attribute here if needed
        model.addAttribute("id", 0L); // Default value, change as needed
        return "idform.jsp";
    }
    
    @GetMapping("/factgrievance")
    public String fun31() {
    	return "facultygrievance.jsp";
    }

    @GetMapping("/grievancesr1")
    public String listGrievancesfact(@RequestParam("category") String category, Model model) {
        try {
           

            List<Grievance> grievances = grievanceRepository.findByCategory(category);

            if (!grievances.isEmpty()) {
                model.addAttribute("grievances", grievances);
            } else {
                // Handle the case where no matching grievance is found.
            }
        } catch (NumberFormatException e) {
            // Handle the case where the "studentId" parameter is not a valid Long.
            // You can redirect to an error page or return an error response.
            return "errorPage"; // Create an error page.
        }

        return "grievanceshis";
    }
    @GetMapping("/grievanceshis")
    public String fun21() {
        return "grievanceHistory.jsp";
    }

    
    

    @GetMapping("/track")
    public String fun22() {
    	
    	return "tack.jsp";
    }
    
    @GetMapping("/management")
    public String fun23() {
    	return "managementdash.jsp";
    }
    
    @GetMapping("/managementlog")
    public String fun24() {
    	return "managementlog.jsp";
    }
    
    @PostMapping("/login")
	public String login3(Model m, @ModelAttribute("pf") Management pf, HttpServletRequest request) {
			if(mdao.validateLogin(pf)) {
				 Management m1 = mdao.getDetailsById(pf);
				 //m.addAttribute("command", u);
				 //StringBuffer stringBufferName = new StringBuffer(u.getFirst_name());
				 System.out.println(m1.getUsername());
				// System.out.println(stringBufferName);
				 m.addAttribute("Admin", m1.getUsername());
				 request.getSession().setAttribute("facultyName", m1.getUsername());

				 
				 return "redirect:/management";
			}
			else {
				return "/managementlog";
			}
	}
    
    @GetMapping("/search")
    public String searchGrievances(@RequestParam("studentId") Long studentId, Model model) {
        List<Grievance> grievances = grievanceRepository.findByIdnum(studentId);
        System.out.println("Number of grievances found: " + grievances.size());
        model.addAttribute("grievances", grievances);
        return "searchres.jsp"; // Create a JSP page to display the search results.
    }
     

//    @GetMapping("/find")
//    public String fun33() {
//    	
//    }
// 
    
    
	

}

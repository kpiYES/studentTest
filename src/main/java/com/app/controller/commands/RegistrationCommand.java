package com.app.controller.commands;

import com.app.dto.DTOHandler;
import com.app.dto.UserDTO;
import com.app.model.Role;
import com.app.model.User;
import com.app.service.RoleService;
import com.app.service.ServiceFactory;
import com.app.service.UserService;
import com.app.service.util.PasswordSecurity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistrationCommand implements Command {

    private UserService userService = ServiceFactory.getUserService();
    private RoleService roleService = ServiceFactory.getRoleService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        if (!request.getParameter("password").equals(request.getParameter("confirmPassword"))) {
            request.setAttribute("errorMsg", "You've incorrectly confirm password, please try again");
            return "registr.jsp";
        }

        Role role = roleService.findByName("student");
        User user = new User();
        user.setRole(role);
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setMail(request.getParameter("email"));
        String password = request.getParameter("password");
        String saltedHash = PasswordSecurity.generateSaltedPasswordHash(password);
        user.setHash(PasswordSecurity.getHashFromSaltedHash(saltedHash));
        user.setSalt(PasswordSecurity.getSaltFromSaltedHash(saltedHash));
        Long id = userService.insert(user);
        User currentUser = userService.findById(id);
        UserDTO currentUserDTO = DTOHandler.constructUserDTO(currentUser);
        request.getSession().setAttribute("currentUser", currentUserDTO);
        return "student.jsp";
    }
}


package com.app.controller.commands;

import com.app.dto.DTOHandler;
import com.app.dto.UserDTO;
import com.app.model.Role;
import com.app.model.User;
import com.app.service.RoleService;
import com.app.service.ServiceFactory;
import com.app.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserRoleCommand implements Command {

   private UserService userService = ServiceFactory.getUserService();
    private RoleService roleService = ServiceFactory.getRoleService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {



       if (request.getParameter("userRole")==null) {
           request.setAttribute("message", "You should choose different user role");
       }else {
           String newUserRole = request.getParameter("userRole");
           Role role = roleService.findByName(newUserRole);
           UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userDTO");
           User user = userService.findById(userDTO.getId());
           user.setRole(role);
           userService.update(user);
           UserDTO updatedUserDTO = DTOHandler.constructUserDTO(user);
           request.getSession().setAttribute("userDTO", updatedUserDTO);
           request.setAttribute("message", "User role was successfully updated");
       }
       request.setAttribute("pageFragment","showListOfUsersFragment.jsp");
       request.setAttribute("subPageFragment", "showUserFragment.jsp");
        return "admin.jsp";
    }
}

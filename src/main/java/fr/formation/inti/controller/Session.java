//package fr.formation.inti.controller;
//
//public class Session {
//	
//	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
//	@ResponseBody
//	public String login(HttpSession session,String username,String password) throws Exception {
//	    Member member=userService.authenticateUser(username, password);
//	    if(member!=null) {
//	        session.setAttribute("MEMBER", member);
//	    } else {
//	        throw new Exception("Invalid username or password");
//	    }
//	    return Utils.toJson("SUCCESS");
//	}
//
//}
